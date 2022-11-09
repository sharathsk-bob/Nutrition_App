package com.capg.nutritionapp.entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class WeightLog {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	//@OneToMany
	//@JoinColumn(name="WeightLog")
	//@OneToMany
	//@JoinColumn(name="WeightLog")
	private Long ID;
	@Column(nullable = false)
    private float weight;
    @JsonFormat(pattern ="yyyy-MM-dd")
    private Date created_At;
    @JsonFormat(pattern ="yyyy-MM-dd")
    private Date updated_At;
    private String userId;
	
	public WeightLog() {
		super();
	}

	public WeightLog(long ID, float weight, Date created_At, Date updated_At, String userId) {
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

    public Date getCreated_At() {
        return created_At;
    }

    public void setCreated_At(Date created_At) {
        this.created_At = created_At;
    }

    public Date getUpdated_At() {
        return updated_At;
    }

    public void setUpdated_At(Date updated_At) {
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
    
    @Override
	public int hashCode() {
		return Objects.hash(ID, created_At, updated_At, userId, weight);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WeightLog other = (WeightLog) obj;
		return Objects.equals(ID, other.ID) && Objects.equals(created_At, other.created_At)
				&& Objects.equals(updated_At, other.updated_At) && Objects.equals(userId, other.userId)
				&& Float.floatToIntBits(weight) == Float.floatToIntBits(other.weight);
	}

	@PrePersist
	public void onCreate() {
		this.created_At = new Date();
	}
    
	@PreUpdate
	public void onUpdate() {
		this.updated_At = new Date();
	}
	
}


