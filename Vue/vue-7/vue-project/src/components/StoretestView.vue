<template>
    <div>
        <h2>store test</h2>
        <!-- state 에 저장되어 있는 count 가 보고 싶을 때 -->
        <p> state : {{ store.count }} </p>
        <!-- getters 사용하고 싶은 경우 -->
        <p> getter : {{ store.doubleCount }}</p>
        <button @click="store.increment">증가</button>
    </div>
</template>

<script setup>
    import { useCounterStore } from './stores/counter';

    const store = useCounterStore();
    console.log(store.count)
</script>

<style lang="scss" scoped>

</style>