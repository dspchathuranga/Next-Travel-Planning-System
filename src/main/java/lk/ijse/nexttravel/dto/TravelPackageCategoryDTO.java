package lk.ijse.nexttravel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TravelPackageCategoryDTO {
    private String travelPackageCategoryId;
    private String travelPackageCategoryName;
    private List<String> hotelIds;
    private List<String> vehicleIds;
    private List<String> guideIds;
    private String status;
}
