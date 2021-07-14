<template>
  <div>
    <div id="g-signin2"></div>
    {{ googleUser }}
    <button @click="signout">signout</button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      googleUser: null,
    }
  },
  mounted() {
    window.gapi.signin2.render('g-signin2', {
      scope: 'profile email',
      width: 240,
      height: 50,
      longtitle: true,
      theme: 'dark',
      onsuccess: this.onSuccess,
      onfailure: this.onFailure,
    })
  },
  methods: {
    onSuccess(googleUser) {
      this.googleUser = googleUser.getBasicProfile()
      // this.$router.push({ name: "Home"})
    },
    onFailure(err) {
      console.log(err)
    },
    signout() {
      const authInst = window.gapi.auth2.getAuthInstance()
      authInst.signOut().then(() => {
        this.googleUser = null
      })
    }
  },
}
</script>

<style>

</style>