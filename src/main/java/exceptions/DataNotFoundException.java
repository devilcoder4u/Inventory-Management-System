package exceptions;

public class DataNotFoundException extends RuntimeException {

    private String message;
    private Integer errorCode;

    public DataNotFoundException(String message,Integer errorCode){
        super(message);
        this.message=message;
        this.errorCode=errorCode;
    }

    @Override
    public String toString() {
        return "DataNotFoundException{" +
                "message='" + message + '\'' +
                ", errorCode=" + errorCode +
                '}';
    }
}
