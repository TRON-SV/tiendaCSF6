package product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor
@Data
public abstract class ProductAbstractClass implements IProduct{
    private String id;
    private EProductType productType;
    private String name;
    private double price;
    private String brand;
    private double tax;
}