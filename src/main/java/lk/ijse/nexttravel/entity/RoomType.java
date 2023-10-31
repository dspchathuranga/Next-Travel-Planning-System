package lk.ijse.nexttravel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(value = "room-type")
public class RoomType {
    @Id
    private int room_type_id;
    private String room_type_name;
    private String status;
    private int headCount;
}
