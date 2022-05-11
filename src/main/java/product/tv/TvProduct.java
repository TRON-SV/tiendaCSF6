package product.tv;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import product.AProduct;

@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class TvProduct extends AProduct {
    private String tvsize;
    private Boolean smart;
    private String tvtype;
    @Builder
    public TvProduct(){ super();}
}
