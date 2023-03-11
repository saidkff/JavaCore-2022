package com.company;

@TestTable(scheme = "garage", dataName = "car")
public class Car {
    @TestColumn("model")
    private String model;
    @TestColumn("brand")
    private String brand;

    public Car(String model, String brand) {
        this.model = model;
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
