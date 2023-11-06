package lk.ijse.nexttravel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(value = "vehicle-category")
public class VehicleCategory {
    @Id
    private int vehicleCategoryId;
    private String vehicleCategoryName;
    private String status;
}
