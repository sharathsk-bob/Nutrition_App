package com.group_4_trial_1.Nutri_App_user_Trial;

import com.group_4_trial_1.Nutri_App_user_Trial.entity.NutritionPlan;
import com.group_4_trial_1.Nutri_App_user_Trial.repository.NutritionPlanRepository;
import com.group_4_trial_1.Nutri_App_user_Trial.service.NutritionPlanService;
import com.group_4_trial_1.Nutri_App_user_Trial.entity.User;
import com.group_4_trial_1.Nutri_App_user_Trial.repository.UserRepository;
import com.group_4_trial_1.Nutri_App_user_Trial.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.time.Month.JANUARY;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class NutritionApplicationTests {

	@Test
	void contextLoads() {
	}

	@MockBean
	private UserRepository userRepository;
	@Autowired
	private UserService userService;

	@Test
	public void getAllUsersTest() {
		when(userRepository.findAll()).thenReturn(Stream
				.of(new User(
                    "mariam007",
                "Mariam",
                    "9564525874",
                    "Female",
                    LocalDate.of(1999, JANUARY, 1)), new User(
                    "alex009",
                    "Alex",
                    "8975469871",
                    "Male",
                    LocalDate.of(2004, JANUARY, 1))).collect(Collectors.toList()));
		assertEquals(2, userService.getAllUsers().size());
	}

	@Test
	public void getUserByUserIdTest() {
		String userId = "mariam007";
		when(userRepository.findByUserId(userId)).thenReturn(
				Optional.of(new User(
						"mariam007",
						"Mariam",
						"9564525874",
						"Female",
						LocalDate.of(1999, JANUARY, 1)))
		);
		assertEquals(userId, userService.getUserByUserId(userId).getUserId());
	}

	@Test
	public void registerUserTest() {
		User user = new User(
				"mariam007",
				"Mariam",
				"9564525874",
				"Female",
				LocalDate.of(1999, JANUARY, 1));
		when(userRepository.save(user)).thenReturn(user);
		assertEquals(user, userService.registerUser(user));
	}

//	@Test
//	public void deleteUserTest() {
//		Long id = 1L;
//		userService.deleteUser(id);
//		verify(userRepository, times(0)).deleteById(id);
//	}

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
		assertEquals(2, nutritionPlanService.listAllPlans().size());
	}

	@Test
	public void createPlanTest() {
		NutritionPlan nutritionPlanDTO = new NutritionPlan(
				"Plant-based Nutrition Plan","Eating Vegetables and Fruits",
				LocalDate.of(2022, Month.OCTOBER,10),
				LocalDate.of(2022, Month.OCTOBER,14),
				5000
				);
		when(nutritionPlanRepository.save(nutritionPlanDTO)).thenReturn(nutritionPlanDTO);
		assertEquals(nutritionPlanDTO, nutritionPlanService.createPlan(nutritionPlanDTO));
	}


	/*@Test
	public void removePlanTest() throws NutritionPlanNotFoundException {
		long nutritionPlanDTOId = 1L;
		nutritionPlanService.removePlan(nutritionPlanDTOId);
		((NutritionPlanService) verify(nutritionPlanRepository, times(0))).removePlan(nutritionPlanDTOId);
	}*/
}
