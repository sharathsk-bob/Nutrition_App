package com.capg.nutritionapp.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name="nutrition_plan")
public class NutritionPlan {
    
//    @SequenceGenerator(
//            name = "nutritionplan_sequence",
//            sequenceName = "nutritionplan_sequence",
//            allocationSize = 1
//    )
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String planDescription;
    @Column(nullable = false)
    private LocalDate created_At;
    @Column(nullable = false)
    private LocalDate updated_At;
    @Column(nullable = false)
    private double price;

    // Constructors	
    public NutritionPlan() {
    	super();
    }

    public NutritionPlan(long id,String name,
                         String planDescription,
                         LocalDate created_At,LocalDate updated_At,
                         double price) {
        this.id = id;
        this.name = name;
        this.planDescription = planDescription;
        this.created_At = created_At;
        this.updated_At = updated_At;
        this.price = price;
    }

    public NutritionPlan(String name,String planDescription,
                         LocalDate created_At,LocalDate updated_At,
                         double price) {
        this.name = name;
        this.planDescription = planDescription;
        this.created_At = created_At;
        this.updated_At = updated_At;
        this.price = price;
    }

    public NutritionPlan(long i, String name, String eating_vegetables_and_fruits, LocalDate of, LocalDate of1, int price) {
    	super();
    }

    // Getters and setters
    public long getId() {
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
        return planDescription;
    }

    public void setPlanDiscription(String planDescription) {
        this.planDescription = planDescription;
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

    //overrides
    @Override
    public String toString() {
        return "NutritionPlanDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", planDescription='" + planDescription + '\'' +
                ", created_At=" + created_At +
                ", updated_At=" + updated_At +
                ", price=" + price +
                '}';
    }

	@Override
	public int hashCode() {
		return Objects.hash(created_At, id, name, planDescription, price, updated_At);
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
		return Objects.equals(created_At, other.created_At) && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(planDescription, other.planDescription)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(updated_At, other.updated_At);
	}
     
}