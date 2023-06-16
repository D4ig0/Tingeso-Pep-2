package milkStgo.pagoservice.services;

import lombok.Generated;
import milkStgo.pagoservice.entities.PagoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import milkStgo.pagoservice.models.AcopioModel;
import milkStgo.pagoservice.models.ProveedorModel;
import milkStgo.pagoservice.models.NutricionalModel;

import org.springframework.web.client.RestTemplate;
import milkStgo.pagoservice.repositories.PagoRepository;
import java.time.*;
import java.util.Arrays;
import java.util.List;

@Service
public class PagoService {
    private static final Double categoria_a = 700.0;
    private static final Double categoria_b = 550.0;
    private static final Double categoria_c = 400.0;
    private static final Double categoria_d = 250.0;
    private static final Double bonificacion_MT = 0.2;
    private static final Double bonificacion_M = 0.12;
    private static final Double bonificacion_T = 0.08;

    @Autowired
    RestTemplate restTemplate;



    @Autowired
    PagoRepository pagoRepository;


    //Mediante RestTemplate
    /////////////////////////////////////////////////////////////////////////////////
    public List<ProveedorModel> getProveedores(){
    ProveedorModel[] proveedores =  restTemplate.getForObject("http://proveedor-service/proveedores",ProveedorModel[].class);
    return Arrays.asList(proveedores);
    }
    public Integer cantidadTurnoM (String codigo){
        Integer turnoM= restTemplate.getForObject("http://acopio-service/acopios/cantidadTurnoM/" +codigo, Integer.class);
        return turnoM;

    }
    public Integer cantidadTurnoT (String codigo){
        Integer turnoT= restTemplate.getForObject("http://acopio-service/acopios/cantidadTurnoT/" +codigo, Integer.class);
        return turnoT;
    }

    public Integer totalDiasEnviados(String codigo){
        Integer totalDiasEnviados = restTemplate.getForObject("http://acopio-service/acopios/totalDiasEnviados/"+ codigo,Integer.class);
        return totalDiasEnviados;
    }

    public  Double obtenerGrasa(String codigo){

        Double grasa= restTemplate.getForObject("http://nutricional-service/nutricionales/obtenerGrasa/"+codigo, Double.class);
        return grasa;
    }
    public  Double obtenerSolidos(String codigo){

        Double solidos= restTemplate.getForObject("http://nutricional-service/nutricionales/obtenerSolidos/"+codigo, Double.class);
        return solidos;
    }
    public Double totalLecheProveedor(String codigo){
        Double totalLeche= restTemplate.getForObject("http://acopio-service/acopios/totalLecheProveedor/"+codigo, Double.class);
        return totalLeche;
    }

    /////////////////////////////////////////////////////////////////////////////////


    // Mediante PagoService
    public List<PagoEntity> obtenerPagos(){ return pagoRepository.findAll(); }

    public double pagoporleche(Double total_kls, String categoria){
        switch(categoria){
            case "A" : return categoria_a * total_kls;
            case "B" : return categoria_b * total_kls;
            case "C" : return categoria_c * total_kls;
            case "D" : return categoria_d * total_kls;
            default :
                return 0.0;
        }
    }

    public Double pagoporgrasa (Double total_kls, Double grasa ){
        if (0 <= grasa && grasa<=20)
        {return 30.0 * total_kls ;}
        else if (21 <= grasa && grasa<=45)
        {return 80.0 * total_kls ;}
        else return 120.0 * total_kls;}

    public Double pagoporsolido (Double total_kls, Double solido)
    {
        if (0 <= solido && solido<=7)
        {return  -130 * total_kls;}
        else if (8 <= solido && solido<=18)
        {return -90 * total_kls;}
        else if (19 <= solido && solido<=35)
        {return  95* total_kls;}
        else return  150 * total_kls;}


    public Double bonoFrecuencia(ProveedorModel proveedor,Double pagoLeche){

        Integer turno_m = cantidadTurnoM(proveedor.getCodigo());

        Integer turno_t = cantidadTurnoT(proveedor.getCodigo());

        if (turno_t>10 && turno_m >10){
            return bonificacion_MT * pagoLeche;}
        else if (turno_m>10){
            return bonificacion_M * pagoLeche;}
        else if (turno_t>10) {
            return bonificacion_T * pagoLeche;}
        else  return 0.0 ;}

    public double retencion(Double monto, ProveedorModel proveedor){

        if (monto>950000 && proveedor.getRetencion()=="Si")
        {return monto*0.13;}

        else return 0;
    }

    public Double variacionLeche(ProveedorModel proveedor)
    {
        List<PagoEntity> anterior;
        PagoEntity actual = pagoRepository.obtenerPagoActual(proveedor.getCodigo());

        anterior= pagoRepository.obtenerPagoAnterior(proveedor.getCodigo(),actual.getId_pago());
        if (anterior.isEmpty()){return 0.0;

        } else {
            return (((anterior.get(0).getTotal_kls_leche()- actual.getTotal_kls_leche())/anterior.get(0).getTotal_kls_leche()));
        }}

