<template>
    <div>
        <h2>App.vue</h2>
        <nav>
            <RouterLink to="/">home</RouterLink> <br>
            <RouterLink to="/about">about</RouterLink>
        </nav>
        <RouterView />
    </div>
</template>

<script setup>
    import { RouterLink, RouterView } from 'vue-router';
</script>

<style lang="scss" scoped>

</style>