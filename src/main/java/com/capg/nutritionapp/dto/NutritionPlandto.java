package com.capg.nutritionapp.dto;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;


public class NutritionPlandto {
    private Long id;
    @NotNull(message = "{customer.name.absent}")
    @Pattern(regexp = "[A-Za-z]+( [A-Za-z]+)*", message = "{customer.name.invalid}")
    private String name;
    @NotEmpty(message = "planDiscription")
    private String planDiscription;
  //  @PastOrPresent(message = "customer.created.invalid")
    private LocalDate created_At;
//    @PastOrPresent(message = "customer.updated.invalid")
    private LocalDate updated_At;
    @NotNull(message = "Price > 0 ")
    private double price;

    public NutritionPlandto() {
    }

    public NutritionPlandto(Long id, String name, String planDiscription, LocalDate created_At, LocalDate updated_At, double price) {
        this.id = id;
        this.name = name;
        this.planDiscription = planDiscription;
        this.created_At = created_At;
        this.updated_At = updated_At;
        this.price = price;
    }

    public NutritionPlandto(String name, String planDiscription, LocalDate created_At, LocalDate updated_At, double price) {
        this.name = name;
        this.planDiscription = planDiscription;
        this.created_At = created_At;
        this.updated_At = updated_At;
        this.price = price;
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
}
