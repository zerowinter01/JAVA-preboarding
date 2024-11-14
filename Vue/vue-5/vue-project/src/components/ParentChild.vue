<template>
    <div>
        <h4> 자식 Component </h4>
        <p> {{ myMsg }}</p>
        <p> {{ dynamicProps }}</p>

        <button @click="$emit('someEvent')"> 클릭 </button> 
        <button @click="buttonClick"> 클릭2 </button> 
        <button @click="emitArgs">추가 인자 전달</button>

        <ParentGrandChild @update-name="updateName" />
    </div>
</template>

<script setup>

    import ParentGrandChild from './ParentGrandChild.vue';

    defineProps({
		myMsg: String,
        dynamicProps: String
	})

    const emit = defineEmits(["someEvent", "emitArgs", "updateName"]);
    const buttonClick = function () {
        emit("someEvent")
    }

    const emitArgs = function () {
        emit("emitArgs", 1, 2, 3) // 전개 연산자는 묶어서 한 번에 보내준다. 
    }

    const updateName=function (name) {
        emit('updateName', name)
        console.log('ParentChild 에서 받은' +name+'입니다.')
    }
</script>

<style scoped>

</style>