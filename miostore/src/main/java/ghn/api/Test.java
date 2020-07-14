package ghn.api;

import currency.ShowMoney;
import ghn.entity.AddressGHN;
import ghn.entity.MethodGHN;
import md5.MD5Library;
import model.customer.Customer;
import service.CustomerService;
import serviceimpl.CustomerServiceImpl;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Test {
    public static void main(String[] args) {
//        MD5Library md5 = new MD5Library();
//        CustomerServiceImpl customerService = new CustomerServiceImpl();
//        Customer customer = customerService.getCustomer("customer1",md5.encrypt("123456"));
//        //System.out.println(customer);
//        AddressGHN addressGHN = ConvertAddressToAddressGHNService.convertToAddressGHN(customer.getAddress().get(0));
//        GHNService ghnService = new GHNService();
//        ArrayList<MethodGHN> methodGHNS = ghnService.getMethodGHN(addressGHN);
//        for(MethodGHN methodGHN:methodGHNS){
//            System.out.println(methodGHN);
//        }
        System.out.println(ShowMoney.fomartMoney(123456));
    }
}
