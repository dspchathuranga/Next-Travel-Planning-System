package lk.ijse.nexttravel.entity;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(value = "Guid_details")
public class Guide{
    @Id
    private String guidId;
    @Column(nullable = false)
    private String guidName;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String gender;
    @Column(nullable = false)
    private String contact;
    @Column(nullable = false)
    private String experience;
    @Column(nullable = false)
    private double dayValue;
    @Column(nullable = false)
    private String remarks;
    @Column(nullable = false)
    private byte[] guideProfile;
    @Column(nullable = false)
    private int policyId;
}
