package serviceimpl;

import dao.AccountCustomerDAOImpl;
import dao.CustomerDAO;
import dao.CustomerDAOimpl;
import model.account.AccountCustomer;
import model.customer.Customer;
import service.CustomerService;

public class CustomerServiceImpl implements CustomerService{

    @Override
    public Customer getCustomer(String username, String password) {
        Customer customer = null;
        AccountCustomerDAOImpl accountDAOImpl = new AccountCustomerDAOImpl();
        AccountCustomer accountCustomer = null;
        accountCustomer = accountDAOImpl.getAccount(username, password);
        if(accountCustomer != null){
            CustomerDAO customerDAOimpl = new CustomerDAOimpl();
            customer = customerDAOimpl.getCustomerByIDAccount(accountCustomer.getId());
            customer.setAccountCustomer(accountCustomer);
        }
        return customer;
    }
    
    

}