package lk.ijse.RanasingheCinnamon.entity;

public class Vehicle {
    private String vehicleId;
    private String brand;
    private String fuelCapacity;
    private String capacity;

    public Vehicle(String vehicleId, String brand, String fuelCapacity, String capacity) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.fuelCapacity = fuelCapacity;
        this.capacity = capacity;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(String fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }
}
