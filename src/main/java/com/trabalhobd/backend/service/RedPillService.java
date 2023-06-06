package com.trabalhobd.backend.service;

import com.trabalhobd.backend.exceptions.EntityNotFoundException;
import com.trabalhobd.backend.model.RedPill;
import com.trabalhobd.backend.repository.RedPillRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class RedPillService {
    private final RedPillRepository redPillRepository;

    public RedPillService(final RedPillRepository redPillRepository) {
        this.redPillRepository = redPillRepository;
    }

    public RedPill createRedPill(final RedPill redPill) {
        return redPillRepository.save(redPill);
    }

    public List<RedPill> getAllRedPills() {
        return redPillRepository.findAll();
    }

    public RedPill getRedPillById(final Long redPillId) {
        return redPillRepository.findById(redPillId)
                .orElseThrow(()-> new EntityNotFoundException(RedPill.class.toString(),redPillId));
    }

    public RedPill updateRedPill(final RedPill redPillPutRequest, final Long redPillId) {

        return redPillRepository.findById(redPillId)
                .map(redPill -> {
                    final RedPill updatedRedPill = validateRedPillPutRequest(redPill, redPillPutRequest);
                    return redPillRepository.save(updatedRedPill);
                }).orElseThrow(()-> new EntityNotFoundException(RedPill.class.getName(),redPillId));
    }

    public String deleteRedPill(final Long redPillId) {
        if(!redPillRepository.existsById(redPillId)){
            throw new EntityNotFoundException(RedPill.class.getName(),redPillId);
        }
        redPillRepository.deleteById(redPillId);
        return "RedPill with id " + redPillId + " was deleted successfully";
    }


    private RedPill validateRedPillPutRequest(final RedPill existingRedPill, final RedPill redPillPutRequest) {
        if(!Objects.isNull(redPillPutRequest.getName()) && !redPillPutRequest.getName().isEmpty()) {
            existingRedPill.setName(redPillPutRequest.getName());
        }
        if(!Objects.isNull(redPillPutRequest.getAge()) && redPillPutRequest.getAge() >= 0) {
            existingRedPill.setAge(redPillPutRequest.getAge());
        }
        if(!Objects.isNull(redPillPutRequest.getEmail()) && !redPillPutRequest.getEmail().isEmpty()) {
            existingRedPill.setEmail(redPillPutRequest.getEmail());
        }
        if(!Objects.isNull(redPillPutRequest.getPhone()) && !redPillPutRequest.getPhone().isEmpty()) {
            existingRedPill.setPhone(redPillPutRequest.getPhone());
        }
        if(!Objects.isNull(redPillPutRequest.getGender()) && !redPillPutRequest.getGender().isEmpty()) {
            existingRedPill.setGender(redPillPutRequest.getGender());
        }
        if(!Objects.isNull(redPillPutRequest.getBirthDate()) && !redPillPutRequest.getBirthDate().isEmpty()) {
            existingRedPill.setBirthDate(redPillPutRequest.getBirthDate());
        }
        return existingRedPill;
    }
}
