import axios from 'axios';

const url = 'http://localhost:8080/proveedores';

class ProveedoresService {
    obtenerProveedores() {

      return axios.get(url);
    }
  
    crearProveedor(nombre, codigo, categoria, retencion){
      return axios.post(`${url}?nombre=${nombre}&codigo=${codigo}&categoria=${categoria}&retencion=${retencion}`);
    }
    eliminarProveedores() {
        return axios.get(url+'/eliminarProveedores');
      }
    encontrarCategoriaProveedor(codigo){
        return axios.get(url +'/findCategoriaProvedor/'+ codigo);
    }
    encontrarPorCodigo(codigo){
        return axios.get(url +'/findByCodigo/'+ codigo);
    }
    encontrarPorId(id){
        return axios.get(url +'/findById/'+ id);
    }
}

const instance = new ProveedoresService();
export default instance;