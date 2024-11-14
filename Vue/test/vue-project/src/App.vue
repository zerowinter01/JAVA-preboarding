<template>
    <div>
      <h2>회원가입</h2>
  
      <div>
        <label>이메일:</label>
        <input v-model="email" type="email" />
        <button @click="sendVerificationCode">인증번호 요청</button>
      </div>
  
      <div v-if="verificationCodeSent">
        <label>인증번호 입력:</label>
        <input v-model="userCode" type="text" />
        <button @click="verifyCode">인증번호 확인</button>
      </div>
  
      <div v-if="isEmailVerified">
        <label>아이디:</label>
        <input v-model="userDetails.userLoginId" type="text" />
  
        <label>비밀번호:</label>
        <input v-model="userDetails.password" type="password" />
  
        <button @click="signup">회원가입</button>
      </div>
    </div>
  </template>
  
  <script>
  import { ref } from 'vue';
  
  export default {
    setup() {
      const email = ref('');
      const userCode = ref('');
      const verificationCodeSent = ref(false);
      const isEmailVerified = ref(false);
      const userDetails = ref({
        userLoginId: '',
        password: ''
      });
  
      // 이메일로 인증번호 보내기
      const sendVerificationCode = async () => {
        try {
          const response = await fetch(`http://localhost:8080/mailSend?mail=${encodeURIComponent(email.value)}`, {
            method: 'POST',
          });
          const data = await response.json();
          if (data.success) {
            alert('인증번호가 전송되었습니다.');
            verificationCodeSent.value = true;
          } else {
            alert('인증번호 전송 실패: ' + data.error);
          }
        } catch (error) {
          console.error('Error sending email verification:', error);
        }
      };
  
      // 인증번호 확인
      const verifyCode = async () => {
        try {
          const response = await fetch(`http://localhost:8080/mailCheck?userNumber=${encodeURIComponent(userCode.value)}`, {
            method: 'GET',
          });
          const isMatch = await response.json();
          if (isMatch) {
            isEmailVerified.value = true;
            alert('이메일 인증이 완료되었습니다.');
          } else {
            alert('인증번호가 일치하지 않습니다.');
          }
        } catch (error) {
          console.error('Error verifying code:', error);
        }
      };
  
      // 회원가입 처리
      const signup = async () => {
        if (!isEmailVerified.value) {
          alert('이메일 인증을 완료해야 합니다.');
          return;
        }
  
        try {
          const response = await fetch('http://localhost:8080/user/signup', {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json'
            },
            body: JSON.stringify(userDetails.value)
          });
          if (response.ok) {
            alert('회원가입이 성공적으로 완료되었습니다.');
          } else {
            const data = await response.json();
            alert('회원가입 실패: ' + data.message);
          }
        } catch (error) {
          console.error('Error during signup:', error);
        }
      };
  
      return {
        email,
        userCode,
        verificationCodeSent,
        isEmailVerified,
        userDetails,
        sendVerificationCode,
        verifyCode,
        signup
      };
    }
  };
  </script>
  
  <style scoped>
  /* 필요한 스타일 추가 */
  </style>
  