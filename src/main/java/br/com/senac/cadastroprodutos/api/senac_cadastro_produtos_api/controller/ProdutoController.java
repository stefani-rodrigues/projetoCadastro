package br.com.senac.cadastroprodutos.api.senac_cadastro_produtos_api.controller;

import br.com.senac.cadastroprodutos.api.senac_cadastro_produtos_api.entity.Produto;
import br.com.senac.cadastroprodutos.api.senac_cadastro_produtos_api.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Produto>> listarProdutos() {
        List<Produto> produtoList = produtoService.listarProdutos();

        if (produtoList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(produtoList);
    }

    @PostMapping("/criar")
    public ResponseEntity<Produto> criarProduto(@RequestBody Produto produto) {
        Produto produtoResult = produtoService.criarProduto(produto);
        return ResponseEntity.ok(produtoResult);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable Long id, @RequestBody Produto produtoAtualizado) {
        produtoAtualizado.setId(id);
        Produto produtoResult = produtoService.atualizarProduto(id, produtoAtualizado);
        return ResponseEntity.ok(produtoResult);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluirProduto(@PathVariable Long id) {
        produtoService.excluirProduto(id);
        return ResponseEntity.noContent().build();
    }
}
