package product.computer.interfaces;

import product.computer.ComputerProduct;

public interface IComputerProductManager {
    Boolean addComputerProduct(ComputerProduct product);
    Boolean deleteComputerProduct(String productId);
}
