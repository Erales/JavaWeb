
package dataAccessPackage.interfaces;

import exceptionPackage.*;
import modelPackage.*;

public interface ICustomerDBAccess
{
    public Customer login(String id, String mdp) throws AnimaliaException;
    public void inscription(Customer newClient) throws AnimaliaException;
}
