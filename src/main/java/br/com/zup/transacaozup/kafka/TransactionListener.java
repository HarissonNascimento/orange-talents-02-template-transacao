package br.com.zup.transacaozup.kafka;

import br.com.zup.transacaozup.kafka.model.event.TransactionEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TransactionListener {

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void listen(TransactionEvent transactionEvent){
        System.out.println(transactionEvent);
    }
}
