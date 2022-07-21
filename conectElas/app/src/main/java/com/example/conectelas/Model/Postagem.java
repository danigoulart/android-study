
package com.example.conectelas.Model;

import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class Postagem {

    @Expose
    private String date;
    @Expose
    private String foto;
    @Expose
    private Long id;
    @Expose
    private Tema tema;
    @Expose
    private String texto;
    @Expose
    private String titulo;
    @Expose
    private String usuario;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}
