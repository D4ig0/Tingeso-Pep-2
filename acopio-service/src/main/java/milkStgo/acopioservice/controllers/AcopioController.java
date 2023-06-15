package milkStgo.acopioservice.controllers;


import milkStgo.acopioservice.entities.AcopioEntity;
import milkStgo.acopioservice.services.AcopioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@RequestMapping("/acopios")
@RestController
public class AcopioController {

    @Autowired
    private AcopioService acopioService;



    @PostMapping("/fileUpload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        acopioService.guardar(file);
        redirectAttributes.addFlashAttribute("mensaje", "¡Archivo cargado correctamente!");
        acopioService.leerCsv("Acopio.csv");
        return ResponseEntity.ok().build();
    }


    @GetMapping("/findAll")
    public ResponseEntity<List<AcopioEntity>> findAll(){
        return  ResponseEntity.ok(acopioService.findAll());
    }
    @GetMapping("/findName/{codigoProveedor}")
    public ResponseEntity<String> findName(@PathVariable("codigoProveedor") String codigoProveedor){
        return ResponseEntity.ok(acopioService.findName(codigoProveedor));
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

