package com.example.julio.bookstore.resources;

import com.example.julio.bookstore.dto.LivroDTO;
import com.example.julio.bookstore.entities.Livro;
import com.example.julio.bookstore.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/livros")
public class LivroResource {

    @Autowired
    private LivroService livroService;

    // Para salvar um de livro, vou precisa de saber o id da CATEGORIA vinculado
    @PostMapping
    public ResponseEntity<Livro> criarLivro(@RequestParam(value = "categoria", defaultValue = "0") Long id_cat,
                                            @Valid @RequestBody Livro obj) {
        Livro newObj = livroService.salvarLivro(id_cat, obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/livros/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).body(newObj);
    }

    // Para acessar a lista de livro, vou precisa de saber o id da CATEGORIA vinculado
    // Com isso passar o id da CATEGORIA como parametro localhost:8080/livros?categoria=1
    @GetMapping()
    public ResponseEntity<List<LivroDTO>> buscarLivro(@RequestParam(value = "categoria", defaultValue = "0") Long id_cat) {
        List<Livro> list = livroService.buscarLivro(id_cat);
        List<LivroDTO> listDTO = list.stream()
                .map(LivroDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Livro> buscarPorId(@PathVariable Long id) {
        Livro obj = livroService.buscarLivroPorId(id);
        return ResponseEntity.ok().body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Livro> atualizar(@PathVariable Long id, @Valid @RequestBody Livro obj) {
        Livro newObj = livroService.atualizaLivroPorId(id, obj);
        return ResponseEntity.ok().body(newObj);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Livro> atualizarPach(@PathVariable Long id, @Valid @RequestBody Livro obj) {
        Livro newObj = livroService.atualizaLivroPorId(id, obj);
        return ResponseEntity.ok().body(newObj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        livroService.deletaPorId(id);
        return ResponseEntity.noContent().build();
    }

}
