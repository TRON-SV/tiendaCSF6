package product.computer.interfaces;

import product.computer.ComputerProduct;

public interface IComputerProductModifier {
    Boolean modifyComputerProduct(ComputerProduct product, String productId);
}
