package milkStgo.acopioservice.services;


import lombok.Generated;
import milkStgo.acopioservice.entities.AcopioEntity;
import milkStgo.acopioservice.repositories.AcopioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class AcopioService {

    @Autowired
    private AcopioRepository acopioRepository;

    private final Logger logg = LoggerFactory.getLogger(AcopioService.class);

    public ArrayList<AcopioEntity> obtenerData(){
        return (ArrayList<AcopioEntity>) acopioRepository.findAll();
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
        acopioRepository.deleteAll();
        try{
            bf = new BufferedReader(new FileReader(direccion));
            String temp = "";
            String bfRead;
            int count = 1;
            while((bfRead = bf.readLine()) != null){

                if (count == 1){
                    count = 0;}

                else{
                    guardarDataDB(bfRead.split(";")[0], bfRead.split(";")[1], bfRead.split(";")[2], bfRead.split(";")[3]);
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



    public void guardarData(AcopioEntity data){
        acopioRepository.save(data);
    }
    public void guardarDataDB(String fecha, String turno, String codigoProveedor, String kls_leche){
        AcopioEntity newData = new AcopioEntity();
        newData.setFecha(fecha);
        newData.setTurno(turno);
        newData.setCodigoProveedor(codigoProveedor);
        newData.setKls_leche(kls_leche);
        guardarData(newData);
    }

    public List<AcopioEntity> findAll(){

        return acopioRepository.findAll();
    }

    public  String findName(String codigoProveedor){
        return acopioRepository.findName(codigoProveedor);

    }

    public List<AcopioEntity> obtenerAcopios(String codigoProveedor){
        return acopioRepository.obtenerAcopios(codigoProveedor);

    }

    public Integer cantidadTurnoM(String codigoProveedor){
        return acopioRepository.cantidadTurnoM(codigoProveedor);

    }
    public Integer cantidadTurnoT(String codigoProveedor){
        return acopioRepository.cantidadTurnoT(codigoProveedor);

    }
    public Double totalLecheProveedor(String codigoProveedor){
        return  acopioRepository.totalLecheProveedor(codigoProveedor);
    }
    public Integer totalDiasEnviados(String codigoProveedor){
        return acopioRepository.totalDiasEnviados(codigoProveedor);

    }




}