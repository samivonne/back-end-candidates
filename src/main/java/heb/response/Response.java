package heb.response;

public abstract class Response {
    int code;
    String status;
    String message;

    public int getCode()
    {
        return code;
    }

    public String getStatus()
    {
        return status;
    }

    public String getMessage()
    {
        return message;
    }

    public void setCode(int code)
    {
        this.code = code;
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