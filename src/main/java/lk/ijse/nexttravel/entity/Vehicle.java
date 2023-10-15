package lk.ijse.nexttravel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(value = "Vehicle_details")
public class Vehicle {
    @Id
    private int vehicleId;
    private String vehicleCategory;
    private String vehicle_name;
    private String fuelType;
    private String isHybrid;
    private int fuelUsage;
    private int seatCount;
    private int transmissionType;
    private double vehicle1kmCharge;
    private String remarks;
    private String canPolicy;
}
