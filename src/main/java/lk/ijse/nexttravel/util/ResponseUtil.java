package lk.ijse.nexttravel.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseUtil{
    private int code;
    private String message;
    Object data;
}
