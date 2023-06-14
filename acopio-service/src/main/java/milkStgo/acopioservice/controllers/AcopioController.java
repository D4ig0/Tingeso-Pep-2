package milkStgo.acopioservice.controllers;


import milkStgo.acopioservice.entities.AcopioEntity;
import milkStgo.acopioservice.services.AcopioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/acopio")
public class AcopioController {

    @Autowired
    private AcopioService acopioService;


    @PostMapping("/fileUpload")
    public ResponseEntity upload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        acopioService.guardar(file);
        redirectAttributes.addFlashAttribute("mensaje", "¡Archivo cargado correctamente!");
        acopioService.leerCsv("Acopio.csv");
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<AcopioEntity>> findAll(){
        return  ResponseEntity.ok(acopioService.findAll());
    }
    @GetMapping("/findName")
    public ResponseEntity<String> findName(String proveedor){
        return ResponseEntity.ok(acopioService.findName(proveedor));
    }

    @GetMapping("/obtenerAcopios")
    public  ResponseEntity<List<AcopioEntity>> obtenerAcopios (String proveedor){
        return  ResponseEntity.ok(acopioService.obtenerAcopios(proveedor));
    }

    @GetMapping("/cantidadTurnoM")
    public  ResponseEntity<Integer> cantidadTurnoM(String proveedor){
        return ResponseEntity.ok(acopioService.cantidadTurnoM(proveedor));
    }

    @GetMapping("/cantidadTurnoT")
    public  ResponseEntity<Integer> cantidadTurnoT(String proveedor){
        return ResponseEntity.ok(acopioService.cantidadTurnoT(proveedor));
    }

    @GetMapping("/totalLecheProveedor")
    public  ResponseEntity<Double> totalLecheProveedor(String proveedor){
        return ResponseEntity.ok(acopioService.totalLecheProveedor(proveedor));
    }


    @GetMapping("/totalDiasEnviados")
    public  ResponseEntity<Integer> totalDiasEnviados(String proveedor){
        return ResponseEntity.ok(acopioService.totalDiasEnviados(proveedor));
    }

}

