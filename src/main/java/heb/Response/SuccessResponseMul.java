package heb.Response;

import java.util.List;
import heb.candidate.Candidate;

public class SuccessResponseMul extends Response
{
    private List<Candidate> result;
    public SuccessResponseMul(int code, String status, String message, List<Candidate> cands)
    {
        this.code = code;
        this.status = status;
        this.message = message;
        this.result = cands;
    }

    public List<Candidate> getResult()
    {
        return result;
    }

    public void setResult(List<Candidate> result)
    {
        this.result = result;
    }
}