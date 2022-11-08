package com.capg.nutritionapp.dto;

import java.time.LocalDate;
import java.util.Objects;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.capg.nutritionapp.entity.Payment;

public class PaymentDTO {
	// Data Fields
	@NotNull(message="Id should not ne empty")
	@Size(min=3,max=5, message="Id should be between 3 to 5 characters")
	@Min(value=100, message="Id should not be less than 100")
	private long id;
	@NotNull(message="payment should not be empty")
    private float payment;
	@NotNull(message="discount should not be empty")
    private float discount;
	@NotNull(message="Creation date should not be empty")
    private LocalDate created_At;
	@NotNull(message="Update date should not be empty")
    private LocalDate updated_At;
	//relationships
    private String userId;
    private long planId;
    
	// Constructors
    public PaymentDTO() {
    	super();
    }

    public PaymentDTO(long id,float payment, float discount, LocalDate created_At, LocalDate updated_At, String userId, long planId) {
        this.id=id;
    	this.payment = payment;
        this.discount = discount;
        this.created_At = created_At;
        this.updated_At = updated_At;
        this.userId = userId;
        this.planId = planId;
    }

    //Getters Setters
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setPlanId(long planId) {
		this.planId = planId;
	}

	public float getPayment() {
        return payment;
    }

    public void setPayment(float payment) {
        this.payment = payment;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
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

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    //Overrides
	@Override
	public String toString() {
		return "PaymentDTO [id=" + id + ", payment=" + payment + ", discount=" + discount + ", created_At=" + created_At
				+ ", updated_At=" + updated_At + ", userId=" + userId + ", planId=" + planId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(created_At, discount, id, payment, planId, updated_At, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PaymentDTO other = (PaymentDTO) obj;
		return Objects.equals(created_At, other.created_At)
				&& Float.floatToIntBits(discount) == Float.floatToIntBits(other.discount) && id == other.id
				&& Float.floatToIntBits(payment) == Float.floatToIntBits(other.payment) && planId == other.planId
				&& Objects.equals(updated_At, other.updated_At) && Objects.equals(userId, other.userId);
	}
   
	//Conversions
	public Payment toPayment() {
		Payment payment = new Payment();
		payment.setId(this.getId());
		payment.setPayment(this.getPayment());
		payment.setDiscount(this.getDiscount());
		payment.setCreated_At(this.getCreated_At());
		payment.setUpdated_At(this.getUpdated_At());
		payment.setUserId(this.getUserId());
		payment.setPlanId(this.getPlanId());
		return payment;
	}
}