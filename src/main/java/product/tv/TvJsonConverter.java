package product.tv;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import product.computer.ComputerProduct;

import java.io.File;
import java.util.ArrayList;

@AllArgsConstructor @NoArgsConstructor
@Data
public class TvJsonConverter {
    private static final Logger LOGGER = LogManager.getLogger(TvJsonConverter.class);
    String arrayToJson;
    ArrayList<TvProduct> productList = new ArrayList<>();
    ObjectMapper objectMapper = new ObjectMapper();

    @Builder
    public TvJsonConverter(ArrayList<TvProduct> productList){
        this.productList = productList;
    }
    public void exportToJson(){
        try {
            objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(new File("src/main/resources/jsonFiles/tvList.json"), getProductList());
            System.out.println("PRODUCTS EXPORTED TO -> src/main/resources/jsonFiles/tvList.json");
        }catch (Exception e){
            LOGGER.fatal(e.getMessage());
            LOGGER.fatal("An unexpected error happened. Please try again" + e, e);
        }
    }
    public ArrayList<TvProduct> importFromJson(){
        try {
            TypeReference<ArrayList<TvProduct>> mapType = new TypeReference<>() {};
            setProductList(objectMapper.readValue(new File("src/main/resources/jsonFiles/tvList.json"),mapType));
            System.out.println("!Loaded Data From JSON file!");
        }catch (Exception e){
            LOGGER.fatal(e.getMessage());
            LOGGER.fatal("An unexpected error happened. Please try again" + e, e);
        }
        return getProductList();
    }
}
