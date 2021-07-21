package cursoUdemyNelio.exerciciosFixacao.exercHeranca02.entities;

public class Product {

    private String name;
    private Double price;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public String priceTag (){
        return name + " $ " + String.format("%.2f", getPrice())+ "\n";
    }

    @Override
    public String toString () {
        return  priceTag();
    }
}
