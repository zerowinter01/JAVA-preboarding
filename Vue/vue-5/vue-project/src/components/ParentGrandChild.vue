<template>
    <div>
        <hr />
        <p> 손자 태그 </p>
        <p>신청 이름 : {{name}}</p> 
        <input type="text" v-model="name">
        <button @click="updateName"> 개명신청 </button>
    </div>
</template>

<script setup>
    const emit = defineEmits(['updateName'])

    import { ref } from 'vue'; 
    const name = ref("")

    const updateName = function () {
        emit('updateName', name.value)
        name.value=""
    }
    
</script>

<style scoped>

</style>