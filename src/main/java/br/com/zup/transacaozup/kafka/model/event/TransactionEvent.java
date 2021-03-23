package br.com.zup.transacaozup.kafka.model.event;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class TransactionEvent {

    private String id;
    @JsonProperty("valor")
    private BigDecimal value;
    @JsonProperty("estabelecimento")
    private EstablishmentEvent establishment;
    @JsonProperty("cartao")
    private CardEvent card;
    @JsonProperty("efetivadaEm")
    private String effectiveOn;

    public String getId() {
        return id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public EstablishmentEvent getEstablishment() {
        return establishment;
    }

    public CardEvent getCard() {
        return card;
    }

    public String getEffectiveOn() {
        return effectiveOn;
    }

    @Override
    public String toString() {
        return "TransactionEvent{" +
                "id='" + id + '\'' +
                ", value=" + value +
                ", establishment=" + establishment +
                ", card=" + card +
                ", effectiveOn=" + effectiveOn +
                '}';
    }
}
