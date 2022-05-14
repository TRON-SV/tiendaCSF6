package product.console;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
@AllArgsConstructor @NoArgsConstructor
@Data
public class ConsoleJsonConverter {
    private static final Logger LOGGER = LogManager.getLogger(ConsoleJsonConverter.class);
    String arrayToJson;
    ArrayList<ConsoleProduct> productList = new ArrayList<>();
    ObjectMapper objectMapper = new ObjectMapper();

    @Builder
    public ConsoleJsonConverter(ArrayList<ConsoleProduct> productList){
        this.productList = productList;
    }
    public void exportToJson(){
        try {
            objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(new File("src/main/resources/jsonFiles/consoleList.json"), getProductList());
            System.out.println("PRODUCTS EXPORTED TO -> src/main/resources/jsonFiles/consoleList.json");
        }catch (Exception e){
            LOGGER.fatal(e.getMessage());
            LOGGER.fatal("An unexpected error happened. Please try again" + e, e);
        }
    }
    public ArrayList<ConsoleProduct> importFromJson(){
        try {
            TypeReference<ArrayList<ConsoleProduct>> mapType = new TypeReference<>() {};
            setProductList(objectMapper.readValue(new File("src/main/resources/jsonFiles/consoleList.json"),mapType));
            System.out.println("!Loaded Data From JSON file!");
        }catch (Exception e){
            LOGGER.fatal(e.getMessage());
            LOGGER.fatal("An unexpected error happened. Please try again" + e, e);
        }
        return getProductList();
    }
}
