package product.cellphone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor @NoArgsConstructor
@Data
public class CellphoneProductArchiver implements ICellphoneProductArchiver, ICellphoneProductModifier {

    CellphoneProduct cellphoneProduct = new CellphoneProduct();
    CellphoneProductPrinter productPrinter = new CellphoneProductPrinter();
    public ArrayList<CellphoneProduct> cellphoneProductList = new ArrayList<CellphoneProduct>();

    @Override
    public void addCellphoneProduct(CellphoneProduct product) {
        this.cellphoneProductList.add(product);
        productPrinter.displayMessage("--------------!PRODUCT "+ product.getId() +" ADDED!-----------------");
    }

    @Override
    public void deleteCellphoneProduct(String productSudoId) {
        boolean isTheProductFounded = false;
        for(int i=0; i<cellphoneProductList.size(); i++){
            if(cellphoneProductList.get(i).getId().equals(productSudoId)){
                isTheProductFounded = true;
                this.cellphoneProductList.remove(i);
                break;
            }
        }
        if(isTheProductFounded==true){
            productPrinter.displayMessage("--------------!PRODUCT DELETED!-----------------");
        }else{
            productPrinter.displayMessage("--------------!PRODUCT NOT FOUNDED!-----------------");
        }
    }

    @Override
    public void modifyCellphoneProduct(CellphoneProduct product, String productId) {
        for(int i=0; i<cellphoneProductList.size(); i++){
            if(cellphoneProductList.get(i).getId().equals(productId)){
                //PERFORMING A UPDATE OF THE PRODUCT DATA
                cellphoneProductList.get(i).setProductType(product.getProductType());
                cellphoneProductList.get(i).setName(product.getName());
                cellphoneProductList.get(i).setPrice(product.getPrice());
                cellphoneProductList.get(i).setBrand(product.getBrand());
                cellphoneProductList.get(i).setTax(product.getTax());
                cellphoneProductList.get(i).setScreenSize(product.getScreenSize());
                cellphoneProductList.get(i).setProcessor(product.getProcessor());
                cellphoneProductList.get(i).setOperatingSystem(product.getOperatingSystem());
                cellphoneProductList.get(i).setMemoryRAM(product.getMemoryRAM());
                cellphoneProductList.get(i).setHardDrive(product.getHardDrive());
                cellphoneProductList.get(i).setCamera(product.getCamera());
                productPrinter.displayMessage("--------------!PRODUCT UPDATED!-----------------");
            }
        }
    }
}
