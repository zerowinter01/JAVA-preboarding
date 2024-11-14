<template>
  <div>
    <h2>주간 운동 목표 조회</h2>
    <input type="date" v-model="startDate" placeholder="시작 날짜" />
    <input type="date" v-model="endDate" placeholder="종료 날짜" />
    <button @click="fetchWeeklyGoals">조회</button>

    <ul>
      <li v-for="goal in goals" :key="goal.id">
        {{ goal.goalDescription }} - {{ goal.achievementDate }}
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  data() {
    return {
      startDate: "",
      endDate: "",
      goals: [],
    };
  },
  methods: {
    fetchWeeklyGoals() {
      const userId = 1; // 테스트용 사용자 ID
      fetch(
        `http://localhost:8080/api/goals/weekly?userId=${userId}&startDate=${this.startDate}&endDate=${this.endDate}`
      )
        .then(response => response.json())
        .then(data => (this.goals = data));
    },
  },
};
</script>
