package com.example.julio.bookstore.dto;

import com.example.julio.bookstore.entities.Livro;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

public class LivroDTO {

    private Long id;

    @NotEmpty(message = "Campo TITULO obrigatório.")
    @Length(min = 3, max = 100, message = "Campo deve ter de 3 a 100 caracteres.")
    private String titulo;

    public LivroDTO() {
    }

    public LivroDTO(Livro obj) {
        this.id = obj.getId();
        this.titulo = obj.getTitulo();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
