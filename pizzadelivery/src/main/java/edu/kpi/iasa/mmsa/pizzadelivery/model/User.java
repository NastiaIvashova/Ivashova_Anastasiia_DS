package edu.kpi.iasa.mmsa.pizzadelivery.model;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;


@Entity
@Table(name = "user")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;

    private String login;

    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private Date birthday;

    private String email;

    @Column(name = "phone_number")
    private String phone;

    private String city;

    private String street;

    @Column(name = "street_number")
    private int number;

    @Column(name = "entrance_street")
    private int entrance;

    public Long getId_user()
    {
        return id_user;
    }

    public void setId_user(Long id_user)
    {
        this.id_user = id_user;
    }

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public String getPassword()
    {
        try{
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(password.getBytes());
            byte[] result = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for(byte b : result){
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        }
        catch(NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;

    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public Date getBirthday()
    {
        return birthday;
    }

    public void setBirthday(Date birthday)
    {
        this.birthday = birthday;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public int getNumber()
    {
        return number;
    }

    public void setNumber(int number)
    {
        this.number = number;
    }

    public int getEntrance()
    {
        return entrance;
    }

    public void setEntrance(int entrance)
    {
        this.entrance = entrance;
    }

}

