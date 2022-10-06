package co.usa.ciclo3.ciclo3.repository;

import co.usa.ciclo3.ciclo3.entity.Cinema;
import co.usa.ciclo3.ciclo3.repository.crudRepository.CinemaCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CinemaRepository {
 
    @Autowired
    private CinemaCrudRepository cinemaCrudRepository;
    
    public List<Cinema> getAll(){
        return (List<Cinema>) cinemaCrudRepository.findAll();
    }
    
    public Optional<Cinema> getCinema(int id){
        return cinemaCrudRepository.findById(id);
    }
    
    public Cinema save(Cinema cinema){
        return cinemaCrudRepository.save(cinema);
    }
    
     public void delete(Cinema cinema){
        cinemaCrudRepository.delete(cinema);
    }
    
    
}
