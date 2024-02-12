package com.assignment.microservice.rawardservice.model;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    @JsonIgnore
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<CustomerTransaction> transactions;
    @JsonInclude
    @Transient
    private Long rewardPoints;
    @JsonInclude
    @Transient
    private Double totalPurchases;
    
    public Customer() {
        super();
    }
    
    public Customer(Integer id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Set<CustomerTransaction> getTransactions() {
        return transactions;
    }
    
    public void setTransactions(Set<CustomerTransaction> transactions) {
        this.transactions = transactions;
    }
    
    public Long getRewardPoints() {
        return rewardPoints;
    }
    
    public void setRewardPoints(Long rewardPoints) {
        this.rewardPoints = rewardPoints;
    }
    
    public Double getTotalPurchases() {
        return totalPurchases;
    }
    
    public void setTotalPurchases(Double totalPurchases) {
        this.totalPurchases = totalPurchases;
    }
}