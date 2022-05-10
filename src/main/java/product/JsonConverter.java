package product;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.*;
import product.console.ConsoleProduct;

import java.io.File;
import java.util.ArrayList;
@AllArgsConstructor @NoArgsConstructor
@Data
public class JsonConverter {
    String arrayToJson;
    ArrayList<ConsoleProduct> productList = new ArrayList<>();
    ObjectMapper objectMapper = new ObjectMapper();

    @Builder
    public JsonConverter(ArrayList<ConsoleProduct> productList){
        this.productList = productList;
    }
    public void exportToJson(){
        try {
            objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(new File("src/main/resources/productList.json"), getProductList());
            System.out.println("PRODUCTS EXPORTED TO -> src/main/resources/productList.json");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public ArrayList<ConsoleProduct> importFromJson(){
        try {
            TypeReference<ArrayList<ConsoleProduct>> mapType = new TypeReference<>() {};
            setProductList(objectMapper.readValue(new File("src/main/resources/productList.json"),mapType));
            System.out.println("!Loaded Data From JSON file!");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return getProductList();
    }
}
