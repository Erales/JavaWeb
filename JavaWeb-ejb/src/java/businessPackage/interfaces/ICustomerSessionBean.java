
package businessPackage.interfaces;


import exceptionPackage.*;
import javax.ejb.*;
import modelPackage.*;

@Local
public interface ICustomerSessionBean {

    public Customer login(String id, String mdp) throws AnimaliaException;

    public void inscription(Customer newClient) throws AnimaliaException;
    
}
