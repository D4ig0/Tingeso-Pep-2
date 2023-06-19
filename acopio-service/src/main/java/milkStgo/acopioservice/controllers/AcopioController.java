package milkStgo.acopioservice.controllers;


import milkStgo.acopioservice.entities.AcopioEntity;
import milkStgo.acopioservice.services.AcopioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/acopios")
public class AcopioController {

    @Autowired
    private AcopioService acopioService;



    @PostMapping("/fileUpload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile archivo){
        acopioService.guardar(archivo);
        return ResponseEntity.ok(acopioService.leerCsv("Acopio.csv"));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<AcopioEntity>> findAll(){
        return  ResponseEntity.ok(acopioService.findAll());
    }



    @GetMapping("/obtenerAcopiosProveedor/{codigo}")
    public  ResponseEntity<List<AcopioEntity>> obtenerAcopios (@PathVariable("codigo") String codigo){
        return  ResponseEntity.ok(acopioService.obtenerAcopios(codigo));
    }

    @GetMapping("/cantidadTurnoM/{codigo}")
    public  ResponseEntity<Integer> cantidadTurnoM(@PathVariable("codigo") String codigo){
        return ResponseEntity.ok(acopioService.cantidadTurnoM(codigo));
    }

    @GetMapping("/cantidadTurnoT/{codigo}")
    public  ResponseEntity<Integer> cantidadTurnoT(@PathVariable ("codigo") String codigo){
        return ResponseEntity.ok(acopioService.cantidadTurnoT(codigo));
    }

    @GetMapping("/totalLecheProveedor/{codigo}")
    public  ResponseEntity<Double> totalLecheProveedor(@PathVariable("codigo") String codigo){
        return ResponseEntity.ok(acopioService.totalLecheProveedor(codigo));
    }


    @GetMapping("/totalDiasEnviados/{codigo}")
    public  ResponseEntity<Integer> totalDiasEnviados(@PathVariable("codigo") String codigo){
        return ResponseEntity.ok(acopioService.totalDiasEnviados(codigo));
    }

}

