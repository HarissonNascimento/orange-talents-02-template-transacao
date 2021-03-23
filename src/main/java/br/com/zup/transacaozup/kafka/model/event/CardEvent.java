package br.com.zup.transacaozup.kafka.model.event;

import br.com.zup.transacaozup.model.domain.Card;

public class CardEvent {

    private String id;
    private String email;

    public CardEvent(String id, String email) {
        this.id = id;
        this.email = email;
    }

    @Deprecated
    protected CardEvent() {
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Card toCard() {
        return new Card(this.id, this.email);
    }
}
