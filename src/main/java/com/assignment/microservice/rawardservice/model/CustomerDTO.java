package com.assignment.microservice.rawardservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;

public class CustomerDTO {
    private String name;
    @JsonInclude
    private Long rewardPoints;
    @JsonInclude
    private Double totalPurchases;

    public CustomerDTO(String name, Long rewardPoints, Double totalPurchases) {
        this.name = name;
        this.rewardPoints = rewardPoints;
        this.totalPurchases = totalPurchases;
    }

    public CustomerDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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