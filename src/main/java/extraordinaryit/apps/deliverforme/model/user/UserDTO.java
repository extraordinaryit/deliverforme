package extraordinaryit.apps.deliverforme.model.user;

import extraordinaryit.apps.deliverforme.model.base.BaseDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserDTO extends BaseDTO {

    @Builder
    public UserDTO(String name, String surname, String email, Long userId, String status,String message) {
        super(message,status);
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.userId = userId;
    }

    private String name;
    private String surname;
    private String email;
    private Long userId;

}
