package ghn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class District {
    private int districtID;
    private String districtName;
    private String code;
    private ArrayList<Ward> listWard;

}
