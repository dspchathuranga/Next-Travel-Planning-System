package lk.ijse.nexttravel.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity(name = "User_details")
public class User {
    @Id
    private String userId;
    private String userName;
    private String userPassword;
    private String userContactNo;
    private String userNic;
    private int userAge;
    private String gender;
    private String address;
    private String remarks;
}
