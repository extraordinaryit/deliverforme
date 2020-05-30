package extraordinaryit.apps.deliverforme.model.base;

public enum Status {

    SUCCESS("SUCCESS"),
    FAILURE("FAILURE");

    String status;

    Status(String status){
        this.status = status;
    }
}
