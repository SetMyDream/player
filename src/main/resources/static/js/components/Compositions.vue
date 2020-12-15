<template>
  <div class="playlist__wrapper card">
    <div class="card-body">
      <div class="list">
        <div class="list-item title">
          <div class="name">
            name
          </div>
          <div class="singer">
            singer
          </div>
          <div class="band">
            band
          </div>
          <div class="genre">
            genre
          </div>
          <div class="country">
            country
          </div>
          <div class="year">
            year
          </div>
        </div>
      </div>
      <hr>
      <div class="list">
        <div v-for="song in filterCompositions" v-model="filterCompositions" :key="song.id">
          <div class="list-item">
            <div class="name">
              {{ song.name }}
            </div>
            <div class="singer">
              {{ song.singer }}
            </div>
            <div class="band">
              {{ song.band }}
            </div>
            <div class="genre">
              {{ song.genre }}
            </div>
            <div class="country">
              {{ song.country }}
            </div>
            <div class="year">
              {{ song.year }}
            </div>
            <button class="play" @click="play(song.id)">
              <svg width="18px" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20">
                <path fill="currentColor"
                      d="M15,10.001c0,0.299-0.305,0.514-0.305,0.514l-8.561,5.303C5.51,16.227,5,15.924,5,15.149V4.852c0-0.777,0.51-1.078,1.135-0.67l8.561,5.305C14.695,9.487,15,9.702,15,10.001z"/></svg>
            </button>
            <a :href="song.url">
              <button class="download">
                <svg width="18px" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20">
                  <path fill="currentColor"
                        d="M15,7h-3V1H8v6H5l5,5L15,7z M19.338,13.532c-0.21-0.224-1.611-1.723-2.011-2.114C17.062,11.159,16.683,11,16.285,11h-1.757l3.064,2.994h-3.544c-0.102,0-0.194,0.052-0.24,0.133L12.992,16H7.008l-0.816-1.873c-0.046-0.081-0.139-0.133-0.24-0.133H2.408L5.471,11H3.715c-0.397,0-0.776,0.159-1.042,0.418c-0.4,0.392-1.801,1.891-2.011,2.114c-0.489,0.521-0.758,0.936-0.63,1.449l0.561,3.074c0.128,0.514,0.691,0.936,1.252,0.936h16.312c0.561,0,1.124-0.422,1.252-0.936l0.561-3.074C20.096,14.468,19.828,14.053,19.338,13.532z"/>
                </svg>
              </button>
            </a>
          </div>
          <hr>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: ["filterCompositions"],
  methods: {
    play(id) {
      this.$emit("songId", id);
    }
  }
}
</script>

<style lang="scss">
.playlist__wrapper {
  margin-top: 15px;
}

.list-item {
  display: flex;
  flex-direction: row;
  width: 100%;
  font-size: 14px;
}

.list-item.title {
  font-weight: bold;
}

.list-item button {
  width: 34px;
  height: 34px;
  border-radius: 50%;
  outline: none;
  margin-left: 7px;
}

.list-item div {
  width: 15%;
  align-self: center;

}

.list-item .name {
  width: 18%;
}

.list-item .singer {
  width: 18%;
}

.list-item .band {
  width: 17%;
}

.list-item .year {
  width: 5%;
}

</style>