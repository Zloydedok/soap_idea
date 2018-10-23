<template>
  <div class="root">
    <h1>Map</h1>
    <div id="mapid"/>
  </div>
</template>

<script lang="ts">
  import Vue from 'vue';
  import L from 'leaflet';

  export default Vue.extend({
    name: 'Map',
    mounted() {
      const map = this.initMap();
      this.initBuilding(map);
    },
    methods: {
      initMap() {
        const map = L.map('mapid').setView([48.708133, 9.143919], 18);
        L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
          attribution: 'Map data &copy; <a ' +
            'href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, <a ' +
            'href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>',
          maxZoom: 21
        }).addTo(map);
        return map;
      },
      initBuilding(map: L.Map) {
        const bounds = this.initBounds();
        const building = L.imageOverlay('/static/Building_Plan.PNG', bounds);
        const area = L.imageOverlay('/static/Observed_Area.PNG', bounds);
        building.addTo(map);

        map.on('zoomend', () => {
          map.removeLayer(building);
          map.removeLayer(area);
          if (map.getZoom() > 18) {
            area.addTo(map);
          } else {
            building.addTo(map);
          }
        });
      },
      initBounds() {
        const corner1 = L.latLng(48.707585, 9.143975);
        const corner2 = L.latLng(48.708544, 9.142873);
        return L.latLngBounds(corner1, corner2);
      }
    }
  });
</script>

<style lang="scss" scoped>
  h1 {
    font-size: 300%;
  }

  #mapid {
    height: 500px;
  }
</style>
