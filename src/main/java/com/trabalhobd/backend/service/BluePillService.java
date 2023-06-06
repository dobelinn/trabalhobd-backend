package com.trabalhobd.backend.service;

import com.trabalhobd.backend.exceptions.EntityNotFoundException;
import com.trabalhobd.backend.model.BluePill;
import com.trabalhobd.backend.repository.BluePillRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class BluePillService {

    private final BluePillRepository bluePillRepository;

    public BluePillService(final BluePillRepository bluePillRepository) {
        this.bluePillRepository = bluePillRepository;
    }

    public BluePill createBluePill(final BluePill bluePill) {
        return bluePillRepository.save(bluePill);
    }

    public List<BluePill> getAllBluePills() {
        return bluePillRepository.findAll();
    }

    public BluePill getBluePillById(final Long bluePillId) {
        return bluePillRepository.findById(bluePillId)
                .orElseThrow(()-> new EntityNotFoundException(BluePill.class.getName(),bluePillId));
    }

    public BluePill updateBluePill(final BluePill bluePillPutRequest, final Long bluePillId) {

        return bluePillRepository.findById(bluePillId)
                .map(bluePill -> {
                    final BluePill updatedBluePill = validateBluePillPutRequest(bluePill, bluePillPutRequest);
                    return bluePillRepository.save(updatedBluePill);
                }).orElseThrow(()-> new EntityNotFoundException(BluePill.class.toString(),bluePillId));
    }

    public String deleteBluePill(final Long bluePillId) {
        if(!bluePillRepository.existsById(bluePillId)){
            throw new EntityNotFoundException(BluePill.class.getName(),bluePillId);
        }
        bluePillRepository.deleteById(bluePillId);
        return "BluePill with id " + bluePillId + " was deleted successfully";
    }


    private BluePill validateBluePillPutRequest(final BluePill existingBluePill, final BluePill bluePillPutRequest) {
        if(!Objects.isNull(bluePillPutRequest.getName()) && !bluePillPutRequest.getName().isEmpty()) {
            existingBluePill.setName(bluePillPutRequest.getName());
        }
        if(!Objects.isNull(bluePillPutRequest.getAge()) && bluePillPutRequest.getAge() >= 0) {
            existingBluePill.setAge(bluePillPutRequest.getAge());
        }
        if(!Objects.isNull(bluePillPutRequest.getEmail()) && !bluePillPutRequest.getEmail().isEmpty()) {
            existingBluePill.setEmail(bluePillPutRequest.getEmail());
        }
        if(!Objects.isNull(bluePillPutRequest.getPhone()) && !bluePillPutRequest.getPhone().isEmpty()) {
            existingBluePill.setPhone(bluePillPutRequest.getPhone());
        }
        if(!Objects.isNull(bluePillPutRequest.getGender()) && !bluePillPutRequest.getGender().isEmpty()) {
            existingBluePill.setGender(bluePillPutRequest.getGender());
        }
        if(!Objects.isNull(bluePillPutRequest.getBirthDate()) && !bluePillPutRequest.getBirthDate().isEmpty()) {
            existingBluePill.setBirthDate(bluePillPutRequest.getBirthDate());
        }
        return existingBluePill;
    }

}
