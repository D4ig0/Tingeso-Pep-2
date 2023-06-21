import axios from 'axios';

const url = 'http://localhost:8080/pagos';

class PagosService{

    obtenerPagos(){
        return axios.get(url+'/obtenerPagos');
    }
    realizarCalculos(){
        return axios.get(url+'/realizarCalculos');
    }
    eliminarPagos(){
        return axios.get(url+'/eliminarPagos');
    }
}

const instance = new PagosService();
export default instance;