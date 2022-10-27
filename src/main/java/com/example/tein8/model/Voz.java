package com.example.tein8.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="TB_VOZ")
public class Voz {

    @Id 
    @Column(name= "cd_voz")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "frase")
    @NotBlank
    private String frase;

    public Voz() {
    }

    public Voz(String frase) {
        this.frase = frase;
    }

    public Voz(Long id, String frase) {
        this.id = id;
        this.frase = frase;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

    @Override
    public String toString() {
        return "Voz [id=" + id + ", frase=" + frase + "]";
    }

    

}
