<template>

   <v-container>

        <v-data-table
            id="tabela"
            :headers="headers"
            :items="alunos"
            sort-by="nome"
            >

            <template v-slot:top>

                <v-toolbar
                    flat
                    >

                    <v-toolbar-title>
                        
                        <h2><strong> Alunos </strong></h2>

                    </v-toolbar-title>

                    <v-spacer></v-spacer>

                    <v-btn
                        class="mx-2"
                        fab
                        dark
                        router :to="cadastrar"
                        color="green"
                        >

                        <v-icon dark>
                            mdi-account-plus
                        </v-icon>
                        
                    </v-btn>

                </v-toolbar>

            </template>

            <template v-slot:item.acoes="{ item }">

                <v-dialog  v-model="dialog_visualizar[item.id]"
                            :retain-focus="false"
                            max-width="400">

                    <template v-slot:activator="{ on, attrs }">

                        <v-btn
                            class="mr-2"
                            icon
                            color="green"
                            v-bind="attrs"
                            v-on="on">
                            <v-icon size="25px"> 
                                mdi-eye 
                            </v-icon>
                        </v-btn>

                    </template>
                    
                    <v-card
                        fluid
                        justify="space-around"
                        class="mx-auto"
                        max-width="600"
                        min-height="434"
                        tile>

                        <v-col cols="12">

                            <v-row justify="space-around" style="padding: 15px">

                                <v-avatar
                                    size="250px">
                                    <img
                                        :src="item.nomeFoto"
                                    >
                                </v-avatar>

                            </v-row>

                            <v-row justify="space-around">

                                <v-card-title>

                                    <h2><strong>{{item.nome}}</strong></h2>

                                </v-card-title>

                            </v-row>

                            <v-col cols="12">

                                <v-row justify="space-around">
                                    
                                    <v-icon>mdi-cake</v-icon> 
                                    <v-spacer></v-spacer>
                                    {{item.dataNascimento}}

                                </v-row>

                            </v-col>

                            <v-divider></v-divider>

                            <v-col cols="12">
                        
                                <v-row style="padding: 5px">
                                    <v-icon>mdi-home-city</v-icon>

                                    <v-spacer></v-spacer>

                                    <v-col cols="12">
                                        Logradouro: {{item.endereco.logradouro}}
                                    </v-col>

                                    <v-col cols="12">
                                        Bairro: {{item.endereco.bairro}}
                                    </v-col>

                                    <v-col cols="12">
                                        {{ item.endereco.localidade + ' - ' + item.endereco.uf }}
                                    </v-col>
                                </v-row>

                            </v-col>

                            <v-divider></v-divider>

                        </v-col>

                    </v-card>

                </v-dialog>

                <v-btn
                    class="mr-2"
                    router :to="editar + item.id" 
                    icon>
                    <v-icon color="blue" size="25px"> mdi-pencil </v-icon>
                </v-btn>

                <v-dialog  v-model="dialog_cancelar[item.id]"
                            persistent 
                            :retain-focus="false"
                            max-width="300">

                    <template v-slot:activator="{ on, attrs }">

                        <v-btn
                            class="mr-2"
                            icon
                            color="red"
                            v-bind="attrs"
                            v-on="on">
                            <v-icon size="25px"> 
                                mdi-delete 
                            </v-icon>
                        </v-btn>

                    </template>
                    
                    <v-card>
                        
                        <v-card-title class="headline">
                            <strong><h2>Atenção!</h2></strong>
                        </v-card-title>
                        
                        <v-card-text>
                                Deseja realmente deletar o aluno: 
                                <p><strong> {{item.nome}} </strong>?</p>
                        </v-card-text>

                        <v-card-actions>

                            <v-spacer></v-spacer>

                            <v-btn  color="red darken-1" 
                                    text @click="cancelarDialogo(item.id)">
                                Não
                            </v-btn>

                            <v-btn  color="green darken-1 white--text" 
                                    @click="deletar(item.id)">
                                Sim
                            </v-btn>

                        </v-card-actions>

                    </v-card>

                </v-dialog>

            </template>

        </v-data-table>

   </v-container>

</template>


<script>

    import AlunosServices from "../../services/alunosService";

    export default {

        data: () => ({

            dialog_cancelar: [],

            dialog_visualizar: [],

            cadastrar: 'cadastrar-aluno',

            editar: '/aluno/editar/',

            headers: [
                { text: 'Nome', value: 'nome', class: "black--text  font-weight-bold" },
                { text: 'Data de nascimento', value: 'dataNascimento', class: "black--text  font-weight-bold" },
                { 
                    text: 'Ações', 
                    value: 'acoes', 
                    sortable: false, 
                    align: 'center' ,
                    class: "black--text  font-weight-bold"
                },
            ],

            alunos: [],

        }),

        mounted(){

            this.listar()

        },

        methods: {


            listar(){
                AlunosServices.listar()
                            .then( resposta => {
                                console.log(resposta.data)
                                this.alunos = resposta.data
                            })
                            .catch(error => {
                                console.log(error)
                                this.$toast.error('Erro ao carregar alunos!')
                            })
            },

            deletar(aluno) {

                console.log(aluno)

                AlunosServices.deletar(aluno)
                        .then( () => {
                            this.$toast.success('Aluno deletado com sucesso!')
                            this.listar()
                        })
                        .catch(error => {
                            console.log(error)
                            this.$toast.error('Erro ao deletar Aluno!')
                        })

            },

            cancelarDialogo(){
                this.dialog_cancelar = []
                this.dialog_visualizar = []
            },

        },

    }

</script>

<style>

    #tabela {
        text-align: center;
        padding: 10px;
    }

</style>
