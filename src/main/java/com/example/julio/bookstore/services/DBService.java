package com.example.julio.bookstore.services;

import com.example.julio.bookstore.entities.Categoria;
import com.example.julio.bookstore.entities.Livro;
import com.example.julio.bookstore.repositories.CategoriaRepository;
import com.example.julio.bookstore.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private LivroRepository livroRepository;

    public void instaciaBaseDeDados() {

        Categoria cat1 = new Categoria(null, "Informática", "Livro de TI");
        Categoria cat2 = new Categoria(null, "Ficção Científica", "Livro de Ciências");
        Categoria cat3 = new Categoria(null, "Biografias", "Livro de Biografias");

        Livro livro1 = new Livro(null, "Clean Code", "Robert Matin", "Lorem ipsum", cat1);
        Livro livro2 = new Livro(null, "Engenharia de Software", "Louis V. Gerstner", "Lorem ipsum", cat1);
        Livro livro3 = new Livro(null, "The Time Machine", "H.G. Wells", "Lorem ipsum", cat2);
        Livro livro4 = new Livro(null, "the War Of The Words", "H.G. Wells", "Lorem ipsum", cat2);
        Livro livro5 = new Livro(null, "I, Robot", "Isaac Asimov", "Lorem ipsum", cat2);

        cat1.getLivros().addAll(Arrays.asList(livro1, livro2));
        cat2.getLivros().addAll(Arrays.asList(livro3, livro4, livro5));

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        livroRepository.saveAll(Arrays.asList(livro1, livro2, livro3, livro4, livro5));
    }
}
