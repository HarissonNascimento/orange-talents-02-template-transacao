package br.com.zup.transacaozup.kafka.model.event;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EstablishmentEvent {

    @JsonProperty("nome")
    private String name;
    @JsonProperty("cidade")
    private String city;
    @JsonProperty("endereco")
    private String address;

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "EstablishmentEvent{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
