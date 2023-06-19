import axios from 'axios';

const url = 'http://localhost:8080/nutricionales';

class NutricionalesService{
    subirNutricional(nutricional){
        return axios.post(url+'/fileUploadNutricional', nutricional);
    }
    obtenerNutricional(){
        return axios.get(url+'/findAll');
    }
    obtenerProveedor(codigo){
        return axios.get(url+'/obtenerProveedor/'+codigo);
    }
    obtenerGrasa(codigo){
        return axios.get(url+'/obtenerGrasa/'+codigo);
    }
    obtenerSolidos(codigo){
        return axios.get(url+'/obtenerSolidos/'+codigo);
    }


}

const instance = new NutricionalesService();
export default instance;