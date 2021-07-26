<template>

    <v-footer
        app
        dark
        padless>

        <v-card
            class="flex"
            flat
            tile
            >

            <v-card-title class="primary">

                <strong class="subheading">API de cadastro de alunos</strong>

                <v-spacer></v-spacer>

            </v-card-title>

            <v-card-text class="py-2 white--text text-center">
                {{ new Date().getFullYear() }} — <strong>Igor Carvalho</strong>
            </v-card-text>
            
        </v-card>

    </v-footer>

</template>

<script>

    export default {
        name: "Footer",

        data: () => ({

        }),
    };

</script>
