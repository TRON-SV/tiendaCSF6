package product.cellphone;

import java.util.ArrayList;

public class CellphoneProductArchiver implements ICellphoneProductArchiver{

    CellphoneProduct cellphoneProduct = new CellphoneProduct();
    CellphoneProductPrinter productPrinter = new CellphoneProductPrinter();
    public ArrayList<CellphoneProduct> cellphoneProductList = new ArrayList<CellphoneProduct>();


    public ArrayList<CellphoneProduct> getCellphoneProductList() {
        return cellphoneProductList;
    }

    public void setCellphoneProductList(ArrayList<CellphoneProduct> cellphoneProductList) {
        this.cellphoneProductList = cellphoneProductList;
    }

    @Override
    public void addCellphoneProduct(CellphoneProduct product) {
        this.cellphoneProductList.add(product);
        productPrinter.displayMessage("--------------!PRODUCT "+ product.getId() +" ADDED!-----------------");
    }

    @Override
    public void deleteCellphoneProduct(Integer productSudoId) {
        boolean isTheProductFounded = false;
        for(int i=0; i<cellphoneProductList.size(); i++){
            if(cellphoneProductList.get(i).getId() == productSudoId){
                isTheProductFounded = true;
                this.cellphoneProductList.remove(i);
            }
        }
        if(isTheProductFounded==true){
            productPrinter.displayMessage("--------------!PRODUCT DELETED!-----------------");
        }else{
            productPrinter.displayMessage("--------------!PRODUCT NOT FOUNDED!-----------------");
        }
    }

    @Override
    public void modifyCellphoneProduct(CellphoneProduct product, int productId) {
        for(int i=0; i<cellphoneProductList.size(); i++){
            if(cellphoneProductList.get(i).getId() == productId){
                //PERFORMING A UPDATE OF THE PRODUCT DATA
                cellphoneProductList.get(i).setProductType(product.getProductType());
                cellphoneProductList.get(i).setPrice(product.getPrice());
                cellphoneProductList.get(i).setSerie(product.getSerie());
                cellphoneProductList.get(i).setTax(product.getTax());
                cellphoneProductList.get(i).setBrand(product.getBrand());
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
