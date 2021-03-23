package br.com.zup.transacaozup.endpoint.controller;

import br.com.zup.transacaozup.endpoint.repository.TransactionRepository;
import br.com.zup.transacaozup.model.domain.Transaction;
import br.com.zup.transacaozup.model.response.TransactionGetResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping("/{cardId}")
    public ResponseEntity<?> getMyTransactions(@PathVariable String cardId) {
        Page<Transaction> transactionPage =
                transactionRepository.findAllByCardId(cardId, PageRequest.of(
                        0, 10, Sort.by(Sort.Direction.DESC, "effectiveOn")));

        if (transactionPage.getContent().isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<TransactionGetResponseBody> collect =
                transactionPage.getContent()
                        .stream()
                        .map(transaction -> new TransactionGetResponseBody().toTransactionGetResponseBody(transaction))
                        .collect(Collectors.toList());

        return ResponseEntity.ok(collect);
    }
}
