package ghn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressGHN {
    private int to_provinceID;
    private String to_provinceName;
    private int to_districtID;
    private String to_districtName;
    private String to_wardCode;
    private String to_wardName;
}
