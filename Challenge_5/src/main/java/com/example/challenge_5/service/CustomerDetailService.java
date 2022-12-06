package com.example.challenge_5.service;

import com.example.challenge_5.model.security.User;
import com.example.challenge_5.model.security.UserDetail;
import com.example.challenge_5.repositories.CustomerDetailRepository;
import com.example.challenge_5.service.interfaces.BaseService;
import com.example.challenge_5.utils.Config;
import com.example.challenge_5.utils.MessageResponse;
import com.example.challenge_5.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CustomerDetailService extends Response<String, String, Object> implements BaseService<UserDetail> {
    @Autowired
    private CustomerDetailRepository customerDetailRepository;

    @Override
    public Map save(UserDetail customerDetail) {
        try {
            if(customerDetail.getUser()==null){
                return error(Config.ERROR_400, new MessageResponse().getCannotNull(), null);
            }
            if(customerDetail.getName()==null){
                return error(Config.ERROR_400, new MessageResponse().getCannotNull(), null);
            }
            if(customerDetail.getAddress()==null){
                return error(Config.ERROR_400, new MessageResponse().getCannotNull(), null);
            }
            if(customerDetail.getPhoneNumber()==null){
                return error(Config.ERROR_400, new MessageResponse().getCannotNull(), null);
            }
            UserDetail customerDetailSave = customerDetailRepository.save(customerDetail);
            return sukses(Config.SUCCESS_200, new MessageResponse().getSuccesSave(), null);
        }catch (Exception e){
            return error(Config.ERROR_400, e.getMessage(), null);
        }
    }

    @Override
    public Map update(UserDetail customerDetail) {
        try {
            if(!customerDetailRepository.existsById(customerDetail.getId())){
                return error(Config.ERROR_404, new MessageResponse().getErrorNotFound(customerDetail.getId()), null);
            }
            UserDetail customerDetailUpdate = customerDetailRepository.findById(customerDetail.getId()).get();
            if(customerDetail.getUser()!=null){
                customerDetailUpdate.setUser(customerDetail.getUser());
            }
            if(customerDetail.getName()!=null){
                customerDetailUpdate.setName(customerDetail.getName());
            }
            if(customerDetail.getAddress()!=null){
                customerDetailUpdate.setAddress(customerDetail.getAddress());
            }
            if(customerDetail.getPhoneNumber()!=null){
                customerDetailUpdate.setPhoneNumber(customerDetail.getPhoneNumber());
            }
            return sukses(Config.SUCCESS_200, new MessageResponse().getSuccesUpdate(), customerDetailRepository.save(customerDetailUpdate));

        }catch (Exception e){
            return error(Config.ERROR_500, e.getMessage(), null);
        }
    }

    @Override
    public Map delete(long id) {
        try {
            if(!customerDetailRepository.existsById(id)){
                return error(Config.ERROR_404, new MessageResponse().getErrorNotFound(id), null);
            }
            customerDetailRepository.deleteById(id);
            return sukses(Config.SUCCESS_200, new MessageResponse().getSuccesDelete(), null);
        }catch (Exception e){
            return error(Config.ERROR_500, e.getMessage(), null);
        }
    }

    @Override
    public Map getAll() {
        try {
            return sukses(Config.SUCCESS_200, new MessageResponse("Found All DAta").getMessage(), customerDetailRepository.findAll());
        }catch (Exception e){
            return error(Config.ERROR_500, e.getMessage(), null);
        }
    }

    @Override
    public Map getOne(long id) {
        try {
            if(!customerDetailRepository.existsById(id)){
                return error(Config.ERROR_404, new MessageResponse().getErrorNotFound(id), null);
            }
            UserDetail customerDetail = customerDetailRepository.findById(id).get();
            return sukses(Config.SUCCESS_200, new MessageResponse("Data Found").getMessage(), customerDetail);
        }catch (Exception e){
            return error(Config.ERROR_500, e.getMessage(), null);
        }
    }
}
