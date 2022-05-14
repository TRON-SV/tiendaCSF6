package shoppingcar;

import product.AProduct;
import product.EProductType;

import java.util.ArrayList;

public class CartPrinter implements ICartPrinter{
    ShoppingCart cart;
    public CartPrinter(ShoppingCart cart){
        this.cart = cart;
    }
    @Override
    public void displayProductInfo(ArrayList<AProduct> productList) {
        System.out.println("-------------------------------------------------SHOPPING CART--------------------------------------------------------------------------------------------------------------------------");
        for(int i=0; i<productList.size() ; i++) {
            EProductType eProductType = productList.get(i).getProductType();
            switch (eProductType){
                case COMPUTER:
                    System.out.println("#: "+productList.get(i).getId()
                            +"      Type: "+productList.get(i).getProductType()
                            +"      Name: "+productList.get(i).getName()
                            +"      Price: $"+productList.get(i).getPrice()
                            +"      Brand: "+productList.get(i).getBrand()
                            +"      Tax: $"+productList.get(i).getTax()
                            +"      OS: "+cart.getComputerProductList().get(cart.getComputerCounter()).getOperativeSystem()
                            +"      Processor: "+cart.getComputerProductList().get(cart.getComputerCounter()).getProcessor()
                            +"      Size: "+cart.getComputerProductList().get(cart.getComputerCounter()).getSize()
                            +"      RAM: "+cart.getComputerProductList().get(cart.getComputerCounter()).getMemoryRam()
                            +"      Hard-Disk: "+cart.getComputerProductList().get(cart.getComputerCounter()).getHardDisk()
                    );
                    cart.setComputerCounter(cart.getComputerCounter()+1);
                    break;
                case CONSOLE:
                    System.out.println("#: "+productList.get(i).getId()
                            +"      Type: "+productList.get(i).getProductType()
                            +"      Name: "+productList.get(i).getName()
                            +"      Price: $"+productList.get(i).getPrice()
                            +"      Brand: "+productList.get(i).getBrand()
                            +"      Tax: $"+productList.get(i).getTax()
                            +"      Disk-Capacity: "+cart.getConsoleProductList().get(cart.getConsoleCounter()).getDiskCapacity()
                            +"      Disk-Reader: "+cart.getConsoleProductList().get(cart.getConsoleCounter()).getDiskReader()
                    );
                    cart.setConsoleCounter(cart.getConsoleCounter()+1);
                    break;
                case TV:
                    System.out.println("#: "+productList.get(i).getId()
                            +"      Type: "+productList.get(i).getProductType()
                            +"      Name: "+productList.get(i).getName()
                            +"      Price: $"+productList.get(i).getPrice()
                            +"      Brand: "+productList.get(i).getBrand()
                            +"      Tax: $"+productList.get(i).getTax()
                            +"      Size: "+cart.getTvProductList().get(cart.getTvCounter()).getTvsize()
                            +"      Smart: "+cart.getTvProductList().get(cart.getTvCounter()).getSmart()
                            +"      TV-Type: "+cart.getTvProductList().get(cart.getTvCounter()).getTvtype()
                    );
                    cart.setTvCounter(cart.getTvCounter()+1);
                    break;
            }
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }//FOR LOOP
        cart.setComputerCounter(0); cart.setConsoleCounter(0); cart.setTvCounter(0);
    }
}
