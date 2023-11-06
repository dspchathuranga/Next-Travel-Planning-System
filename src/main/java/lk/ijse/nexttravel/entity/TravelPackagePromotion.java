package lk.ijse.nexttravel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(value = "travel-package-promotion")
public class TravelPackagePromotion {
    @Id
    private String promotionId;
    private String travelPackageId;
    private double hotelDiscount;
    private double guideDiscount;
    private double vehicleDiscount;
    private double travelPackageDiscount;
    private Date promotionStartDate;
    private Date promotionEndDate;
    private String promotionStatus;
    private String status;
}
