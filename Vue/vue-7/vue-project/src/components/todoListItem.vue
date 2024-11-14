<template>
    <div>
        <span :class="{'is-done': todo.isDone}" @click="store.updateTodo(todo.id)"> {{ todo.text }}</span>
        <button @click="store.deleteTodo(todo.id)">X</button>
    </div>
</template>

<script setup>
    import { useTodosStore } from '@/stores/todos';

    const store = useTodosStore();

    defineProps({
        todo: Object
    })
</script>

<style lang="scss" scoped>
    .is-done{
        text-decoration: line-through;
    }
</style>