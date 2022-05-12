package product.tv.interfaces;

import product.tv.TvProduct;

public interface ITvProductManager {
    Boolean addTvProduct(TvProduct product);
    Boolean deleteTvProduct(String productSudoId);
}
