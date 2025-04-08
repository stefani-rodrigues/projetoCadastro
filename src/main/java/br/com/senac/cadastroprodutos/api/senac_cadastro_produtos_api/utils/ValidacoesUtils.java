package br.com.senac.cadastroprodutos.api.senac_cadastro_produtos_api.utils;

import br.com.senac.cadastroprodutos.api.senac_cadastro_produtos_api.repository.ProdutoRepository;

public class ValidacoesUtils {
    public static void validarCodigoBarras(ProdutoRepository produtoRepository, Long id, String codigoBarras) {

            // 1. Verifica se o código de barras tem exatamente 13 caracteres
            if (codigoBarras.length() != 13) {
                throw new IllegalArgumentException("Código de barras deve ter exatamente 13 caracteres.");
            }
    }
}
