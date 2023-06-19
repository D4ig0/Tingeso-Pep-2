package milkStgo.nutricionalservice.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import milkStgo.nutricionalservice.entities.NutricionalEntity;
import milkStgo.nutricionalservice.services.NutricionalService;

import java.util.ArrayList;


@Controller
@RequestMapping("/nutricionales")
public class NutricionalController {

    @Autowired
    private NutricionalService nutricionalService;

    @CrossOrigin(origins = "http://localhost:3000")

    @PostMapping("/fileUploadNutricional")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
        nutricionalService.guardar(file);
       nutricionalService.leerCsv("Nutricional.csv");
       return ResponseEntity.ok().build();
    }
    @GetMapping("/findAll")
    public  ResponseEntity<ArrayList<NutricionalEntity>> findAll(){
        return ResponseEntity.ok(nutricionalService.findAll());
    }
    @GetMapping("/obtenerProveedor/{codigo}")
    public  ResponseEntity<NutricionalEntity> obtenerProveedor(@PathVariable("codigo") String codigo){
        return ResponseEntity.ok(nutricionalService.obtenerProveedor(codigo));
    }

    @GetMapping("/obtenerGrasa/{codigo}")
    public  ResponseEntity<Double> obtenerGrasa(@PathVariable("codigo") String codigo){
        return ResponseEntity.ok(nutricionalService.obtenerGrasa(codigo));
    }
    @GetMapping("/obtenerSolidos/{codigo}")
    public  ResponseEntity<Double> obtenerSolidos(@PathVariable("codigo") String codigo){
        return ResponseEntity.ok(nutricionalService.obtenerSolidos(codigo));
    }



}