package application.simulateSale;

import domain.entities.IProductRepository;

public class SimulateSaleService implements ISimulateSaleService
{
    private final IProductRepository productRepository;

    public SimulateSaleService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
