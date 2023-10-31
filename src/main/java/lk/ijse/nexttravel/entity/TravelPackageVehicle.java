package lk.ijse.nexttravel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(value = "Travel_Package_Vehicle")
public class TravelPackageVehicle {
    @Id
    private int travel_package_vehicle_id;
    private int travel_package_id;
    private int vehicle_id;
    private String price_cal_type;
}
