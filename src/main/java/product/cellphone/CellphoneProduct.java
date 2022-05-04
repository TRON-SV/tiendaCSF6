package product.cellphone;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import product.IDeviceSwitcher;
import product.IProduct;
import product.ProductAbstractClass;
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class CellphoneProduct extends ProductAbstractClass implements IProduct,IDeviceSwitcher {
    private String screenSize;
    private String processor;
    private String operatingSystem;
    private Integer memoryRAM;
    private Integer hardDrive;
    private Integer camera;

    @Builder
    public CellphoneProduct() {
        super();
    }

    @Override
    public void turnOnDevice() {
        System.out.println("Turning ON Device...");
    }

    @Override
    public void turnOffDevice() {
        System.out.println("Turning OFF Device...");
    }
}
