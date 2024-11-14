import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'
import router from '@/router'

const REST_API_URL = 'http://localhost:8080/board'

export const useBoardStore = defineStore('board', () => {
  const boardList = ref([]) // 게시글 목록을 스토어에서 관리 

  const getBoardList = function () {
    axios.get(REST_API_URL)
    .then((response)=>{
      // console.log(response.data)
      boardList.value = response.data
    })
  }

  const createBoard = function(board){
    axios({
      url: REST_API_URL,
      method: 'POST',
      data: board
    })
    .then(()=>{
      console.log('완료')
      router.push({name: 'boardList'})
    })
    .catch((err)=>{
      console.log(err)
      console.log('실패')
    })
  }

  const detailBoard = function(id){
    axios.get(`${REST_API_URL}/${id}`)
    .then((response)=>{
      console.log(response.data)
      boardList.value = response.data
    })
  }

  return { boardList, getBoardList, createBoard, detailBoard }
})
