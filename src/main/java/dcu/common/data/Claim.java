package dcu.common.data;

/**
 * Created by Sean on 03/02/2016.
 */
public class Claim {

    private Integer claimId;

    private  String claimReference;


    public  Claim(){}
    public  Claim(Integer claimId, String claimReference){

        super();
        this.claimId = claimId;
        this.claimReference= claimReference;

    }

   public Integer getClaimId(){
       return claimId;

   }

    public void setClaimId(Integer claimId){

        this.claimId = claimId;
    }

    public String getClaimReference(){

        return claimReference;

    }

    public void setClaimReference(String claimReference) {
        this.claimReference = claimReference;
    }
}
