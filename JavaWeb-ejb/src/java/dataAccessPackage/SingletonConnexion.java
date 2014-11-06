
package dataAccessPackage;

//Import Java.
import java.sql.Connection;
import javax.naming.Context;
import javax.naming.*;
import javax.sql.DataSource;
//Import du projet.
import exceptionPackage.*;

public class SingletonConnexion
{
    private static Connection myConnexion;
    
    private SingletonConnexion()
    {
        
    }
    
    //Création et obtention de la connexion a la BD.
    public static Connection getInstance() throws AnimaliaException
    {
        if(myConnexion == null)
        {
            try
            {
                Context cont=new InitialContext();
                DataSource source=(DataSource)cont.lookup("jdbc/animalia");
                myConnexion=source.getConnection("Gilles","erales");
                
                return myConnexion;
            } 
            catch (Exception ex)
            {
                throw new ConnexionDBException(ex.getMessage());
            }
        }
        else
        {
            return myConnexion;
        }
    }
}