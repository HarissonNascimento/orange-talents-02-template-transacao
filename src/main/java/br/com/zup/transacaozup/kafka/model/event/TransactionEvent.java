package br.com.zup.transacaozup.kafka.model.event;

import br.com.zup.transacaozup.model.domain.Card;
import br.com.zup.transacaozup.model.domain.Establishment;
import br.com.zup.transacaozup.model.domain.Transaction;
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

    public TransactionEvent(String id, BigDecimal value, EstablishmentEvent establishment, CardEvent card, String effectiveOn) {
        this.id = id;
        this.value = value;
        this.establishment = establishment;
        this.card = card;
        this.effectiveOn = effectiveOn;
    }

    @Deprecated
    protected TransactionEvent() {
    }

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

    public Transaction toTransaction() {
        Establishment establishment = this.establishment.toEstablishment();
        Card card = this.card.toCard();
        return new Transaction(this.id, this.value, establishment, card, this.effectiveOn);
    }
}
