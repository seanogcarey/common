package dcu.common.hibernate;

import javax.persistence.*;

/**
 * Created by Sean on 12/02/2016.
 */
@Entity
@Table(name = "Claim", schema = "dbo", catalog = "SSMS-demo")
public class ClaimEntity {
    @Id
    private int claimId;
    private String claimReference;


    @Column(name = "claimId", nullable = false)
    public int getClaimId() {
        return claimId;
    }

    public void setClaimId(int claimId) {
        this.claimId = claimId;
    }

    @Basic
    @Column(name = "claimReference", nullable = true)
    public String getClaimReference() {
        return claimReference;
    }

    public void setClaimReference(String claimReference) {
        this.claimReference = claimReference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClaimEntity that = (ClaimEntity) o;

        if (claimId != that.claimId) return false;
        if (claimReference != null ? !claimReference.equals(that.claimReference) : that.claimReference != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = claimId;
        result = 31 * result + (claimReference != null ? claimReference.hashCode() : 0);
        return result;
    }
}
