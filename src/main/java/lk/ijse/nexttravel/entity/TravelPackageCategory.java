package lk.ijse.nexttravel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(value = "Travel_package_category")
public class TravelPackageCategory {
    @Id
    private int travel_package_category_id;
    private String travel_package_category_name;
    private List<HotelCategory>hotelCategories;
    private List<TravelPackageCategory>packageCategories;
}
