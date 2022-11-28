package com.example.challenge_5.service;
import com.example.challenge_5.model.Theater;
import com.example.challenge_5.repositories.TheaterRepository;
import com.example.challenge_5.service.interfaces.BaseService;
import com.example.challenge_5.utils.Config;
import com.example.challenge_5.utils.MessageResponse;
import com.example.challenge_5.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class TheaterService extends Response<String,String, Object> implements BaseService<Theater> {
    @Autowired
    private TheaterRepository theaterRepository;

    @Override
    public Map save(Theater theater) {
        try{
            if(theater.getName()==null){
                return error(Config.ERROR_400, new MessageResponse().getCannotNull(), null);
            }
            Theater theaterSave = theaterRepository.save(theater);
            return sukses(Config.SUCCESS_200,new MessageResponse().getSuccesSave(), theaterSave);
        }catch (Exception e){
                return error(Config.ERROR_500,e.getMessage(), null);
        }

    }

    @Override
    public Map update(Theater theater) {
        try{
            if(!theaterRepository.existsById(theater.getId())){
                return error(Config.ERROR_404, new MessageResponse().getErrorNotFound(theater.getId()), null);
            }
            Theater theaterUpdate = theaterRepository.findById(theater.getId()).get();
            if(theater.getName()!=null){
                theaterUpdate.setName(theater.getName());
            }
            theaterRepository.save(theaterUpdate);
            return sukses(Config.SUCCESS_200, new MessageResponse().getSuccesUpdate(), theaterUpdate);
        }catch (Exception e){
            return error(Config.ERROR_500, e.getMessage(), null);
        }
    }

    @Override
    public Map delete(long id) {
        try{
            if(!theaterRepository.existsById(id)){
                return error(Config.ERROR_404, new MessageResponse().getErrorNotFound(id), null);
            }
            theaterRepository.deleteById(id);
            return sukses(Config.SUCCESS_200, new MessageResponse().getSuccesDelete(), null);
        }catch (Exception e){
            return error(Config.ERROR_500, e.getMessage(), null);
        }
    }

    @Override
    public Map getAll() {
        return sukses(Config.SUCCESS_200, new MessageResponse("Success Find All Data").getMessage(), theaterRepository.findAll());
    }

    @Override
    public Map getOne(long id) {
        try {
            if(!theaterRepository.existsById(id)){
                return error(Config.ERROR_404, new MessageResponse().getErrorNotFound(id), null);
            }
            Theater theater = theaterRepository.findById(id).get();
            return sukses(Config.SUCCESS_200, new MessageResponse("Files is Found").getMessage(), theater);
        }catch (Exception e){
            return error(Config.ERROR_500, e.getMessage(), null);
        }

    }
}
