package edu.kpi.iasa.mmsa.pizzadelivery.model;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_role;

    @Column(name = "code_name")
    private String codeName;

    private String description;

    public Long getId_role()
    {
        return id_role;
    }

    public void setId_role(Long id_role)
    {
        this.id_role = id_role;
    }

    public String getCodeName()
    {
        return codeName;
    }

    public void setCodeName(String codeName)
    {
        this.codeName = codeName;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
}
