package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.entity.Cinema;
import co.usa.ciclo3.ciclo3.repository.CinemaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CinemaService {
    
    @Autowired
    private CinemaRepository cinemaRepository;
    
    public List<Cinema> getAll(){
        return cinemaRepository.getAll();
    }
    
    public Optional<Cinema> getCinema(int cinemaId){
        return cinemaRepository.getCinema(cinemaId);
    }
    
    public Cinema save(Cinema cinema){
        if(cinema.getId()==null){
            return cinemaRepository.save(cinema);
        }else{
            Optional<Cinema> e =cinemaRepository.getCinema(cinema.getId());
            if(e.isPresent()){
                return cinema;
            }else{
                return cinemaRepository.save(cinema);
            }
        }
    }
    
    public Cinema update(Cinema cinema){
        if(cinema.getId()!=null){
            Optional<Cinema> e =cinemaRepository.getCinema(cinema.getId());
            if(e.isPresent()){
                 if(cinema.getName()!=null){
                    e.get().setName(cinema.getName());
                }
                if(cinema.getOwner()!=null){
                    e.get().setOwner(cinema.getOwner());
                }
                if(cinema.getCapacity()!=null){
                    e.get().setCapacity(cinema.getCapacity());
                }
                if(cinema.getDescription()!=null){
                    e.get().setDescription(cinema.getDescription());
                }
                if(cinema.getCategory()!=null){
                    e.get().setCategory(cinema.getCategory());
                }
                cinemaRepository.save(e.get());
                return e.get();
            }else{
                return cinema;
            }
        }else{
            return cinema;
        }
    }
    
      public boolean deleteCinema (int id){
        Boolean d = getCinema(id).map(cinema -> {
            cinemaRepository.delete(cinema);
            return true;
        }).orElse(false);
        return d;
    }
    
}
    
