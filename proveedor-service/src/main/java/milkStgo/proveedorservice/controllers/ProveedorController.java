package milkStgo.proveedorservice.controllers;


import milkStgo.proveedorservice.entities.ProveedorEntity;
import milkStgo.proveedorservice.services.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;


@Controller
@RequestMapping
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping("/getProveedores")
    public ResponseEntity<List<ProveedorEntity>> getProveedores() {
        List<ProveedorEntity> proveedores = proveedorService.obtenerProveedores();
        return ResponseEntity.ok(proveedores);
    }

    @PostMapping("/nuevoProveedor")
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
    @GetMapping("/findByNameCustomQuery")
    public ResponseEntity<ProveedorEntity> findByNameCustomQuery(String nombre){
        return ResponseEntity.ok(proveedorService.findByNameCustomQuery(nombre));
    }

    @GetMapping("/findCategory")
    public ResponseEntity<String> findCategory(String codigo){
        return ResponseEntity.ok(proveedorService.findCategory(codigo));
    }
    @GetMapping("/findByCodigo")
    public ResponseEntity<ProveedorEntity> findByCodigo(String codigo){
        return ResponseEntity.ok(proveedorService.findByCodigo(codigo));
    }
    @GetMapping("findById")
    public ResponseEntity<String> findById(int numero){
        return  ResponseEntity.ok(proveedorService.findById(numero));
    }


}