package com.capg.nutritionapp.entity;

import javax.persistence.*;

import com.capg.nutritionapp.dto.PaymentDTO;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Payment {
        @Id
//      @SequenceGenerator(
//              name = "payement_sequence",
//              sequenceName = "payment_sequence",
//              allocationSize = 1
//      )
        @GeneratedValue(
                strategy = GenerationType.SEQUENCE,
                generator = "payment_sequence"
        )
        private long id;
        @Column(nullable = false)
        private long planId;
        @Column(nullable = false)
        private float payment;
        @Column(nullable = false)
        private float discount;
        @Column(nullable = false)
        private LocalDate created_At;
        @Column(nullable = false)
        private LocalDate updated_At;
        //?
        //@OneToOne(cascade = CascadeType.MERGE)
    	//@JoinColumn(name = "paymentId", unique = true)
        private String userId;

     // Constructors	
    public Payment() {
    	super();
    }

    public Payment(long id, float payment, float discount, LocalDate created_At, LocalDate updated_At, String userId, long planId) {
            this.id=id;
    	    this.payment = payment;
            this.discount = discount;
            this.created_At = created_At;
            this.updated_At = updated_At;
            this.userId = userId;
            this.planId = planId;
        }

    // Getters and setters
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

        public long getPlanId() {
            return planId;
        }

        public void setPlanId(long planId) {
            this.planId = planId;
        }

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		//overrides
		@Override
		public String toString() {
			return "Payment [Id=" + id + ", planId=" + planId + ", payment=" + payment + ", discount=" + discount
					+ ", created_At=" + created_At + ", updated_At=" + updated_At + ", userId=" + userId + "]";
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
			Payment other = (Payment) obj;
			return Objects.equals(created_At, other.created_At)
					&& Float.floatToIntBits(discount) == Float.floatToIntBits(other.discount) && id == other.id
					&& Float.floatToIntBits(payment) == Float.floatToIntBits(other.payment) && planId == other.planId
					&& Objects.equals(updated_At, other.updated_At) && Objects.equals(userId, other.userId);
		}

		//Conversions
		public PaymentDTO toPaymentDTO() {
			PaymentDTO paymentDTO = new PaymentDTO();
			paymentDTO.setId(this.getId());
			paymentDTO.setPayment(this.getPayment());
			paymentDTO.setDiscount(this.getDiscount());
			paymentDTO.setCreated_At(this.getCreated_At());
			paymentDTO.setUpdated_At(this.getUpdated_At());
			paymentDTO.setUserId(this.getUserId());
			paymentDTO.setPlanId(this.getPlanId());	
			return paymentDTO;
		}	
        
        
    }