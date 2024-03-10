package codoacodo.vuelosapi.controller;
import codoacodo.vuelosapi.model.Flight;
import codoacodo.vuelosapi.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vuelos")
public class FligthController {


    @Autowired
    FlightService flightService;

    @GetMapping("")
    public List<Flight> getAllFlight(){
        return flightService.getAllFlight();
    }

    @PostMapping("/agregar")
    public void createfligth(@RequestBody Flight flight){
        flightService.crearVuelo(flight);
    }

    @GetMapping("/{id}")
    public Flight findVuelo(@PathVariable Long id){
        return flightService.buscarVueloXid(id);

    }


    @DeleteMapping("/eliminar/{id}")
    public void deleteFligth(@PathVariable Long id){
        flightService.borrarVueloXid(id);
    }


    @PutMapping("/actualizar")
    public Flight updateFligth(@RequestBody Flight flight){
        flightService.actualizarVuelo(flight);
        return flight;
    }

}
