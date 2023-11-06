package lk.ijse.nexttravel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DriverDTO {
    private String driverId;
    private String driverName;
    private String driverContactNo;
    private byte[] driverLicenFront;
    private byte[] driverLicenBack;
    private String status;
}
