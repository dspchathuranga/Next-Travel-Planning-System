package lk.ijse.nexttravel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HotelRoomTypeDTO {
    private String roomTypeId;
    private String roomTypeName;
    private String status;
    private int roomCount;
    private int adultCount;
    private int childCount;
}
