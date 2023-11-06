package lk.ijse.nexttravel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GuideDTO {
    private String guidId;
    private String guidName;
    private String address;
    private String gender;
    private int age;
    private String contact;
    private String experience;
    private double dayValue;
//    private byte[] guideProfile;
    private String remarks;
    private int policyId;
    private String status;
}
