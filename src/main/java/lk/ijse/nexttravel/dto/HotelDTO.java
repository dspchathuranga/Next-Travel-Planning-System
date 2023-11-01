package lk.ijse.nexttravel.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class HotelDTO {
    private String hotelId;
    private String hotelName;
    private HotelCategoryDTO hotelCategoryDTO;
    private String email;
    private String telephone;
    private String mobile;
    private String fax;
    private String address_1;
    private String address_2;
    private String city;
    private double longitude;
    private double latitude;
    private String description;
    private String websiteLink;
    private String facebook;
    private String instagram;
    private String status;
    private List<RoomDTO> roomDTOList;
}
