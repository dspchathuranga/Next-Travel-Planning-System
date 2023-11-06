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
@Document(value = "travel-package-category")
public class TravelPackageCategory {
    @Id
    private String travelPackageCategoryId;
    private String travelPackageCategoryName;
    private List<String> hotelIds;
    private List<String> vehicleIds;
    private List<String> guideIds;
    private String status;

}
