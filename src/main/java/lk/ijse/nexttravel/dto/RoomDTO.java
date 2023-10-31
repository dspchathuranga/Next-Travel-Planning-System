package lk.ijse.nexttravel.dto;

import lk.ijse.nexttravel.entity.CancellationPolicy;
import lk.ijse.nexttravel.entity.MealPlane;
import lk.ijse.nexttravel.entity.RoomType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoomDTO {
    private int room_id;
    private String room_name;
    private List<MealPlaneDTO> mealPlaneList;
    private List<RoomTypeDTO> roomTypeList;
    private boolean is_AC;
    private int adulte_count;
    private int child_count;
    private boolean is_pets_allow;
    private CancellationPolicy cancellationPolicy;
    private double price_day;
    private double price_day_discount;
    private double price_night;
    private double price_night_discount;
    private String status;
}
