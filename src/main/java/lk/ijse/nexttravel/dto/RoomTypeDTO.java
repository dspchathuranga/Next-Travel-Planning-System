package lk.ijse.nexttravel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoomTypeDTO {
    private int room_type_id;
    private String room_type_name;
    private String status;
    private int headCount;
}
