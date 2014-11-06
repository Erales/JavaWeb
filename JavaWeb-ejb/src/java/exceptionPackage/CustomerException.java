
package exceptionPackage;

import modelPackage.*;

public class CustomerException extends AnimaliaException
{
    private String mdpClient;
    private String idClient;
    private Customer newClient;
    
    public CustomerException(String erreur) {
        super(erreur);
    }
    
    public CustomerException(String erreur, String mdpClient, String idClient)
    {
        super(erreur);
                
        this.mdpClient=mdpClient;
        super.addNewMessageErreur("\nMdp: "+mdpClient);
        
        this.idClient=idClient;
        super.addNewMessageErreur("\nID: "+idClient);
    }
    
    public CustomerException(String erreur, Customer newClient)
    {
        super(erreur);
        
        this.newClient=newClient;
        super.addNewMessageErreur(newClient.toString());        
    }
}
