
package businessPackage.interfaces;

import exceptionPackage.*;
import java.util.*;
import javax.ejb.*;
import modelPackage.*;

@Local
public interface IProductSessionBean
{

    public ArrayList<Product> getListProductForACategorie(Integer idCategorie, String idLangue) throws AnimaliaException;
    
}
