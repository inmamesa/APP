// Call the dataTables jQuery plugin
$(document).ready(function() {	
	if(!localStorage.id){
		window.location.href='login.html'
	}
	
  $('#dataTable').DataTable( {
        "ajax": "/cliente?id="+localStorage.id,
        "columns": [
            { "data": "codServicio" },
            { "data": "tipoServicio" }
        ]
    } );
    
     $('#boton').click( function () {
	    //alert(localStorage.id);
 		localStorage.id= null;
		window.location.href='login.html'
	});
});



