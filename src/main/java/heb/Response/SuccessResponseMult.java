package heb.Response;

import java.util.List;
import heb.Candidate.Candidate;

public class SuccessResponseMult extends Response implements MultObjects
{
    private List<Candidate> result;
    public SuccessResponseMult(int code, String status, String message, List<Candidate> cands)
    {
        this.code = code;
        this.status = status;
        this.message = message;
        this.result = cands;
    }

    @Override
    public List<Candidate> getResult ()
    {
        return result;
    }

    @Override
    public void setResult(List<Candidate> result)
    {
        this.result = result;
    }
}