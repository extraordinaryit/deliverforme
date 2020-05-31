package extraordinaryit.apps.deliverforme.model.base;


import lombok.Data;

@Data
public class BaseDTO<T> {
    private String message;
    private Status status;
    private T payload;
}
