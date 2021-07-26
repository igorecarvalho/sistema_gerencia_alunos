import { ViacepService } from './viacep.service'


const CepService =  {

    getEndereco: async(cep) => {
        return ViacepService.get(`${cep}/json/`);
    },

}

export default CepService;