package ghn.api;

import ghn.entity.AddressGHN;
import ghn.entity.District;
import ghn.entity.Province;
import ghn.entity.Ward;
import model.customer.Address;

public class ConvertAddressToAddressGHNService {

    public static AddressGHN convertToAddressGHN(Address address){
        AddressGHN addressGHN = new AddressGHN();
        //getProvince
        ProvinceService provinceService = new ProvinceService();
        Province province = provinceService.getProvinceFromDBByName(address.getProvince());
        //getDistrict
        DistrictService districtService = new DistrictService();
        District district = districtService.getDistrictByName(province,address.getDistrict());
        //getWard
        WardService wardService = new WardService();
        Ward ward = wardService.getWardByName(district,address.getWard());

        //seter
        addressGHN.setTo_districtID(district.getDistrictID());
        addressGHN.setTo_provinceID(province.getProvinceID());
        addressGHN.setTo_provinceName(province.getProvinceName());
        addressGHN.setTo_districtName(district.getDistrictName());
        addressGHN.setTo_wardCode(ward.getWardCode());
        addressGHN.setTo_wardName(ward.getWardName());


        return addressGHN;

    }
}
