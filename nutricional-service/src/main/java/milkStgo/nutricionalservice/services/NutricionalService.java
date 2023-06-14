package milkStgo.nutricionalservice.services;

import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import milkStgo.nutricionalservice.entities.NutricionalEntity;
import milkStgo.nutricionalservice.repositories.NutricionalRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class NutricionalService {


    @Autowired
    private NutricionalRepository nutricionalRepository;

    private final Logger logg = LoggerFactory.getLogger(milkStgo.nutricionalservice.services.NutricionalService.class);

    public ArrayList<NutricionalEntity> obtenerData(){
        return (ArrayList<NutricionalEntity>) nutricionalRepository.findAll();
    }

    @Generated
    public String guardar(MultipartFile file){
        String filename = file.getOriginalFilename();
        if(filename != null){
            if(!file.isEmpty()){
                try{
                    byte [] bytes = file.getBytes();
                    Path path  = Paths.get(file.getOriginalFilename());
                    Files.write(path, bytes);
                    logg.info("Archivo guardado");
                }
                catch (IOException e){
                    logg.error("ERROR", e);
                }
            }
            return "Archivo guardado con exito!";
        }
        else{
            return "No se pudo guardar el archivo";
        }
    }

    @Generated
    public void leerCsv(String direccion){
        String texto = "";
        BufferedReader bf = null;
        nutricionalRepository.deleteAll();
        try{
            bf = new BufferedReader(new FileReader(direccion));
            String temp = "";
            String bfRead;
            int count = 1;
            while((bfRead = bf.readLine()) != null){
                if (count == 1){
                    count = 0;
                }
                else{
                    guardarDataDB(bfRead.split(";")[0], bfRead.split(";")[1], bfRead.split(";")[2]);
                    temp = temp + "\n" + bfRead;
                }
            }
            texto = temp;
            System.out.println("Archivo leido exitosamente");
        }catch(Exception e){
            System.err.println("No se encontro el archivo");
        }finally{
            if(bf != null){
                try{
                    bf.close();
                }catch(IOException e){
                    logg.error("ERROR", e);
                }
            }
        }
    }


    public void guardarDataDB(String proveedor,String grasa, String  solido){
        NutricionalEntity newData = new NutricionalEntity();
        newData.setProveedor(proveedor);
        newData.setGrasa(Integer.parseInt(grasa));
        newData.setSolidos_totales(Integer.parseInt(solido));
        guardarData(newData);
    }

    //no la utilizo, debería eliminarla,
    @Deprecated
    public void eliminarData(List<NutricionalEntity> datas){
        nutricionalRepository.deleteAll();
    }

    public void guardarData(NutricionalEntity data){
        nutricionalRepository.save(data);
    }
    public ArrayList<NutricionalEntity> findAll(){
         return nutricionalRepository.findAll();
    }
    public String obtenerProveedor(String proveedor){
        return nutricionalRepository.obtenerProveedor(proveedor);
    }
    public Double obtenerGrasa(String proveedor){
        return  nutricionalRepository.obtenerGrasa(proveedor);
    }
    public Double obtenerSolidos(String proveedor){
        return  nutricionalRepository.obtenerSolidos(proveedor);

    }





}
