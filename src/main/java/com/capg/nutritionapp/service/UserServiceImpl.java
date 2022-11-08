package com.capg.nutritionapp.service;

import com.capg.nutritionapp.dto.UserDTO;

import com.capg.nutritionapp.entity.DietPlan;
import com.capg.nutritionapp.entity.NutritionPlan;
import com.capg.nutritionapp.entity.Payment;
import com.capg.nutritionapp.entity.User;
import com.capg.nutritionapp.entity.WeightLog;
import com.capg.nutritionapp.exception.UserApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capg.nutritionapp.repository.UserRepository;
import com.capg.nutritionapp.exception.InvalidDataException;
import javax.transaction.Transactional;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    //private UserRepository userRepository;
//    private Logger logger;

    @Autowired
    private UserRepository iuserRepository;
    

    @Override
    public List<UserDTO> getAllUsers()throws InvalidDataException {
//        logger.info("Getting all users request initiated...");
    	Iterable<User> users = iuserRepository.findAll();
		List<UserDTO> users2 = new ArrayList<>();
		users.forEach(user -> {
			UserDTO cust = new UserDTO(user.getId(),user.getUserIdentification(),user.getName(),user.getContact(),
	                   user.getGender(), user.getDob(), user.getEmail(),user.getRole(),
	                   user.getStatus(), user.getWeight(), user.getHeight(), user.getDietaryOrientation(),
	                   user.getIntensity(),user.getGoal(), user.getWorkOutline(),user.getWakeUpTime(),
	                   user.getSleepTime(), user.getMedicalCondition(),user.getAllergicTo(),user.getLoginName(),user.getPassword(),user.getDietPlan(),user.getNutritionPlan(),
	       			user.getPaymentList(),user.getWeightLogList());
			users2.add(cust);
		});
		if (users2.isEmpty())
			throw new InvalidDataException("Service.USERS_NOT_FOUND");
		return users2;
        //return userRepository.findAll();
    }

    @Override
    public UserDTO getUserByUserId(Long id) throws InvalidDataException{
    	Optional<User> optional = iuserRepository.findById(id);
        User user = optional.orElseThrow(() -> new InvalidDataException("Service.USER_NOT_FOUND"));
		UserDTO user2 = new UserDTO(user.getId(),user.getUserIdentification(),user.getName(),user.getContact(),
                user.getGender(), user.getDob(), user.getEmail(),user.getRole(),
                user.getStatus(), user.getWeight(), user.getHeight(), user.getDietaryOrientation(),
                user.getIntensity(), user.getGoal(), user.getWorkOutline(),user.getWakeUpTime(),
                user.getSleepTime(), user.getMedicalCondition(),user.getAllergicTo(),user.getLoginName(),user.getPassword(),user.getDietPlan(),user.getNutritionPlan(),
    			user.getPaymentList(),user.getWeightLogList());
		return user2;
		}



    @Override
    public User registerUser(User user) throws InvalidDataException {
    	List<User> optionalUser = iuserRepository.findUserByemail(user.getEmail());
		if(!optionalUser.isEmpty()) {
			throw new InvalidDataException("Service.USER_FOUND");
		}
		User c = new User();
		c.setName(user.getName());
		c.setContact(user.getContact());
        c.setGender(user.getGender()); 
        c.setDob(user.getDob()); c.setEmail(user.getEmail());c.setRole(user.getRole());
        c.setStatus(user.getStatus()); c.setWeight(user.getWeight()); c.setHeight(user.getHeight()); c.setDietaryOrientation(user.getDietaryOrientation());
        c.setIntensity(user.getIntensity()); c.setGoal(user.getGoal());  c.setWorkOutline(user.getWorkOutline()); c.setWakeUpTime(user.getWakeUpTime());
        c.setSleepTime(user.getSleepTime()); c.setMedicalCondition(user.getMedicalCondition());c.setAllergicTo(user.getAllergicTo());c.setLoginName(user.getLoginName());
        c.setPassword(user.getPassword());
		User c2 = iuserRepository.save(c);
		return c2;
    }

    @Override
    public UserDTO deleteUser(Long id) throws InvalidDataException {
//        boolean exist = userRepository.existsById(id);
    	Optional<User> user1 = iuserRepository.findById(id);
		User user=user1.orElseThrow(() -> new InvalidDataException("Service.USER_NOT_FOUND"));
		UserDTO customer=new UserDTO(user.getId(),user.getUserIdentification(),user.getName(),user.getContact(),
                user.getGender(), user.getDob(), user.getEmail(),user.getRole(),
                user.getStatus(), user.getWeight(), user.getHeight(), user.getDietaryOrientation(),
                user.getIntensity(), user.getGoal(), user.getWorkOutline(),user.getWakeUpTime(),
                user.getSleepTime(), user.getMedicalCondition(),user.getAllergicTo(),user.getLoginName(),user.getPassword(),user.getDietPlan(),user.getNutritionPlan(),
    			user.getPaymentList(),user.getWeightLogList());
		return customer;

    }

    @Override
    public UserDTO updateUser(UserDTO user)throws InvalidDataException{
    	Optional<User> user1 = iuserRepository.findById(user.getId());
		User c = user1.orElseThrow(() -> new InvalidDataException("Service.USER_NOT_FOUND"));
		c.setName(user.getName());
		c.setContact(user.getContact());
        c.setGender(user.getGender()); 
        c.setDob(user.getDob()); c.setEmail(user.getEmail());c.setRole(user.getRole());
        c.setStatus(user.getStatus()); c.setWeight(user.getWeight()); c.setHeight(user.getHeight()); c.setDietaryOrientation(user.getDietaryOrientation());
        c.setIntensity(user.getIntensity()); c.setGoal(user.getGoal());  c.setWorkOutline(user.getWorkOutline()); c.setWakeUpTime(user.getWakeUpTime());
        c.setSleepTime(user.getSleepTime()); c.setMedicalCondition(user.getMedicalCondition());c.setAllergicTo(user.getAllergicTo());c.setLoginName(user.getLoginName());
        c.setPassword(user.getPassword());
		return user;
    }
    
}
