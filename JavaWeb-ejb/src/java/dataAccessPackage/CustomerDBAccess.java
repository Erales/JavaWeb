
package dataAccessPackage;

import dataAccessPackage.interfaces.*;
import java.sql.*;

import exceptionPackage.*;
import modelPackage.*;

public class CustomerDBAccess implements ICustomerDBAccess
{
    public Customer login(String id, String mdp) throws AnimaliaException
    { 
      try
        {
            Customer newClient = null;
            
            //Création de la connexion.          
            SingletonConnexion.getInstance();
            
            //Instruction SQL: Formation+exécution.
            String instruction="select * from Client where ? = AdrMail and ? = Mdp";
            PreparedStatement ps=SingletonConnexion.getInstance().prepareCall(instruction);
            ps.setString(1,id);
            ps.setString(2,mdp);           
            ResultSet donnee=ps.executeQuery();
            
            //Récupération des données et retour.
            donnee.next();
            newClient = new Customer(donnee.getString("AdrMail"),
                    donnee.getString("Mdp"),
                    donnee.getString("Nom"),
                    donnee.getString("adresse"),
                    donnee.getString("prenom"),
                    donnee.getString("numTel"),
                    donnee.getDate("dateNaiss"),
                    donnee.getDate("DateInscription"));
            
            //Fermeture de la DB.
            SingletonConnexion.getInstance().close();
            
            return newClient;
        }
      catch(Exception e)
        {
            throw new CustomerException(e+"\nImpossible de récupérer un client avec les ID encodé.",mdp,id);
        }
    }
    
    public void inscription(Customer newClient) throws AnimaliaException
    {
        try
        {
            //Préparation des dates.
            java.sql.Date birthDate, registerDate;
            
            //Création de la connexion.         
            SingletonConnexion.getInstance();

            //Instruction SQL: Formation+exécution.
            String instruction="insert into Client (ClientId, Mdp, Adresse, Nom, Prenom, NumTel, AdrMail, DateNaiss, DateInscription)"
                    + "values (?,?,?,?,?,?,?,?,?)";

            PreparedStatement prepaStat=SingletonConnexion.getInstance().prepareStatement(instruction);
            prepaStat.setObject(1,newClient.getCustomerID(),Types.INTEGER);
            prepaStat.setObject(2,newClient.getPassword(),Types.VARCHAR);
            prepaStat.setObject(3,newClient.getAddress(),Types.VARCHAR);
            prepaStat.setObject(4,newClient.getLastName(),Types.VARCHAR);
            prepaStat.setObject(5,newClient.getFirstName(),Types.VARCHAR);
            prepaStat.setObject(6,newClient.getPhone(),Types.VARCHAR);
            prepaStat.setObject(7,newClient.getMail(),Types.VARCHAR);
            prepaStat.setObject(8,newClient.getBirthDate(),Types.DATE);
            prepaStat.setObject(9,newClient.getRegistrationDate(),Types.DATE);
            
            prepaStat.executeUpdate();
            
            //Fermeture de la DB.
            SingletonConnexion.getInstance().close();
        }
        catch(Exception e)
        {
            throw new CustomerException("Impossible d'encoder le client suivant:\n",newClient);
        }
    }
    
    
}
