
package co.usa.ciclo3.ciclo3.repository.crudRepository;

import co.usa.ciclo3.ciclo3.entity.Reservation;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer>{

    public List <Reservation> findAllByStatus(String status);
    
    public List<Reservation> findAllByStartDateAfterAndStartDateBefore (Date datoUno, Date datoDos); 
    
    @Query("SELECT c.client, COUNT(c.client) from Reservation AS c group by c.client order by COUNT(c.client) DESC")
    public List<Object[]> countTotalReservationByClient();
    
}
