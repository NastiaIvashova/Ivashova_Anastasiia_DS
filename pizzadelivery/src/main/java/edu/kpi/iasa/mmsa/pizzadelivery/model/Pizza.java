package edu.kpi.iasa.mmsa.pizzadelivery.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "pizza")
@NamedStoredProcedureQueries({@NamedStoredProcedureQuery(name = "findByPizzaName", procedureName = "GET_PIZZA_BY_NAME",
        parameters = {@StoredProcedureParameter(mode = ParameterMode.IN, name = "namePizza", type= String.class) })})
public class Pizza
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pizza;

    private String name;

    @Column(name = "link_to_picture")
    private String link;

    private BigDecimal price;

    private String description;

    private BigDecimal discounts;

    public Long getId_pizza()
    {
        return id_pizza;
    }

    public void setId_pizza(Long id_pizza)
    {
        this.id_pizza = id_pizza;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getLink()
    {
        return link;
    }

    public void setLink(String link)
    {
        this.link = link;
    }

    public BigDecimal getPrice()
    {
        return price;
    }

    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public BigDecimal getDiscounts()
    {
        return discounts;
    }

    public void setDiscounts(BigDecimal discounts)
    {
        this.discounts = discounts;
    }

}
