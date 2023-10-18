package lk.ijse.nexttravel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(value = "Room_details")
public class RoomDetails {
    @Id
    private int room_id;
    private String room_name;
    private int prmeal_plane_id;
    private int room_type_id;
    private boolean is_AC;
    private int adulte_count;
    private int child_count;
    private boolean is_pets_allow;
    private int can_policy_id;
    private double price_day;
    private double price_day_discount;
    private double price_night;
    private double price_night_discount;
    private String status;
}
