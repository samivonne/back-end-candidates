package heb.candidate;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

//This is a crudrepository for query candidate infos from mysql database

public interface CandidateRepository extends CrudRepository<Candidate, Integer> {

    
    Candidate findFirstByemail(String email);

    //First match and list of matching last name
    Candidate findFirstBylastName(String lastName);
    List<Candidate> findBylastName(String lastname);

    //First match and list of matching first name
    Candidate findFirstByfirstName(String firstName);
    List<Candidate> findByfirstName(String firstName);
}