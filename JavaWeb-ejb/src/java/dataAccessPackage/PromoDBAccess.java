
package dataAccessPackage;

import dataAccessPackage.interfaces.*;
import java.sql.*;
import java.util.*;
//Projet
import exceptionPackage.*;
import modelPackage.*;

public class PromoDBAccess implements IPromoDBAccess
{
    public ArrayList<Product> getProduitsEnPromo(Integer promoID, String idLangue) throws AnimaliaException
    { 
      try
        {
            ArrayList<Product>produitsEnPromo = null;
            
            //Création de la connexion.          
            SingletonConnexion.getInstance();
            
            //Instruction SQL: Formation+exécution.
            String instruction="select Produit.*, InformationsTextuellesProduit.Description, PromoAccordee.* "
                    + "from Produit, InformationsTextuellesProduit, PromoAccordee "
                    + "where ? = PromoAccordee.PromoID and PromoAccordee.IDProduit = Produit.IDProduit "
                    + "and Produit.IDProduit = InformationsTextuellesProduit.IDProduit "
                    + "and InformationsTextuellesProduit.IDLangue = ?";
            PreparedStatement ps=SingletonConnexion.getInstance().prepareCall(instruction);
            ps.setInt(1,promoID);
            ps.setString(1,idLangue);
            ResultSet donnee=ps.executeQuery();
            
            //Récupération des données et retour.
            while(donnee.next())
            {
                produitsEnPromo.add(new Product(
                        donnee.getInt("Produit.IDProduit"),
                        donnee.getBoolean("Produit.isNew"),
                        donnee.getBoolean("Produit.isSolde"),
                        donnee.getDouble("Produit.prix"),
                        donnee.getString("InformationTextuellesProduit.Description")
                        ));
            }
            
            //Fermeture de la DB.
            SingletonConnexion.getInstance().close();
            
            return produitsEnPromo;
        }
      catch(Exception e)
        {
            throw new PromoException(e+"\nImpossible de récupérer les produits en promo.",promoID);
        }
    }
}
