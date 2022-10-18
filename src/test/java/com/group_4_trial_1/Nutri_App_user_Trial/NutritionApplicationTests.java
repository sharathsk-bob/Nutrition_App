package com.group_4_trial_1.Nutri_App_user_Trial;

import com.group_4_trial_1.Nutri_App_user_Trial.entity.User;
import com.group_4_trial_1.Nutri_App_user_Trial.repository.UserRepository;
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

}
