package com.example.challenge_5.service;
import com.example.challenge_5.model.Movie;
import com.example.challenge_5.repositories.MovieRepository;
import com.example.challenge_5.service.interfaces.BaseService;
import com.example.challenge_5.utils.Config;
import com.example.challenge_5.utils.MessageResponse;
import com.example.challenge_5.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class MovieService extends Response<String,String,Object> implements BaseService<Movie> {
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Map save(Movie movie) {
        try{
            if(movie.getActor()==null){
                return error(Config.ERROR_400, new MessageResponse().getCannotNull(), null);
            }
            if(movie.getDescription()==null){
                return error(Config.ERROR_400, new MessageResponse().getCannotNull(), null);
            }
            if(movie.getDirector()==null){
                return error(Config.ERROR_400,new MessageResponse().getCannotNull(), null);
            }
            if (movie.getTitle()==null){
                return error(Config.ERROR_400, new MessageResponse().getCannotNull(), null);
            }
            if (movie.getDuration_min()==0){
                return error(Config.ERROR_400, new MessageResponse().getCannotNull(), null);
            }
            Movie movieSave = movieRepository.save(movie);
            return  sukses(Config.SUCCESS_200,new MessageResponse().getSuccesSave(),movieSave );
        }catch (Exception e){
            return error(Config.ERROR_500, e.getMessage(), "Some Errors Occur in the backend");
        }
    }

    @Override
    public Map update(Movie movie) {
        try {
            if(!movieRepository.existsById(movie.getId())){
                return error(Config.ERROR_404, new MessageResponse().getErrorNotFound(movie.getId()), null);
            }
            Movie movieUpdate = movieRepository.findById(movie.getId()).get();
            if(movie.getDuration_min()!=0){
                movieUpdate.setDuration_min(movie.getDuration_min());
            }
            if(movie.getActor()!=null){
                movieUpdate.setActor(movie.getActor());
            }
            if(movie.getTitle()!=null){
                movieUpdate.setTitle(movie.getTitle());
            }
            if(movie.getDirector()!=null){
                movieUpdate.setTitle(movie.getDirector());
            }
            if(movie.getDescription()!=null){
                movieUpdate.setDescription(movieUpdate.getDescription());
            }
            Movie movieUpdateSave = movieRepository.save(movieUpdate);
            return sukses(Config.SUCCESS_200,new MessageResponse().getSuccesUpdate(), movieUpdateSave);
        }catch (Exception e){
            return error(Config.ERROR_500, e.getMessage(), "Some Errors Occur in the backend");
        }

    }

    @Override
    public Map delete(long id) {
            try{
                if(!movieRepository.existsById(id)) {
                    return error(Config.ERROR_404, new MessageResponse().getErrorNotFound(id), null);
                }
                Movie movie = movieRepository.findById(id).get();
                movieRepository.delete(movie);
                return sukses(Config.SUCCESS_200, new MessageResponse().getSuccesDelete(), null);
            }catch (Exception e){
                return error(Config.ERROR_500, e.getMessage(), "Some Errors Occur in the backend");
            }
    }

    @Override
    public Map getAll() {
        return sukses(Config.SUCCESS_200, "Success Get All Data", movieRepository.findAll());
    }

    @Override
    public Map getOne(long id) {
        try {
            if(!movieRepository.existsById(id)){
                return error(Config.ERROR_404, new MessageResponse().getErrorNotFound(id), null);
            }
            Movie movie = movieRepository.findById(id).get();
            return sukses(Config.SUCCESS_200, new MessageResponse("Success Found Data").getMessage(), movie);
        }catch (Exception e){
            return error(Config.ERROR_500,e.getMessage(),null);
        }
    }
}
