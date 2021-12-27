package edu.kpi.iasa.mmsa.pizzadelivery.controller;

import edu.kpi.iasa.mmsa.pizzadelivery.model.UserRole;
import edu.kpi.iasa.mmsa.pizzadelivery.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserRoleController
{
    private final UserRoleService userRoleService;

    @Autowired
    public UserRoleController(UserRoleService userRoleService)
    {
        this.userRoleService = userRoleService;
    }

    @GetMapping(value = "/rolesUsers")
    public ResponseEntity<List<UserRole>> getUserRoles()
    {
        return ResponseEntity.ok(userRoleService.getUserRoles());
    }

    @PostMapping(value = "/rolesUsers")
    public ResponseEntity<UserRole> postUserRole(@Valid @RequestBody UserRole newUserRole)
    {
        return ResponseEntity.ok(userRoleService.saveUserRole(newUserRole));
    }

    @GetMapping(value = "/rolesUsers/{iduser_role}")
    public ResponseEntity<UserRole> getUserRole(@PathVariable Long iduser_role)
    {
        return ResponseEntity.ok(userRoleService.getUserRoleById(iduser_role));
    }

    @DeleteMapping(value = "/rolesUsers/{iduser_role}")
    public ResponseEntity<String> deleteUserRole(@PathVariable Long iduser_role)
    {
        return ResponseEntity.ok(userRoleService.deleteUserRoleById(iduser_role));
    }
}
