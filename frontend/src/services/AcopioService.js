import axios from 'axios';

const url = 'http://localhost:8080/acopios';

class AcopioService{
    subirAcopio(acopio){
        return axios.post(url+'/fileUpload', acopio);
    }
    obtenerAcopios(){
        return axios.get(url+'/findAll');
    }
}

const instance = new AcopioService();
export default instance;