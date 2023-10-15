package lk.ijse.nexttravel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleDTO {
    private int vehicleId;
    private String vehicleCategory;
    private String vehicleName;
    private String fuelType;
    private String isHybrid;
    private int fuelUsage;
    private int seatCount;
    private String transmissionType;
    private double vehicle1kmCharge;
    private String remarks;
    private String canPolicy;
}
