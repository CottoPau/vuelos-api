package codoacodo.vuelosapi.services;
import codoacodo.vuelosapi.model.Flight;
import codoacodo.vuelosapi.repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    private VueloRepository vueloRepository;

    public List<Flight> getAllFlight(){
        return vueloRepository.findAll();
    }

    public void crearVuelo(Flight flight){
        vueloRepository.save(flight);

    }


    public Flight buscarVueloXid(Long id) {
        return vueloRepository.findById(id).orElse(new Flight());
    }

    public void borrarVueloXid(Long id) {
        vueloRepository.deleteById(id);

    }

    public Flight actualizarVuelo(Flight flight) {
        vueloRepository.save(flight);
        return vueloRepository.findById(flight.getId()).orElse(null);
    }
}
