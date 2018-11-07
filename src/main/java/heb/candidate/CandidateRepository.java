package heb.Candidate;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CandidateRepository extends CrudRepository<Candidate, Integer> {

    Candidate findFirstByemail(String email);

    Candidate findFirstByuserName(String userName);

    Candidate findFirstBylastName(String lastName);
    List<Candidate> findBylastName(String lastname);

    Candidate findFirstByFirstName(String firstName);
    List<Candidate> findByFirstName(String firstName);
}