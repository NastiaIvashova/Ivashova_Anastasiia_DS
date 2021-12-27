package edu.kpi.iasa.mmsa.pizzadelivery.model;

import javax.persistence.*;

@Entity
@Table(name = "status")
public class Status
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_status;

    @Column(name = "code_name")
    private String codeName;

    @Column(name = "description")
    private String description;

    @Column(name = "bclosed")
    private Boolean IsClosed;

    public Long getId_status()
    {
        return id_status;
    }

    public void setId_status(Long id_status) {
        this.id_status = id_status;
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

    public Boolean getClosed()
    {
        return IsClosed;
    }

    public void setClosed(Boolean closed)
    {
        IsClosed = closed;
    }

}
