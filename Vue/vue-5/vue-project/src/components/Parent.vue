<template>
    <div>
        <h3> Parent </h3>
        <ParentChild @some-event="someCallback"
                    @emit-args="getNumbers"
                    @update-name="updateName"
                my-msg="message" :dynamic-props="name"/>
    </div>
</template>

<script setup>
    import ParentChild from './ParentChild.vue';

    import { ref } from 'vue'; 
    const name = ref("kim")

    const someCallback = function () {
        console.log("ParentChild가 발신한 이벤트 수신하였습니다.")
    }
    const getNumbers = function (...args) {
        console.log(args)
    }
    const updateName = function(newName){
        name.value=newName
    }
</script>

<style lang="scss" scoped>

</style>