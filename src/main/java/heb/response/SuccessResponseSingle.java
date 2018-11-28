package heb.response;

import heb.candidate.Candidate;

public class SuccessResponseSingle extends Response implements SingleObject
{
    private Candidate result;
    public SuccessResponseSingle( String status, String message, Candidate cand)
    {
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