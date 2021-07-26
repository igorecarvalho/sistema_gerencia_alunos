<template>

    <v-container>

        <form>

            <v-toolbar flat>

                <v-toolbar-title>
                    <h2>
                        <strong>
                            Cadastro de aluno
                        </strong>
                    </h2>
                </v-toolbar-title>
                
            </v-toolbar>

            <v-card flat>
                
                <v-col cols="12" style="padding: 20px">

                    <v-row style="margin: 10px">
                        <v-toolbar-title>

                                <strong>
                                    Informações pessoais
                                </strong>

                        </v-toolbar-title>
                    </v-row>

                    <v-row>

                        <v-col
                            cols="12"
                            sm="6"
                            md="6"
                            >

                            <v-text-field
                                v-model="aluno.nome"
                                label="Nome"
                            ></v-text-field>

                        </v-col>

                        <v-col
                            cols="12"
                            sm="6"
                            md="6"
                            >

                            <v-text-field
                                type="date"
                                prepend-inner-icon="mdi-calendar"
                                v-model="aluno.dataNascimento"
                                label="Data Nascimento"
                            ></v-text-field>

                        </v-col>

                    </v-row>

                    <v-row style="margin: 10px">
                        <v-toolbar-title>

                                <strong>
                                    Foto
                                </strong>

                        </v-toolbar-title>
                    </v-row>

                    <v-row>

                        <v-col
                            cols="12"
                            sm="6"
                            md="6"
                            >

                            <v-file-input
                            type="file"
                                v-model="aluno.nomeFoto"
                                show-size
                                accept="image/png, image/jpeg, image/bmp"
                                placeholder="Escolha uma foto"
                                prepend-icon="mdi-camera"
                            >
                            </v-file-input>

                        </v-col>

                    </v-row>

                    <v-row style="margin: 10px">
                        <v-toolbar-title>

                                <strong>
                                    Endereço
                                </strong>

                        </v-toolbar-title>
                    </v-row>

                    <v-row>

                        <v-col
                            cols="12"
                            sm="6"
                            md="6"
                            >

                            <v-text-field
                                v-model.lazy="aluno.endereco.cep"
                                v-on:keyup="attEndereco"
                                mask='"#####-###"'
                                label="CEP"
                            ></v-text-field>

                        </v-col>

                    </v-row>

                    <v-row>

                        <v-col
                            cols="12"
                            sm="6"
                            md="6"
                            >

                            <v-text-field
                                v-model="aluno.endereco.logradouro"
                                :value="aluno.endereco.logradouro"
                                label="Logradouro"
                            ></v-text-field>

                        </v-col>

                        <v-col
                            cols="12"
                            sm="6"
                            md="6"
                            >

                            <v-text-field
                                v-model="aluno.endereco.bairro"
                                :value="aluno.endereco.bairro"
                                label="Bairro"
                            ></v-text-field>

                        </v-col>

                    </v-row>

                    <v-row>

                        <v-col
                            cols="12"
                            sm="6"
                            md="6"
                            >

                            <v-text-field
                                v-model="aluno.endereco.localidade"
                                :value="aluno.endereco.localidade"
                                label="Cidade"
                            ></v-text-field>

                        </v-col>

                        <v-col
                            cols="12"
                            sm="6"
                            md="6"
                            >

                            <v-text-field
                                v-model="aluno.endereco.uf"
                                :value="aluno.endereco.uf"
                                label="UF"
                            ></v-text-field>

                        </v-col>

                    </v-row>



                </v-col>

                <v-col cols="12">

                    <v-row>

                        <v-spacer></v-spacer>

                        <v-btn
                            class="mr-4"
                            color="red darken-1 white--text"
                            router :to="voltar"
                            >
                            Cancelar
                        </v-btn>

                        <v-btn
                            class="mr-4"
                            color="green white--text"
                            @click="submit"
                            >
                            Salvar
                        </v-btn>
                    
                    </v-row>
                    
                </v-col>

            </v-card>

        </form>

    </v-container>
        
</template>

<script>

    import AlunosServices from "../../services/alunosService";
    import UploadServices from "../../services/uploadService";
    import CepServices from "../../services/cepService";

    export default {

        data: () => ({

            voltar: '/listar-alunos',

            id: '',

            aluno: {

                nome: null,

                dataNascimento: null,

                nomeFoto: null,

                endereco: {

                    cep: null,

                    logradouro: null,

                    bairro: null,

                    localidade: null,
                    
                    uf: null

                }

            },

        }),

        mounted(){

            this.id = this.$route.params.id

            AlunosServices.getAluno(this.id)
                        .then( resposta => {
                            this.aluno = resposta.data
                            console.log(this.contato)
                        }).catch(error => {
                            console.log(error.response.data.message)
                            this.$toast.error('Erro ao editar aluno!')
                            this.$toast.error("Erro: " + error.response.data.message)
                        })
        },

        methods: {

            submit () {

                console.log("ANTES", this.aluno)

                UploadServices.uploadFoto(this.aluno.nomeFoto)
                    .then(resposta => {
                        console.log(resposta.data)
                        this.aluno.nomeFoto = resposta.data

                        AlunosServices.editar(this.aluno)
                            .then(resposta => {
                                console.log(resposta.data)
                                this.$toast.success('Aluno editado com sucesso!')
                                window.location.href = this.voltar
                            })
                            .catch(error => {
                                this.$toast.error("Erro: " + error.response.data.message)
                            })
                    })
                    .catch(error => {
                        console.log("ERROR", error.response.data.message)
                    })


            },

            attEndereco(){

                CepServices.getEndereco(this.aluno.endereco.cep)
                    .then(resposta => {
                        this.aluno.endereco.logradouro = resposta.data.logradouro
                        this.aluno.endereco.bairro = resposta.data.bairro
                        this.aluno.endereco.localidade = resposta.data.localidade
                        this.aluno.endereco.uf = resposta.data.uf
                    })
                    .catch(() => {
                    })

            }


        },
    }

</script>