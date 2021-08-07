$(document).ready( function () {
    $('#songs').DataTable();
} );


function searchArtist(){
    window.location.href="/search/"+$("#artist").val();
}