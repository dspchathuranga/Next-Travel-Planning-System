package lk.ijse.nexttravel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("images")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Image {
    @Id
    private String id;
    private String imageUrl;
}
