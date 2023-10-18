package lk.ijse.nexttravel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(value = "Driver_details")
public class Driver {
    @Id
    private int driver_id;
    private String driver_name;
    private String driver_contact_No;
    private byte[] driver_licen_front;
    private byte[] driver_licen_back;
}
