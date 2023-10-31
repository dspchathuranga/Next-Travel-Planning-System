package lk.ijse.nexttravel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(value = "Travel_Package_Guide")
public class TravelPackageGuide {
    @Id
    private int travel_package_guid_id;
    private int travel_package_id;
    private int guid_id;
    private double discount;
}
