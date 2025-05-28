import application.registerProduct.ProdutoDto;
import domain.exceptions.InsufficientStockException;
import domain.exceptions.InvalidProductValueException;
import domain.exceptions.ProductNotFoundException;
import domain.sale.Produto;
import infrastructure.ContainerInjection;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        ContainerInjection container = new ContainerInjection();

        try
        {

            container.registerProductService.CadastrarProduto(new ProdutoDto("ProdutoTeste", "123u", new BigDecimal("10.50"),1));

            container.registerProductService.CadastrarProduto(new ProdutoDto("ProdutoTeste", "123t", new BigDecimal("-5"),1));
        }
        catch (InvalidProductValueException ex)
        {
            System.out.println("Erro ao cadastrar produto: " + ex.getMessage());
        }

        try
        {
            container.simulateSaleService.RealizarVenda("123u", 1);

            container.simulateSaleService.RealizarVenda("123u", 500);
        }
        catch (InsufficientStockException ex)
        {
            System.out.println("Erro ao vender por falta de estoque: " + ex.getMessage());
        }
        catch (ProductNotFoundException ex)
        {
            System.out.println("Erro ao vender por não encontrar o produto: " + ex.getMessage());
        }

        try
        {
            container.simulateSaleService.RealizarVenda("123x", 1);
        }
        catch (ProductNotFoundException ex)
        {
            System.out.println("Erro por não existir o produto: " + ex.getMessage());
        }

        try
        {
            container.registerProductService.CadastrarProduto(new ProdutoDto("", "", new BigDecimal("10.50"),1));
        }
        catch (InvalidProductValueException ex)
        {
            System.out.println("Erro ao cadastrar produto: " + ex.getMessage());
        }
        finally {
            System.out.println("Né que deu erro, enviando para a fila de envio de email de erros...");
        }

        System.out.println("Não crie pânico, foram inseridos os sequintes produtos:");

        for (Produto p : container.productRepository.findAll()) {
            System.out.println(p);
        }

        System.out.println("\nFinalizando o sistema. Obrigado aí por utilizar!");

    }
}