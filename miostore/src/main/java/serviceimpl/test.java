package serviceimpl;

import md5.MD5Library;

public class test {
    public static void main(String[] args) {
        MD5Library md5 = new MD5Library();
        CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
        System.out.println(customerServiceImpl.getCustomer("customer1", md5.encrypt("1234")));
        String s = null;
        if(s != null){
            System.out.println("a");
        }else{
            System.out.println("b");
        }
    }

}