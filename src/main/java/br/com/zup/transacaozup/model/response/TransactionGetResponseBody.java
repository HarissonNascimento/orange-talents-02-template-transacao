package br.com.zup.transacaozup.model.response;

import br.com.zup.transacaozup.model.domain.Transaction;

import java.math.BigDecimal;

public class TransactionGetResponseBody {

    private String transactionId;
    private BigDecimal amount;
    private String establishmentName;
    private String effectiveOn;

    public String getTransactionId() {
        return transactionId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getEstablishmentName() {
        return establishmentName;
    }

    public String getEffectiveOn() {
        return effectiveOn;
    }

    public TransactionGetResponseBody toTransactionGetResponseBody(Transaction transaction) {
        this.transactionId = transaction.getId();
        this.amount = transaction.getAmount();
        this.establishmentName = transaction.getEstablishment().getName();
        this.effectiveOn = transaction.getEffectiveOn();
        return this;
    }
}
