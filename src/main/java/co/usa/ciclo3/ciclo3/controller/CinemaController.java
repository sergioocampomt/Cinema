package co.usa.ciclo3.ciclo3.controller;

import co.usa.ciclo3.ciclo3.entity.Cinema;
import co.usa.ciclo3.ciclo3.service.CinemaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/Cinema")
public class CinemaController {
    
    @Autowired
    private CinemaService cinemaService;
    
    @GetMapping("/all")
    public List<Cinema> getCinema(){
        return cinemaService.getAll();
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cinema save(@RequestBody Cinema cinema){
        return cinemaService.save(cinema);
    }
}
