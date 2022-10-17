package app.easycontact.rest;

public class EmailStatus {
    private final int status;
    private final String message;

    public EmailStatus(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
