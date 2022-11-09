package com.capg.nutritionapp.dto;

import java.util.Date;
import java.util.Objects;

import javax.validation.constraints.NotNull;
public class WeightLogDTO {
	@NotNull(message="Id should not ne empty")
    public long ID;
    @NotNull(message="weight should not be empty")
    public float weight;
    @NotNull(message="created At Date should not be empty")
    public Date created_At;
    @NotNull(message="updated At Date should not be empty")
    public Date updated_At;
    @NotNull(message="User Id should not ne empty")
    public String userId;
    
    
    public WeightLogDTO() {
		super();
	}

	public WeightLogDTO(long ID, float weight, Date created_At, Date updated_At, String userId) {
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
		WeightLogDTO other = (WeightLogDTO) obj;
		return ID == other.ID && Objects.equals(created_At, other.created_At)
				&& Objects.equals(updated_At, other.updated_At) && Objects.equals(userId, other.userId)
				&& Float.floatToIntBits(weight) == Float.floatToIntBits(other.weight);
	}
      
}

