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
    private String roomId;
    private String roomName;
    private List<HotelMealPlaneDTO> hotelMealPlaneDTOList;
    private List<HotelRoomTypeDTO> hotelRoomTypeDTOList;
    private boolean isAC;
    private boolean isPetsAllow;
    private CancellationPolicy cancellationPolicy;
    private double priceDay;
    private double priceDayDiscount;
    private double priceNight;
    private double priceNightDiscount;
    private String status;
}
