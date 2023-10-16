package lk.ijse.nexttravel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
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
