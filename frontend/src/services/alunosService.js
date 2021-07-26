import {ApiService} from './api.service'


const alunosService =  {

    listar: async() => {
        return ApiService.get('alunos/listarAlunos');
    },

    getAluno: async(id) => {
        return ApiService.get(`alunos/${id}/listar`);
    },

    cadastrar: async(aluno) => {
        return ApiService.post(`alunos/cadastrar`, aluno);
    },

    editar: async(aluno, id) => {
        return ApiService.put(`alunos/${id}/editar`, aluno);
    },

    deletar: async(id) => {
        return ApiService.delete(`alunos/${id}/deletar`);
    },

}

export default alunosService;