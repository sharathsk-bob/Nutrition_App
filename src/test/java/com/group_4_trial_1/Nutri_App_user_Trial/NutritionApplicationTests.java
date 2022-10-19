package com.group_4_trial_1.Nutri_App_user_Trial;

import com.group_4_trial_1.Nutri_App_user_Trial.entity.*;
import com.group_4_trial_1.Nutri_App_user_Trial.exception.PaymentNotFoundException;
import com.group_4_trial_1.Nutri_App_user_Trial.exception.WeightLogNotFoundException;
import com.group_4_trial_1.Nutri_App_user_Trial.repository.*;
import com.group_4_trial_1.Nutri_App_user_Trial.service.*;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
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

	/************************************************************************************
	 * Pratik Tests
	 * Description: Tests for User Module
	 *
	 ************************************************************************************/
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

	@Test
	public void deleteUserTest() {
//		User user = new User(
//				"mariam007",
//				"Mariam",
//				"9564525874",
//				"Female",
//				LocalDate.of(1999, JANUARY, 1));
//		userService.deleteUser(user.getId());
//		verify(userRepository, times(1)).deleteById(user.getId());
	}


	/************************************************************************************
	 * Kamran Tests
	 * Description: Tests for Nutrition Plans
	 *
	 ************************************************************************************/
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
		NutritionPlan nutritionPlan = new NutritionPlan(1L,
				"Plant-based Nutrition Plan","Eating Vegetables and Fruits",
				LocalDate.of(2022, Month.OCTOBER,10),
				LocalDate.of(2022, Month.OCTOBER,14),
				5000
		);
		when(nutritionPlanRepository.save(nutritionPlan)).thenReturn(nutritionPlan);
		assertEquals(null, nutritionPlanService.addNewNutritionPlan(nutritionPlan));
	}



