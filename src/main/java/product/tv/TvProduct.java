package product.tv;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import product.ProductAbstractClass;

@AllArgsConstructor
@Data
public class TvProduct extends ProductAbstractClass {
    private String tvsize;
    private Boolean smart;
    private String tvtype;
    @Builder
    public TvProduct(){ super();}
}
