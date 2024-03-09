package com.jberger.eleasecrud.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "leases")
public class Lease {

    @JsonIgnoreProperties("leases")
    @ManyToOne
    @JoinColumn(name="leaseholder_id", nullable=false)
    private Leaseholder leaseholder;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long leaseId;

    private String leaseName;

    private String leaseDescription;

    private Integer leaseLot;

    private Float leasePrice;

    private Float leaseIndex;


    public Lease() {
    }

    public Lease(Leaseholder leaseholder, long leaseId, String leaseName, String leaseDescription, Integer leaseLot, Float leasePrice, Float leaseIndex) {
        this.leaseholder = leaseholder;
        this.leaseId = leaseId;
        this.leaseName = leaseName;
        this.leaseDescription = leaseDescription;
        this.leaseLot = leaseLot;
        this.leasePrice = leasePrice;
        this.leaseIndex = leaseIndex;
    }

    public Lease(Leaseholder leaseholder, String leaseName, String leaseDescription, Integer leaseLot, Float leasePrice, Float leaseIndex) {
        this.leaseholder = leaseholder;
        this.leaseName = leaseName;
        this.leaseDescription = leaseDescription;
        this.leaseLot = leaseLot;
        this.leasePrice = leasePrice;
        this.leaseIndex = leaseIndex;
    }

    public Leaseholder getLeaseholder() {
        return leaseholder;
    }

    public void setLeaseholder(Leaseholder leaseholder) {
        this.leaseholder = leaseholder;
    }

    public long getLeaseId() {
        return leaseId;
    }

    public void setLeaseId(long id) {
        this.leaseId = id;
    }

    public String getLeaseName() {
        return leaseName;
    }

    public void setLeaseName(String name) {
        this.leaseName = name;
    }

    public String getLeaseDescription() {
        return leaseDescription;
    }

    public void setLeaseDescription(String description) {
        this.leaseDescription = description;
    }

    public Integer getLeaseLot() {
        return leaseLot;
    }

    public void setLeaseLot(Integer lot) {
        this.leaseLot = lot;
    }

    public Float getLeasePrice() {
        return leasePrice;
    }

    public void setLeasePrice(Float price) {
        this.leasePrice = price;
    }

    public Float getLeaseIndex() {
        return leaseIndex;
    }

    public void setLeaseIndex(Float index) {
        this.leaseIndex = index;
    }

    @Override
    public String toString() {
        return "Lease{" +
                "leaseholder=" + leaseholder +
                ", leaseId=" + leaseId +
                ", leaseName='" + leaseName + '\'' +
                ", leaseDescription='" + leaseDescription + '\'' +
                ", leaseLot='" + leaseLot + '\'' +
                ", leasePrice=" + leasePrice +
                ", leaseIndex=" + leaseIndex +
                '}';
    }
}
