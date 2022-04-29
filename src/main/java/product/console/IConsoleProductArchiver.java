package product.console;

public interface IConsoleProductArchiver {
    void addConsoleProduct(ConsoleProduct product);
    void deleteConsoleProduct(Integer productSudoId);
    void modifyConsoleProduct(ConsoleProduct product, int productId);
}
