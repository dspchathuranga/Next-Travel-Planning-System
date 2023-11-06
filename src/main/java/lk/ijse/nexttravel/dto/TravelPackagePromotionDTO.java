package lk.ijse.nexttravel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TravelPackagePromotionDTO {
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
