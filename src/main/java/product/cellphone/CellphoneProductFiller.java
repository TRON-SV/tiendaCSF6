package product.cellphone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import product.EProductType;

@NoArgsConstructor
public class CellphoneProductFiller implements IFillSingleCellphoneProduct, IFillSeveralCellphoneProduct{
    @Override
    public void fillProducts(Integer quantity, CellphoneProductArchiver productArchiver) {
        for(int i=0; i<quantity; i++) {
            CellphoneProduct cellphoneProduct = new CellphoneProduct();
            cellphoneProduct.setId(productArchiver.cellphoneProductList.size());
            cellphoneProduct.setProductType(EProductType.CELLPHONE);
            cellphoneProduct.setPrice(500);
            cellphoneProduct.setSerie("Product " + i);
            cellphoneProduct.setBrand("Product brand" +i);
            cellphoneProduct.setTax(500);
            cellphoneProduct.setScreenSize("6,5");
            cellphoneProduct.setProcessor("Snapdragon");
            cellphoneProduct.setOperatingSystem("Android 8.0");
            cellphoneProduct.setMemoryRAM(8);
            cellphoneProduct.setHardDrive(256);
            cellphoneProduct.setCamera(12);
            productArchiver.addCellphoneProduct(cellphoneProduct);
        }
    }

    @Override
    public void fillProduct(CellphoneProduct product, CellphoneProductArchiver productArchiver) {
        productArchiver.cellphoneProduct = product;
        product.setId(productArchiver.cellphoneProductList.size());

    }
}
