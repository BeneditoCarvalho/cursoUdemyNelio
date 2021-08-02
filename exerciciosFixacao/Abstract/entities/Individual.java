package cursoUdemyNelio.exerciciosFixacao.Abstract.entities;

public class Individual extends TaxPayer {

    private Double healthExpend;


    public Individual(String name, Double annualIncome, Double healthExpend) {
        super(name, annualIncome);
        this.healthExpend = healthExpend;
    }

    @Override
    public Double tax() {
        double tax = 0.0;
        if (getAnnualIncome() < 20000) {
            tax = getAnnualIncome() * 0.15 - (healthExpend * 0.5);
        } else if (getAnnualIncome() > 20000) {
            tax = getAnnualIncome() * 0.25 - (healthExpend * 0.5);
        }
        return tax;
    }

    @Override
    public String toString() {
        return getName() + ":" + " $ " + String.format("%.2f", tax());
    }
}
