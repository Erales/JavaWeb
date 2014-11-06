
package businessPackage;

import javax.ejb.*;

import modelPackage.*;
import businessPackage.interfaces.*;
import dataAccessPackage.interfaces.*;
import exceptionPackage.*;
import dataAccessPackage.*;

@Stateless
public class CustomerSessionBean implements ICustomerSessionBean {

    private ICustomerDBAccess cliDBA;
    
    public CustomerSessionBean()
    {
        cliDBA = new CustomerDBAccess();
    }
    
    public Customer login(String id, String mdp) throws AnimaliaException
    {
        if(id.isEmpty()== false && mdp.isEmpty()==false)
        {
            return cliDBA.login(id, mdp);
        }
        else
        {
            throw new CustomerException("ID et mot de passe incomplets.\nVeuillez remplir ces 2 informations.");
        }
    }
    
    public void inscription(Customer newClient) throws AnimaliaException
    {
        if(newClient == null)
        {
            throw new CustomerException("Le client désiré n'existe pas.");
        }
        else
        {
            cliDBA.inscription(newClient);
        }
    }   
}
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")