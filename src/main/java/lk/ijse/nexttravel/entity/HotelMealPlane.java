package lk.ijse.nexttravel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HotelMealPlane {
    private String mealPlaneId;
    private String mealPlaneName;
    private String status;
    private double adultPrice;
    private double childPrice;
}
