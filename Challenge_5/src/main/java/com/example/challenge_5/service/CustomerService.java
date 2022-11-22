package com.example.challenge_5.service;
import com.example.challenge_5.model.Customer;
import com.example.challenge_5.repositories.CustomerRepository;
import com.example.challenge_5.utils.Config;
import com.example.challenge_5.utils.MessageResponse;
import com.example.challenge_5.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class CustomerService extends Response<String, String, Object > implements BaseService<Customer>{
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Map save(Customer customer) {
        try{
            if(customer.getPassword()==null){
                return error(Config.ERROR_400, new MessageResponse().getCannotNull(), null);
            }
            if(customer.getUsername()==null){
                return error(Config.ERROR_400, new MessageResponse().getCannotNull(), null);
            }
            Customer customerSave = customerRepository.save(customer);
            return sukses(Config.SUCCESS_200, new MessageResponse().getSuccesSave(), customerSave);
        }catch (Exception e){
            return error(Config.ERROR_500, e.getMessage(), null);
        }
    }

    @Override
    public Map update(Customer customer) {
        try{
            if(!customerRepository.existsById(customer.getId())){
                return error(Config.ERROR_404, new MessageResponse().getErrorNotFound(customer.getId()), null);
            }
            Customer customerUpdate = customerRepository.findById(customer.getId()).get();
            if(customer.getUsername()!=null){
                customerUpdate.setUsername(customer.getUsername());
            }
            if(customer.getPassword()!=null){
                customerUpdate.setPassword(customer.getPassword());
            }

            return sukses(Config.SUCCESS_200, new MessageResponse().getMessage(), customerRepository.save(customerUpdate));
        }catch (Exception e){
            return error(Config.ERROR_500, e.getMessage(), null);
        }
    }

    @Override
    public Map delete(long id) {
        try {
            if(!customerRepository.existsById(id)){
                return error(Config.ERROR_404, new MessageResponse().getErrorNotFound(id), null);
            }
            customerRepository.deleteById(id);
            return sukses(Config.SUCCESS_200, new MessageResponse().getSuccesDelete(), null);
        }catch (Exception e){
            return error(Config.ERROR_500, e.getMessage(), null);
        }
    }

    @Override
    public Map getAll() {
        try {
            return sukses(Config.SUCCESS_200, "Found All Data", customerRepository.findAll());
        }catch (Exception e){
            return error(Config.ERROR_500, e.getMessage(), null);
        }
    }

    @Override
    public Map getOne(long id) {
        try{
            if(!customerRepository.existsById(id)){
                return error(Config.ERROR_404, new MessageResponse().getErrorNotFound(id), null);
            }
            Customer customer = customerRepository.findById(id).get();
            return sukses(Config.SUCCESS_200, new MessageResponse("Found Data").getMessage(), customer);
        }catch (Exception e){
            return error(Config.ERROR_500, e.getMessage(), null);
        }
    }
}
