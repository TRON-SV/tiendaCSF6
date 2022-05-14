package product.tv.interfaces;

import product.tv.TvProduct;

public interface ITvProductModifier {
    Boolean modifyTvProduct(TvProduct product, String productId);
}
