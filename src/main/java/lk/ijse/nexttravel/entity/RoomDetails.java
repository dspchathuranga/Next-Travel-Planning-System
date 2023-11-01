package lk.ijse.nexttravel.entity;

import lk.ijse.nexttravel.dto.HotelMealPlaneDTO;
import lk.ijse.nexttravel.dto.HotelRoomTypeDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
//@Document(value = "room-details")
public class RoomDetails {
    private String roomId;
    private String roomName;
    private List<HotelMealPlane> hotelMealPlaneList;
    private List<HotelRoomType> hotelRoomTypeList;
    private boolean isAC;
    private boolean isPetsAllow;
    private CancellationPolicy cancellationPolicy;
    private double priceDay;
    private double priceDayDiscount;
    private double priceNight;
    private double priceNightDiscount;
    private String status;
}
