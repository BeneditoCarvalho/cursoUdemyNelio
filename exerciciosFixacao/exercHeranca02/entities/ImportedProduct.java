package cursoUdemyNelio.exerciciosFixacao.exercHeranca02.entities;

public class ImportedProduct extends Product {

    private Double customsFee;

    public ImportedProduct(String name, Double price, Double customsFee) {
        super(name, price);
        this.customsFee = customsFee;
    }

    public Double getCustomsFee() {
        return customsFee;
    }

    public Double totalPrice() {
        return getPrice() + customsFee;
    }

    @Override
    public String priceTag() {
        return getName() + " $ " + String.format("%.2f", totalPrice())
                + " (Customs fee: $ " + String.format("%.2f", getCustomsFee()) + ")" + "\n";
    }

    @Override
    public String toString() {
        return priceTag();
    }

}
