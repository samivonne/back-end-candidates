package heb.Response;

import heb.candidate.Candidate;

public class SuccessResponseSingle extends Response implements SingleObject
{
    private Candidate result;
    public SuccessResponseSingle(int code, String status, String message, Candidate cand)
    {
        this.code = code;
        this.status = status;
        this.message = message;
        this.result = cand;
    }

    public Candidate getResult()
    {
        return result;
    }

    public void setResult(Candidate result)
    {
        this.result = result;
    }
}