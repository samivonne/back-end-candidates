package heb.candidate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Candidate {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    @Column(name = "userId")
    private int userId;

    @Column(name = "userName")
    private String userName;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "streetAddress")
    private String streetAddress;

    @Column(name = "zipCode")
    private String zipCode;

    @Column(name = "state")
    private String state;

    @Column(name = "city")
    private String city;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "githubLink")
    private String githubLink;

    @Column(name = "password")
    private String password;

    public String getUserName(){
        return userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstname(String firstName){
        this.firstName= firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getStreetAddress(){
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress){
        this.streetAddress = streetAddress;
    }

    public String getZipCode(){
        return zipCode;
    }

    public void setZipcode(String zipCode){
        this.zipCode = zipCode;
    }

    public String getState(){
        return state;
    }

    public void setState(String state){
        this.state = state;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber= phoneNumber;
    }

    public String getGithubLink(){
        return githubLink;
    }

    public void setGithublink(String githubLink){
        this.githubLink = githubLink;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public boolean checkEmpty()
    {
        if ( (userName == "") || (password == "") || (firstName == "") || (lastName == "") || (email == "") || (phoneNumber == ""))
            return true;
        else
            return false;
    }
}