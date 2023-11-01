package lk.ijse.nexttravel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DriverDTO {
    private String driver_id;
    private String driver_name;
    private String driver_contact_No;
    private byte[] driver_licen_front;
    private byte[] driver_licen_back;
}
