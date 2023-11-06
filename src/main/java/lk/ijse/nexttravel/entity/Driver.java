package lk.ijse.nexttravel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(value = "driver-details")
public class Driver {
    @Id
    private String driverId;
    private String driverName;
    private String driverContactNo;
    private byte[] driverLicenFront;
    private byte[] driverLicenBack;
    private String status;
}
