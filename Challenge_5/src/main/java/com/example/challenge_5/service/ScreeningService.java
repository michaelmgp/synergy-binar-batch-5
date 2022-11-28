package com.example.challenge_5.service;
import com.example.challenge_5.model.Screening;
import com.example.challenge_5.repositories.ScreeningReposiotry;
import com.example.challenge_5.service.interfaces.BaseService;
import com.example.challenge_5.utils.Config;
import com.example.challenge_5.utils.MessageResponse;
import com.example.challenge_5.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ScreeningService extends Response<String,String,Object> implements BaseService<Screening> {
    @Autowired
    private ScreeningReposiotry screeningReposiotry;
    @Override
    public Map save(Screening screening) {
        try{
            if(screening.getMovie()==null){
                return error(Config.ERROR_400, new MessageResponse().getCannotNull(), null);
            }
            if(screening.getTheater()==null){
                return error(Config.ERROR_400, new MessageResponse().getCannotNull(), null);
            }
            if(screening.getScreeningDateString()==null){
                return error(Config.ERROR_400, new MessageResponse().getCannotNull(), null);
            }
            if(screening.getScreeningStartString()==null){
                return error(Config.ERROR_400, new MessageResponse().getCannotNull(), null);
            }
            Screening screeningSave = new Screening();
            screeningSave.setScreeningStartFormatted(screening.getScreeningStartString());
            screeningSave.setScreeningDateFormatted(screening.getScreeningDateString());
            screeningSave.setMovie(screening.getMovie());
            screeningSave.setTheater(screening.getTheater());
            screeningReposiotry.save(screeningSave);
            return sukses(Config.SUCCESS_200, new MessageResponse().getSuccesSave(), screeningSave);
        }catch (Exception e){
            return error(Config.ERROR_500, e.getMessage(), null);
        }
    }

    @Override
    public Map update(Screening screening) {
        try {
            if(!screeningReposiotry.existsById(screening.getId())){
                return error(Config.ERROR_404, new MessageResponse().getErrorNotFound(screening.getId()),null);
            }
            Screening screeningUpdate = screeningReposiotry.findById(screening.getId()).get();
            if(screening.getScreeningStart()!=null){
                screeningUpdate.setScreeningStart(screening.getScreeningStart());
            }
            if(screening.getScreeningDate()!=null){
                screeningUpdate.setScreeningDate(screening.getScreeningDate());
            }
            if(screening.getMovie()!=null){
                screeningUpdate.setMovie(screening.getMovie());
            }
            if(screening.getTheater()!=null){
                screeningUpdate.setTheater(screening.getTheater());
            }
        }catch (Exception e){
            return error(Config.ERROR_500, e.getMessage(), null);
        }
        return null;
    }

    @Override
    public Map delete(long id) {
        try{
            if(!screeningReposiotry.existsById(id)){
                return error(Config.ERROR_404, new MessageResponse().getErrorNotFound(id), null);
            }
            screeningReposiotry.deleteById(id);
            return sukses(Config.SUCCESS_200, new MessageResponse().getSuccesDelete(), null);
        }catch (Exception e){
            return error(Config.ERROR_500, e.getMessage(), null);
        }
    }

    @Override
    public Map getAll() {
        try {
            return sukses(Config.SUCCESS_200, new MessageResponse("All Data Found").getMessage(), screeningReposiotry.findAll());
        }catch (Exception e){
            return error(Config.ERROR_500, e.getMessage(), null);
        }

    }

    @Override
    public Map getOne(long id) {
        try {
            if(!screeningReposiotry.existsById(id)){
                return error(Config.ERROR_404, new MessageResponse().getErrorNotFound(id), null);
            }
            Screening screening = screeningReposiotry.findById(id).get();
            return sukses(Config.SUCCESS_200, new MessageResponse(" Data Found ").getMessage(), null);
        }catch (Exception e){
            return error(Config.ERROR_500, e.getMessage(), null);
        }

    }
}
