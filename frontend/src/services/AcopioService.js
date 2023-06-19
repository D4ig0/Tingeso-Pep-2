import axios from 'axios';

const url = 'http://localhost:8080/acopios';

class AcopioService{
    subirAcopio(acopio){
        return axios.post(url+'/fileUpload', acopio);
    }
    obtenerAcopios(){
        return axios.get(url+'/findAll');
    }
    obtenerTurnosM(codigo){
        return axios.get(url+'/obtenerTurnosM/'+codigo);
    }
    obtenerTurnosT(codigo){
        return axios.get(url+'/obtenerTurnosT/'+codigo);
    }
    totalLecheProveedor(codigo){
        return axios.get(url+'/totalLecheProveedor/'+codigo);
    }
    totalDiasEnviados(codigo){
        return axios.get(url+'/totalDiasEnviados/'+codigo);
    }
}

const instance = new AcopioService();
export default instance;