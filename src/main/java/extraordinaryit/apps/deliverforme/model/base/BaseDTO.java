package extraordinaryit.apps.deliverforme.model.base;

import lombok.*;

@Data
public class BaseDTO<T> {
    private String message;
    private String status;
    private T data;
}
