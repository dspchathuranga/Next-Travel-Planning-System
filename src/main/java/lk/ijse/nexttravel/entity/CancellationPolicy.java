package lk.ijse.nexttravel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(value = "cancellation-policy")
public class CancellationPolicy {
    @Id
    private String canPolicyId;
    private String canPolicyName;
    private double cancelFee;
    private String canPolicyDetails;
    private String status;
}
