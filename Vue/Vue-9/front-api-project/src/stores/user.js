import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'
import router from '@/router'

const REST_API_URL = `http://localhost:8080/api-user`

export const useUserStore = defineStore('user', () => {
  const loginUser = ref(null);

  const userLogin = function(id, password){
    axios.post(`${REST_API_URL}/login`,{
      id: id,
      password: password
    }).then((res) => {
      console.log(res)

      sessionStorage.setItem('access-token', res.data['access-token']) // 세션 스토리지에 저장 
      
      const token = res.data['access-token'].split('.')
      const name = JSON.parse(atob(token[1]))['name']

      loginUser.value = name

      router.push({name: 'boardList'}) // 로그인 성공 시 게시글 목록으로 이동 

    }).catch((err)=>{
      console.log(err)
    })
  }

  return { loginUser, userLogin }
})
