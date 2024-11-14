import { ref, computed } from 'vue'
import { defineStore } from 'pinia'

export const useTodosStore = defineStore('todos', () => {
  let id = 0

  const todos = ref([
    {id: id++, text: '잠 자기', isDone: false},
    {id: id++, text: '밥 먹기', isDone: false},
    {id: id++, text: 'view 복습하기', isDone: false},
  ])

  const addTodo = function(todoText){
    todos.value.push({
      id: id++,
      text: todoText, // 파라미터 명이 text라면 text: text 이지만, text 라고만 작성해도 된다. 
      isDone: false
    })
  }
  
  const deleteTodo = function(id){
    const idx = todos.value.findIndex((todo) => {
      return todo.id === id
    })
    todos.value.splice(idx, 1)
  }


  const updateTodo = function(id){
    todos.value = todos.value.map((todo) =>{
      if(todo.id == id) {
        todo.isDone = !todo.isDone;
      }
      return todo
    })
  }

  return { todos, addTodo, deleteTodo, updateTodo }
})
