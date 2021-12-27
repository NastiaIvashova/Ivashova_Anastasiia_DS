package edu.kpi.iasa.mmsa.pizzadelivery.service;

import edu.kpi.iasa.mmsa.pizzadelivery.exception.HistoryNotFoundException;
import edu.kpi.iasa.mmsa.pizzadelivery.model.History;
import edu.kpi.iasa.mmsa.pizzadelivery.repository.HistoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class HistoryService
{
    private final HistoryRepository historyRepository;

    public HistoryService(HistoryRepository historyRepository)
    {
        this.historyRepository = historyRepository;
    }

    public List<History> getHistories()
    {
        return historyRepository.findAll();
    }

    public History getHistoryById(Long id_history)
    {
        Optional<History> history = historyRepository.findById(id_history);
        if (history.isPresent())
        {
            log.info("history: {}", history.get());
            return history.get();
        }
        throw new HistoryNotFoundException();
    }

    public String deleteHistoryById(Long id_history)
    {
        historyRepository.deleteById(id_history);
        return "History was successfully deleted!";
    }
}
