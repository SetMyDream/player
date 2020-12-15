<template>
  <div class="card">
    <div class="card-body">
      <div class="search__wrapper">
        <input type="text" class="search" v-model="name" placeholder="Composition name/Single/Squad...">
        <select v-model="genre" @click="filterGenre">
          <option v-for="genre in genres">{{genre}}</option>
        </select>
        <input type="text" placeholder="Year" v-model="year" class="year">
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    props: ["songs"],
    data() {
      return {
        genres: [""],
        countries: [""],
        name: "",
        year: "",
        genre: "",
        country: ""
      }
    },
    watch: {
      songs() {
        this.fillGenresAndCountries();
      },
      name() {
        this.$emit("filterName", this.name)
      },
      year() {
        this.$emit("filterYear", this.year)
      }
    },
    methods: {
      fillGenresAndCountries: function() {
        for (let i = 0; i < this.songs.length; i++) {
          if (this.songs[i].genre !== "") {
            this.genres.push(this.songs[i].genre);
          }
          if (this.songs[i].country !== "") {
            this.countries.push(this.songs[i].country);
          }
        }
      },
      filterGenre: function() {
        this.$emit("filterGenre", this.genre)
      },
      filterCountry: function() {
        this.$emit("filterCountry", this.country)
      }
    }
  }
</script>

<style lang="scss">
  .search__wrapper {
    width: 100%;
  }
  .search__wrapper select {
    margin-top: 2px;
    height: 30px;
    width: 20%;
  }
  .search__wrapper .search {
    width: 48%;
  }
  .search__wrapper .year {
    width: 10%;
  }
</style>