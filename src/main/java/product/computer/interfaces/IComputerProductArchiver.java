package product.computer.interfaces;

import product.computer.ComputerProduct;

public interface IComputerProductArchiver {
    void addComputerProduct(ComputerProduct product);
    void deleteComputerProduct(Integer productId);
    void modifyComputerProduct(ComputerProduct product, Integer productId);
}
