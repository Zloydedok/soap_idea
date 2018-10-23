<template>
  <div id="app">
    <Header/>
    <div class="view">
      <router-view/>
    </div>
    <Footer/>
  </div>
</template>

<script lang="ts">
  import Vue from 'vue';
  import ButtonTest from './components/example/ButtonTest.vue';
  import Logger from './common/classes/Logger';

  export default Vue.extend({
    name: 'App',
    components: {
      ButtonTest
    },
    created() {
      Logger.log('[App] created ', ACTUATOR);
    }
  });
</script>

<style lang="scss" scoped>
  @import './styles/variables';

  .view {
    margin-top: $header-height;
  }
</style>
