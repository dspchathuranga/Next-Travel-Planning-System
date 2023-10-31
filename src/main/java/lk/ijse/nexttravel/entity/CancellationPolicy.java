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
    private int can_policy_id;
    private String can_policy_name;
    private double cancel_fee;
    private String can_policy_details;
}
