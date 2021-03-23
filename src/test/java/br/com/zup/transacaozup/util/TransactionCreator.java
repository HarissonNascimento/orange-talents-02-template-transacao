package br.com.zup.transacaozup.util;

import br.com.zup.transacaozup.model.domain.Card;
import br.com.zup.transacaozup.model.domain.Establishment;
import br.com.zup.transacaozup.model.domain.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TransactionCreator {

    public static List<Transaction> createTransactionListToBeSave(int amount, String cardId) {
        List<Transaction> transactionList = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            transactionList.add(createValidTransactionToBeSave(cardId));
        }
        return transactionList;
    }

    public static Transaction createValidTransactionToBeSave(String cardId) {
        Establishment establishment = new Establishment("TestEstablishmentName",
                "TestEstablishmentCity",
                "TestEstablishmentAddress");
        Card card = new Card(cardId, "test@email.com");
        return new Transaction(UUID.randomUUID().toString(),
                BigDecimal.TEN, establishment, card, LocalDateTime.now().toString());
    }
}
