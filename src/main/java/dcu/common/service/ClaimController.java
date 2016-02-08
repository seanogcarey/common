
package dcu.common.service;

import dcu.common.DAO.ClaimDAO;
import dcu.common.data.Claim;
import javassist.NotFoundException;
//import org.apache.http.HttpEntity;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Created by Sean on 06/02/2016.
 */
public class ClaimController {


    //Claim claim ;
    ClaimDAO claimDAO ;

    @ResponseBody
    @RequestMapping(value = "/claimReference/{claimReference}",method = RequestMethod.GET)
    public HttpEntity<List<ClaimResource>> getClaimByClaimReference
            (@PathVariable final Integer claimReference)
    throws JsonMappingException,JsonGenerationException, IOException, NotFoundException{

        List<Claim> claim = claimDAO.getClaimByClaimReference(claimReference);

        if(claim == null){
            throw new NotFoundException("claim does not exist");
        }

        //mapping claim here ---> appclaim, not sure if I need to do this

        List<ClaimResource> resourceList= claimAssembler.toResources(claim);

        return new ResponseEntity<List<ClaimResource>>(resourceList,HttpStatus.OK);


    }
}
