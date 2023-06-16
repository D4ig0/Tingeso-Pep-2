import axios from 'axios';

const url = 'http://localhost:8080/nutricionales';

class NutricionalService{
    subirNutricional(nutricional){
        return axios.post(url+'/fileUpload', nutricional);
    }
    obtenerNutricional(){
        return axios.get(url+'/findAll');
    }
}

const instance = new NutricionalService();
export default instance;