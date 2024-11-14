<template>
    <div>
        <h4>게시글 상세</h4>
        <hr>
        <h4>{{ board.id }}</h4>
        <p>{{ board.content }}</p>
    </div>
</template>

<script setup>
import { useBoardStore } from '@/stores/board'
import { ref, onMounted } from 'vue'



const store = useBoardStore()
const board = ref('')

onMounted(() => {
    const id = route.params.id  
    try {
        console.log(id)
        board.value = store.detailBoard(id)  
    } catch (error) {
        console.error('Error fetching board details:', error)
    } 
})
</script>

<style scoped></style>
