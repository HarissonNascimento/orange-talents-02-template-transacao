package br.com.zup.transacaozup.model.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
public class Card {

    @Id
    @NotBlank
    private String id;
    @NotBlank
    @Email
    private String email;

    public Card(@NotBlank String id,
                @NotBlank @Email String email) {
        this.id = id;
        this.email = email;
    }

    @Deprecated
    protected Card() {
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
