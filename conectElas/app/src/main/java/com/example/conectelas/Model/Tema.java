
package com.example.conectelas.Model;


import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class Tema {

    @Expose
    private Long id;
    @Expose
    private String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
