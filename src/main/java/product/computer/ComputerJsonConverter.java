package product.computer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.ArrayList;

@AllArgsConstructor @NoArgsConstructor
@Data
public class ComputerJsonConverter {
    private static final Logger LOGGER = LogManager.getLogger(ComputerJsonConverter.class);
    String arrayToJson;
    ArrayList<ComputerProduct> productList = new ArrayList<>();
    ObjectMapper objectMapper = new ObjectMapper();

    @Builder
    public ComputerJsonConverter(ArrayList<ComputerProduct> productList){
        this.productList = productList;
    }
    public void exportToJson(){
        try {
            objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(new File("src/main/resources/jsonFiles/computerList.json"), getProductList());
            System.out.println("PRODUCTS EXPORTED TO -> src/main/resources/jsonFiles/computerList.json");
        }catch (Exception e){
            LOGGER.fatal(e.getMessage());
            LOGGER.fatal("An unexpected error happened. Please try again" + e, e);
        }
    }
    public ArrayList<ComputerProduct> importFromJson(){
        try {
            TypeReference<ArrayList<ComputerProduct>> mapType = new TypeReference<>() {};
            setProductList(objectMapper.readValue(new File("src/main/resources/jsonFiles/computerList.json"),mapType));
            System.out.println("!Loaded Data From JSON file!");
        }catch (Exception e){
            LOGGER.fatal(e.getMessage());
            LOGGER.fatal("An unexpected error happened. Please try again" + e, e);
        }
        return getProductList();
    }
}
