package application.simulateSale;

import domain.exceptions.ProductNotFoundException;
import domain.sale.IProductRepository;
import domain.sale.Produto;
import infrastructure.data.ProductRepository;

public class SimulateSaleService implements ISimulateSaleService
{
    private final IProductRepository productRepository;

    public SimulateSaleService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void RealizarVenda(String codigoProduto, int quantidade) {
        Produto produto = productRepository
                .findByCodigo(codigoProduto)
                .orElseThrow(() -> ProductNotFoundException.create("Código de produto inexistente: " + codigoProduto));

        Produto.reduzirEstoque(produto, quantidade);
    }
}
