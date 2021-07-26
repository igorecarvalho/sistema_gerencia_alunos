<template>

    <div>

        <v-app>

            <v-main cols="12"
                    align="center"
                    justify="center"
                    class="grey lighten-2">
                    
                <Header></Header>
                <router-view></router-view>
                <Footer></Footer>

            </v-main>

        </v-app>

    </div>

</template>

<script>

    import Header from "@/components/Header.vue";
    import Footer from "@/components/Footer.vue";
    import 'vue-toast-notification/dist/theme-sugar.css';

    export default {

        name: "App",

        components: {
            Header,
            Footer,
        },
    };

</script>

<style>

</style>