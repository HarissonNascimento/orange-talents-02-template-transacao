package br.com.zup.transacaozup.kafka.model.event;

import br.com.zup.transacaozup.model.domain.Establishment;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EstablishmentEvent {

    @JsonProperty("nome")
    private String name;
    @JsonProperty("cidade")
    private String city;
    @JsonProperty("endereco")
    private String address;

    public EstablishmentEvent(String name, String city, String address) {
        this.name = name;
        this.city = city;
        this.address = address;
    }

    @Deprecated
    protected EstablishmentEvent() {
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public Establishment toEstablishment() {
        return new Establishment(this.name, this.city, this.address);
    }
}
