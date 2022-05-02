package product.computer.interfaces;

import product.computer.ComputerProduct;

public interface IComputerProductArchiver {
    void addComputerProduct(ComputerProduct product);
    void deleteComputerProduct(Integer productId);
}
