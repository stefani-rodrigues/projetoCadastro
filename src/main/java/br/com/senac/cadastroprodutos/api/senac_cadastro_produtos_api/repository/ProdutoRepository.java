package br.com.senac.cadastroprodutos.api.senac_cadastro_produtos_api.repository;

import br.com.senac.cadastroprodutos.api.senac_cadastro_produtos_api.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long> {

   public List<Produto> findByProdutoId(Long id);

}
