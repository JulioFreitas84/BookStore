package com.example.julio.bookstore.services;

import com.example.julio.bookstore.dto.CategoriaDTO;
import com.example.julio.bookstore.entities.Categoria;
import com.example.julio.bookstore.repositories.CategoriaRepository;
import com.example.julio.bookstore.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria findById(Long id) {
        Optional<Categoria> optionalCategoria = categoriaRepository.findById(id);
        return optionalCategoria.orElseThrow(
                () -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo:" + Categoria.class.getName()));
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Categoria save(Categoria obj) {
        obj.setId(null);
        return categoriaRepository.save(obj);
    }

    public Categoria findByIdSave(Long id, CategoriaDTO objDTO) {
        Categoria obj = categoriaRepository.findById(id).get();
        obj.setNome(objDTO.getNome());
        obj.setDescricao(objDTO.getDescricao());
        return categoriaRepository.save(obj);
    }

    public void deletaCategoria(Long id) {
        categoriaRepository.deleteById(id);

    }
}
