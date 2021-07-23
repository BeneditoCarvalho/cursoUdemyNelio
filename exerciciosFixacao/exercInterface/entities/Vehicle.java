package cursoUdemyNelio.exerciciosFixacao.exercInterface.entities;

public class Vehicle {

    private String carModel;

    public Vehicle(String carModel) {
        this.carModel = carModel;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }
}
