package edu.kpi.iasa.mmsa.pizzadelivery.controller;

import edu.kpi.iasa.mmsa.pizzadelivery.model.History;
import edu.kpi.iasa.mmsa.pizzadelivery.model.User;
import edu.kpi.iasa.mmsa.pizzadelivery.service.HistoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class HistoryControler
{
    private final HistoryService historyService;

    public HistoryControler(HistoryService historyService) {
        this.historyService = historyService;
    }

    @GetMapping(value = "/history")
    public ResponseEntity<List<History>> getHistories()
    {
        return ResponseEntity.ok(historyService.getHistories());
    }

    @GetMapping(value = "/history/{id_history}")
    public ResponseEntity<History> getHistory(@PathVariable Long id_history)
    {
        return ResponseEntity.ok(historyService.getHistoryById(id_history));
    }

    @DeleteMapping(value = "/history/{id_history}")
    public ResponseEntity<String> deleteHistory(@PathVariable Long id_history)
    {
        return ResponseEntity.ok(historyService.deleteHistoryById(id_history));
    }
}
