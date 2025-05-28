package application.registerProduct;

import domain.sale.IProductRepository;
import domain.sale.Produto;

public class RegisterProductService implements IRegisterProductService
{
    private final IProductRepository productRepository;

    public RegisterProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void CadastrarProduto(ProdutoDto request) {
        var produto = Produto.CreateProduto(request.nome,request.codigo, request.preco, request.estoque);
        productRepository.save(produto);
    }
}
