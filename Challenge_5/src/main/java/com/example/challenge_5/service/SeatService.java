package com.example.challenge_5.service;
import com.example.challenge_5.model.Seat;
import com.example.challenge_5.repositories.SeatRepository;
import com.example.challenge_5.utils.Config;
import com.example.challenge_5.utils.MessageResponse;
import com.example.challenge_5.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class SeatService extends Response<String, String, Object> implements BaseService<Seat> {
    @Autowired
    private SeatRepository seatRepository;
    @Override
    public Map save(Seat seat) {
        try{
            if(seat.getTheater()==null){
                return error(Config.ERROR_400, new MessageResponse().getCannotNull(), null);
            }
            Seat seatSave = seatRepository.save(seat);
            return sukses(Config.SUCCESS_200, new MessageResponse().getSuccesSave(), seatSave);
        }catch (Exception e){
            return error(Config.ERROR_500, e.getMessage(), null);
        }
    }

    @Override
    public Map update(Seat seat) {
        try{
            if(!seatRepository.existsById(seat.getId())){
                return error(Config.ERROR_404, new MessageResponse().getErrorNotFound(seat.getId()), null);
            }
            Seat seatUpdate = seatRepository.findById(seat.getId()).get();
            seatUpdate.setRow(seat.getRow());
            seatUpdate.setNumber(seat.getNumber());
            seatUpdate.setTheater(seat.getTheater());
            seatRepository.save(seatUpdate);
            return sukses(Config.SUCCESS_200, new MessageResponse().getSuccesUpdate(), seatUpdate);
        }catch (Exception e){
            return error(Config.ERROR_500, e.getMessage(), null);
        }
    }

    @Override
    public Map delete(long id) {
        try{
            if(!seatRepository.existsById(id)){
                return error(Config.ERROR_404, new MessageResponse().getErrorNotFound(id), null);
            }
            Seat seatDelete = seatRepository.findById(id).get();
            Seat seatDeleteResponse = seatDelete;
            seatRepository.deleteById(id);
            return sukses(Config.SUCCESS_200, new MessageResponse().getSuccesDelete(), seatDeleteResponse);
        }catch (Exception e){
            return error(Config.ERROR_500, e.getMessage(), null);
        }
    }

    @Override
    public Map getAll() {
        return sukses(Config.SUCCESS_200, "Found All Data", seatRepository.findAll());
    }

    @Override
    public Map getOne(long id) {
       try{
           if(!seatRepository.existsById(id)){
               return error (Config.ERROR_404, new MessageResponse().getErrorNotFound(id), null);
           }
           Seat seat = seatRepository.findById(id).get();
           return sukses(Config.SUCCESS_200, new MessageResponse().getSuccesSave(), seat);
       }catch (Exception e){
           return error(Config.ERROR_500, e.getMessage(), null);
       }
    }
}
