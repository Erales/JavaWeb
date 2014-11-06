
package modelPackage;

import exceptionPackage.*;
import java.util.*;

public class Customer
{
    private ArrayList<Product> listArticles=new ArrayList<Product>();
    private String lastName, firstName, password, mail, phone, address;
    private Integer customerID;
    private Date birthDate, registrationDate;
    
    public Customer(String email, String pswd, String lName, String address, String fName, String phone, Date bDate, Date rDate)throws AnimaliaException
    {
        setPassword(pswd);
        setMail(email);
        
        this.lastName=lName;
        this.address=address;
        this.firstName=fName;
        this.phone=phone;
        this.birthDate=bDate;
        this.registrationDate=rDate;
    }
    
    public String toString()
    {
        String chaine = "Client n°"+customerID+"\n"+lastName+" "+firstName+"\nID: "+mail+" ("+password+")\nPhone: "+phone+"\nNé le "+birthDate;
        chaine+="\nAdresse: "+address+"\nInscrit le: "+registrationDate;
        
        return chaine;
    }
    
    //Setters.
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) throws AnimaliaException
    {
        if(password.length() > 15)
        {
            throw new CustomerException("Mot de passe trop long.\nMaximum 15 caractères.");
        }
        else
        {
            this.password = password;
        }
    }

    public void setMail(String mail) throws AnimaliaException
    {
        if(mail.matches("@"))
            this.mail = mail;
        else
            throw new CustomerException("Email invalide.\nExemple d'adresse mail valide: exemple@domaine.com");
    }
    
    //Getters.
    public ArrayList<Product> getListArticles() {
        return listArticles;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPassword() {
        return password;
    }

    public String getMail() {
        return mail;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }
}
