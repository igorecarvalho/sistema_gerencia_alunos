import axios from 'axios'

export const ApiService = axios.create({
  baseURL: 'https://gerencia-alunos-be.herokuapp.com/'
})
