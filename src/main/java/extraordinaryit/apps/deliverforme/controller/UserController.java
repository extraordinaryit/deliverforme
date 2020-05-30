package extraordinaryit.apps.deliverforme.controller;

import extraordinaryit.apps.deliverforme.entity.User;
import extraordinaryit.apps.deliverforme.model.base.Status;
import extraordinaryit.apps.deliverforme.model.user.ApplicationUser;
import extraordinaryit.apps.deliverforme.model.user.UserDTO;
import extraordinaryit.apps.deliverforme.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value="users")
@RestController
public class UserController {

    private final static Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping(path = "/user/drivers")
    public List<User> getDrivers(){

        return null;
    }

    @ApiOperation(value = "Get a User By Id",response = UserDTO.class)
    @GetMapping(path = "/user/{userId}")
    public UserDTO getUser(@PathVariable("userId") String userId){
        LOG.info("Getting user "+userId);
        UserDTO userDTO = new UserDTO();
        try{
            userDTO = userService.getUser(userId);
        } catch (Exception e){
            LOG.error(e.getMessage(),e);
            userDTO.setStatus(Status.FAILURE);
            userDTO.setMessage("Technical Error");
        }
        return userDTO;
    }

    @ApiOperation(value = "Register an Application User",response = UserDTO.class)
    @PostMapping(path = "/user/register")
    public UserDTO registerUser(@RequestBody ApplicationUser applicationUser){
        LOG.info("Getting user \n"+applicationUser);
        UserDTO userDTO = new UserDTO();
        try{
            userDTO = userService.registerUser(applicationUser);
        } catch (Exception e){
            LOG.error(e.getMessage(),e);
            userDTO.setStatus(Status.FAILURE);
            userDTO.setMessage("Technical Error");
        }
        return userDTO;
    }
}
