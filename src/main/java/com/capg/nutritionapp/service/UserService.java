package com.capg.nutritionapp.service;

import java.util.List;
import com.capg.nutritionapp.dto.UserDTO;
import com.capg.nutritionapp.entity.User;
import com.capg.nutritionapp.exception.InvalidDataException;

public interface UserService {
    public List<UserDTO> getAllUsers() throws InvalidDataException;

    //    public List<Userdto> getByUserId(Userdto user) {
    //        return userRepository.findAll();
    //    }
    public UserDTO getUserByUserId(Long id) throws InvalidDataException;

    public User registerUser(User user)throws InvalidDataException;

    public UserDTO deleteUser(Long id)throws InvalidDataException;
    
    public UserDTO updateUser(UserDTO user)throws InvalidDataException;
}
