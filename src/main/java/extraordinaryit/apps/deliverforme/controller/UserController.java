package extraordinaryit.apps.deliverforme.controller;

import extraordinaryit.apps.deliverforme.entity.User;
import extraordinaryit.apps.deliverforme.model.user.UserDTO;
import extraordinaryit.apps.deliverforme.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final static Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping(path = "/user/drivers")
    public List<User> getDrivers(){

        return null;
    }

    @GetMapping(path = "/user/{userId}")
    public UserDTO getUser(@PathVariable("userId") String userId){
        LOG.info("Getting user "+userId);
        UserDTO userDTO;
        try{
            userDTO = userService.getUser(userId);
            return userDTO;
        } catch (Exception e){
            LOG.error(e.getMessage(),e);
//            userDTO = UserDTO.builder()
//            .message("Invalid User ID")
//            .status("FAILURE").build();
        }
        return new UserDTO();
    }
}
