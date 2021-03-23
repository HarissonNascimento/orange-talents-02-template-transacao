package br.com.zup.transacaozup.kafka;

import br.com.zup.transacaozup.endpoint.repository.TransactionRepository;
import br.com.zup.transacaozup.kafka.model.event.TransactionEvent;
import br.com.zup.transacaozup.model.domain.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TransactionListener {

    @Autowired
    private TransactionRepository transactionRepository;

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    @Transactional
    public void listen(TransactionEvent transactionEvent) {
        Transaction transaction = transactionEvent.toTransaction();
        transactionRepository.save(transaction);
    }
}
