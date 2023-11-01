package lk.ijse.nexttravel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HotelCategoryDTO {
    private String hotelCategoryId;
    private String hotelCategoryName;
    private String status;
}
