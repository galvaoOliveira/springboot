package br.com.devSpringBoot.awesome.model;

public class Estudante {

    private String name;

    public Estudante(String name) {
        this.name = name;
    }

    public Estudante() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
