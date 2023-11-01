package lk.ijse.nexttravel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HotelRoomType {
    private String roomTypeId;
    private String roomTypeName;
    private String status;
    private int roomCount;
    private int adultCount;
    private int childCount;
}
