package br.com.zup.transacaozup.kafka.model.event;

public class CardEvent {

    private String id;
    private String email;

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "CardEvent{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
