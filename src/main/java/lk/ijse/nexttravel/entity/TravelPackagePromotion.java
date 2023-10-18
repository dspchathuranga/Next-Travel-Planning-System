package lk.ijse.nexttravel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(value = "Travel_Package_Promotion")
public class TravelPackagePromotion {
    @Id
    private int promotion_id;
    private int travel_package_id;
    private double hotel_discount;
    private double guide_discount;
    private double vehicle_discount;
    private double travel_package_discount;
    private Date promotion_start_date;
    private Date promotion_end_date;
    private String promotion_status;
}
