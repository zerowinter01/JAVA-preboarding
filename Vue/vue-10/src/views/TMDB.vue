<template>
    <div>
        <h2>TMDB VIEW</h2>

        <RouterLink :to="{name: 'tmdbPopular'}">인기 순위</RouterLink> | 
        <RouterLink :to="{name: 'tmdbTopRated'}">역대 순위</RouterLink>
        <RouterView /> 
    </div>
</template>

<script setup>

</script>

<style scoped>

</style>