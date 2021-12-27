package edu.kpi.iasa.mmsa.pizzadelivery.service;

import edu.kpi.iasa.mmsa.pizzadelivery.exception.PizzaNotFoundException;
import edu.kpi.iasa.mmsa.pizzadelivery.model.Pizza;
import edu.kpi.iasa.mmsa.pizzadelivery.repository.PizzaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PizzaService
{
    private final PizzaRepository pizzaRepository;
    private final EntityManager em;

    public PizzaService(PizzaRepository pizzaRepository, EntityManager em)
    {
        this.pizzaRepository = pizzaRepository;
        this.em = em;
    }

    public List<Pizza> getPizzas()
    {
        return pizzaRepository.findAll();
    }

    public Pizza savePizza(Pizza newPizza)
    {
        return pizzaRepository.save(newPizza);
    }

    public Pizza getPizzaById(Long id_pizza)
    {
        Optional<Pizza> pizza = pizzaRepository.findById(id_pizza);
        if (pizza.isPresent())
        {
            log.info("pizza: {}", pizza.get());
            return pizza.get();
        }
        throw new PizzaNotFoundException();
    }

    public Pizza updatePizzaById(Long id_pizza, Pizza updatedPizza)
    {
        Optional<Pizza> pizza = pizzaRepository.findById(id_pizza);
        if (pizza.isPresent()) {
            Pizza oldPizza = pizza.get();
            log.info("pizza: {}", oldPizza);
            updatePizza(oldPizza, updatedPizza);
            return pizzaRepository.save(oldPizza);
        }
        throw new PizzaNotFoundException();
    }

    private void updatePizza(Pizza oldPizza, Pizza updatedPizza)
    {
        oldPizza.setName(updatedPizza.getName());
        oldPizza.setLink(updatedPizza.getLink());
        oldPizza.setPrice(updatedPizza.getPrice());
        oldPizza.setDescription(updatedPizza.getDescription());
        oldPizza.setDiscounts(updatedPizza.getDiscounts());
    }

    public String deletePizzaById(Long id_pizza)
    {
        pizzaRepository.deleteById(id_pizza);
        return "Pizza was successfully deleted!";
    }

    public List<Pizza> getPizzaByName(String NamePizza)
    {
        return em.createNamedStoredProcedureQuery("findByPizzaName").setParameter("namePizza", NamePizza).getResultList();
    }
}
