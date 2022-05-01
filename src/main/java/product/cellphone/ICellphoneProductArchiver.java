package product.cellphone;

import product.console.ConsoleProduct;

public interface ICellphoneProductArchiver {

    void addCellphoneProduct(CellphoneProduct product);
    void deleteCellphoneProduct(Integer productSudoId);
    void modifyCellphoneProduct(CellphoneProduct product, int productId);
}
