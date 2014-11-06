
package exceptionPackage;

public class PromoException extends AnimaliaException
{
    private Integer promoID;
    
    public PromoException(String erreur,Integer promoID) {
        super(erreur);
        
        this.promoID=promoID;
        super.addNewMessageErreur("\nPromo concernée: "+promoID);
    }
}
