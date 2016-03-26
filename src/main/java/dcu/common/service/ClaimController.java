
package dcu.common.service;

import dcu.common.DAO.ClaimDAO;
import dcu.common.DAO.ClaimDAOImpl;
import dcu.common.data.Claim;
import javassist.NotFoundException;
//import org.apache.http.HttpEntity;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.hibernate.Transaction;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Created by Sean on 06/02/2016.
 */

@RequestMapping("/claims")
public class ClaimController {


    //Claim claim ;
    ClaimDAOImpl claimDAOImpl = new ClaimDAOImpl() ;

    //@ResponseBody
    //@RequestMapping(value = "/getAllClaims/",method = RequestMethod.GET)
    public HttpEntity<List<Claim>> getClaim()
            throws JsonMappingException,JsonGenerationException, IOException, NotFoundException{

        List<Claim> claimList = claimDAOImpl.getAllClaims();

        if(claimList == null){
            throw new NotFoundException("claim does not exist");
        }

        //mapping claim here ---> appclaim, not sure if I need to do this

        //List<Claim> resourceList= claimAssembler.toResources(claimList);

        //return claimList;
        return new ResponseEntity<List<Claim>>(claimList,HttpStatus.OK);


    }

    @ResponseBody
    @RequestMapping(value = "/getAllClaims/",method = RequestMethod.GET)
    public List<Claim> getClaimList()
            throws JsonMappingException,JsonGenerationException, IOException, NotFoundException{


        claimDAOImpl.printmsg();
        System.out.println("In controller now");
        List<Claim> claimList = claimDAOImpl.getAllClaims();

        System.out.println("here");
        if(claimList == null){
            throw new NotFoundException("claim does not exist");
        }


        //mapping claim here ---> appclaim, not sure if I need to do this

        //List<Claim> resourceList= claimAssembler.toResources(claimList);


        return claimList;


    }
/*
    @RequestMapping(value="{name}", method = RequestMethod.GET)
    public @ResponseBody Claim getClaimInXML(@PathVariable String name) {

        Coffee coffee = new Coffee(name, 100);

        return coffee;

    }
    */

/*
    @ResponseBody
    @RequestMapping(value = "/claimReference/{claimReference}",method = RequestMethod.GET)
    public HttpEntity<Claim> getClaimByClaimReference
            (@PathVariable final String claimReference)
    throws JsonMappingException,JsonGenerationException, IOException, NotFoundException{

        Claim claim = claimDAO.getClaimByRef(claimReference);

        if(claim == null){
            throw new NotFoundException("claim does not exist");
        }

        //mapping claim here ---> appclaim, not sure if I need to do this

        List<Claim> resourceList= claimAssembler.toResources(claim);

        return new ResponseEntity<Claim>(resourceList,HttpStatus.OK);


    }
    */
}
