package dcu.common.DAO;

import dcu.common.data.Claim;

import java.util.List;

/**
 * Created by Sean on 03/02/2016.
 */
public interface ClaimDAO {

        public List<Claim> getAllClaims();

        public Claim getClaimByRef(final String claimReference);


}
