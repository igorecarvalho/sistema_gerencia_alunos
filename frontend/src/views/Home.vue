<template>

    <v-container>

        <v-toolbar flat>

            <v-toolbar-title>
                <h2>
                    <strong>
                        Bem vindo! 
                    </strong>
                </h2>
            </v-toolbar-title>
            
        </v-toolbar>
        
        <v-row dense cols="10">

            <v-col cols="6">

                <v-card
                    style="padding: 10px; margin: 10px"
                    color="teal"
                    dark
                    >

                    <v-card-title class="headline">
                        Cadastrar Aluno
                    </v-card-title>

                    <v-card-actions>

                        <v-spacer></v-spacer>

                        <v-btn icon
                                router :to="cadastrar">

                            <v-icon color="white"
                                    large
                                    dark>
                                mdi-account-plus
                            </v-icon>

                        </v-btn>

                    </v-card-actions>

                </v-card>

            </v-col>

            <v-col cols="6">

                <v-card
                    style="padding: 10px; margin: 10px"
                    color="purple"
                    dark
                    >

                    <v-card-title class="headline">
                        Listar Alunos
                    </v-card-title>

                    <v-card-actions>

                        <v-spacer></v-spacer>

                        <v-btn icon
                                router :to="listarTodos">

                            <v-icon color="white"
                                    large
                                    dark>
                                mdi-account-details
                            </v-icon>

                        </v-btn>

                    </v-card-actions>

                </v-card>

            </v-col>

        </v-row>

    </v-container>

</template>


<script>

    export default {

        data: () => ({

            cadastrar: 'cadastrar-aluno',

            listarTodos: 'listar-alunos',

        }),

    }

</script>

<style>

    #tabela {
        text-align: center;
        padding: 10px;
    }

</style>
