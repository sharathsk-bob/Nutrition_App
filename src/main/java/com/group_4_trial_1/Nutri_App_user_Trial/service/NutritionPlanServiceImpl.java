package com.example.demo.service;

import com.example.demo.entity.NutritionPlanDTO;
import com.example.demo.exception.NutritionPlanNotFoundException;
import com.example.demo.repository.NutritionPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;


@Service
public class NutritionPlanServiceImpl implements NutritionPlanService{

    private final NutritionPlanRepository nutritionPlanRepository;

    public NutritionPlanServiceImpl(NutritionPlanRepository nutritionPlanRepository) {
        this.nutritionPlanRepository = nutritionPlanRepository;
    }

    @Autowired
    public List<NutritionPlanDTO> listAllPlans(){
        return nutritionPlanRepository.findAll();
    }

    public NutritionPlanDTO createPlan(NutritionPlanDTO nutritionPlanDTO) {
   /*    Optional<NutritionPlanDTO> findNutritionPlanDTOByEmail = nutritionPlanRepository.
                findNutritionPlanDTOByEmail(nutritionPlanDTO.getEmail())
        if(nutritionPlanDTOOptional.isPresent()){
            throw new IllegalStateException("Email Taken");
        }*/

        // Logger logger = (Logger) Logger.getLogger(NutritionPlanService.class.getName());
        nutritionPlanRepository.save(nutritionPlanDTO);
        // logger.log(Level.INFO, (Supplier<String>) nutritionPlanDTO);
        //System.out.println(nutritionPlanDTO);
        return nutritionPlanDTO;
    }


    public void removePlan(Long nutritionPlanDTOId) throws NutritionPlanNotFoundException {
        boolean exists = nutritionPlanRepository.existsById(nutritionPlanDTOId);
        if(!exists){
            throw new NutritionPlanNotFoundException("Nutrition Plan for id "
                    + nutritionPlanDTOId + " does not exits");
        }
        nutritionPlanRepository.deleteById(nutritionPlanDTOId);
    }

    @Transactional
    public NutritionPlanDTO changePlan(Long nutritionPlanDTOId,
                                       String name,
                                       Double price , String planDescription ) throws NutritionPlanNotFoundException{
        NutritionPlanDTO nutritionPlanDTO = nutritionPlanRepository.findById(nutritionPlanDTOId).
                orElseThrow(() -> new NutritionPlanNotFoundException(
                        "Nutrition Plan with id " + nutritionPlanDTOId + " does not exists"));
        if(name != null && name.length() > 0 &&
                !Objects.equals(nutritionPlanDTO.getName(),name)){
            nutritionPlanDTO.setName(name);
        }
        if(price!= null  &&
                !Objects.equals(nutritionPlanDTO.getPrice(),price)){
            nutritionPlanDTO.setPrice(price);
        }
        if(planDescription!= null  &&
                !Objects.equals(nutritionPlanDTO.getPlanDescription(),planDescription)){
            nutritionPlanDTO.setPlanDescription(planDescription);
        }
       /*  if(created_At!= null  &&
                !Objects.equals(nutritionPlanDTO.getCreated_At(),created_At)){
            nutritionPlanDTO.setCreated_At(created_At);
        }
        if(updated_At!= null  &&
                !Objects.equals(nutritionPlanDTO.getUpdated_At(),updated_At)){
            nutritionPlanDTO.setUpdated_At(updated_At);
        }*/
        return nutritionPlanDTO;
    }
}
