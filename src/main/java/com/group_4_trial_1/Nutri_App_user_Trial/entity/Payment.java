package com.sprint_1.payment_module.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Payment {
        @Id
        @SequenceGenerator(
                name = "payement_sequence",
                sequenceName = "payment_sequence",
                allocationSize = 1
        )
        @GeneratedValue(
                strategy = GenerationType.SEQUENCE,
                generator = "payment_sequence"
        )
        private long id;
        private long planId;
        private float payment;
        private float discount;
        private LocalDate created_At;
        private LocalDate updated_At;
        private String userId;


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

        public void setPlanId(long planId) {
            this.planId = planId;
        }

		
		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		@Override
		public String toString() {
			return "Payment [Id=" + id + ", planId=" + planId + ", payment=" + payment + ", discount=" + discount
					+ ", created_At=" + created_At + ", updated_At=" + updated_At + ", userId=" + userId + "]";
		}

        
        
    }

