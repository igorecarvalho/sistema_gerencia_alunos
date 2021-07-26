<template>

    <div>
        
        <v-toolbar
            prominent
            dark
            color="primary">
            
            <v-app-bar-nav-icon large @click.stop="drawer = !drawer"></v-app-bar-nav-icon>

            <v-toolbar-title>
                <strong> <h1>Gerenciador de Alunos</h1> </strong>
            </v-toolbar-title>

            <v-spacer></v-spacer>
            
            <v-avatar color="primary">
                      <v-icon   color="white"
                                large
                                dark>
                        mdi-account
                    </v-icon>
            </v-avatar>

        </v-toolbar>

        <v-navigation-drawer
            v-model="drawer"
            absolute
            temporary
            >
            
            <v-list-item>

                <v-list-item-avatar>
                    <v-img src="../assets/logo.png"></v-img>
                </v-list-item-avatar>

                <v-list-item-content>
                    <v-list-item-title><h3><strong>Menu</strong></h3></v-list-item-title>
                </v-list-item-content>

            </v-list-item>

            <v-divider></v-divider>

            <v-list rounded>

                <v-list-item
                    v-for="item in items"
                    :key="item.title"
                    router :to="item.route"
                    link>

                    <v-list-item-icon>
                        <v-icon>{{ item.icon }}</v-icon>
                    </v-list-item-icon>

                    <v-list-item-content>
                        <v-list-item-title>{{ item.title }}</v-list-item-title>
                    </v-list-item-content>

                </v-list-item>

            </v-list>

        </v-navigation-drawer>

    </div>

</template>

<script>

    export default {
        name: "Header",

        data () {

            return {
                drawer: null,

                items: [
                    { title: 'Home', icon: 'mdi-account' , route: '/'},
                    { title: 'Listar Alunos', icon: 'mdi-account-details' , route: '/listar-alunos'},
                    { title: 'Cadastrar Aluno', icon: 'mdi-account-plus', route: '/cadastrar-aluno'},
                ],
            }

        },

    };

</script>

<style>

    .header {
        padding: 5px;
    }


</style>


