package product.tv;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import product.IProduct;
import product.ProductAbstractClass;

@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class TvProduct extends ProductAbstractClass implements IProduct {
    private String tvsize;
    private Boolean smart;
    private String tvtype;
    @Builder
    public TvProduct(){ super();}
}
