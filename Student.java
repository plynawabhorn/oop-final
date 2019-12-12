
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LAB207_70
 */
public class Student implements Serializable {
    private String std_id;
    private String firstname;
    private String lastname;
    private String gpa;

    /**
     * @return the std_id
     */
    public String getStd_id() {
        return std_id;
    }

    /**
     * @param std_id the std_id to set
     */
    public void setStd_id(String std_id) {
        this.std_id = std_id;
    }

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the gpa
     */
    public String getGpa() {
        return gpa;
    }

    /**
     * @param gpa the gpa to set
     */
    public void setGpa(String gpa) {
        this.gpa = gpa;
    }
    
}
