package milkStgo.pagoservice.controllers;


import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import milkStgo.pagoservice.entities.PagoEntity;
import milkStgo.pagoservice.services.PagoService;

import java.util.List;

@Controller
@RequestMapping("/pagos")
public class  PagoController {

    @Autowired
    private PagoService pagoService;


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


}
