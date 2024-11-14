<template>
    <div>
        <nav>
            <RouterLink to="/">Home</RouterLink> | 
            <RouterLink to="/board">Board</RouterLink>
        </nav>

        <!-- "board" 경로일 때만 "Create" 메뉴 표시 -->
        <div v-if="isBoardPage" class="menu">
            <RouterLink to="/board" class="menu-link">List</RouterLink> |
            <RouterLink to="/board/create" class="menu-link">Create</RouterLink>
        </div>
    </div>
</template>

<script setup>
import { ref, computed } from 'vue'
import { useRoute } from 'vue-router'

const route = useRoute()

// 현재 경로가 "/board"일 때만 표시하도록 설정
const isBoardPage = computed(() => route.path.startsWith('/board'))
</script>

<style scoped>
    nav {
        text-align: center;
    }
    nav a {
        font-weight: bold;
        text-decoration: none;
        color: black;
    }
    nav a.router-link-exact-active {
        color: #42b983;
    }
    .menu {
        text-align: center;
        margin-top: 10px;
    }
    .menu a {
        font-weight: bold;
        text-decoration: none;
        color: black;
    }
    .menu a.router-link-exact-active {
        color: #42b983;
    }
</style>
