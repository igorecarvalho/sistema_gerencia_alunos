import {ApiService} from './api.service'


const uploadService =  {

    uploadFoto: async(file) => {
        
        console.log("FILE", file)

        const formData = new FormData();

        formData.append('file',file)

        const config = {
            headers: {
                'content-type': 'multipart/form-data'
            }
        }

        return ApiService.post(`alunos/uploadFile`, formData, config);
    },

}

export default uploadService;