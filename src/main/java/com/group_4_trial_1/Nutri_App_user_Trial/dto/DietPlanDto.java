package com.group_4_trial_1.Nutri_App_user_Trial.dto;


public class DietPlanDto {

    private Long id;

    //    @Id
//    @Column(name = "diet_plan_id")
    private String  userId;
    private String slots;
    private String foodType;
    private String proteinRatio;
    private String fatRatio;
    private String carbsRatio;
    private String total;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id", unique = true)
//    private User user;

    public DietPlanDto() {
    }



    public DietPlanDto(Long id, String userId, String slots,
                        String foodType, String proteinRatio,
                        String fatRatio, String carbsRatio, String total) {
        this.id = id;
        this.userId = userId;
        this.slots = slots;
        this.foodType = foodType;
        this.proteinRatio = proteinRatio;
        this.fatRatio = fatRatio;
        this.carbsRatio = carbsRatio;
        this.total = total;
    }

    public DietPlanDto(String userId, String slots, String foodType,
                        String proteinRatio, String fatRatio,
                        String carbsRatio, String total) {
        this.userId = userId;
        this.slots = slots;
        this.foodType = foodType;
        this.proteinRatio = proteinRatio;
        this.fatRatio = fatRatio;
        this.carbsRatio = carbsRatio;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

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
