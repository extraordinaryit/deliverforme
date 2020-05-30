package extraordinaryit.apps.deliverforme.model.user;

import extraordinaryit.apps.deliverforme.model.base.BaseDTO;
import lombok.Data;


@Data
public class UserDTO extends BaseDTO<ApplicationUser> {

    public UserDTO() {
        ApplicationUser b = getData();
    }
}
