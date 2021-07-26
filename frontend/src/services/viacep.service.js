import axios from 'axios'

export const ViacepService = axios.create({
  baseURL: 'http://viacep.com.br/ws/'
})
