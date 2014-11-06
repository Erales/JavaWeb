
package businessPackage;


import businessPackage.interfaces.*;
import dataAccessPackage.*;
import dataAccessPackage.interfaces.*;
import exceptionPackage.*;
import javax.ejb.*;
import modelPackage.Promo;

@Stateless
public class PromoSessionBean implements IPromoSessionBean
{
    private IPromoDBAccess promoDBA;
    
    public PromoSessionBean()
    {
        promoDBA = new PromoDBAccess();
    }
    
    public Promo getPromo(Integer idPromo, String idLangue) throws AnimaliaException
    {
        Promo myPromo=promoDBA.getPromo(idPromo,idLangue);
        
        if(myPromo == null)
        {
            return myPromo;
        }
        else
        {
            throw new PromoException("Pas de promo trouvée", idPromo);
        }
    }
    
}
