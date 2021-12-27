package edu.kpi.iasa.mmsa.pizzadelivery.service;

import edu.kpi.iasa.mmsa.pizzadelivery.exception.RoleNotFoundException;
import edu.kpi.iasa.mmsa.pizzadelivery.exception.StatusNotFoundException;
import edu.kpi.iasa.mmsa.pizzadelivery.model.Role;
import edu.kpi.iasa.mmsa.pizzadelivery.model.Status;
import edu.kpi.iasa.mmsa.pizzadelivery.repository.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class RoleService
{
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository)
    {
        this.roleRepository = roleRepository;
    }

    public List<Role> getRoles()
    {
        return roleRepository.findAll();
    }

    public Role saveRole(Role newRole)
    {
        return roleRepository.save(newRole);
    }

    public Role getRoleById(Long id_role)
    {
        Optional<Role> role = roleRepository.findById(id_role);
        if (role.isPresent())
        {
            log.info("role: {}", role.get());
            return role.get();
        }
        throw new RoleNotFoundException();
    }

    public Role updateRoleById(Long id_role, Role updatedRole)
    {
        Optional<Role> role = roleRepository.findById(id_role);
        if (role.isPresent()) {
            Role oldRole = role.get();
            log.info("role: {}", oldRole);
            updateRole(oldRole, updatedRole);
            return roleRepository.save(oldRole);
        }
        throw new RoleNotFoundException();
    }

    private void updateRole(Role oldRole, Role updatedRole)
    {
        oldRole.setCodeName(updatedRole.getCodeName());
        oldRole.setDescription(updatedRole.getDescription());
    }

    public String deleteRoleById(Long id_role)
    {
        roleRepository.deleteById(id_role);
        return "Role was successfully deleted!";
    }
}
