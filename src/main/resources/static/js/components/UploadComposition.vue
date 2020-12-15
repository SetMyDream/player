<template>
  <div>
    <div>
      <div class="upload__wrapper card">
        <div class="card-body">
          <input type="file" id="file" ref="file" v-on:change="handleFileUpload()">
          <input type="text" v-model="name" placeholder="name">
          <input type="text" v-model="singer" placeholder="singer">
          <input type="text" v-model="band" placeholder="band">
          <input type="text" v-model="genre" placeholder="genre">
          <input type="text" v-model="year" placeholder="year">
          <button v-on:click="submitFile()">Submit</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      file: "",
      name: "",
      singer: "",
      band: "",
      genre: "",
      country: "",
      year: ""
    }
  },
  methods: {
    handleFileUpload() {
      this.file = this.$refs.file.files[0];
    },
    submitFile() {
      let formData = new FormData();
      formData.append("file", this.file);
      formData.append("name", this.name);
      formData.append("singer", this.singer);
      formData.append("band", this.band);
      formData.append("genre", this.genre);
      formData.append("country", this.country)
      formData.append("year", this.year)

      axios
          .post("http://localhost:8080/songs", formData, {
            headers: {
              "Content-Type": "multipart/from-data"
            }
          })
          .then(function () {
            console.log("Load file on server SUCCESS");
          })
          .catch(function () {
            console.log("Load file on server FAILURE");
          });
      this.clear();
      this.updatePlaylist();
    },
    clear: function() {
      this.file = "";
      this.name = "";
      this.singer = "";
      this.band = "";
      this.genre = "";
      this.country = "";
      this.year = ""
    },
    updatePlaylist: function () {
      this.$emit("updatePlaylist");
    }
  }
}
</script>

<style lang="scss">
  .upload__wrapper input,
  .upload__wrapper textarea {
    width: 100%;
    margin-bottom: 5px;
  }
  .upload__wrapper button {
    width: 100%;
  }
</style>