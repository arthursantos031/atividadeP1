package infrastructure.data;

import domain.sale.IProductRepository;
import domain.sale.Produto;

import java.util.*;

public class ProductRepository implements IProductRepository
{
    private final Map<String, Produto> produtos = new HashMap<>();

    @Override
    public void save(Produto produto) {
        produtos.put(produto.getCodigo(), produto);
    }

    @Override
    public Optional<Produto> findByCodigo(String codigo) {
        return  produtos.values().stream()
                .filter(p -> p.getCodigo().equals(codigo))
                .findFirst();
    }

    @Override
    public Collection<Produto> findAll() {
        return produtos.values();
    }
}
