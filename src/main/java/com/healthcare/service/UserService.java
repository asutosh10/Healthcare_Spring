package com.healthcare.service;

import com.healthcare.DTO.LoginDTO;
import com.healthcare.DTO.UserDTO;
import com.healthcare.entity.UserEntity;
import com.healthcare.exception.ExceptionConstants;
import com.healthcare.exception.WeCareExceptions;
import com.healthcare.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public String createUser(UserDTO userDTO){
        UserEntity userEntity=new UserEntity();
        userEntity.setUserId(userDTO.getUserId());
        userEntity.setName(userDTO.getName());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setGender(userDTO.getGender());
        userEntity.setDateOfBirth(userDTO.getDateOfBirth());
        userEntity.setMobileNo(userDTO.getMobileNo());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setPincode(userDTO.getPincode());
        userEntity.setCity(userDTO.getCity());
        userEntity.setState(userDTO.getState());
        userEntity.setCountry(userDTO.getCountry());
        userRepository.save(userEntity);
        return userDTO.getUserId();
    }
    public boolean loginUser(LoginDTO loginDTO) throws WeCareExceptions {
        System.out.println(loginDTO.getId());
        UserEntity userEntity=userRepository.findByUserId(loginDTO.getId()).get();
        System.out.println(userEntity.getUserId());
        System.out.println(userEntity.getPassword());
        System.out.println(loginDTO.getPassword());
        if (loginDTO.getPassword().equals(userEntity.getPassword()) ){
            System.out.println("hi");
        }

        if (userEntity==null || ! loginDTO.getPassword().equals(userEntity.getPassword() )){
            throw new WeCareExceptions(ExceptionConstants.COACH_NOT_FOUND.toString());
        }
        return true;
    }
    public UserDTO getUserProfile(String userId){
        UserEntity userEntity=userRepository.findByUserId(userId).get();
        if(userEntity != null){
        UserDTO userDTO=new UserDTO();
        userDTO.setUserId(userEntity.getUserId());
        userDTO.setName(userEntity.getName());
        userDTO.setPassword(userEntity.getPassword());
        userDTO.setGender(userEntity.getGender());
        userDTO.setDateOfBirth(userEntity.getDateOfBirth());
        userDTO.setMobileNo(userEntity.getMobileNo());
        userDTO.setEmail(userEntity.getEmail());
        userDTO.setPincode(userEntity.getPincode());
        userDTO.setCity(userEntity.getCity());
        userDTO.setState(userEntity.getState());
        userDTO.setCountry(userEntity.getCountry());
        return  userDTO;}
        else
            return null;
    }
}
