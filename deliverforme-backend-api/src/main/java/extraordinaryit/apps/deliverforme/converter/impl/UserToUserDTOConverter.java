package extraordinaryit.apps.deliverforme.converter.impl;

import extraordinaryit.apps.deliverforme.converter.Converter;
import extraordinaryit.apps.deliverforme.entity.User;
import extraordinaryit.apps.deliverforme.model.user.ApplicationUser;
import org.springframework.stereotype.Component;

@Component
public class UserToUserDTOConverter implements Converter<User, ApplicationUser> {

    @Override
    public ApplicationUser convert(User user) {
        ApplicationUser applicationUser = new ApplicationUser();
        applicationUser.setName(user.getName());
        applicationUser.setSurname(user.getSurname());
        applicationUser.setEmail(user.getEmail());
        applicationUser.setUserId(user.getId());
        applicationUser.setEnabled(user.isEnabled());
        return applicationUser;
    }

    @Override
    public User reverseConvert(ApplicationUser applicationUser) {
        User user = new User();
        user.setEmail(applicationUser.getEmail());
        user.setEnabled(applicationUser.isEnabled());
        user.setName(applicationUser.getName());
        user.setSurname(applicationUser.getSurname());
        user.setTokenExpired(applicationUser.isTokenExpired());
        return user;
    }

}
