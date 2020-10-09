package br.com.devSpringBoot.awesome.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;

@Entity
public class Estudante extends AbstractEntity {

    @NotEmpty
    private String name;

    @Email
    @NotEmpty
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
