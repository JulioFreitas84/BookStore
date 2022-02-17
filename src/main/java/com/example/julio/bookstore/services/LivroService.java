package com.example.julio.bookstore.services;

import com.example.julio.bookstore.entities.Categoria;
import com.example.julio.bookstore.entities.Livro;
import com.example.julio.bookstore.repositories.LivroRepository;
import com.example.julio.bookstore.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private CategoriaService categoriaService;


    public Livro buscarLivroPorId(Long id) {
        Optional<Livro> obj = livroRepository.findById(id);
        return obj.orElseThrow(() ->
                new ObjectNotFoundException(
                        "Objeto não encontrado: " + id + ", Tipo: " + Livro.class.getName()));
    }

    public List<Livro> buscarLivro(Long id_cat) {
        categoriaService.findById(id_cat);
        return livroRepository.findAllByCategoria(id_cat);
    }

    public Livro atualizaLivroPorId(Long id, Livro obj) {
        Livro newObj = buscarLivroPorId(id);
        updateData(newObj, obj);
        return livroRepository.save(newObj);
    }

    private void updateData(Livro newObj, Livro obj) {
        newObj.setTitulo(obj.getTitulo());
        newObj.setNome_autor(obj.getNome_autor());
        newObj.setTexto(obj.getTexto());
    }

    public Livro salvarLivro(Long id_cat, Livro obj) {
        obj.setId(null);
        Categoria cat = categoriaService.findById(id_cat);
        obj.setCategoria(cat);
        return livroRepository.save(obj);
    }

    public void deletaPorId(Long id) {
        livroRepository.deleteById(id);
    }
}
