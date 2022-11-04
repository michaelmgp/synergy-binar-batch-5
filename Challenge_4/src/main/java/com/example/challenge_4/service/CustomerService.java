package com.example.challenge_4.service;
import com.example.challenge_4.model.Customer;
import com.example.challenge_4.repositories.CustomerRepository;
import com.example.challenge_4.service.base.BaseUserService;
import com.example.challenge_4.utils.Config;
import com.example.challenge_4.utils.MessageResponse;
import com.example.challenge_4.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class CustomerService extends Response<String,String,Object> implements BaseUserService<Customer> {
    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public Map menambahkanUser(Customer customer) {
        if(customer.getUsername()==null){
            return error(Config.ERROR_500, new MessageResponse().getCannotNull(), null);
        }
        if(customer.getEmailAddress()==null){
            return error(Config.ERROR_500, new MessageResponse().getCannotNull(), null);
        }
        if(customer.getPassword()==null){
            return error(Config.ERROR_500, new MessageResponse().getCannotNull(), null);
        }
        Customer customerSave =  customerRepository.save(customer);
        return sukses(Config.SUCCESS_200,new MessageResponse().getSuccesSave(),customerSave);
    }


    @Override
    public Map menghapusUser(long id) {
        try{
            if(!customerRepository.existsById(id)){
                return error(Config.ERROR_404, new MessageResponse().getErrorNotFound(id),null);
            }
            Customer customer = customerRepository.findById(id).get();
            customerRepository.delete(customer);
            return sukses(Config.SUCCESS_200, new MessageResponse().getSuccesDelete(),null);
        }catch (Exception e){
            return error(Config.ERROR_500, e.getMessage(), null);
        }
    }

    @Override
    public Map mengubahUser(long id, Customer customer) {
        try{
            if(!customerRepository.existsById(id)){
                return error(Config.ERROR_404,new MessageResponse().getErrorNotFound(id), null);
            }
            Customer customerUpdate = customerRepository.findById(id).get();
            if(customer.getEmailAddress()!=null){
                customerUpdate.setEmailAddress(customer.getEmailAddress());
            }
            if(customer.getPassword()!=null){
                customerUpdate.setPassword(customer.getPassword());
            }
            if(customer.getUsername()!=null){
                customerUpdate.setUsername(customer.getUsername());
            }
            Customer save = customerRepository.save(customerUpdate);
            return sukses(Config.SUCCESS_200, new MessageResponse().getSuccesUpdate(), save );
        }catch (Exception e){
            return error(Config.ERROR_400,e.getMessage(), null);
        }
    }

    @Override
    public Map mencariSemuaUser() {
        return sukses(Config.SUCCESS_200, "Success", customerRepository.findAll());
    }
}
