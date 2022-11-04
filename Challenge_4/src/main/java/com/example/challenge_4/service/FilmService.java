package com.example.challenge_4.service;

import com.example.challenge_4.enums.Tayang;
import com.example.challenge_4.model.Film;
import com.example.challenge_4.model.dto.FilmDTO;
import com.example.challenge_4.repositories.FilmRepository;
import com.example.challenge_4.service.base.BaseFilmService;
import com.example.challenge_4.utils.Config;
import com.example.challenge_4.utils.MessageResponse;
import com.example.challenge_4.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.sym.error;

@Service
public class FilmService extends Response<String,String,Object>implements BaseFilmService<FilmDTO> {
    @Autowired
    private FilmRepository filmRepository;




    @Override
    public Map tambahFilm(FilmDTO film) {
        try{
            String tayang = film.getTayang();
            if(tayang==null){
                return error(Config.ERROR_400, new MessageResponse().getCannotNull(), null);
            }else{
                String tayangString=tayang.replaceAll("[^a-zA-Z]"," ").toLowerCase().trim();
                Film filmNew = new Film();
                filmNew.setCode(film.getCode());
                filmNew.setName(film.getName());
                if(tayangString.equals("tayang")){
                    filmNew.setTayang(Tayang.TAYANG);
                }else if(tayangString.equals("segeratayang")){
                    filmNew.setTayang((Tayang.SEGERA_TAYANG));
                }else{
                    return error(Config.ERROR_500, "Please Replace Value on Tayang with 'Tayang' or 'Segera-Tayang' ", null);
                }
                Film filmsave = filmRepository.save(filmNew);
                return sukses(Config.SUCCESS_200,new MessageResponse().getSuccesSave(),filmsave);
            }




        }catch (Exception e){
            return error(Config.ERROR_400, e.getMessage(), null);
        }

    }

    @Override
    public Map mengubahNamaFilm(Long id, FilmDTO film) {
        try{
            if(film.getName()==null){
                return error(Config.ERROR_500, new MessageResponse().getCannotNull(),null);
            }
            if(!filmRepository.findById(id).isPresent()){
                return error(Config.ERROR_404, new MessageResponse().getErrorNotFound(id),null);
            }
            Film filmUpdate = filmRepository.findById(id).get();
            filmUpdate.setName(film.getName());
            Film filmSave = filmRepository.save(filmUpdate);
            return sukses(Config.SUCCESS_200,new MessageResponse().getSuccesSave(),filmSave);
        }catch (Exception e){
            return error(Config.ERROR_400, e.getMessage(),null);
        }
    }


    @Override
    public Map menghapusFilm(long id) {
        try {
            if(!filmRepository.findById(id).isPresent()){
                return error(Config.ERROR_404,new MessageResponse().getErrorNotFound(id),null);
            }
            filmRepository.deleteById(id);
            return sukses(Config.SUCCESS_200, new MessageResponse().getSuccesDelete(),null);
        }catch (Exception e){
            return error(Config.ERROR_400, e.getMessage(),null);
        }
    }

    @Override
    public Map menampilkanSemuafilm() {
        return sukses(Config.SUCCESS_200,  "Succes", filmRepository.findAll());
    }

    @Override
    public Map menampilkanYangTayang(String tayang) {
        List <Film> filmTayang= new ArrayList<>();
        try{
            tayang.replaceAll("[^a-zA-Z]","");
            if(tayang=="tayang"){
               filmTayang = filmRepository.findAllByTayang(Tayang.TAYANG);
            }if(tayang=="segeratayang"){
               filmTayang = filmRepository.findAllByTayang(Tayang.SEGERA_TAYANG);
            }else{
                return error(Config.ERROR_500,"Bad Request ! Please input 'Tayang or Segera Tayang",null);
            }
            return sukses(Config.SUCCESS_200, "Succes", (Film) filmTayang);
        }catch (Exception e){
            return error(Config.ERROR_400, e.getMessage(), null);
        }
    }
}
