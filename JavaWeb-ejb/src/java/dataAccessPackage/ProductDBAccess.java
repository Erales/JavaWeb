
package dataAccessPackage;

import dataAccessPackage.interfaces.*;
import java.sql.*;
import java.util.*;
//Projet
import exceptionPackage.*;
import modelPackage.*;

public class ProductDBAccess implements IProductDBAccess
{
    public ArrayList<Product> getListProductForACategorie(Integer categorie,String idLangue) throws AnimaliaException
    { 
      try
        {
            ArrayList<Product> listProduct = null;
            
            //Création de la connexion.          
            SingletonConnexion.getInstance();
            
            //Instruction SQL: Formation+exécution.
            String instruction="select Produit.*, InformationTextuellesProduit.Description from Produit, InformationTextuellesProduit "
                    + "where ? = Produit.IDCategorie and Produit.IDProduit = InformationTextuellesProduit.IDProduit "
                    + "and InformationTextuellesProduit.IDLangue = ?";
            PreparedStatement ps=SingletonConnexion.getInstance().prepareCall(instruction);
            ps.setInt(1,categorie);
            ps.setString(2,idLangue);
            ResultSet donnee=ps.executeQuery();
            
            //Récupération des données et retour.
            while(donnee.next())
            {
                listProduct.add(new Product(
                    donnee.getInt("Produit.IDProduit"),
                    donnee.getBoolean("Produit.isNew"),
                    donnee.getBoolean("Produit.isSolde"),
                    donnee.getDouble("Produit.prix"),
                    donnee.getString("InformationTextuellesProduit.Description")));
            }
            
            //Fermeture de la DB.
            SingletonConnexion.getInstance().close();
            
            return listProduct;
        }
      catch(Exception e)
        {
            throw new ProductException(e.getMessage()+"Impossible de récupérer les produits.",categorie,idLangue);
        }
    }
    
    public ArrayList<Product> getMonPanier(Integer idClient,String idLangue) throws AnimaliaException
    { 
      try
        {
            ArrayList<Product> listProduct = null;
            
            //Création de la connexion.         
            SingletonConnexion.getInstance();
            
            //Instruction SQL: Formation+exécution.
            String instruction="select Produit.* from Produit, Commande, LigneCommande, InformationTextuellesProduit "
                    + "where ? = Commande.ClientID and Commande.IDCommande = LigneCommande.IDCommande "
                    + "and LigneCommande.IDProduit = Produit.IDProduit "
                    + "and Produit.IDProduit = InformationTextuellesProduit.IDProduit "
                    + "and InformationTextuellesProduit.IDLangue = ?";
            PreparedStatement ps=SingletonConnexion.getInstance().prepareCall(instruction);
            ps.setInt(1,idClient);
            ps.setString(2,idLangue);
            ResultSet donnee=ps.executeQuery();
            
            //Récupération des données et retour.
            while(donnee.next())
            {
                listProduct.add(new Product(
                    donnee.getInt("Produit.IDProduit"),
                    donnee.getBoolean("Produit.isNew"),
                    donnee.getBoolean("Produit.isSolde"),
                    donnee.getDouble("Produit.prix"),
                    donnee.getString("InformationTextuellesProduit.Description")
                    ));
            }
            
            //Fermeture de la DB
            SingletonConnexion.getInstance().close();
            
            return listProduct;
        }
      catch(Exception e)
        {
            throw new ProductException(e.getMessage()+"\nImpossible de récupérer les produits relatifs au client: ",idClient);
        }
    }
    
}
