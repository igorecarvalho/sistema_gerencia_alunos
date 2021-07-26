import Vue from 'vue'
import VueRouter from 'vue-router'
import ListarAlunos from '../views/Contatos/Listar.vue'
import CasdastrarAlunos from '../views/Contatos/Cadastrar.vue'
import EditarAluno from '../views/Contatos/Editar.vue'
import Home from '../views/Home.vue'

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: 'Bem Vindo',
        component: Home
    },
    {
        path: '/cadastrar-aluno',
        name: 'Cadastro de Contato',
        component: CasdastrarAlunos
    },
    {
        path: '/listar-alunos',
        name: 'Listagem de alunos',
        component: ListarAlunos
    },
    {
        path: '/aluno/editar/:id',
        name: 'Editar Aluno',
        component: EditarAluno
    },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
