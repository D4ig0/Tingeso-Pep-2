package milkStgo.proveedorservice.controllers;


import milkStgo.proveedorservice.entities.ProveedorEntity;
import milkStgo.proveedorservice.services.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public ResponseEntity<List<ProveedorEntity>> getProveedores() {
        List<ProveedorEntity> proveedores = proveedorService.obtenerProveedores();
        if(proveedores.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(proveedores);
    }

    @PostMapping
    public ResponseEntity<?> nuevoProveedor(@RequestParam("codigo") String codigo,
                                         @RequestParam("nombre") String nombre,
                                         @RequestParam("categoria") String categoria,
                                         @RequestParam("retencion") String retencion){
        proveedorService.guardarProveedor(codigo, nombre, categoria, retencion);
        return ResponseEntity.ok().build();

    }

    @GetMapping("/eliminarProveedores")
    public ResponseEntity<?> eliminar() {
        proveedorService.eliminarProveedores();
       return ResponseEntity.ok().build();
    }
    @GetMapping("/findByNameCustomQuery/{nombre}")
    public ResponseEntity<ProveedorEntity> findByNameCustomQuery(@PathVariable("nombre") String nombre){
        return ResponseEntity.ok(proveedorService.findByNameCustomQuery(nombre));
    }

    @GetMapping("/findCategoriaProveedor/{codigo}")
    public ResponseEntity<String> findCategoriaProveedor(@PathVariable("codigo") String codigo){
        return ResponseEntity.ok(proveedorService.findCategory(codigo));
    }
    @GetMapping("/findByCodigo/{codigo}")
    public ResponseEntity<ProveedorEntity> findByCodigo(@PathVariable("codigo") String codigo){
        return ResponseEntity.ok(proveedorService.findByCodigo(codigo));
    }


    @GetMapping("findById/{numero}")
    public ResponseEntity<ProveedorEntity> findById(@PathVariable("numero") Integer numero){
        return  ResponseEntity.ok(proveedorService.findById(numero));
    }


}