package lk.ijse.nexttravel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TravelPackageDTO {
    private int packageId;
    private String packageName;
    private String packageDescription;
    private String packageCategory;
    private String travelAreas;
    private String allowPets;
    private String roomTypes;
    private String travelPackageVideoUrl;
}
