package lk.ijse.nexttravel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(value = "Travel_package_hotel_details")
public class TravelPackageHotel {
    @Id
    private int travel_package_hotel_id;
    private int travel_package_id;
    private int hotel_Id;
    private String price_cal_type;
    private int price_cal_count;
    private boolean is_hotel_discount_allowed;
}
