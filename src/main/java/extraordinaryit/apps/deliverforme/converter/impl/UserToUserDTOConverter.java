package extraordinaryit.apps.deliverforme.converter.impl;

import extraordinaryit.apps.deliverforme.converter.Converter;
import extraordinaryit.apps.deliverforme.entity.User;
import extraordinaryit.apps.deliverforme.model.user.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserToUserDTOConverter implements Converter<User, UserDTO> {

    @Override
    public UserDTO convert(User user) {
        UserDTO userDTO = UserDTO.builder()
                .name(user.getName())
                .surname(user.getSurname())
                .build();
        return userDTO;
    }

    @Override
    public User reverseConvert(UserDTO userDTO) {
        User user = new User();
        return user;
    }
}
