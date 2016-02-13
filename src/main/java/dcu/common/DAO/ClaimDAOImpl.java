package dcu.common.DAO;

import dcu.common.data.Claim;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction

import java.util.List;

/**
 * Created by Sean on 03/02/2016.
 */

@Repository

public class ClaimDAOImpl implements ClaimDAO {


    private static final String CLAIM_REF = "claimReference";

    @Autowired
    private SessionFactory sf  ;

    public void printmsg() {
        System.out.println("msg");
    }

    public List<Claim> getAllClaims() {


        System.out.println("Getting all claims");
        return (List<Claim>) sf.getCurrentSession().getNamedQuery("getAllClaimsInfo");

    }

    public Claim getClaimByRef(final String claimReference){

        return (Claim) sf.getCurrentSession().getNamedQuery("getByRef")
                .setString(CLAIM_REF, claimReference).uniqueResult();
    }


}
