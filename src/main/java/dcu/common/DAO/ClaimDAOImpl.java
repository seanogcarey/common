package dcu.common.DAO;

import dcu.common.data.Claim;
import dcu.common.hibernate.SessionFactoryHelper;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

/**
 * Created by Sean on 03/02/2016.
 */

@Repository
@Transactional
public class ClaimDAOImpl implements ClaimDAO {


    private static final String CLAIM_REF = "claimReference";

    private static final String SELECT_CLAIM = "select claimId,claimReference from [SSMS-demo].dbo.Claim";


    @Autowired
    private SessionFactory sf =null ;

    /*
    @Autowired
    public void setSessionFactory(SessionFactory sf) {
        this.sf = sf;
    }
    */

    public void printmsg() {
        System.out.println("msg");
    }

    @SuppressWarnings("unchecked")
    @Transactional
    public List<Claim> getAllClaims() {
        System.out.println("----------in get all claims-----------");

        //begin transaction
        Session session = SessionFactoryHelper.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        System.out.println("transaction");

        sf = SessionFactoryHelper.getSessionFactory();
        System.out.println("Got Session Factory");
        //Transaction tx = getCurrent().beginTransaction();
        //Query query = session.getNamedQuery("getAllClaimsInfo");
        sf.getCurrentSession().getNamedQuery("getAllClaimsInfo");

        //commit transaction
        session.getTransaction().commit();

        //sf.close();
        return (List<Claim>) sf.getCurrentSession().getNamedQuery("getAllClaimsInfo");
        //return null ;//"getAllClaimsInfo"

    }

    public Claim getClaimByRef(final String claimReference){

        return (Claim) sf.getCurrentSession().getNamedQuery(SELECT_CLAIM)
                .setString(CLAIM_REF, claimReference).uniqueResult();
    }


}
