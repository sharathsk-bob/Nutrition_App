package com.group_4_trial_1.Nutri_App_user_Trial.entity;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "userTable")
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;
//    @Column(name = "user_id")
//    @Id
    private String userId;
    private String name;
    private String contact;
    private String gender;
    private LocalDate dob;
    //    private Image photo;
    private String email;
    private String role;
//    @Enumerated(EnumType.STRING)
//    @Column(columnDefinition = "varchar(255) default 'INACTIVE'")
//    @Type( type = "pgsql_enum" )
    private String status;
    private float weight;
    private float height;
    private String dietaryOrientation;
    private String intensity;
    private String goal;
    private String workOutline;
    private Time wakeUpTime;
    private Time sleepTime;
    private String medicalCondition;
    private String allergicTo;
    private String loginName;
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "diet_plan_id")
    private DietPlan dietPlan;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nutrition_plan_id")
    private NutritionPlan nutritionPlan;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id")
    private List<Payment> paymentList;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "weight_log_id")
    private List<WeightLog> weightLogList;

    public User() {
    }

    public User(long l, String mariam007, String mariam, String gender, String female, LocalDate of) {
    }

    public User(String userId, String name, String contact, String gender, LocalDate dob, DietPlan dietPlan) {
        this.userId = userId;
        this.name = name;
        this.contact = contact;
        this.gender = gender;
        this.dob = dob;
        this.dietPlan = dietPlan;
    }

    public User(Long id, String userId, String name, String contact,
                String gender, LocalDate dob, String email, String role,
                String status, float weight, float height, String dietaryOrientation,
                String intensity, String goal, String workOutline, Time wakeUpTime, Time sleepTime,
                String medicalCondition, String allergicTo, String loginName, String password) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.contact = contact;
        this.gender = gender;
        this.dob = dob;
        this.email = email;
        this.role = role;
        this.status = status;
        this.weight = weight;
        this.height = height;
        this.dietaryOrientation = dietaryOrientation;
        this.intensity = intensity;
        this.goal = goal;
        this.workOutline = workOutline;
        this.wakeUpTime = wakeUpTime;
        this.sleepTime = sleepTime;
        this.medicalCondition = medicalCondition;
        this.allergicTo = allergicTo;
        this.loginName = loginName;
        this.password = password;
    }

    public User(String name, String contact, String gender, LocalDate dob) {
        this.name = name;
        this.contact = contact;
        this.gender = gender;
        this.dob = dob;
    }

    public User(String userId, String name, String contact, String gender, LocalDate dob) {
        this.userId = userId;
        this.name = name;
        this.contact = contact;
        this.gender = gender;
        this.dob = dob;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public String getDietaryOrientation() {
        return dietaryOrientation;
    }

    public void setDietaryOrientation(String dietaryOrientation) {
        this.dietaryOrientation = dietaryOrientation;
    }

    public String getIntensity() {
        return intensity;
    }

    public void setIntensity(String intensity) {
        this.intensity = intensity;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getWorkOutline() {
        return workOutline;
    }

    public void setWorkOutline(String workOutline) {
        this.workOutline = workOutline;
    }

    public Time getWakeUpTime() {
        return wakeUpTime;
    }

    public void setWakeUpTime(Time wakeUpTime) {
        this.wakeUpTime = wakeUpTime;
    }

    public Time getSleepTime() {
        return sleepTime;
    }

    public void setSleepTime(Time sleepTime) {
        this.sleepTime = sleepTime;
    }

    public String getMedicalCondition() {
        return medicalCondition;
    }

    public void setMedicalCondition(String medicalCondition) {
        this.medicalCondition = medicalCondition;
    }

    public String getAllergicTo() {
        return allergicTo;
    }

    public void setAllergicTo(String allergicTo) {
        this.allergicTo = allergicTo;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public DietPlan getDietPlan() {
        return dietPlan;
    }

    public void setDietPlan(DietPlan dietPlan) {
        this.dietPlan = dietPlan;
    }

    public NutritionPlan getNutritionPlan() {
        return nutritionPlan;
    }

    public void setNutritionPlan(NutritionPlan nutritionPlan) {
        this.nutritionPlan = nutritionPlan;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    public List<WeightLog> getWeightLogList() {
        return weightLogList;
    }

    public void setWeightLogList(List<WeightLog> weightLogList) {
        this.weightLogList = weightLogList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", gender='" + gender + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", status='" + status + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                ", dietaryOrientation='" + dietaryOrientation + '\'' +
                ", intensity='" + intensity + '\'' +
                ", goal='" + goal + '\'' +
                ", workOutline='" + workOutline + '\'' +
                ", wakeUpTime=" + wakeUpTime +
                ", sleepTime=" + sleepTime +
                ", medicalCondition='" + medicalCondition + '\'' +
                ", allergicTo='" + allergicTo + '\'' +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", DietPlan='" + dietPlan + '\'' +
                ", NutritionPlan'" + nutritionPlan + '\'' +
                ", Payments'" + paymentList + '\'' +
                ", WeightLogs'" + weightLogList + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return getUserId().equals(user.getUserId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId());
    }
}