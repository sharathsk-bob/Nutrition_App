//package com.group_4_trial_1.Nutri_App_user_Trial.config;
//
//import com.example.demo.entity.NutritionPlanDTO;
//import com.example.demo.repository.NutritionPlanRepository;
//import com.group_4_trial_1.Nutri_App_user_Trial.entity.NutritionPlan;
//import com.group_4_trial_1.Nutri_App_user_Trial.repository.NutritionPlanRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.time.LocalDate;
//import java.time.Month;
//import java.util.List;
//
//@Configuration
//public class NutritionPlanConfig {
//
////    @Bean
////    CommandLineRunner commandLineRunner(
////            NutritionPlanRepository repository) {
////        return args -> {
////            NutritionPlan Suresh = new NutritionPlan (
////                    "Suresh",
////                    "Eating Healthy Foods",
////                    LocalDate.of(2022, Month.OCTOBER,10),
////                    LocalDate.of(2022, Month.OCTOBER,14),
////                    5000
////            );
////
////            NutritionPlan Ramesh = new NutritionPlan (
////                    "Ramesh",
////                    "Eating Fatty Foods",
////                    LocalDate.of(2022, Month.SEPTEMBER,30),
////                    LocalDate.of(2022, Month.OCTOBER,11),
////                    4000
////            );
////
////            repository.saveAll(
////                    List.of(Suresh,Ramesh)
////            );
////        };
////
////    }
//}