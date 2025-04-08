package br.com.senac.cadastroprodutos.api.senac_cadastro_produtos_api.service;

import br.com.senac.cadastroprodutos.api.senac_cadastro_produtos_api.entity.Produto;
import br.com.senac.cadastroprodutos.api.senac_cadastro_produtos_api.exception.SenacException;
import br.com.senac.cadastroprodutos.api.senac_cadastro_produtos_api.repository.ProdutoRepository;
import br.com.senac.cadastroprodutos.api.senac_cadastro_produtos_api.utils.ValidacoesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;


    public List<Produto> listarProdutos() {
        List<Produto> produtosResult = produtoRepository.findAll();
        return produtosResult;
    }

    public List<Produto> listarProdutoById(Long id) {
        List<Produto> produtosResult = produtoRepository.findByProdutoId(id);
        return produtosResult;
    }


    public Produto criarProduto(Produto produto) throws SenacException {

        ValidacoesUtils.validarCodigoBarras(produtoRepository, produto.getId(), produto.getCodigoBarras());
        return produtoRepository.save(produto);
    }


    public Produto atualizarProduto(Long id, Produto produto) throws SenacException {
        // Verifica se o produto existe antes de tentar atualizar
        if (!produtoRepository.existsById(id)) {
            throw new SenacException("Produto com ID " + id + " não encontrado.");
        }

        // Valida código de barras antes de atualizar
        ValidacoesUtils.validarCodigoBarras(produtoRepository, produto.getId(), produto.getCodigoBarras());

        produto.setId(id); // Garante que o ID seja mantido
        return produtoRepository.save(produto);
    }


    public void excluirProduto(Long id) throws SenacException {

        if (!produtoRepository.existsById(id)) {
            throw new SenacException("Produto com ID " + id + " não encontrado.");
        }
        produtoRepository.deleteById(id);
    }
}





