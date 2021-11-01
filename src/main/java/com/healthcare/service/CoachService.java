package com.healthcare.service;

import com.healthcare.DTO.CoachDTO;
import com.healthcare.DTO.LoginDTO;
import com.healthcare.entity.CoachEntity;
import com.healthcare.exception.ExceptionConstants;
import com.healthcare.exception.WeCareExceptions;
import com.healthcare.repository.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CoachService {
    @Autowired
    private CoachRepository coachRepository;
    public String createCoach(CoachDTO coachDTO){
        CoachEntity coachEntity=new CoachEntity();
        coachEntity.setCoachId(coachDTO.getCoachId());
        coachEntity.setName(coachDTO.getName());
        coachEntity.setPassword(coachDTO.getPassword());
        coachEntity.setGender(coachDTO.getGender());
        coachEntity.setDateOfBirth(coachDTO.getDateOfBirth());
        coachEntity.setMobileNo(coachDTO.getMobileNo());
        coachEntity.setSpeciality(coachDTO.getSpeciality());
        coachRepository.save(coachEntity);
        return coachDTO.getCoachId();

    }
    public Boolean loginCoach(LoginDTO loginDTO) throws WeCareExceptions {
        CoachEntity coachId = coachRepository.findByCoachId(loginDTO.getId()).get();

        if (coachId==null || !loginDTO.getPassword().equals(coachId.getPassword() )){
            throw new WeCareExceptions(ExceptionConstants.COACH_NOT_FOUND.toString());
        }
        return true;
    }
    public CoachDTO getCoachProfile(String coachId){
        CoachDTO coachDTO=new CoachDTO();
        CoachEntity coachId1 = coachRepository.findByCoachId(coachId).get();
        if (coachId1==null){
            return null;
        }
        else{
            coachDTO.setCoachId(coachId1.getCoachId());
            coachDTO.setName(coachId1.getName());
            coachDTO.setPassword(coachId1.getPassword());
            coachDTO.setGender(coachId1.getGender());
            coachDTO.setDateOfBirth(coachId1.getDateOfBirth());
            coachDTO.setMobileNo(coachId1.getMobileNo());
            coachDTO.setSpeciality(coachId1.getSpeciality());
            return coachDTO;
          }
    }
    public List<CoachDTO> showAllCoaches(){
        List<CoachEntity> allCoaches = coachRepository.findAll();
        List<CoachDTO> allCoachDTO=allCoaches.stream().map(coachEntity ->
                {
                    CoachDTO coachDTO=new CoachDTO();
                    coachDTO.setCoachId(coachEntity.getCoachId());
                    coachDTO.setName(coachEntity.getName());
                    coachDTO.setPassword(coachEntity.getPassword());
                    coachDTO.setGender(coachEntity.getGender());
                    coachDTO.setDateOfBirth(coachEntity.getDateOfBirth());
                    coachDTO.setMobileNo(coachEntity.getMobileNo());
                    coachDTO.setSpeciality(coachEntity.getSpeciality());
                    return coachDTO;
                }
                ).collect(Collectors.toList());
        return allCoachDTO;
    }
}
