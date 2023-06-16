import axios from 'axios';

const url = 'http://localhost:8080/proveedores';

class ProveedorService{
    subirProveedor(proveedores){
        return axios.post(url+'/fileUpload', proveedores);
    }
    obtenerProveedores(){
        return axios.get(url+'/findAll');
    }
}

const instance = new ProveedorService();
export default instance;