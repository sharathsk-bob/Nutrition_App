package com.capg.nutritionapp.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;

@Entity
public class WeightLog {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@OneToMany
	//@JoinColumn(name="WeightLog")
	//@OneToMany
	//@JoinColumn(name="WeightLog")
	private Long ID;
    private float weight;
    private LocalDate created_At;
    private LocalDate updated_At;
    private String userId;
	
	public WeightLog() {
		super();
	}

	public WeightLog(long ID, float weight, LocalDate created_At, LocalDate updated_At, String userId) {
       super();
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


