package com.example.challenge_5.service;
import com.example.challenge_5.model.ReservationType;
import com.example.challenge_5.repositories.ReservationTypeRepository;
import com.example.challenge_5.utils.Config;
import com.example.challenge_5.utils.MessageResponse;
import com.example.challenge_5.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class ReservationTypeService extends Response<String, String, Object> implements BaseService<ReservationType> {
    @Autowired
    private ReservationTypeRepository repository;

    @Override
    public Map save(ReservationType reservationType) {
        try {
            if(reservationType.getType()==null){
                return error(Config.ERROR_400, new MessageResponse().getCannotNull(), null);
            }
            ReservationType reservationTypeSave = repository.save(reservationType);
            return sukses(Config.SUCCESS_200, new MessageResponse().getSuccesSave(), reservationTypeSave);
        }catch (Exception e){
            return error(Config.ERROR_500, e.getMessage(), null);
        }
    }

    @Override
    public Map update(ReservationType reservationType) {
        try {
            return sukses(Config.SUCCESS_200, new MessageResponse().getSuccesUpdate(), repository.save(reservationType));
        }catch (Exception e){
            return error(Config.ERROR_500, e.getMessage(), null);
        }
    }

    @Override
    public Map delete(long id) {
        try{
            if(!repository.existsById(id)){
                return error(Config.ERROR_404, new MessageResponse().getErrorNotFound(id), null);
            }
            repository.deleteById(id);
            return sukses(Config.SUCCESS_200, new MessageResponse().getSuccesDelete(), null);
        }catch (Exception e){
            return error(Config.ERROR_500, e.getMessage(), null);
        }
    }

    @Override
    public Map getAll() {
        try{
            return sukses(Config.SUCCESS_200, new MessageResponse("All Data Found").getMessage(), repository.findAll());
        }catch (Exception e){
            return error(Config.ERROR_500, e.getMessage(), null);
        }
    }

    @Override
    public Map getOne(long id) {
        try{
            return sukses(Config.SUCCESS_200, new MessageResponse("Data Found").getMessage(), repository.findById(id).get());
        }catch (Exception e){
            return error(Config.ERROR_500, e.getMessage(), null);
        }
    }
}
