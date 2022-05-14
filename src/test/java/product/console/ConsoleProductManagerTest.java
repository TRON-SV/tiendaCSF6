package product.console;

import junit.framework.TestCase;

public class ConsoleProductManagerTest extends TestCase {

    private ConsoleProductManager productManager;

    public ConsoleProductManagerTest(String name) {
        super(name);
    }

    public void setUp() {
        productManager = new ConsoleProductManager();
    }

    public void testAddConsole() {
        // Insert the product to test
        System.out.println("[Add Console Test]: ");

        ConsoleProduct product = new ConsoleProduct();
        product.setDiskCapacity(1000);
        product.setDiskReader(false);
        System.out.println("Product created");

        boolean added = productManager.addConsoleProduct(product);
        System.out.println("Product inserted?: " + added + "\n");
        assertTrue(added);
    }

    public void testDeleteConsole() {
        System.out.println("[Delete Console Test]: ");

        // Create a product
        ConsoleProduct product = new ConsoleProduct();
        product.setId("CON-15");
        product.setDiskCapacity(1000);
        product.setDiskReader(false);

        // Add product to test
        productManager.addConsoleProduct(product);
        System.out.println("Product inserted");

        // Test method "deleteConsoleProduct", the result should be true
        boolean deleted = productManager.deleteConsoleProduct(product.getId());
        System.out.println("Product deleted?: " + deleted + "\n");
        assertTrue(deleted);
    }

    public void testModifyProduct() {
        System.out.println("[Modify Console Test]: ");

        // Create a product to modify
        ConsoleProduct product = new ConsoleProduct();
        product.setId("CON-15");
        product.setDiskCapacity(1000);
        product.setDiskReader(false);
        productManager.addConsoleProduct(product);
        System.out.println("Product to modify inserted");

        // Create a product modifier
        ConsoleProduct product2 = new ConsoleProduct();
        product2.setId("CON-20");
        product2.setDiskCapacity(500);
        product2.setDiskReader(true);
        System.out.println("Product modifier created");

        boolean modified = productManager.modifyProduct(product2, product.getId());
        System.out.println("Product modified?: " + modified + "\n");
        assertTrue(modified);
    }

    public void testGenerateId() {
        ConsoleProduct product = new ConsoleProduct();
        product.setId(productManager.generateId());
        product.setDiskCapacity(1000);
        product.setDiskReader(false);
        productManager.addConsoleProduct(product);
        System.out.println("Product inserted");

        System.out.println("Expected: CON-0");
        System.out.println("Result: " + product.getId());
        assertEquals(product.getId(),"CON-0");
    }
}