//	@Test
//	public void createPlanTest() {
//		NutritionPlan nutritionPlan = new NutritionPlan(
//				"Plant-based Nutrition Plan","Eating Vegetables and Fruits",
//				LocalDate.of(2022, Month.OCTOBER,10),
//				LocalDate.of(2022, Month.OCTOBER,14),
//				5000
//				);
//		when(nutritionPlanRepository.save(nutritionPlan)).thenReturn(nutritionPlan);
//		assertEquals(nutritionPlan, nutritionPlanService.addNewNutritionPlan(nutritionPlan));
//	}



	/*@Test
	public void removePlanTest() throws NutritionPlanNotFoundException {
		long nutritionPlanDTOId = 1L;
		nutritionPlanService.removePlan(nutritionPlanDTOId);
		((NutritionPlanService) verify(nutritionPlanRepository, times(0))).removePlan(nutritionPlanDTOId);
	}*/

	/************************************************************************************
	 * Adarsh Tests
	 * Description: Tests for DietPlan
	 *
	 ************************************************************************************/
	@Autowired
	private DietService dietService;
	@MockBean
	private DietPlanRepo repository;

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
		DietPlan plan = new DietPlan(1L,"jjgk","jggig","guguigui","jhfuyfu",
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


	/************************************************************************************
	 * Ashish Tests
	 * Description: Tests for Weight Logs
	 *
	 ************************************************************************************/
	@Autowired
	private WeightLogServiceImpl weightLogService;

	@MockBean
	private WeightLogRepository weightLogRepository;
	WeightLog w1;
	@BeforeEach
	public void init() {
		w1 = new WeightLog(1,20f,LocalDate.now(),LocalDate.now() ,"ABCD1");
	}


   /*@Test
    void contextLoads() {
    }*/

	@Test
	public void showAllWeightLogTest() throws WeightLogNotFoundException {
		when(weightLogRepository.findAll()).thenReturn(Stream.of(new WeightLog(1L,0f,LocalDate.now(),LocalDate.now(),"null"), new WeightLog(2L,0f,LocalDate.now(),LocalDate.now(),"null")).collect(Collectors.toList()));
		Assert.assertEquals(2,weightLogService.showAllWeightLog().size());
	}


	/* public void payTest() throws PaymentNotFoundException{
         PaymentDTO tester= new PaymentDTO(1L,0f,0f,LocalDate.now(),LocalDate.now(),"null",0L);
         float price=0;
         paymentService.pay(tester,price);
         verify(paymentService,times(1)).pay(tester,price);

     } */
//	@Test
//	public void removeWeightLogTest() throws WeightLogNotFoundException {
//
//		when(weightLogRepository.existsById(w1.getID())).thenReturn(true);
//
//		when(weightLogRepository.findById(w1.getID())).thenReturn(Optional.ofNullable(w1));
//
//		weightLogService.removeWeightLog(w1.getID());
//
//		verify(weightLogRepository).delete(w1);
//	}


	/*
    public void addWeightLog() throws WeightLogNotFoundException {

        PaymentDTO tester= new PaymentDTO(1L,0f,0f,LocalDate.now(),LocalDate.now(),"null",0L);
        float discount=0;
        paymentService.addOffer(tester, discount);
        verify(paymentService,times(1)).pay(tester, discount);


    }
    */
	@Test
	public void addWeightLogTest() throws WeightLogNotFoundException {

		when(weightLogRepository.save(w1)).thenReturn(w1);

		Assert.assertEquals(w1.getID(),weightLogService.addWeightLog(w1).getID());

		// assertEquals(w1.getWeight(),weightLogService.addWeightLog(w1).getWeight());

		Assert.assertEquals(w1.getCreated_At(),weightLogService.addWeightLog(w1).getCreated_At());

		Assert.assertEquals(w1.getUpdated_At(),weightLogService.addWeightLog(w1).getUpdated_At());

		Assert.assertEquals(w1.getUserId(),weightLogService.addWeightLog(w1).getUserId());


	}


	// @Test
   /* public void updateWeightLogTest() throws WeightLogNotFoundException {
       // WeightLog tester=  WeightLog(w1);
        when(weightLogService.updateWeightLog(w1,w1.getID())).thenReturn(w1);
        assertEquals(w1,weightLogService.updateWeightLog(w1,w1.getID()));

    } */
	@Test
	public void updateWeightLogTest()  throws WeightLogNotFoundException {

		when(weightLogRepository.existsById(w1.getID())).thenReturn(true);

		when(weightLogRepository.findById(w1.getID())).thenReturn(Optional.ofNullable(w1));

		when(weightLogRepository.save(w1)).thenReturn(w1);

		//  assertEquals(w1.getWeight(),weightLogService.updateWeightLog(w1, w1.getID()).getWeight());

		Assert.assertEquals(w1.getCreated_At(),weightLogService.updateWeightLog(w1, w1.getID()).getCreated_At());

		Assert.assertEquals(w1.getUpdated_At(),weightLogService.updateWeightLog(w1, w1.getID()).getUpdated_At());

		Assert.assertEquals(w1.getUserId(),weightLogService.updateWeightLog(w1, w1.getID()).getUserId());

	}

	/************************************************************************************
	 * Tanya Tests
	 * Description: Tests for Payment Module
	 *
	 ************************************************************************************/
	@Autowired
	private PaymentServiceImpl paymentService;

	@MockBean
	private PaymentRepository paymentRepository;
	Payment p;
	@BeforeEach
	public void init1() {
		p = new Payment(1L,0f,0f,LocalDate.now(),LocalDate.now(),"null",0L);
	}

	/*@Test
	void contextLoads() {
	}*/

	@Test
	public void showAllPaymentsTest() throws PaymentNotFoundException {
		when(paymentRepository.findAll()).thenReturn(Stream.of(new Payment(1L,0f,0f,LocalDate.now(),LocalDate.now(),"null",0L), new Payment(2L,0f,0f,LocalDate.now(),LocalDate.now(),"null",0L)).collect(Collectors.toList()));
		assertEquals(2,paymentService.showAllPayments().size());
	}

	/*@Test
    public void payTest() throws PaymentNotFoundException{
		Payment tester= new Payment(1L,0f,0f,LocalDate.now(),LocalDate.now(),"null",0L);
		//float price=0;
    	paymentService.pay(tester);
    	verify(paymentService,times(1)).pay(tester);
    }

	@Test
	public void addOfferTest() throws PaymentNotFoundException{
		Payment tester= new Payment(1L,0f,0f,LocalDate.now(),LocalDate.now(),"null",0L);
		float discount=0;
		paymentService.addOffer(tester, discount);
		verify(paymentService,times(1)).addOffer(tester, discount);


	}*/

	@Test
	public void updatePaymentTest() throws PaymentNotFoundException {
//		when(paymentRepository.existsById(p.getId())).thenReturn(true);
//		when(paymentRepository.findPaymentById(p.getId())).thenReturn(Optional.ofNullable(p));
//		when(paymentRepository.save(p)).thenReturn(p);
//	    assertEquals(p.getCreated_At(),paymentService.updatePayment(p,p.getId(),p.getPayment(),p.getDiscount(),p.getCreated_At(),p.getCreated_At(),p.getUserId(),p.getPlanId())).getCreated_At();
//	    //assertEquals(p.getUpdated_At(),paymentService.updatePayment(p.getId(),p.getPayment(),p.getDiscount(),p.getUpdated_At(),p.getCreated_At(),p.getUserId(),p.getPlanId())).getCreated_At();

	}


}
