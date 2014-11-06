
package modelPackage;

public class Promo
{
    private String libelle, codePromo;
    private Double pourcReduction; 
    private Integer quantiteMin1ArticleOffert, idPromo;

    public Promo(String libelle, String codePromo, Double pourcReduction, Integer quantiteMin1ArticleOffert, Integer idPromo)
    {
        this.libelle = libelle;
        this.codePromo = codePromo;
        this.pourcReduction = pourcReduction;
        this.quantiteMin1ArticleOffert = quantiteMin1ArticleOffert;
        this.idPromo = idPromo;
    }
    
    //Getters.
    public String getLibelle() {
        return libelle;
    }

    public String getCodePromo() {
        return codePromo;
    }

    public Double getPourcReduction() {
        return pourcReduction;
    }

    public Integer getQuantiteMin1ArticleOffert() {
        return quantiteMin1ArticleOffert;
    }

    public Integer getIdPromo() {
        return idPromo;
    }
}
