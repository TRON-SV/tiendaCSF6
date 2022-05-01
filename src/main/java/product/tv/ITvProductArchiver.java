package product.tv;

import product.tv.TvProduct;

public interface ITvProductArchiver {
    void addTvProduct(TvProduct product);
    void deleteTvProduct(Integer productSudoId);
    void modifyTvProduct(TvProduct product, int productId);
}
