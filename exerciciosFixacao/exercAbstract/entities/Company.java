package cursoUdemyNelio.exerciciosFixacao.exercAbstract.entities;

public class Company extends TaxPayer {

    private Integer numberEmployees;

    public Company(String name, Double annualIncome, Integer numberEmployees) {
        super(name, annualIncome);
        this.numberEmployees = numberEmployees;
    }

    public Integer getNumberEmployees() {
        return numberEmployees;
    }

    public void setNumberEmployees(Integer numberEmployees) {
        this.numberEmployees = numberEmployees;
    }

    @Override
    public Double tax() {
        double tax = 0.0;
        if (getNumberEmployees() < 10) {
            tax = getAnnualIncome() * 0.16;
        } else if (getNumberEmployees() > 10) {
            tax = getAnnualIncome() * 0.14;
        }
        return tax;
    }

    @Override
    public String toString () {
        return getName() + ":" + " $ " + String.format("%.2f", tax());
    }
}
