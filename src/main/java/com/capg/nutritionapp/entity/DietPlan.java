package com.capg.nutritionapp.entity;

import java.util.Objects;

import javax.persistence.*;

@Entity
@Table
public class DietPlan {
    @Id
//    @SequenceGenerator(
//            name="dietplan_sequence",
//            sequenceName = "dietplan_sequence",
//            allocationSize = 1
//    )
    @GeneratedValue( strategy = GenerationType.SEQUENCE,generator = "dietplan_sequence")
    private Long id;
//    @Column(nullable = false)
//    private String  userId;
    @Column(nullable = false)
    private String slots;
    @Column(nullable = false)
    private String foodType;
    @Column(nullable = false)
    private String proteinRatio;
    @Column(nullable = false)
    private String fatRatio;
    @Column(nullable = false)
    private String carbsRatio;
    @Column(nullable = false)
    private String total;

 // Constructors
    public DietPlan() {
    	super();
    }

    public DietPlan(long id, String slots,
                    String foodType, String proteinRatio,
                    String fatRatio, String carbsRatio, String total) {
        this.id = id;
//        this.userId = userId;
        this.slots = slots;
        this.foodType = foodType;
        this.proteinRatio = proteinRatio;
        this.fatRatio = fatRatio;
        this.carbsRatio = carbsRatio;
        this.total = total;
    }

    public DietPlan( String slots, String foodType,
                    String proteinRatio, String fatRatio,
                    String carbsRatio, String total) {
//        this.userId = userId;
        this.slots = slots;
        this.foodType = foodType;
        this.proteinRatio = proteinRatio;
        this.fatRatio = fatRatio;
        this.carbsRatio = carbsRatio;
        this.total = total;
    }

	// Getters and setters   
    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public String getUserId() {
//        return userId;
//    }
//
//    public void setUserId(String userId) {
//        this.userId = userId;
//    }

    public String getSlots() {
        return slots;
    }

    public void setSlots(String slots) {
        this.slots = slots;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public String getProteinRatio() {
        return proteinRatio;
    }

    public void setProteinRatio(String proteinRatio) {
        this.proteinRatio = proteinRatio;
    }

    public String getFatRatio() {
        return fatRatio;
    }

    public void setFatRatio(String fatRatio) {
        this.fatRatio = fatRatio;
    }

    public String getCarbsRatio() {
        return carbsRatio;
    }

    public void setCarbsRatio(String carbsRatio) {
        this.carbsRatio = carbsRatio;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
    
    //overrides
    @Override
	public int hashCode() {
		return Objects.hash(carbsRatio, fatRatio, foodType, id, proteinRatio, slots, total);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DietPlan other = (DietPlan) obj;
		return Objects.equals(carbsRatio, other.carbsRatio) && Objects.equals(fatRatio, other.fatRatio)
				&& Objects.equals(foodType, other.foodType) && Objects.equals(id, other.id)
				&& Objects.equals(proteinRatio, other.proteinRatio) && Objects.equals(slots, other.slots)
				&& Objects.equals(total, other.total);
	}

	@Override
    public String toString() {
        return "DietPlan{" +
                "id=" + id +
//                ", userId='" + userId + '\'' +
                ", slots='" + slots + '\'' +
                ", foodType='" + foodType + '\'' +
                ", proteinRatio='" + proteinRatio + '\'' +
                ", fatRatio='" + fatRatio + '\'' +
                ", carbsRatio='" + carbsRatio + '\'' +
                ", total='" + total + '\'' +
                '}';
    }
}