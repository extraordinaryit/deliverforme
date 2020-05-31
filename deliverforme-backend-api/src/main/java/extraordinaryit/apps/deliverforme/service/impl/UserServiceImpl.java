package extraordinaryit.apps.deliverforme.service.impl;

import extraordinaryit.apps.deliverforme.converter.impl.UserToUserDTOConverter;
import extraordinaryit.apps.deliverforme.entity.User;
import extraordinaryit.apps.deliverforme.model.base.Status;
import extraordinaryit.apps.deliverforme.model.user.ApplicationUser;
import extraordinaryit.apps.deliverforme.model.user.UserDTO;
import extraordinaryit.apps.deliverforme.repository.UserRepository;
import extraordinaryit.apps.deliverforme.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {

    private final static Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserToUserDTOConverter userToUserDTOConverter;

    @Override
    public UserDTO registerUser(ApplicationUser applicationUser) {
        UserDTO userDTO = new UserDTO();
        try{
            User user = userToUserDTOConverter.reverseConvert(applicationUser);
            this.userRepository.save(user);
            userDTO.setPayload(applicationUser);
            userDTO.setStatus(Status.SUCCESS);
        } catch (Exception e){
            LOG.error(e.getMessage(), e);
            userDTO.setStatus(Status.FAILURE);
            userDTO.setMessage("Technical Error: Registration Failure");
        }
        return userDTO;
    }

    @Override
    public void approveUser() {

    }

    @Override
    public void deactivateUser() {

    }

    @Override
    public UserDTO getUser(String userId) {

        UserDTO userDTO = new UserDTO();

        try{
            Long userIdL = Long.parseLong(userId);
            Optional<User> userById = userRepository.findById(userIdL);

            if(userById.isPresent()) {
                userDTO.setPayload(userToUserDTOConverter.convert(userById.get()));
                userDTO.setStatus(Status.SUCCESS);
                userDTO.setMessage("");
                return userDTO;
            } else {
                userDTO.setStatus(Status.FAILURE);
                userDTO.setMessage("Invalid User Id");
            }

        } catch (Exception e){
            LOG.error(e.getMessage(),e);
            userDTO.setStatus(Status.FAILURE);
            userDTO.setMessage("Technical Error");
        }
        return userDTO;
    }
}
