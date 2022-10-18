package com.group_4_trial_1.Nutri_App_user_Trial;

import com.group_4_trial_1.Nutri_App_user_Trial.entity.DietPlan;
import com.group_4_trial_1.Nutri_App_user_Trial.entity.User;
import com.group_4_trial_1.Nutri_App_user_Trial.repository.DietPlanRepo;
import com.group_4_trial_1.Nutri_App_user_Trial.repository.UserRepository;
import com.group_4_trial_1.Nutri_App_user_Trial.service.DietService;
import com.group_4_trial_1.Nutri_App_user_Trial.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.yaml.snakeyaml.events.Event;

import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.time.Month.JANUARY;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

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
	@Autowired
	private DietService dietService;
	@MockBean
	private DietPlanRepo repository;

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
//		User user = new User(
//				1L,
//				"mariam007",
//				"Mariam",
//				"9564525874",
//				"Female",
//				LocalDate.of(1999, JANUARY, 1));
//		userService.deleteUser(user.getId());
//		verify(userRepository, times(1)).deleteById(user.getId());
//	}
@Test
public void listPlansTest(){
	when(repository.findAll()).thenReturn(Stream.of(new DietPlan("jjkj","gugu",
					"jguigiug","guigig","vuiug","jkggi",
					"uigiug"),
			new DietPlan("jedgig","gedui","jegdugd",
					"jbejkbjk","jhegvu","jgedguig","uiguigf")
	).collect(Collectors.toList()));
	assertEquals(2,dietService.listAllPlan().size());
}
	@Test
	public void createPlanTest(){
		DietPlan plan = new DietPlan("jjgk","jggig","guguigui","jhfuyfu",
				"jgjkgk","jhfyufy","fuyuu");
		when(repository.save(plan)).thenReturn(plan);
		assertEquals(plan,dietService.createDietPlan(plan));
	}
//        @Test
//        public void deletePlanTest() throws DietPlanNotFoundException {
//           DietPlan plan = new DietPlan(1,"jjgk","jggig","guguigui","jhfuyfu",
//                    "jgjkgk","jhfyufy","fuyuu");
//            //int Id = 2;
//            dietService.removeDietPlan(plan.getId());
//            verify(repository,times(1)).delete(plan);
//        }

}