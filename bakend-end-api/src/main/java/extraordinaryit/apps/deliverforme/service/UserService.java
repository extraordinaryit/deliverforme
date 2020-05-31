package extraordinaryit.apps.deliverforme.service;

import extraordinaryit.apps.deliverforme.model.user.ApplicationUser;
import extraordinaryit.apps.deliverforme.model.user.UserDTO;

public interface UserService {

    UserDTO registerUser(ApplicationUser applicationUser);
    void approveUser();
    void deactivateUser();
    UserDTO getUser(String userId);
}
