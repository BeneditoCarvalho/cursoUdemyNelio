package cursoUdemyNelio.exerciciosFixacao.exercSummary.entities;

public class Product {

    private String productName;
    private Double productPrice;
    private Integer productQty;

    public Product(String productName, Double productPrice, Integer productQty) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQty = productQty;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductQty() {
        return productQty;
    }

    public void setProductQty(Integer productQty) {
        this.productQty = productQty;
    }

    public double total() {
        return productPrice * productQty;
    }
}