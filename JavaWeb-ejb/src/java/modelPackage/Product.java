
package modelPackage;

public class Product
{
    private Integer productID;
    private Boolean isNew, isSolde;
    private Double price;
    private String description;
    private Integer stock;

    public Product(Integer productID, Boolean isNew, Boolean isSolde, Double price, String description) {
        this.productID = productID;
        this.isNew = isNew;
        this.isSolde = isSolde;
        this.price = price;
        this.description = description;
        this.stock = stock;
    }
    
    
}
