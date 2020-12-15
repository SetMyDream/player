<template>
    <div>
        <div class="container">
            <div class="content">
                <div class="left__wrapper">
                    <search-song :songs="songs"
                    @filterName="filterName"
                    @filterGenre="filterGenre"
                    @filterYear="filterYear"
                ></search-song>
                <songs :filterCompositions="filterCompositions" @songId="play"></songs>
        </div>
        <div class="right__wrapper">
            <upload-song @updatePlaylist="update"></upload-song>
    </div>
</div>
</div>
<player-wrapper :id="songId"></player-wrapper>
</div>
</template>

<script>
    import PlayerWrapper from "../components/PlayerWrapper.vue";
    import UploadComposition from "../components/UploadComposition.vue";
    import SearchComposition from "../components/SearchComposition.vue";
    import Compositions from "../components/Compositions.vue";
    import axios from "axios";
    export default {
    components: {
    PlayerWrapper,
    UploadComposition,
    SearchComposition,
    Compositions
},
    data() {
    return {
    songId: "",
    songs: [],
    filterCompositions: [],
    filter: {
    name: "",
    genre:"",
    country:"",
    year:""
}
}
},
    methods: {
    play(id) {
    this.songId = id;
},
    update: function() {
    this.load();
},
    load: function() {
    axios
    .get('http://localhost:8080/songs')
    .then(response => {
    this.songs = response.data
    this.filterCompositions = response.data
    console.log(response.data);
})
},
    filterName: function(name) {
    let newCompositions = [];
    for (let i = 0; i < this.songs.length; i++) {
    if (this.songs[i].name.toLowerCase().includes(name.toLowerCase())
    || this.songs[i].singer.toLowerCase().includes(name.toLowerCase())
    || this.songs[i].band.toLowerCase().includes(name.toLowerCase())) {
    newCompositions.push(this.songs[i]);
}
}
    this.filterCompositions = newCompositions;
},
    filterGenre: function(genre) {
    if (genre === "") {
    this.copyCompositionsToFilterCompositions();
    return;
}
    let newCompositions = [];
    for (let i = 0; i < this.songs.length; i++) {
    if (this.songs[i].genre === genre) {
    newCompositions.push(this.songs[i]);
}
}
    this.filterCompositions = newCompositions;
},
    filterYear: function(year) {
    if (year === "") {
    this.copyCompositionsToFilterCompositions();
    return;
}
    let newCompositions = [];
    for (let i = 0; i < this.songs.length; i++) {
    if (this.songs[i].year === year) {
    newCompositions.push(this.songs[i]);
}
}
    this.filterCompositions = newCompositions;
},
    copyCompositionsToFilterCompositions: function() {
    this.filterCompositions = [];
    for (let i = 0; i < this.songs.length; i++) {
    this.filterCompositions.push(this.songs[i]);
}
}
},
    created() {
    this.load();
}
}
</script>

<style lang="scss">
    .container {
    width: 100%;
    max-width: 1200px;
    padding: 0 15px;
    margin: 0 auto;
    display: block;
}
    .content {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    margin-top: 15px;
    min-height: 105vh;
}
    .right__wrapper,
    .left__wrapper {
    margin: 0 15px;
}
    .left__wrapper {
    width: 70%;
}
    .right__wrapper {
    width: 30%;
}
</style>
