package shoppingcar;

import User.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import product.AProduct;
import product.EProductType;
import product.computer.ComputerProduct;
import product.computer.ComputerProductArchiver;
import product.computer.ComputerProductFiller;
import product.console.ConsoleProduct;
import product.console.ConsoleProductManager;
import product.console.ConsoleProductFiller;
import product.console.MenuConsole;
import product.tv.TvProduct;
import product.tv.TvProductManager;
import product.tv.TvProductFiller;

import java.util.ArrayList;

@AllArgsConstructor @NoArgsConstructor
public @Data class ShoppingCart {
    private static final Logger LOGGER = LogManager.getLogger(MenuConsole.class);
    private Customer customer;
    ArrayList<AProduct> iProductList = new ArrayList<>();
    ArrayList<AProduct> iProductListBasic = new ArrayList<>();
    ArrayList<ConsoleProduct> iProductListDetails = new ArrayList<>();
    //---------------------------VARIABLES USED FOR CONSOLES------------------------------
    ArrayList<ConsoleProduct> consoleProductList = new ArrayList<>();
    ConsoleProductFiller consoleProductFiller = new ConsoleProductFiller();
    ConsoleProductManager consoleProductManager = new ConsoleProductManager();
    Integer consoleCounter, computerCounter, tvCounter = 0;
    //---------------------------VARIABLES USED FOR COMPUTERS------------------------------
    ArrayList<ComputerProduct> computerProductList = new ArrayList<>();
    ComputerProductFiller computerProductFiller = new ComputerProductFiller();
    ComputerProductArchiver computerProductArchiver = new ComputerProductArchiver();
    //---------------------------VARIABLES USED FOR TVs------------------------------
    ArrayList<TvProduct> tvProductList = new ArrayList<>();
    TvProductFiller tvProductFiller = new TvProductFiller();
    TvProductManager tvProductArchiver = new TvProductManager();

    public Boolean addComputer(ArrayList<ComputerProduct> productList, String productId) {
        for(int i=0; i<productList.size(); i++){
            if(productList.get(i).getId().equals(productId)){
                ComputerProduct product = new ComputerProduct(productList.get(i).getOperativeSystem(),
                        productList.get(i).getProcessor(),productList.get(i).getSize(),
                        productList.get(i).getMemoryRam(),productList.get(i).getHardDisk(),productList.get(i).getDescription());
                product.setId(productList.get(i).getId());
                this.computerProductArchiver.getComputerProductList().add(productList.get(i));
                this.getComputerProductList().add(product);
                this.getIProductList().add(productList.get(i));
                return true;
            }
        }
        return false;
    }
    public Boolean addConsole(ArrayList<ConsoleProduct> productList, String productId) {
        for(int i=0; i<productList.size(); i++){
            if(productList.get(i).getId().equals(productId)){
                ConsoleProduct product = new ConsoleProduct(productList.get(i).getDiskCapacity(), productList.get(i).getDiskReader());
                product.setId(productList.get(i).getId());
                this.consoleProductManager.getConsoleProductList().add(productList.get(i));
                this.getConsoleProductList().add(product);
                this.getIProductList().add(productList.get(i));
                return true;
            }
        }
        return false;
    }
    public Boolean addTv(ArrayList<TvProduct> productList, String productId) {
        for(int i=0; i<productList.size(); i++){
            if(productList.get(i).getId().equals(productId)){
                TvProduct product = new TvProduct(productList.get(i).getTvsize(),productList.get(i).getSmart(),productList.get(i).getTvtype());
                product.setId(productList.get(i).getId());
                this.tvProductArchiver.getTvProductList().add(productList.get(i));
                this.getTvProductList().add(product);
                this.getIProductList().add(productList.get(i));
                return true;
            }
        }
        return false;
    }
}