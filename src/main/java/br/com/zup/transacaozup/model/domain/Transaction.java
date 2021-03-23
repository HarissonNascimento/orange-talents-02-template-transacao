package br.com.zup.transacaozup.model.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Entity
public class Transaction {

    @Id
    @NotBlank
    private String id;
    @NotNull
    @Positive
    private BigDecimal amount;
    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    @Valid
    private Establishment establishment;
    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    @Valid
    private Card card;
    @NotNull
    private String effectiveOn;

    public Transaction(@NotBlank String id,
                       @NotNull @Positive BigDecimal amount,
                       @NotNull @Valid Establishment establishment,
                       @NotNull @Valid Card card,
                       @NotBlank String effectiveOn) {

        this.id = id;
        this.amount = amount;
        this.establishment = establishment;
        this.card = card;
        this.effectiveOn = effectiveOn;
    }

    @Deprecated
    protected Transaction() {
    }

    public String getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Establishment getEstablishment() {
        return establishment;
    }

    public Card getCard() {
        return card;
    }

    public String getEffectiveOn() {
        return effectiveOn;
    }
}
