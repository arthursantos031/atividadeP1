package domain.entities;

import domain.exceptions.InsufficientStockException;
import domain.exceptions.InvalidProductValueException;

import java.math.BigDecimal;

public class Produto {
    private String nome;
    private String codigo;
    private BigDecimal preco;
    private int estoque;

    private Produto(String nome, String codigo, BigDecimal preco, int estoque) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
        this.estoque = estoque;
    }

    public static Produto CreateProduto(String nome, String codigo, BigDecimal preco, int estoque){

        ValidateValues( nome, codigo, preco, estoque);

        return new Produto(nome, codigo, preco, estoque);
    }

    private static void ValidateValues(String nome, String codigo, BigDecimal preco, int estoque){
        if (nome == null || nome.isBlank() || codigo == null || codigo.isBlank()) {
            throw InvalidProductValueException.create("Veja bem, o nome e código devem ser preenchidos.");
        }
        if (preco == null || preco.compareTo(BigDecimal.ZERO) < 0) {
            throw InvalidProductValueException.create("Hora hora hora, preencha o preço com um valor não negativo.");
        }
        if (estoque < 0) {
            throw InvalidProductValueException.create("Preencha o estoque com um valor não negativo, aqui não é dropshipping.");
        }
    }

    public static void reduzirEstoque(Produto produto, int quantidade) {
        if (quantidade > produto.estoque) {
            throw InsufficientStockException.create("Que isso moral, o estoque não é elástico assim. Acabou.");
        }
        produto.estoque -= quantidade;
    }

    public String getCodigo() { return codigo; }
    public int getEstoque() { return estoque; }
    public BigDecimal getPreco() { return preco; }

}
