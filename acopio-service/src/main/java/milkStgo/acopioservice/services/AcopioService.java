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
import java.util.List;

@Service

public class AcopioService {
    @Autowired
    private AcopioRepository acopioRepository;

    private final Logger logg = LoggerFactory.getLogger(AcopioService.class);

    @Generated
    public String guardar(MultipartFile file){
        String name = file.getOriginalFilename();
        if(name != null){
            if(!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    Path path = Paths.get(file.getOriginalFilename());
                    Files.write(path, bytes);
                    logg.info("Archivo guardado");
                }
                catch(IOException e){
                    logg.error("ERROR", e);
                }
            }
            return "Archivo guardado con exito";
        }
        else{
            return "No se ha guardado el archivo";
        }
    }


    @Generated
    public AcopioEntity leerCsv(String archivo){
        BufferedReader bf = null;
        AcopioEntity acopio = new AcopioEntity();
        acopioRepository.deleteAll();
        try{
            bf = new BufferedReader(new FileReader(archivo));
            String temp = "";
            String bfRead;
            int count = 1;
            while((bfRead = bf.readLine()) != null){
                if(count == 1){
                    count = 0;
                }else{
                    String a, b ,c, d;
                    a = bfRead.split(";")[0];
                    b = bfRead.split(";")[1];
                    c =bfRead.split(";")[2];
                    d = bfRead.split(";")[3];
                    System.out.println(a);
                    System.out.println(b);
                    System.out.println(c);
                    System.out.println(d);

                    acopio = guardarDatos(a,b,c,d);
                    temp = temp + "\n" + bfRead;
                }
            }
            logg.info("Se ha cargado correctamente el archivo");
            return acopio;
        }catch(Exception e){
            logg.error("No se ha cargado el archivo");
            return acopio;
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

    public AcopioEntity guardarDatos(String fecha, String turno, String proveedor, String kls_leche){
        AcopioEntity data = new AcopioEntity();
        data.setCodigoProveedor(proveedor);
        data.setFecha(fecha);
        data.setKls_leche(kls_leche);
        data.setTurno(turno);
        acopioRepository.save(data);
        return data;
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