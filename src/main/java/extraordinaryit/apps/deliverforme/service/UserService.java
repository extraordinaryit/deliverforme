package extraordinaryit.apps.deliverforme.service;

import extraordinaryit.apps.deliverforme.model.UserDTO;

public interface UserService {

    void registerUser(UserDTO userDTO);
    void approveUser();
    void deactivateUser();
    UserDTO getUser(String userId);
}
