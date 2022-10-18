package com.group_4_trial_1.Nutri_App_user_Trial.dto;

import java.time.LocalDate;
public class WeightLogDTO {
    public long ID;
    public float weight;
    public LocalDate created_At;
    public LocalDate updated_At;
    public String userId;
    public WeightLogDTO(long ID, float weight, LocalDate created_At, LocalDate updated_At, String userId) {
        this.ID = ID;
        this.weight = weight;
        this.created_At = created_At;
        this.updated_At = updated_At;
        this.userId = userId;
    }
    
    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public LocalDate getCreated_At() {
        return created_At;
    }

    public void setCreated_At(LocalDate created_At) {
        this.created_At = created_At;
    }

    public LocalDate getUpdated_At() {
        return updated_At;
    }

    public void setUpdated_At(LocalDate updated_At) {
        this.updated_At = updated_At;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "WeightLog{" +
                "ID=" + ID +
                ", weight=" + weight +
                ", created_At=" + created_At +
                ", updated_At=" + updated_At +
                ", userId=" + userId +
                '}';
    }
}