    public Double variacionNegativaLeche(Double variacion_leche, Double monto)
    {
        if (variacion_leche>= 0  && variacion_leche<=8)
        {return 0.0*monto;}
        else if (variacion_leche>= 9  && variacion_leche<=25)
        {return 0.07*monto;}
        else if (variacion_leche>= 26  && variacion_leche<=45)
        {return 0.15*monto;}
        else if (variacion_leche>= 45 )
        {return 0.3*monto;}

        else return 0.0*monto;
    }


    public Double variacionGrasa(ProveedorModel proveedor){


        List<PagoEntity> anterior;

        PagoEntity actual = pagoRepository.obtenerPagoActual(proveedor.getCodigo());

        anterior= pagoRepository.obtenerPagoAnterior(proveedor.getCodigo(),actual.getId_pago());

        if (anterior.isEmpty()){return 0.0;
        }
        else {
            return (anterior.get(0).getGrasa()- actual.getGrasa())/anterior.get(0).getGrasa();
        }}


    public Double variacionNegativaGrasa(Double variacion_grasa, Double monto)
    {
        if (variacion_grasa>= 0  && variacion_grasa<=15)
        {return 0.0*monto;}
        else if (variacion_grasa>= 16  && variacion_grasa<=25)
        {return 0.12*monto;}
        else if (variacion_grasa>= 26  && variacion_grasa<=40)
        {return 0.2*monto;}
        else if (variacion_grasa>= 41 )
        {return 0.3*monto;}
        else return 0.0*monto;
    }

    public Double variacionST(ProveedorModel proveedor){

        List<PagoEntity> anterior;

        PagoEntity actual = pagoRepository.obtenerPagoActual(proveedor.getCodigo());


        anterior= pagoRepository.obtenerPagoAnterior(proveedor.getCodigo(),actual.getId_pago());
        if (anterior.isEmpty()){return 0.0;

        } else {
            return ((anterior.get(0).getSolidos_totales()- actual.getSolidos_totales())/anterior.get(0).getSolidos_totales());
        }}
    public Double variacionNegativaST(Double variacion_st, Double monto)
    {
        if (variacion_st >= 0  && variacion_st<=6){
            return 0.0*monto;}
        else if (variacion_st >= 7  && variacion_st<=12)
        {return 0.18*monto;}
        else if (variacion_st >= 13  && variacion_st<=35)
        {return 0.27*monto;}
        else if (variacion_st >= 36)
        {return 0.45*monto;}
        else return 0.0*monto;}

    public Integer cantDiasEnviados(ProveedorModel proveedor){
        return totalDiasEnviados(proveedor.getCodigo());
    }

    @Generated
    public boolean pagototal()
    {   List<ProveedorModel> proveedores= getProveedores();
        for  (int i = 0; i<proveedores.size(); i++){
            ProveedorModel proveedor = proveedores.get(i);
            PagoEntity pago = iniciarpago(proveedor);
            pago.setPago_leche(pagoporleche(pago.getTotal_kls_leche(),proveedor.getCategoria()));
            pago.setPago_grasa(pagoporgrasa(pago.getTotal_kls_leche(),pago.getGrasa()));
            pago.setPago_solido(pagoporsolido(pago.getTotal_kls_leche(),pago.getSolidos_totales()));
            pago.setNro_dias_leche(cantDiasEnviados(proveedor));
            pago.setPromedio_diario_leche(pago.getTotal_kls_leche()/pago.getNro_dias_leche());
            pago.setFrecuencia(bonoFrecuencia(proveedor,pago.getPago_leche()));
            Double pago_acopio = pago.getPago_leche() + pago.getPago_grasa() + pago.getPago_solido()+pago.getFrecuencia();
            pago.setVariacion_grasa(variacionGrasa(proveedor));
            pago.setDcto_variacion_grasa(variacionNegativaGrasa(pago.getVariacion_grasa(),pago_acopio));
            pago.setVariacion_leche(variacionLeche(proveedor));
            pago.setDcto_variacion_leche(variacionNegativaLeche(pago.getVariacion_leche(),pago_acopio));
            pago.setVariacion_solidos_totales(variacionST(proveedor));
            pago.setDcto_variacion_solidos_totales(variacionNegativaST(pago.getVariacion_solidos_totales(),pago_acopio));
            Double descuentos = pago.getDcto_variacion_grasa()+pago.getDcto_variacion_leche()+pago.getDcto_variacion_solidos_totales();
            pago.setPago_total(pago_acopio-descuentos);
            pago.setMonto_retencion(retencion(pago.getPago_total(), proveedor));
            pago.setMonto_final(pago.getPago_total() -pago.getMonto_retencion());
            pagoRepository.save(pago);}
        return  true;}


    @Generated
    public  PagoEntity iniciarpago(ProveedorModel proveedor) {

        PagoEntity pago = new PagoEntity();
        pago.setGrasa(obtenerGrasa(proveedor.getCodigo()));
        pago.setSolidos_totales(obtenerSolidos(proveedor.getCodigo()));
        pago.setTotal_kls_leche(totalLecheProveedor(proveedor.getCodigo()));
        pago.setCodigo_proveedor(proveedor.getCodigo());
        pago.setNombre_proveedor(proveedor.getNombre());
        LocalDate fechaActual = LocalDate.now();
        pago.setQuincena(fechaActual) ;
        pagoRepository.save(pago);
        return  pago;
    }
    public void borrarPagos(){
        pagoRepository.deleteAll();

    }

}
