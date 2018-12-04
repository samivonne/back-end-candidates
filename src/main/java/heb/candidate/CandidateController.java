@PutMapping("/user/{id}/update")
//is username taken

//should only be able to update a candidate that is already present
public ResponseEntity<Response> updateCand(@RequestBody Candidate cand){
    Candidate candata = candidateRepository.findFirstByemail(attempt.getEmail());
    // Current Candidate info from mySQL
    if ((candata != null))
    {
        res = new SuccessResponseSingle(200, "0", "Successful Change", cand);
        code = HttpStatus.OK;
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
        candidateRepository.save(cand);
        return (new ResponseEntity<Response>(res, code));
    }
   else
    {
        res = new FailedResponse(401, "1003", "Candidate does not exist");
        code = HttpStatus.UNAUTHORIZED;
    }

}
    
