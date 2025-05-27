package domain.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Venda {
    private long id;
    private ArrayList<Produto> listaProduto;
    private BigDecimal precoVenda;
    private String descricao;
    
    private Venda(long id, ArrayList<Produto> listaProduto, BigDecimal precoVenda, String descricao){
        this.id = id;
        this.listaProduto = listaProduto;
        this.precoVenda = precoVenda;
        this.descricao = descricao;
    }

    private static Venda create(ArrayList<Produto> listaProduto, String descricao) {

        //os valores que aqui chegarem é esperado que estejam bem tratados, assim espero
        var id = ThreadLocalRandom.current().nextInt(1, 1000000);

        BigDecimal precoVenda = listaProduto.stream()
                .map(Produto::getPreco)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return new Venda(id,listaProduto,precoVenda,descricao);
    }
}
