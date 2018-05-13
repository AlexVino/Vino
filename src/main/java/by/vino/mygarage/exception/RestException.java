package by.vino.mygarage.exception;

public class RestException extends RuntimeException {
    private String code;

    public RestException(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
