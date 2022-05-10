package shoppingcar;

import User.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import product.AProduct;
import product.EProductType;
import product.computer.ComputerProduct;
import product.computer.ComputerProductArchiver;
import product.computer.ComputerProductFiller;
import product.console.ConsoleProduct;
import product.console.ConsoleProductManager;
import product.console.ConsoleProductFiller;
import product.tv.TvProduct;
import product.tv.TvProductManager;
import product.tv.TvProductFiller;

import java.util.ArrayList;

@AllArgsConstructor @NoArgsConstructor
public @Data class ShoppingCart {

    private Customer customer;
    ArrayList<AProduct> iProductList = new ArrayList<>();
    ArrayList<AProduct> iProductListBasic = new ArrayList<>();
    ArrayList<ConsoleProduct> iProductListDetails = new ArrayList<>();
    //---------------------------VARIABLES USED FOR CONSOLES------------------------------
    ArrayList<ConsoleProduct> consoleProductList = new ArrayList<>();
    ConsoleProductFiller consoleProductFiller = new ConsoleProductFiller();
    ConsoleProductManager consoleProductManager = new ConsoleProductManager();
    Integer consoleCounter, cellphoneCounter, computerCounter, tvCounter = 0;
    //---------------------------VARIABLES USED FOR COMPUTERS------------------------------
    ArrayList<ComputerProduct> computerProductList = new ArrayList<>();
    ComputerProductFiller computerProductFiller = new ComputerProductFiller();
    ComputerProductArchiver computerProductArchiver = new ComputerProductArchiver();
    //---------------------------VARIABLES USED FOR TVs------------------------------
    ArrayList<TvProduct> tvProductList = new ArrayList<>();
    TvProductFiller tvProductFiller = new TvProductFiller();
    TvProductManager tvProductArchiver = new TvProductManager();

    public void addComputer(ArrayList<ComputerProduct> productList, String productId) {
        boolean isTheProductFounded = false;
        for(int i=0; i<productList.size(); i++){
            if(productList.get(i).getId().equals(productId)){
                isTheProductFounded = true;
                ComputerProduct product = new ComputerProduct(productList.get(i).getOperativeSystem(),
                        productList.get(i).getProcessor(),productList.get(i).getSize(),
                        productList.get(i).getMemoryRam(),productList.get(i).getHardDisk(),productList.get(i).getDescription());
                product.setId(productList.get(i).getId());
                this.computerProductArchiver.getComputerProductList().add(productList.get(i));
                this.getComputerProductList().add(product);
                this.getIProductList().add(productList.get(i));
                return;
            }
        }
        if(isTheProductFounded){
            computerProductArchiver.getProductPrinter().displayMessage("--------------!PRODUCT MOVED TO SHOPPING CART!-----------------");
        }else{
            computerProductArchiver.getProductPrinter().displayMessage("--------------!PRODUCT NOT FOUNDED!-----------------");
        }
    }
    public void addConsole(ArrayList<ConsoleProduct> productList, String productId) {
        boolean isTheProductFounded = false;
        for(int i=0; i<productList.size(); i++){
            if(productList.get(i).getId().equals(productId)){
                isTheProductFounded = true;
                ConsoleProduct product = new ConsoleProduct(productList.get(i).getDiskCapacity(), productList.get(i).getDiskReader());
                product.setId(productList.get(i).getId());
                this.consoleProductManager.getConsoleProductList().add(productList.get(i));
                this.getConsoleProductList().add(product);
                this.getIProductList().add(productList.get(i));
                return;
            }
        }
        if(isTheProductFounded){
            consoleProductManager.getProductPrinter().displayMessage("--------------!PRODUCT MOVED TO SHOPPING CART!-----------------");
        }else{
            consoleProductManager.getProductPrinter().displayMessage("--------------!PRODUCT NOT FOUNDED!-----------------");
        }
    }
    public void addTv(ArrayList<TvProduct> productList, String productId) {
        boolean isTheProductFounded = false;
        for(int i=0; i<productList.size(); i++){
            if(productList.get(i).getId().equals(productId)){
                isTheProductFounded = true;
                TvProduct product = new TvProduct(productList.get(i).getTvsize(),productList.get(i).getSmart(),productList.get(i).getTvtype());
                product.setId(productList.get(i).getId());
                this.tvProductArchiver.getTvProductList().add(productList.get(i));
                this.getTvProductList().add(product);
                this.getIProductList().add(productList.get(i));
                return;
            }
        }
        if(isTheProductFounded){
            tvProductArchiver.getProductPrinter().displayMessage("--------------!PRODUCT MOVED TO SHOPPING CART!-----------------");
        }else{
            tvProductArchiver.getProductPrinter().displayMessage("--------------!PRODUCT NOT FOUNDED!-----------------");
        }
    }
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
                            +"      OS: "+getComputerProductList().get(computerCounter).getOperativeSystem()
                            +"      Processor: "+getComputerProductList().get(computerCounter).getProcessor()
                            +"      Size: "+getComputerProductList().get(computerCounter).getSize()
                            +"      RAM: "+getComputerProductList().get(computerCounter).getMemoryRam()
                            +"      Hard-Disk: "+getComputerProductList().get(computerCounter).getHardDisk()
                            +"      Description: "+getComputerProductList().get(computerCounter).getDescription()
                    );
                    computerCounter++;
                    break;
                case CONSOLE:
                    System.out.println("#: "+productList.get(i).getId()
                            +"      Type: "+productList.get(i).getProductType()
                            +"      Name: "+productList.get(i).getName()
                            +"      Price: $"+productList.get(i).getPrice()
                            +"      Brand: "+productList.get(i).getBrand()
                            +"      Tax: $"+productList.get(i).getTax()
                            +"      Disk-Capacity: "+getConsoleProductList().get(consoleCounter).getDiskCapacity()
                            +"      Disk-Reader: "+getConsoleProductList().get(consoleCounter).getDiskReader()
                    );
                    consoleCounter++;
                    break;
                case TV:
                    System.out.println("#: "+productList.get(i).getId()
                            +"      Type: "+productList.get(i).getProductType()
                            +"      Name: "+productList.get(i).getName()
                            +"      Price: $"+productList.get(i).getPrice()
                            +"      Brand: "+productList.get(i).getBrand()
                            +"      Tax: $"+productList.get(i).getTax()
                            +"      Size: "+getTvProductList().get(tvCounter).getTvsize()
                            +"      Smart: "+getTvProductList().get(tvCounter).getSmart()
                            +"      TV-Type: "+getTvProductList().get(tvCounter).getTvtype()
                    );
                    tvCounter++;
                    break;
            }
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }//FOR LOOP
        cellphoneCounter=0; computerCounter=0; consoleCounter=0; tvCounter = 0;
    }
}