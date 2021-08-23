function searchPoolByAddress(){
    window.location.href="/search?location="+$("#address").val();
}

$(document).ready( function () {
    $('#dtTable').DataTable();
} );