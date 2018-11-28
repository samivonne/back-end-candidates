package heb.response;

import java.util.List;
import heb.candidate.Candidate;

public class SuccessResponseMult extends Response implements MultObjects
{
    private List<Candidate> result;
    public SuccessResponseMult(String status, String message, List<Candidate> cands)
    {
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