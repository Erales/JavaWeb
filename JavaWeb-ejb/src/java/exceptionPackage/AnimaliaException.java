
package exceptionPackage;

public class AnimaliaException extends Exception
{
    private String erreurMsg;
    
    public AnimaliaException(String erreur)
    {
        erreurMsg=erreur;
    }
    
    public void addNewMessageErreur(String newErreur)
    {
        this.erreurMsg+=newErreur;
    }
    
    public String toString()
    {
        return "Erreur générée:\n"+erreurMsg;
    }
    
    //Setters.
    public void setErreurMsg(String erreurMsg) {
        this.erreurMsg = erreurMsg;
    }

    //Getters.
    public String getErreurMsg() {
        return erreurMsg;
    }
}
