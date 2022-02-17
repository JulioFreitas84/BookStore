package com.example.julio.bookstore.dto;

import com.example.julio.bookstore.entities.Categoria;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

public class CategoriaDTO {

    private Long id;

    @NotEmpty(message = "Campo NOME obrigatório.")
    @Length(min = 3, max = 100, message = "Campo deve ter de 3 a 100 caracteres.")
    private String nome;

    @NotEmpty(message = "Campo DESCRIÇÃO obrigatório.")
    @Length(min = 3, max = 200, message = "Campo deve ter de 3 a 200 caracteres.")
    private String descricao;

    public CategoriaDTO() {
    }

    public CategoriaDTO(Categoria obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.descricao = obj.getDescricao();
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
