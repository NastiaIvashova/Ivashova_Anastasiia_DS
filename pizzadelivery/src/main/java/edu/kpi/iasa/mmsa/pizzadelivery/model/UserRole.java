package edu.kpi.iasa.mmsa.pizzadelivery.model;

import javax.persistence.*;

@Entity
@Table(name = "user_role")
public class UserRole
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iduser_role;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fuser_id", referencedColumnName = "id_user")
    private User fuserId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "frole_id", referencedColumnName = "id_role")
    private Role froleId;

    public Long getIduser_role() {
        return iduser_role;
    }

    public void setIduser_role(Long iduser_role) {
        this.iduser_role = iduser_role;
    }

    public User getFuserId() {
        return fuserId;
    }

    public void setFuserId(User fuserId) {
        this.fuserId = fuserId;
    }

    public Role getFroleId() {
        return froleId;
    }

    public void setFroleId(Role froleId) {
        this.froleId = froleId;
    }
}

