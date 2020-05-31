package extraordinaryit.apps.deliverforme.model.user;

import lombok.Data;

@Data
public class ApplicationUser {
    private String name;
    private String surname;
    private String email;
    private boolean enabled;
    private Long userId;
    private boolean tokenExpired;

    @Override
    public String toString() {
        return "ApplicationUser{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", userId=" + userId +
                '}';
    }
}
