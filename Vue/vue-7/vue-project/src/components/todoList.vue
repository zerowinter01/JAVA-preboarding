<template>
    <div>
        <todoListItem v-for="todo in store.todos" :key="todo.id" 
                        :todo="todo"/> <!-- todo로 내려 보내기 위해서 작성 -->
    </div>
</template>

<script setup>
    import todoListItem from './todoListItem.vue';
    import { useTodosStore } from '@/stores/todos';

    const store = useTodosStore()
</script>

<style lang="scss" scoped>

</style>