package heb.response;

public abstract class Response {

    String status;
    String message;

    public String getStatus()
    {
        return status;
    }

    public String getMessage()
    {
        return message;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }
}