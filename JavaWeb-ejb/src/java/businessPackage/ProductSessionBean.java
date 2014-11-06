/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessPackage;

import businessPackage.interfaces.*;
import dataAccessPackage.*;
import dataAccessPackage.interfaces.*;
import exceptionPackage.*;
import modelPackage.*;

import java.util.*;
import javax.ejb.*;

@Stateless
public class ProductSessionBean implements IProductSessionBean
{
    private IProductDBAccess prodDBA;
    
    public ProductSessionBean()
    {
        prodDBA = new ProductDBAccess();
    }

    @Override
    public ArrayList<Product> getListProductForACategorie(Integer idCategorie, String idLangue) throws AnimaliaException
    {
        ArrayList<Product> listProduits = prodDBA.getListProductForACategorie(idCategorie, idLangue);
        
        if(listProduits != null)
            return listProduits;
        else
            throw new ProductException("La liste des produits récupérés est vide",idCategorie,idLangue);
    }
    
    
}
