package heb.candidate;

import java.util.concurrent.atomic.AtomicLong;

import com.google.gson.Gson;

import heb.Response.*;
import heb.Request.*;
import java.util.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;

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
        return "This is HEB team greeting message";
    }

    //Get a list of all users along with their information
    @GetMapping("/users")
    public ResponseEntity<Response> getUsers()
    {
        Iterable<Candidate> all = candidateRepository.findAll();
        List<Candidate> cands = new ArrayList<Candidate>();
        all.forEach(cands::add);
        Response res = new SuccessResponseMult(200, "0", "Success", cands);
        return (new ResponseEntity<Response>(res, HttpStatus.OK));
    }

    //Get information from a specific user
    @GetMapping(path="/{user}/info")
    public ResponseEntity<Response> getUser(@PathVariable("user") String user)
    {
        Candidate cand = candidateRepository.findFirstByuserName(user);
        Response res;
        HttpStatus code;
        if (cand != null){
            res = new SuccessResponseSingle(200, "0", "Success", cand);
            code = HttpStatus.OK;
        }
        else{
            res = new FailedResponse(404, "1232", "User not found");
            code = HttpStatus.NOT_FOUND;
        }
        return (new ResponseEntity<Response>(res, code));      
    }

    //Check if a login is success or failure
    @PostMapping("/user/login")
    public ResponseEntity<Response> login(@RequestBody Login attempt)
    {
        Response res;
        HttpStatus code;
        Candidate cand = candidateRepository.findFirstByuserName(attempt.getUserName());
        if ((cand != null) && (cand.getPassword().equals(attempt.getPassword())))
        {
            res = new SuccessResponseSingle(200, "0", "Success", cand);
            code = HttpStatus.OK;
        }
        else
        {
            res = new FailedResponse(401, "1003", "Username or Password is incorrect");
            code = HttpStatus.UNAUTHORIZED;
        }
        return (new ResponseEntity<Response>(res, code));
    }

    //Signup a user
    @PostMapping("/user/signup")
    public ResponseEntity<Response> signUp(@RequestBody Candidate cand)
    {
        Response res;
        HttpStatus code;
        if (candidateRepository.findFirstByuserName(cand.getUserName()) != null)
        {
            res = new FailedResponse(404, "1502", "Username already exists");
            code = HttpStatus.FORBIDDEN;
        }
        else {
            if (cand.checkEmpty())
            {
                res = new FailedResponse(401, "1501", "Missing mandatory information");
                code = HttpStatus.UNAUTHORIZED;
            }
            else
            {
                candidateRepository.save(cand);
                res = new SuccessResponseSingle(200, "10001", "Signup Success", cand);
                code = HttpStatus.OK;
            }
        }
        return (new ResponseEntity<Response>(res, code));
    }




    //Testing requests
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