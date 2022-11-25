package com.example.challenge_4.controller;

import com.example.challenge_4.controller.base.BaseController;
import com.example.challenge_4.model.Film;
import com.example.challenge_4.model.dto.FilmDTO;
import com.example.challenge_4.repositories.FilmRepository;
import com.example.challenge_4.service.FilmService;
import com.example.challenge_4.utils.Config;
import com.example.challenge_4.utils.Pagination;
import com.example.challenge_4.utils.Response;
import com.example.challenge_4.utils.SimpleStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/film")
public class FilmController implements BaseController<FilmDTO> {

    @Autowired
    private FilmService filmService;

    @Autowired
    private FilmRepository filmRepository;




    SimpleStringUtils simpleStringUtils = new SimpleStringUtils();;

    @Override
    @PostMapping("/save")
    public ResponseEntity<Map> save(FilmDTO film) {
        return new ResponseEntity<Map>(filmService.save(film), HttpStatus.OK);
    }

    @Override
    @PutMapping("/update/{id}")
    public ResponseEntity<Map> update(FilmDTO film,@PathVariable("id") long id) {
        return new ResponseEntity<Map>(filmService.mengubahNamaFilm(id,film),HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map> delete(@PathVariable("id") Long id) {
        return new ResponseEntity<Map>(filmService.delete(id), HttpStatus.ACCEPTED);
    }

    @Override
    @GetMapping("/find-all")
    public ResponseEntity<Map> findAll() {
        return new ResponseEntity<Map>(filmService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/find-tayang")
    public ResponseEntity<Map> findTayang(@RequestBody FilmDTO filmDTO){
        return new ResponseEntity<Map>(filmService.menampilkanYangTayang(filmDTO), HttpStatus.OK);
    }

//    @GetMapping("/list")
//    public ResponseEntity<Map>listFilm(
//            @RequestParam() Integer page,
//            @RequestParam(required = true) Integer size,
//            @RequestParam(required = false) String name,
//            @RequestParam(required = false) String code,
//            @RequestParam(required = false) String orderby,
//            @RequestParam(required = false) String ordertype
//    ){
//         Pageable show_data = simpleStringUtils.getShort(orderby, ordertype, page, size);
//         Page<Film> list = null;
//        if(name != null && !name.isEmpty() && code != null && !code.isEmpty() ){
//            list = filmRepository.findByNameAndCode(name, code ,show_data );
//        }else if(code != null && !code.isEmpty()){
//            list = filmRepository.findByCode(code,show_data);
//        }else if(name != null && !name.isEmpty()){
//            list = filmRepository.findByName(name,show_data);
//        }else {
//            // nampilkan semuanya
//            list = filmRepository.getAllData(show_data);
//        }
//
//        Map map = new HashMap();
//        map.put("Status", "Oke");
//        map.put("Content", list);
//
//        return new ResponseEntity<Map>(map,HttpStatus.OK);
//    }

}

