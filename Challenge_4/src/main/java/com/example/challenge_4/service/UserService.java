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
public class UserService extends Response<String,String,Customer> implements BaseUserService<Customer> {
    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public Map menambahkanUser(Customer customer) {
        Customer customerSave =  customerRepository.save(customer);
        return sukses(Config.SUCCESS_200,new MessageResponse().getSuccesSave(),customerSave);
    }

    @Override
    public Map mengubahUser(Customer customer, long id) {
        try{
            if(!customerRepository.existsById(id)){
                return error(Config.ERROR_404,new MessageResponse().getErrorNotFound(id),null);
            }
            Customer customerUpdate = customerRepository.findById(id).get();
            customerUpdate.setUsername(customer.getUsername());
            customerUpdate.setPassword(customer.getPassword());
            customerUpdate.setEmailAddress(customer.getEmailAddress());
            Customer save = customerRepository.save(customerUpdate);
            return sukses(Config.SUCCESS_200,new MessageResponse().getSuccesSave(),save);
        }catch (Exception e){
            return error(Config.ERROR_500,e.getMessage(),null);
        }
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
}
