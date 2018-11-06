package heb.candidate;

import java.util.concurrent.atomic.AtomicLong;

import com.google.gson.Gson;


import java.util.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
/*
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
*/
import heb.Response.*;
import heb.Request.*;


@RestController
public class CandidateController {
    @Autowired
    private CandidateRepository candidateRepository;

    private Gson gson = new Gson();

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @RequestMapping("/greeting")
    public String greeting()
    {
        return "This is heb team greeting message";
    }

    //Get a list of all users along with their information
    @GetMapping("/users")
    public Response getUsers()
    {
        Iterable<Candidate> all = candidateRepository.findAll();
        List<Candidate> cands = new ArrayList<Candidate>();
        all.forEach(cands::add);
        Response res = new SuccessResponseMul(200, "0", "Success", cands);
        return res;
    }

    //Get information from a specific user
    @GetMapping(path="/{user}/info")
    public Response getUser(@PathVariable("user") String user)
    {
        Candidate cand = candidateRepository.findFirstByuserName(user);
        Response res;
        if (cand != null){
            res = new SuccessResponseSingle(200, "0", "Success", cand);
        }
        else{
            res = new FailedResponse(404, "1232", "User not found");
        }
        return res;      
    }

    //Check if a login is success or failure
    @PostMapping("/user/login")
    public Response login(@RequestBody Login attempt)
    {
        Response res;
        Candidate cand = candidateRepository.findFirstByuserName(attempt.getUserName());
        if ((cand != null) && (cand.getPassword().equals(attempt.getPassword())))
        {
            res = new SuccessResponseSingle(200, "0", "Success", cand);
        }
        else
        {
            res = new FailedResponse(401, "1003", "Username or Password is incorrect");
        }
        return res;
    }

    //Signup a user, if t
    @PostMapping("/user/signup")
    public Response signUp(@RequestBody Candidate cand)
    {
        Response res;
        if (candidateRepository.findFirstByuserName(cand.getUserName()) != null)
        {
            res = new FailedResponse(404, "1502", "Username already exists");
            
        }
        else {
            if (cand.checkEmpty())
            {
                res = new FailedResponse(401, "1501", "Missing mandatory information");
            }
            else
            {
                candidateRepository.save(cand);
                res = new SuccessResponseSingle(200, "10001", "Signup Success", cand);
            }
        }
        return res;
    }





    @GetMapping("/test")
    public String test()
    {
        Optional<Candidate> cand = candidateRepository.findById(15);
        if (cand.isPresent())
        {
            return gson.toJson(cand);
        }
        else
            return "User not in database";
    }

    @GetMapping("/test/add")
    public String add()
    {
        Candidate cand = new Candidate();
        cand.setUserName("abc");
        candidateRepository.save(cand);
        return "Adding one entry to the database";
    }
}