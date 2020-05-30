package extraordinaryit.apps.deliverforme.model.user;

import lombok.Data;

@Data
public class ApplicationUser {
    private String name;
    private String surname;
    private String email;
    private Long userId;
}
