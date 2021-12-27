package edu.kpi.iasa.mmsa.pizzadelivery.service;

import edu.kpi.iasa.mmsa.pizzadelivery.exception.StatusNotFoundException;
import edu.kpi.iasa.mmsa.pizzadelivery.model.Status;
import edu.kpi.iasa.mmsa.pizzadelivery.repository.StatusRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class StatusService
{
    private final StatusRepository statusRepository;

    public StatusService(StatusRepository statusRepository)
    {
        this.statusRepository = statusRepository;
    }

    public List<Status> getStatuses()
    {
        return statusRepository.findAll();
    }

    public Status saveStatus(Status newStatus)
    {
        return statusRepository.save(newStatus);
    }

    public Status getStatusById(Long id_status)
    {
        Optional<Status> status = statusRepository.findById(id_status);
        if (status.isPresent())
        {
            log.info("status: {}", status.get());
            return status.get();
        }
        throw new StatusNotFoundException();
    }

    public Status updateStatusById(Long id_status, Status updatedStatus)
    {
        Optional<Status> status = statusRepository.findById(id_status);
        if (status.isPresent()) {
            Status oldStatus = status.get();
            log.info("status: {}", oldStatus);
            updateStatus(oldStatus, updatedStatus);
            return statusRepository.save(oldStatus);
        }
        throw new StatusNotFoundException();
    }

    private void updateStatus(Status oldStatus, Status updatedStatus)
    {
        oldStatus.setCodeName(updatedStatus.getCodeName());
        oldStatus.setDescription(updatedStatus.getDescription());
        oldStatus.setClosed(updatedStatus.getClosed());
    }

    public String deleteStatusById(Long id_status)
    {
        statusRepository.deleteById(id_status);
        return "Status was successfully deleted!";
    }
}
