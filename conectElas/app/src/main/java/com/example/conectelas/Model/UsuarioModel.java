
package com.example.conectelas.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
public class UsuarioModel{

    private String email;
    private String foto;
    private Long id;
    private String nome;
    //private List<Postagem> postagem;
    private String senha;
    private String tipo;

    public UsuarioModel() {
    };
        public UsuarioModel(String email, String foto, Long id, String nome, String senha, String tipo) {
            this.email = email;
            this.foto = foto;
            this.id = id;
            this.nome = nome;
            //this.postagem = postagem;
            this.senha = senha;
            this.tipo = tipo;
        };

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
