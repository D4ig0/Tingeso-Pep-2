import axios from 'axios';

const url = 'http://localhost:8080/pagos';

class PagosService{
    subirNutricional(pagos){
        return axios.post(url+'/fileUpload', pagos);
    }
    obtenerNutricional(){
        return axios.get(url+'/findAll');
    }
}

const instance = new PagosService();
export default instance;