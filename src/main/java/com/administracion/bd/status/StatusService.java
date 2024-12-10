package com.administracion.bd.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {

    @Autowired
    private StatusRepository statusRepository;

    public List<StatusEntity> getAllStatuses() {
        return statusRepository.findAll();
    }

    public StatusEntity getStatusById(Long id) {
        return statusRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Status not found with ID: " + id));
    }

    public StatusEntity createStatus(StatusEntity status) {
        return statusRepository.save(status);
    }

    public StatusEntity updateStatus(Long id, StatusEntity statusDetails) {
        StatusEntity existingStatus = statusRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Status not found with ID: " + id));
        existingStatus.setDescription(statusDetails.getDescription());
        return statusRepository.save(existingStatus);
    }

    public void deleteStatus(Long id) {
        if (!statusRepository.existsById(id)) {
            throw new RuntimeException("Status not found with ID: " + id);
        }
        statusRepository.deleteById(id);
    }
}
