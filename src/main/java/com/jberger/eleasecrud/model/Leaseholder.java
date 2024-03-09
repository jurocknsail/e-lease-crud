package com.jberger.eleasecrud.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "leaseholders")
public class Leaseholder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long leaseholderId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "pro")
    private boolean pro;

    @JsonIgnoreProperties("leaseholder")
    @OneToMany(mappedBy = "leaseholder")
    private Set<Lease> leases;

    public Leaseholder() { }

    public Leaseholder(String name, String description, String email, String phone, boolean pro) {
        this.name = name;
        this.description = description;
        this.email = email;
        this.phone = phone;
        this.pro = pro;
    }

    public Leaseholder(long leaseholderId, String name, String description, String email, String phone, boolean pro) {
        this.leaseholderId = leaseholderId;
        this.name = name;
        this.description = description;
        this.email = email;
        this.phone = phone;
        this.pro = pro;
    }

    public long getLeaseholderId() {
        return leaseholderId;
    }

    public void setLeaseholderId(long id) {
        this.leaseholderId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isPro() {
        return pro;
    }

    public void setPro(boolean pro) {
        this.pro = pro;
    }

    public Set<Lease> getLeases() {
        return leases;
    }

    public void setLeases(Set<Lease> leases) {
        this.leases = leases;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Leaseholder that = (Leaseholder) o;
        return leaseholderId == that.leaseholderId && pro == that.pro && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(email, that.email) && Objects.equals(phone, that.phone) && Objects.equals(leases, that.leases);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leaseholderId, name, description, email, phone, pro, leases);
    }

    @Override
    public String toString() {
        return "Leaseholder{" +
                "leaseholderId=" + leaseholderId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", pro=" + pro +
                ", leases=" + leases +
                '}';
    }
}
