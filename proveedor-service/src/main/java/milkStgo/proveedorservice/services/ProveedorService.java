package milkStgo.proveedorservice.services;


import milkStgo.proveedorservice.entities.ProveedorEntity;
import milkStgo.proveedorservice.repositories.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorService {

    @Autowired
    private    ProveedorRepository proveedorRepository;

    public void guardarProveedor(String codigo, String nombre, String categoria, String retencion){
        ProveedorEntity proveedor = new ProveedorEntity();
        proveedor.setCodigo(codigo);
        proveedor.setNombre(nombre);
        proveedor.setCategoria(categoria);
        proveedor.setRetencion(retencion);
        proveedorRepository.save(proveedor);
    }

    public List<ProveedorEntity> obtenerProveedores(){
        return ( proveedorRepository.findAll());
    }
    public void eliminarProveedores(){
        proveedorRepository.deleteAll();
    }

    public ProveedorEntity findByNameCustomQuery(String nombre){
        return proveedorRepository.findByNameCustomQuery(nombre);
    }

    public  String findCategory(String codigo){
        return proveedorRepository.findCategory(codigo);
    }
    public  ProveedorEntity findByCodigo(String codigo){
        return proveedorRepository.findByCodigo(codigo);

    }
    public  String findById(int numero){
        return  proveedorRepository.findById(numero);

    }


}
