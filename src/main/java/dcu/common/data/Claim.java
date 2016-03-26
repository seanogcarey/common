package dcu.common.data;

import javax.persistence.*;

/**
 * Created by Sean on 03/02/2016.
 */
@Entity
@Table(name = "Claim", schema = "dbo", catalog = "SSMS-demo")
public class Claim {


    private Integer claimId;

    private  String claimReference;


    public  Claim(){}
    public  Claim(Integer claimId, String claimReference){

        super();
        this.claimId = claimId;
        this.claimReference= claimReference;

    }

    @Id
    @Column(name = "claimId", nullable = false)
   public Integer getClaimId(){
       return claimId;

   }

    public void setClaimId(Integer claimId){

        this.claimId = claimId;
    }

    @Basic
    @Column(name = "claimReference", nullable = true)
    public String getClaimReference(){

        return claimReference;

    }

    public void setClaimReference(String claimReference) {
        this.claimReference = claimReference;
    }
}
