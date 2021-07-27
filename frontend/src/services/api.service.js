import axios from 'axios'

export const ApiService = axios.create({
  baseURL: 'http://localhost:7979/'
  // baseURL: 'https://gerencia-alunos-be.herokuapp.com/'

})
