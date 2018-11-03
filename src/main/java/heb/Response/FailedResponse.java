package heb.Response;

public class FailedResponse extends Response{
    public FailedResponse(int code, String status, String message)
    {
        this.code = code;
        this.status = status;
        this.message = message;
    }
}