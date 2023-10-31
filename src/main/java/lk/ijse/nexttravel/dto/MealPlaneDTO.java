package lk.ijse.nexttravel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MealPlaneDTO {
    private int meal_plane_id;
    private String meal_plane_name;
    private String status;
    private double price;
}
