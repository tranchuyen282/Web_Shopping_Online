package ghn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MethodGHN {
    private int service_id;
    private String short_name;
    private int service_type_id;
    private String leadtime;
    private int totalFee;
}
