<template>
  <div>
    <UserInfo></UserInfo>
    <Reviews></Reviews>
  </div>
</template>

<script>
import UserInfo from '@/components/user/UserInfo'
import Reviews from '@/components/user/Reviews'

export default {
  name: 'MyPage',
  components: {
    UserInfo,
    Reviews,
  },
  data(){
    return {
    }
  },

}
</script>