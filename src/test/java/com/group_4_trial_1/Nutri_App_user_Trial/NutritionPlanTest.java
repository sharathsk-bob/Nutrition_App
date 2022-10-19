package com.group_4_trial_1.Nutri_App_user_Trial;

import com.group_4_trial_1.Nutri_App_user_Trial.entity.DietPlan;
import com.group_4_trial_1.Nutri_App_user_Trial.entity.NutritionPlan;

import com.group_4_trial_1.Nutri_App_user_Trial.repository.NutritionPlanRepository;

import com.group_4_trial_1.Nutri_App_user_Trial.service.NutritionPlanService;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.Month;

import java.util.stream.Collectors;
import java.util.stream.Stream;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class NutritionPlanTest {

    @Test
    void contextLoads() {
    }


    @MockBean
    private NutritionPlanRepository nutritionPlanRepository;
    @Autowired
    private NutritionPlanService nutritionPlanService;

    @Test
    public void listAllPlansTest(){
        when(nutritionPlanRepository.findAll()).thenReturn(Stream
                .of(new NutritionPlan(
                                "Fat Loss Nutrition Plan","Eating Healthy Foods",
                                LocalDate.of(2022, Month.OCTOBER,10),
                                LocalDate.of(2022, Month.OCTOBER,14),
                                5000),
                        new NutritionPlan (
                                "Bulk Nutrition Plan",
                                "Eating Fatty Foods",
                                LocalDate.of(2022, Month.SEPTEMBER,30),
                                LocalDate.of(2022, Month.OCTOBER,11),
                                4000
                        )).collect(Collectors.toList()));
        assertEquals(2, nutritionPlanService.getNutritionPlans().size());
    }

	@Test
	public void createPlanTest1() {
		NutritionPlan nutritionPlan = new NutritionPlan(
				"Plant-based Nutrition Plan","Eating Vegetables and Fruits",
				LocalDate.of(2022, Month.OCTOBER,10),
				LocalDate.of(2022, Month.OCTOBER,14),
				5000
				);
		when(nutritionPlanRepository.save(nutritionPlan)).thenReturn(nutritionPlan);
		assertEquals(nutritionPlan, nutritionPlanService.addNewNutritionPlan(nutritionPlan));
	}



	/*@Test
	public void removePlanTest() throws NutritionPlanNotFoundException {
		long nutritionPlanDTOId = 1L;
		nutritionPlanService.removePlan(nutritionPlanDTOId);
		((NutritionPlanService) verify(nutritionPlanRepository, times(0))).removePlan(nutritionPlanDTOId);
	}*/

//	@Autowired
//	private DietService dietService;
//	@MockBean
//	private DietPlanRepo repository;





    //        @Test
//        public void deletePlanTest() throws DietPlanNotFoundException {
//           DietPlan plan = new DietPlan(1,"jjgk","jggig","guguigui","jhfuyfu",
//                    "jgjkgk","jhfyufy","fuyuu");
//            //int Id = 2;
//            dietService.removeDietPlan(plan.getId());
//            verify(repository,times(1)).delete(plan);
//        }
}
