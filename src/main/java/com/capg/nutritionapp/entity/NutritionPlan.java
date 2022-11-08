package com.capg.nutritionapp.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table
public class NutritionPlan {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String planDiscription;
    private LocalDate created_At;
    private LocalDate updated_At;
    private double price;

    public NutritionPlan() {
    }

    public NutritionPlan(Long id,
                         String name,
                         String planDiscription,
                         LocalDate created_At,
                         LocalDate updated_At,
                         double price) {
        this.id = id;
        this.name = name;
        this.planDiscription = planDiscription;
        this.created_At = created_At;
        this.updated_At = updated_At;
        this.price = price;
    }

    public NutritionPlan(String name,
                         String planDiscription,
                         LocalDate created_At,
                         LocalDate updated_At,
                         double price) {
        this.name = name;
        this.planDiscription = planDiscription;
        this.created_At = created_At;
        this.updated_At = updated_At;
        this.price = price;
    }

    public NutritionPlan(long i, String name, String eating_vegetables_and_fruits, LocalDate of, LocalDate of1, int price) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlanDiscription() {
        return planDiscription;
    }

    public void setPlanDiscription(String planDiscription) {
        this.planDiscription = planDiscription;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "NutritionPlanDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", planDiscription='" + planDiscription + '\'' +
                ", created_At=" + created_At +
                ", updated_At=" + updated_At +
                ", price=" + price +
                '}';
    }

	@Override
	public int hashCode() {
		return Objects.hash(created_At, id, name, planDiscription, price, updated_At);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NutritionPlan other = (NutritionPlan) obj;
		return Objects.equals(created_At, other.created_At) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(planDiscription, other.planDiscription)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(updated_At, other.updated_At);
	}
    
}
