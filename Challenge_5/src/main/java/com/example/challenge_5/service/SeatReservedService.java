package com.example.challenge_5.service;
import com.example.challenge_5.model.SeatReserved;
import com.example.challenge_5.repositories.SeatReservedRepository;
import com.example.challenge_5.service.interfaces.BaseService;
import com.example.challenge_5.utils.Config;
import com.example.challenge_5.utils.MessageResponse;
import com.example.challenge_5.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;


@Service
public class SeatReservedService extends Response<String, String, Object> implements BaseService<SeatReserved> {
    @Autowired
    private SeatReservedRepository repository;

    @Override
    public Map save(SeatReserved seatReserved) {
        try{
            if(seatReserved.getReservation()==null){
                return error(Config.ERROR_400, new MessageResponse().getCannotNull(), null);
            }
            if(seatReserved.getSeat()==null){
                return error(Config.ERROR_400, new MessageResponse().getCannotNull(), null);
            }
            SeatReserved seatReservedSave = repository.save(seatReserved);
            return sukses(Config.SUCCESS_200, new MessageResponse().getSuccesSave(), null);
        }catch (Exception e){
            return error(Config.ERROR_500, e.getMessage(), null);
        }
    }

    @Override
    public Map update(SeatReserved seatReserved) {
        try {
            if (!repository.existsById(seatReserved.getId())){
                return error(Config.ERROR_404, new MessageResponse().getErrorNotFound(seatReserved.getId()), null );
            }
            SeatReserved seatReservedUpdate = repository.findById(seatReserved.getId()).get();
            if(seatReserved.getReservation()!=null){
                seatReservedUpdate.setReservation(seatReserved.getReservation());
            }
            if(seatReserved.getSeat()!=null){
                seatReservedUpdate.setSeat(seatReserved.getSeat());
            }
        repository.save(seatReservedUpdate);
            return sukses(Config.SUCCESS_200,new MessageResponse().getMessage(), seatReservedUpdate);
        }catch (Exception e){
            return error(Config.ERROR_500, e.getMessage(), null);
        }
    }

    @Override
    public Map delete(long id) {
        try {
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
            return sukses(Config.SUCCESS_200, new MessageResponse("Found Data All").getMessage(), repository.findAll());
        }catch (Exception e){
            return error(Config.ERROR_500, e.getMessage(), null);
        }
    }

    @Override
    public Map getOne(long id) {
        try {
            if(!repository.existsById(id)){
                return error(Config.ERROR_404, new MessageResponse().getErrorNotFound(id), null);
            }
            return sukses(Config.SUCCESS_200, new MessageResponse("Data Found").getMessage(), repository.findById(id).get());
        }catch (Exception e){
            return error(Config.ERROR_500, e.getMessage(), null);
        }
    }
}
