package co.usa.ciclo3.ciclo3.controller;

import co.usa.ciclo3.ciclo3.entity.Cinema;
import co.usa.ciclo3.ciclo3.service.CinemaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public List<Cinema> getCinemas(){
        return cinemaService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Cinema> getCinema(@PathVariable("id") int cinemaId) {
        return cinemaService.getCinema(cinemaId);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cinema save(@RequestBody Cinema cinema){
        return cinemaService.save(cinema);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cinema update(@RequestBody Cinema cinema) {
        return cinemaService.update(cinema);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return cinemaService.deleteCinema(id);
    }
    
  
}
