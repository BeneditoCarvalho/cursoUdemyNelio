package cursoUdemyNelio.exerciciosFixacao.Abstract.entities;

public abstract class TaxPayer {

    private String name;
    private Double annualIncome;

    public TaxPayer(String nome, Double annualIncome) {
        this.name = nome;
        this.annualIncome = annualIncome;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAnnualIncome() {
        return annualIncome;
    }

    public abstract Double tax();


}
