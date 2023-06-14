package milkStgo.nutricionalservice.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;
import milkStgo.nutricionalservice.entities.NutricionalEntity;
import milkStgo.nutricionalservice.services.NutricionalService;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/nutricional")
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
    @GetMapping("/obtenerProveedor")
    public  ResponseEntity<String> obtenerProveedor(String proveedor){
        return ResponseEntity.ok(nutricionalService.obtenerProveedor(proveedor));
    }

    @GetMapping("/obtenerGrasa")
    public  ResponseEntity<Double> obtenerGrasa(String proveedor){
        return ResponseEntity.ok(nutricionalService.obtenerGrasa(proveedor));
    }

    @GetMapping("/obtenerSolidos")
    public  ResponseEntity<Double> obtenerSolidos(String proveedor){
        return ResponseEntity.ok(nutricionalService.obtenerSolidos(proveedor));
    }



}