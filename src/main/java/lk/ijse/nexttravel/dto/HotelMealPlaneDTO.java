package lk.ijse.nexttravel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HotelMealPlaneDTO {
    private String mealPlaneId;
    private String mealPlaneName;
    private String status;
    private double adultPrice;
    private double childPrice;
}
