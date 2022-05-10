package product.console.interfaces;

import product.console.ConsoleProduct;

public interface IConsoleProductManager {
    Boolean addConsoleProduct(ConsoleProduct product);
    Boolean deleteConsoleProduct(String productSudoId);
}
