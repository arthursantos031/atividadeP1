package application.registerProduct;

import java.math.BigDecimal;

public class ProdutoDto {
    public String nome;
    public String codigo;
    public BigDecimal preco;
    public int estoque;

    public ProdutoDto(String nome, String codigo, BigDecimal preco, int estoque) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
        this.estoque = estoque;
    }
}
