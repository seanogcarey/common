package dcu.common.DAO;

import dcu.common.data.Claim;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Sean on 03/02/2016.
 */
public class ClaimDAOImpl implements ClaimDAO {


    private static final String CLAIM_REF = "claimReference";


    private SessionFactory sf;

    public List<Claim> getAllClaims() {

        return null;
    }

    public Claim getClaimByRef(final String claimReference){

        return (Claim) sf.getCurrentSession().getNamedQuery("getByRef")
                .setString(CLAIM_REF, claimReference).uniqueResult();
    }


}
