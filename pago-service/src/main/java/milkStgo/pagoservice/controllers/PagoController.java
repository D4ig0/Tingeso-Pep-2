package milkStgo.pagoservice.controllers;


import milkStgo.pagoservice.repositories.PagoRepository;
import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import milkStgo.pagoservice.entities.PagoEntity;
import milkStgo.pagoservice.services.PagoService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pagos")
public class  PagoController {

    @Autowired
    private PagoService pagoService;
    private PagoRepository pagoRepository;


    @GetMapping("/realizarCalculos")
    public ResponseEntity<Boolean> realizarCalculos()
    {   Boolean ejecucion = pagoService.pagototal();
        return ResponseEntity.ok(ejecucion) ;
    }

    @GetMapping("/obtenerPagos")
    public ResponseEntity<List<PagoEntity>> ObtenerPagos() {
        List<PagoEntity> pagos = pagoService.obtenerPagos();
        return  ResponseEntity.ok(pagos);
    }

    @GetMapping("/eliminarPagos")
    public void eliminarPagos(){
         pagoService.borrarPagos();
    }


}
