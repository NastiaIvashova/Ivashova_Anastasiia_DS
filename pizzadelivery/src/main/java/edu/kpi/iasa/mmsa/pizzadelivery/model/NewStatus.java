package edu.kpi.iasa.mmsa.pizzadelivery.model;

import javax.persistence.*;

@Entity
@Table(name = "new_status")
public class NewStatus
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_new;

    @ManyToOne(optional = false)
    @JoinColumn(name = "now_status", referencedColumnName = "id_status")
    private Status nowStatus;

    @ManyToOne(optional = false)
    @JoinColumn(name = "next_status", referencedColumnName = "id_status")
    private Status nextStatus;

    public Long getId_new() {
        return id_new;
    }

    public void setId_new(Long id_new) {
        this.id_new = id_new;
    }

    public Status getNowStatus() {
        return nowStatus;
    }

    public void setNowStatus(Status nowStatus) {
        this.nowStatus = nowStatus;
    }

    public Status getNextStatus() {
        return nextStatus;
    }

    public void setNextStatus(Status nextStatus) {
        this.nextStatus = nextStatus;
    }
}
