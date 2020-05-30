package extraordinaryit.apps.deliverforme.model.user;

import extraordinaryit.apps.deliverforme.model.base.BaseDTO;
import lombok.Data;
import lombok.ToString;

@Data
public class UserDTO extends BaseDTO<ApplicationUser> {

    public UserDTO() {
        ApplicationUser b = getPayload();
    }
}
