package dcu.common;

import java.util.List;
import dcu.common.DAO.ClaimDAO;
import dcu.common.DAO.ClaimDAOImpl;
import dcu.common.data.Claim;
import dcu.common.service.ClaimController;
import javassist.NotFoundException;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )throws IOException, NotFoundException
    {


        //ClaimController run = new ClaimController();

        App obj = new App();
        obj.run();

    }

    public void run() throws NotFoundException,IOException{

        ObjectMapper mapper = new ObjectMapper();

        Claim claim = createDummyObject();


        try {
            // Convert object to JSON string and save into a file directly
            FileOutputStream jsonfile = new FileOutputStream("newjson.json");
            mapper.writeValue(new File("newJson.json"), claim);

            // Convert object to JSON string
            String jsonInString = mapper.writeValueAsString(claim);
            System.out.println(jsonInString);

            // Convert object to JSON string and pretty print
            jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(claim);
            System.out.println(jsonInString);

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Claim createDummyObject() throws IOException, NotFoundException {


        Claim claim = new Claim();

        ClaimDAO claimTest ;

        //ClaimDAO claimDAO ;
        //java.util.List<Claim> claimList = claimDAO.getAllClaims();

        ClaimController claimController = new ClaimController();
        List<Claim> list = claimController.getClaimList();
        //ist<Claim> claimList = claimTest.getAllClaims();
        System.out.println("Claim List: " + list);


        claim.setClaimId(55);
        claim.setClaimReference("R1");




        return claim;

    }
}
