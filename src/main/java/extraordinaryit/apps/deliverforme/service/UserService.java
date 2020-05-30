package extraordinaryit.apps.deliverforme.service;

import extraordinaryit.apps.deliverforme.model.user.UserDTO;

public interface UserService {

    void registerUser(UserDTO userDTO);
    void approveUser();
    void deactivateUser();
    UserDTO getUser(String userId);
}
