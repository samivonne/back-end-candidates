package heb.response;

public class FailedResponse extends Response{
    public FailedResponse( String status, String message)
    {
        this.status = status;
        this.message = message;
    }
}