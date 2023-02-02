package lk.ijse.RanasingheCinnamon.dto;

public class VehiclesDTO {
    private String id;
    private String brand;
    private String fuelCapacity;
    private String capacity;

    public VehiclesDTO(String id, String brand, String fuelCapacity, String capacity) {
        this.id = id;
        this.brand = brand;
        this.fuelCapacity = fuelCapacity;
        this.capacity = capacity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
