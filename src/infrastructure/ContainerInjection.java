package infrastructure;

import application.registerProduct.RegisterProductService;
import application.simulateSale.SimulateSaleService;
import domain.entities.IProductRepository;
import infrastructure.data.ProductRepository;

public class ContainerInjection {
    public final IProductRepository productRepository = new ProductRepository();
    public final RegisterProductService registerProductService = new RegisterProductService(productRepository);
    public final SimulateSaleService simulateSaleService = new SimulateSaleService(productRepository);
}
