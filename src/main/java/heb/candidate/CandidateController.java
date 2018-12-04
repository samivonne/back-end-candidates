package heb.candidate;


import com.google.gson.Gson;
import heb.response.*;
import heb.request.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

//import javax.annotation.Resource;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;

//@CrossOrigin
@RestController
public class CandidateController {
    @Autowired
    private CandidateRepository candidateRepository;

    private Gson gson = new Gson();

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
        Response res = new SuccessResponseMult("0", "Success", cands);
        return (new ResponseEntity<Response>(res, HttpStatus.OK));
    }

    //Get information from a specific user, using their email address as the value
    @GetMapping(path="/{email}/info")
    public ResponseEntity<Response> getUser(@PathVariable("email") String email)
    {
        // Query for email address
        Candidate cand = candidateRepository.findFirstByemail(email);
        Response res;
        HttpStatus code;
        if (cand != null){
            res = new SuccessResponseSingle("0", "Success", cand);
            code = HttpStatus.OK;
        }
        else{
            res = new FailedResponse("1232", "Email not found");
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
        System.out.println(attempt.getEmail());
        System.out.println(attempt.getPassword());
        // Check if email exist in the databse, then check the password
        Candidate cand = candidateRepository.findFirstByemail(attempt.getEmail());
        if ((cand != null) && (cand.getPassword().equals(attempt.getPassword())))
        {
            res = new SuccessResponseSingle("0", "Success", cand);
            code = HttpStatus.OK;
        }
        else if (attempt.getEmail() == null)
        {
            res = new FailedResponse("1000", "Password incorrect");
            code = HttpStatus.FORBIDDEN;
        }
        else
        {
            res = new FailedResponse("1003", "Username or Password is incorrect");
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
        // Check if email already in used
        if (candidateRepository.findFirstByemail(cand.getEmail()) != null)
        {
            res = new FailedResponse("1502", "Email already in use");
            code = HttpStatus.FORBIDDEN;
        }
        // Validation check for all the required fields
        else {
            if (cand.checkEmpty())
            {
                res = new FailedResponse("1501", "Missing mandatory information");
                code = HttpStatus.UNAUTHORIZED;
            }
            // Add user to the database
            else
            {
                candidateRepository.save(cand);
                res = new SuccessResponseSingle("10001", "Signup Success", cand);
                code = HttpStatus.OK;
            }
        }
        return (new ResponseEntity<Response>(res, code));
    }


    @GetMapping("/resume/test")
    public ResponseEntity<ByteArrayResource> getResumeFromCandidate() throws IOException
    {
        //Will change this later
        //Will have to query for the path of their resume from the database
        String resume = "template.pdf";
        Path path = Paths.get("C:\\Users\\thoai bui\\Documents\\Resume\\template.pdf");
        //ByteArrayResource resume = ;
        return ResponseEntity.ok().header("Content-Disposition", "attachment; filename=\"" + resume + "\"") //header to specify the name
                                    .contentType(MediaType.parseMediaType("application/octet-stream"))//Specify that it is a pdf file
                                    .body(new ByteArrayResource(Files.readAllBytes(path))); //return the content of the file 
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