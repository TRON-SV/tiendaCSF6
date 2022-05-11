package product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor
@Data
public abstract class AProduct {
    private String id;
    private EProductType productType;
    private String name;
    private Double price;
    private String brand;
    private Double tax;
}