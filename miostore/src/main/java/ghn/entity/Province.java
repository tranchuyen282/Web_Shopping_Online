package ghn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Province {
    private int provinceID;
    private String provinceName;
    private String code;
    private ArrayList<District> listDistrict;
}
