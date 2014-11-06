
package exceptionPackage;

public class ProductException extends AnimaliaException
{
    private Integer idCategorie;
    private String idLangue;
    private Integer idClient;

    public ProductException(String erreur, Integer idCategorie, String idLangue)
    {
        super(erreur);
        
        this.idCategorie=idCategorie;
        super.addNewMessageErreur("\nCatégorie choisie: "+idCategorie);
        
        this.idLangue=idLangue;
        super.addNewMessageErreur("\nCode langue: "+idLangue);
    }
    
    public ProductException(String erreur, Integer idClient)
    {
        super(erreur);
        this.idClient=idClient;
        super.addNewMessageErreur("\nClient concerné: "+idClient);
    }
}
