package edu.kpi.iasa.mmsa.pizzadelivery.controller;

import edu.kpi.iasa.mmsa.pizzadelivery.model.Status;
import edu.kpi.iasa.mmsa.pizzadelivery.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class StatusController
{
    private final StatusService statusService;

    @Autowired
    public StatusController(StatusService statusService)
    {
        this.statusService = statusService;
    }

    @GetMapping(value = "/status")
    public ResponseEntity<List<Status>> getStatuses()
    {
        return ResponseEntity.ok(statusService.getStatuses());
    }

    @PostMapping(value = "/status")
    public ResponseEntity<Status> postStatuses(@Valid @RequestBody Status newStatus)
    {
        return ResponseEntity.ok(statusService.saveStatus(newStatus));
    }

    @GetMapping(value = "/status/{id_status}")
    public ResponseEntity<Status> getStatus(@PathVariable Long id_status)
    {
        return ResponseEntity.ok(statusService.getStatusById(id_status));
    }

    @PutMapping(value = "/status/{id_status}")
    public ResponseEntity<Status> updateStatus(@PathVariable Long id_status, @Valid @RequestBody Status updatedStatus)
    {
        return ResponseEntity.ok(statusService.updateStatusById(id_status, updatedStatus));
    }

    @DeleteMapping(value = "/status/{id_status}")
    public ResponseEntity<String> deleteStatus(@PathVariable Long id_status)
    {
        return ResponseEntity.ok(statusService.deleteStatusById(id_status));
    }
}
