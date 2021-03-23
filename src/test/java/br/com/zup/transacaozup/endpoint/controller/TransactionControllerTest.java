package br.com.zup.transacaozup.endpoint.controller;

import br.com.zup.transacaozup.endpoint.repository.TransactionRepository;
import br.com.zup.transacaozup.model.domain.Transaction;
import br.com.zup.transacaozup.model.response.TransactionGetResponseBody;
import br.com.zup.transacaozup.util.TransactionCreator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureDataJpa
@AutoConfigureMockMvc
@Transactional
@ActiveProfiles("test")
@DisplayName("Transaction Controller Test")
class TransactionControllerTest {

    private final String URL_GET_TRANSACTIONS = "/api/transactions/{cardId}";

    private String cardId;
    private List<Transaction> transactionList;

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setUp() {
        cardId = UUID.randomUUID().toString();

        transactionList = TransactionCreator.createTransactionListToBeSave(10, cardId);

        transactionRepository.saveAll(transactionList);
    }

    @Test
    @DisplayName("Get my transactions, return 200 status code and transaction list when successful")
    void getMyTransactions_Return200StatusCodeAndTransactionList_WhenSuccessful() throws Exception {
        ResultActions resultActions = mockMvc.perform(get(URL_GET_TRANSACTIONS, cardId)).andExpect(status().isOk());

        TransactionGetResponseBody[] responseBodies =
                objectMapper.readValue(resultActions.andReturn().getResponse().getContentAsString(), TransactionGetResponseBody[].class);

        assertNotNull(responseBodies);
        assertEquals(transactionList.size(), responseBodies.length);

        TransactionGetResponseBody responseBody = responseBodies[0];

        Optional<Transaction> optionalTransaction = transactionRepository.findById(responseBody.getTransactionId());

        assertTrue(optionalTransaction.isPresent());

        Transaction transaction = optionalTransaction.get();

        assertEquals(cardId, transaction.getCard().getId());
    }

    @Test
    @DisplayName("Get my transactions, return 404 status code if dont found id card")
    void getMyTransactions_Return404StatusCode_IfDontFoundIdCard() throws Exception {
        mockMvc.perform(get(URL_GET_TRANSACTIONS, "1NV4L1D-1D-C4RD")).andExpect(status().isNotFound());
    }
}