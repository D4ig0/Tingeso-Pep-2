package milkStgo.nutricionalservice.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import milkStgo.nutricionalservice.entities.NutricionalEntity;
import milkStgo.nutricionalservice.services.NutricionalService;

import java.util.ArrayList;


@Controller
@RequestMapping("/nutricionales")
public class NutricionalController {

    @Autowired
    private NutricionalService nutricionalService;


    @PostMapping("/fileUploadNutricional")
    public ResponseEntity upload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        nutricionalService.guardar(file);
        redirectAttributes.addFlashAttribute("mensaje", "¡Archivo cargado correctamente!");
        nutricionalService.leerCsv("Nutricional.csv");
        return ResponseEntity.ok().build();
    }
    @GetMapping("/findAll")
    public  ResponseEntity<ArrayList<NutricionalEntity>> findAll(){
        return ResponseEntity.ok(nutricionalService.findAll());
    }
    @GetMapping("/obtenerProveedor/{codigoProveedor}")
    public  ResponseEntity<String> obtenerProveedor(@PathVariable("codigoProveedor") String codigoProveedor){
        return ResponseEntity.ok(nutricionalService.obtenerProveedor(codigoProveedor));
    }

    @GetMapping("/obtenerGrasa/{codigoProveedor}")
    public  ResponseEntity<Double> obtenerGrasa(@PathVariable("codigoProveedor") String codigoProveedor){
        return ResponseEntity.ok(nutricionalService.obtenerGrasa(codigoProveedor));
    }

    @GetMapping("/obtenerSolidos/{codigoProveedor}")
    public  ResponseEntity<Double> obtenerSolidos(String codigoProveedor){
        return ResponseEntity.ok(nutricionalService.obtenerSolidos(codigoProveedor));
    }



}