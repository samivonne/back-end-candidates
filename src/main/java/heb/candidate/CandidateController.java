package heb.candidate;


import com.google.gson.Gson;
import heb.response.*;
import heb.request.*;
import java.util.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;

//@CrossOrigin
@RestController
public class CandidateController {
    @Autowired
    private CandidateRepository candidateRepository;

    private Gson gson = new Gson();

//    private static final String template = "Hello, %s!";
//    private final AtomicLong counter = new AtomicLong();
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
    @GetMapping(path="/{email}/info")
    public ResponseEntity<Response> getUser(@PathVariable("email") String email)
    {
        Candidate cand = candidateRepository.findFirstByemail(email);
        Response res;
        HttpStatus code;
        if (cand != null){
            res = new SuccessResponseSingle(200, "0", "Success", cand);
            code = HttpStatus.OK;
        }
        else{
            res = new FailedResponse(404, "1232", "Email not found");
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
        Candidate cand = candidateRepository.findFirstByemail(attempt.getEmail());
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
    @PutMapping("/user/{id}/update")
//is username taken

//should only be able to update a candidate that is already present
public ResponseEntity<Response> updateCand(@RequestBody Candidate cand){
    Candidate candata = candidateRepository.findFirstByuserName(attempt.getUserName());
    Response res;
        HttpStatus code;
    // Current Candidate info from mySQL
    
    if ((candata != null))
    {
        
        if(cand.getPassword()==null) {
        	cand.setPassword(candata.getPassword);
        }else if(cand.getFirstName()=null) {
        	cand.setFirstname(candata.getFirstName());
        }else if(cand.getLastname()=null) {
        	cand.setLastName(candata.getLastName());
        }
        else if(cand.getEmail()=null) {
        	cand.setEmail(candata.getEmail());
        }
        else if(cand.getStreetAddress()=null) {
        	cand.setStreetAddress(candata.getStreetAddress());
        }
        else if(cand.getZipCode()=null) {
        	cand.setZipCode(candata.getZipcode());
        }
        else if(cand.getState()=null) {
        	cand.setState(candata.getState());
        }
        else if(cand.getCity()=null) {
        	cand.setCity(candata.getCity());
        }
        else if(cand.getPhoneNumber()=null) {
        	cand.setPhoneNumber(candata.getPhoneNumber());
        }
        else if(cand.getGithubLink()=null) {
        	cand.setGithubLink(candata.getGithubLink());
        }else {}
        res = new SuccessResponseSingle(200, "0", "Successful Change", cand);
        code = HttpStatus.OK;
        return (new ResponseEntity<Response>(res, code));
        
    }
   else
    {
        res = new FailedResponse(401, "1003", "Candidate does not exist");
        code = HttpStatus.UNAUTHORIZED;
    }
    
    
}
    
    

    //Signup a user
    @PostMapping("/user/signup")
    public ResponseEntity<Response> signUp(@RequestBody Candidate cand)
    {
        Response res;
        HttpStatus code;
        if (candidateRepository.findFirstByemail(cand.getEmail()) != null)
        {
            res = new FailedResponse(404, "1502", "Email already in use");
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
    //These are only for testing and should not be included in the main app
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
}
