package com.administracion.bd.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/status")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @GetMapping
    public List<StatusEntity> getAllStatuses() {
        return statusService.getAllStatuses();
    }

    @GetMapping("/{id}")
    public StatusEntity getStatusById(@PathVariable Long id) {
        return statusService.getStatusById(id);
    }

    @PostMapping
    public StatusEntity createStatus(@RequestBody StatusEntity status) {
        return statusService.createStatus(status);
    }

    @PutMapping("/{id}")
    public StatusEntity updateStatus(@PathVariable Long id, @RequestBody StatusEntity statusDetails) {
        return statusService.updateStatus(id, statusDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteStatus(@PathVariable Long id) {
        statusService.deleteStatus(id);
    }
}
