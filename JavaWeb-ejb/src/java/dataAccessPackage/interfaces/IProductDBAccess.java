
package dataAccessPackage.interfaces;

import exceptionPackage.*;
import java.util.*;
import modelPackage.*;

public interface IProductDBAccess
{
    public ArrayList<Product> getListProductForACategorie(Integer categorie, String langue) throws AnimaliaException;
    public ArrayList<Product> getMonPanier(Integer idClient,String langue) throws AnimaliaException;
}
