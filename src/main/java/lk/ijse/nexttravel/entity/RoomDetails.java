package lk.ijse.nexttravel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(value = "room-details")
public class RoomDetails {
    @Id
    private int room_id;
    private String room_name;
    private List<MealPlane> mealPlaneList;
    private List<RoomType> roomTypeList;
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
