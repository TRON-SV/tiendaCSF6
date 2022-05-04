package shoppingcar;

import User.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import product.EProductType;
import product.ProductAbstractClass;
import product.cellphone.CellphoneProduct;
import product.cellphone.CellphoneProductArchiver;
import product.cellphone.CellphoneProductFiller;
import product.computer.ComputerProduct;
import product.computer.ComputerProductArchiver;
import product.computer.ComputerProductFiller;
import product.console.ConsoleProduct;
import product.console.ConsoleProductArchiver;
import product.console.ConsoleProductFiller;
import product.tv.TvProduct;
import product.tv.TvProductArchiver;
import product.tv.TvProductFiller;

import java.util.ArrayList;

@AllArgsConstructor @NoArgsConstructor
public @Data class ShoppingCart {

    private Customer customer;
    ArrayList<ProductAbstractClass> iProductList = new ArrayList<>();
    ArrayList<ProductAbstractClass> iProductListBasic = new ArrayList<>();
    ArrayList<ConsoleProduct> iProductListDetails = new ArrayList<>();
    //---------------------------VARIABLES USED FOR CONSOLES------------------------------
    ArrayList<ConsoleProduct> consoleProductList = new ArrayList<>();
    ConsoleProductFiller consoleProductFiller = new ConsoleProductFiller();
    ConsoleProductArchiver consoleProductArchiver = new ConsoleProductArchiver();
    Integer consoleCounter, cellphoneCounter, computerCounter, tvCounter = 0;
    //---------------------------VARIABLES USED FOR CELLPHONES------------------------------
    ArrayList<CellphoneProduct> cellphoneProductList = new ArrayList<>();
    CellphoneProductFiller cellphoneProductFiller = new CellphoneProductFiller();
    CellphoneProductArchiver cellphoneProductArchiver = new CellphoneProductArchiver();
    //---------------------------VARIABLES USED FOR COMPUTERS------------------------------
    ArrayList<ComputerProduct> computerProductList = new ArrayList<>();
    ComputerProductFiller computerProductFiller = new ComputerProductFiller();
    ComputerProductArchiver computerProductArchiver = new ComputerProductArchiver();
    //---------------------------VARIABLES USED FOR TVs------------------------------
    ArrayList<TvProduct> tvProductList = new ArrayList<>();
    TvProductFiller tvProductFiller = new TvProductFiller();
    TvProductArchiver tvProductArchiver = new TvProductArchiver();


    public void addCellphone(ArrayList<CellphoneProduct> productList, String productId) {
        boolean isTheProductFounded = false;
        for(int i=0; i<productList.size(); i++){
            if(productList.get(i).getId().equals(productId)){
                isTheProductFounded = true;
                CellphoneProduct product = new CellphoneProduct(productList.get(i).getScreenSize(),productList.get(i).getProcessor(),
                        productList.get(i).getOperatingSystem(),productList.get(i).getMemoryRAM(),productList.get(i).getHardDrive(),
                        productList.get(i).getCamera());
                product.setId(productList.get(i).getId());
                this.cellphoneProductArchiver.getCellphoneProductList().add(productList.get(i));
                this.getCellphoneProductList().add(product);
                this.getIProductList().add(productList.get(i));
                return;
            }
        }
        if(isTheProductFounded){
            cellphoneProductArchiver.getProductPrinter().displayMessage("--------------!PRODUCT MOVED TO SHOPPING CART!-----------------");
        }else{
            cellphoneProductArchiver.getProductPrinter().displayMessage("--------------!PRODUCT NOT FOUNDED!-----------------");
        }
    }
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
                this.consoleProductArchiver.getConsoleProductList().add(productList.get(i));
                this.getConsoleProductList().add(product);
                this.getIProductList().add(productList.get(i));
                return;
            }
        }
        if(isTheProductFounded){
            consoleProductArchiver.getProductPrinter().displayMessage("--------------!PRODUCT MOVED TO SHOPPING CART!-----------------");
        }else{
            consoleProductArchiver.getProductPrinter().displayMessage("--------------!PRODUCT NOT FOUNDED!-----------------");
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
    public void displayProductInfo(ArrayList<ProductAbstractClass> productList) {
        System.out.println("-------------------------------------------------SHOPPING CART--------------------------------------------------------------------------------------------------------------------------");
        for(int i=0; i<productList.size() ; i++) {
            EProductType eProductType = productList.get(i).getProductType();
            switch (eProductType){
                case CELLPHONE:
                    System.out.println("#: "+productList.get(i).getId()
                            +"      Type: "+productList.get(i).getProductType()
                            +"      Name: "+productList.get(i).getName()
                            +"      Price: $"+productList.get(i).getPrice()
                            +"      Brand: "+productList.get(i).getBrand()
                            +"      Tax: $"+productList.get(i).getTax()
                            +"      Screen-Size: "+getCellphoneProductList().get(cellphoneCounter).getScreenSize()
                            +"      Processor: "+getCellphoneProductList().get(cellphoneCounter).getProcessor()
                            +"      OS: "+getCellphoneProductList().get(cellphoneCounter).getOperatingSystem()
                            +"      RAM: "+getCellphoneProductList().get(cellphoneCounter).getMemoryRAM()
                            +"      Hard-Drive: "+getCellphoneProductList().get(cellphoneCounter).getHardDrive()
                            +"      Camera: "+getCellphoneProductList().get(cellphoneCounter).getCamera()
                    );
                    cellphoneCounter++;
                    break;
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