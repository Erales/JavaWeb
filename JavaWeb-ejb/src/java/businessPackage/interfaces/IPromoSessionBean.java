
package businessPackage.interfaces;

import exceptionPackage.AnimaliaException;
import javax.ejb.Local;
import modelPackage.Promo;

@Local
public interface IPromoSessionBean {

    Promo getPromo(Integer idPromo, String idLangue) throws AnimaliaException;
    
}
