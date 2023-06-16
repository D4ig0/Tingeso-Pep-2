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



    @GetMapping("/obtenerAcopiosProveedor/{codigoProveedor}")
    public  ResponseEntity<List<AcopioEntity>> obtenerAcopios (@PathVariable("codigoProveedor") String codigoProveedor){
        return  ResponseEntity.ok(acopioService.obtenerAcopios(codigoProveedor));
    }

    @GetMapping("/cantidadTurnoM/{codigoProveedor}")
    public  ResponseEntity<Integer> cantidadTurnoM(@PathVariable("codigoProveedor") String codigoProveedor){
        return ResponseEntity.ok(acopioService.cantidadTurnoM(codigoProveedor));
    }

    @GetMapping("/cantidadTurnoT/{codigoProveedor}")
    public  ResponseEntity<Integer> cantidadTurnoT(@PathVariable ("codigoProveedor") String codigoProveedor){
        return ResponseEntity.ok(acopioService.cantidadTurnoT(codigoProveedor));
    }

    @GetMapping("/totalLecheProveedor/{codigoProveedor}")
    public  ResponseEntity<Double> totalLecheProveedor(@PathVariable("codigoProveedor") String codigoProveedor){
        return ResponseEntity.ok(acopioService.totalLecheProveedor(codigoProveedor));
    }


    @GetMapping("/totalDiasEnviados/{codigoProveedor}")
    public  ResponseEntity<Integer> totalDiasEnviados(@PathVariable("codigoProveedor") String codigoProveedor){
        return ResponseEntity.ok(acopioService.totalDiasEnviados(codigoProveedor));
    }

}

