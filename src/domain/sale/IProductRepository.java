package domain.sale;

import java.util.Collection;
import java.util.Optional;

public interface IProductRepository {
    void save(Produto produto);
    Optional<Produto> findByCodigo(String codigo);
    Collection<Produto> findAll();
}
