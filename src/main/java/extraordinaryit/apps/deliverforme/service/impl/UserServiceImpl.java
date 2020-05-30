package extraordinaryit.apps.deliverforme.service.impl;

import extraordinaryit.apps.deliverforme.converter.impl.UserToUserDTOConverter;
import extraordinaryit.apps.deliverforme.entity.User;
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
    public void registerUser(UserDTO userDTO) {
        try{
            User user = userToUserDTOConverter.reverseConvert(userDTO);
            this.userRepository.save(user);
        } catch (Exception e){

        }
    }

    @Override
    public void approveUser() {

    }

    @Override
    public void deactivateUser() {

    }

    @Override
    public UserDTO getUser(String userId) {

        try{
            Long userIdL = Long.parseLong(userId);
            Optional<User> userById = userRepository.findById(userIdL);

            if(userById.isPresent())
                return userToUserDTOConverter.convert(userById.get());
            else
                throw new UsernameNotFoundException("User Id Invalid");

        } catch (Exception e){
            LOG.error(e.getMessage(),e);
        }
        return null;
    }
}
