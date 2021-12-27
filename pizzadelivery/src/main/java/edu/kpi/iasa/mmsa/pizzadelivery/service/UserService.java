package edu.kpi.iasa.mmsa.pizzadelivery.service;

import edu.kpi.iasa.mmsa.pizzadelivery.exception.UserNotFoundException;
import edu.kpi.iasa.mmsa.pizzadelivery.model.User;
import edu.kpi.iasa.mmsa.pizzadelivery.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserService
{
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository, EntityManager em)
    {
        this.userRepository = userRepository;
    }

    public List<User> getUsers()
    {
        return userRepository.findAll();
    }

    public User saveUsers(User newUser)
    {
        return userRepository.save(newUser);
    }

    public User getUserById(Long id_user)
    {
        Optional<User> user = userRepository.findById(id_user);
        if(user.isPresent())
        {
            log.info("user: {}", user.get());
            return user.get();
        }
        throw new UserNotFoundException();
    }

    public User updateUserById(Long id_user, User updatedUser)
    {
        Optional<User> user = userRepository.findById(id_user);
        if (user.isPresent())
        {
            User oldUser = user.get();
            log.info("user: {}", oldUser);
            updateUser(oldUser, updatedUser);
            return userRepository.save(oldUser);
        }
        throw new UserNotFoundException();
    }

    private void updateUser(User oldUser, User updatedUser)
    {
        oldUser.setLogin(updatedUser.getLogin());
        oldUser.setPassword(updatedUser.getPassword());
        oldUser.setFirstName(updatedUser.getFirstName());
        oldUser.setLastName(updatedUser.getLastName());
        oldUser.setBirthday(updatedUser.getBirthday());
        oldUser.setEmail(updatedUser.getEmail());
        oldUser.setPhone(updatedUser.getPhone());
        oldUser.setCity(updatedUser.getCity());
        oldUser.setStreet(updatedUser.getStreet());
        oldUser.setNumber(updatedUser.getNumber());
        oldUser.setEntrance(updatedUser.getEntrance());
    }

    public String deleteUserById(Long id_user)
    {
        userRepository.deleteById(id_user);
        return "User was successfully deleted!";
    }

}
