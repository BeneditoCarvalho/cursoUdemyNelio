package cursoUdemyNelio.exerciciosFixacao.Composicao03.entities;

public class OrderItem {

    private Integer quantity;
    private Double price;
    private Product product;

    public OrderItem() {
    }

    public OrderItem(Integer quantity, Double price, Product product) {
        this.quantity = quantity;
        this.price = price;
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public Product getProduct() {
        return product;
    }

    public Double subTotal() {
        return quantity * price;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(product.getName());
        str.append(", ");
        str.append("$");
        str.append(String.format("%.2f", price));
        str.append(", ");
        str.append("Quantity: ");
        str.append(quantity);
        str.append(", ");
        str.append("Subtotal: $");
        str.append(String.format("%.2f", subTotal()));
        return
                str.toString();
    }
}
