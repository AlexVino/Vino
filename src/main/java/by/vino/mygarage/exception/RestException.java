package by.vino.mygarage.exception;

public class RestException extends RuntimeException {
    private static final String PREFIX = "error.";
    private int code;
    private String message;

    public RestException(int code) {
        this.code = code;
        this.message = PREFIX + code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
