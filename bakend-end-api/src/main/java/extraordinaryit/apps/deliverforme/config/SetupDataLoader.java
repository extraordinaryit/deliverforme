package extraordinaryit.apps.deliverforme.config;

import extraordinaryit.apps.deliverforme.entity.Privilege;
import extraordinaryit.apps.deliverforme.entity.Role;
import extraordinaryit.apps.deliverforme.entity.User;
import extraordinaryit.apps.deliverforme.repository.PrivilegeRepository;
import extraordinaryit.apps.deliverforme.repository.RoleRepository;
import extraordinaryit.apps.deliverforme.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = true;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;


    private PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (alreadySetup)
            return;

        Privilege readPrivilege = createPrivilegeIfNotFound("READ_PRIVILEGE");
        Privilege writePrivilege = createPrivilegeIfNotFound("WRITE_PRIVILEGE");

        List<Privilege> adminPrivileges = Arrays.asList(readPrivilege, writePrivilege);

        createRoleIfNotFound("ROLE_BUSINESS_USER", adminPrivileges);
        createRoleIfNotFound("ROLE_DRIVER", Arrays.asList(readPrivilege));
        createRoleIfNotFound("ROLE_USER", Arrays.asList(readPrivilege));

        Role businessRole = roleRepository.findByName("ROLE_BUSINESS_USER");
        Role driverRole = roleRepository.findByName("ROLE_DRIVER");
        Role userRole = roleRepository.findByName("ROLE_USER");

        User user = new User();
        user.setName("Sipho");
        user.setSurname("Business");
        user.setEmail("testbusiness@deliverforme.com");
        user.setRoles(Arrays.asList(businessRole));
        user.setEnabled(true);
        userRepository.save(user);

        user = new User();
        user.setName("Thabo");
        user.setSurname("Driver");
        user.setEmail("testdriver@deliverforme.com");
        user.setRoles(Arrays.asList(driverRole));
        user.setEnabled(true);
        userRepository.save(user);

        user = new User();
        user.setName("Sabelo");
        user.setSurname("User");
        user.setEmail("testuser@gmail.com");
        user.setRoles(Arrays.asList(driverRole));
        user.setEnabled(true);
        userRepository.save(user);

        alreadySetup = true;
    }

    @Transactional
    private Privilege createPrivilegeIfNotFound(String name) {

        Privilege privilege = privilegeRepository.findByName(name);
        if (privilege == null) {
            privilege = new Privilege();
            privilege.setName(name);
            privilegeRepository.save(privilege);
        }
        return privilege;
    }

    @Transactional
    private Role createRoleIfNotFound(
            String name, Collection<Privilege> privileges) {

        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role();
            role.setName(name);
            role.setPrivileges(privileges);
            roleRepository.save(role);
        }
        return role;
    }
}
