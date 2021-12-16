// Call the dataTables jQuery plugin
$(document).ready(function() {	
	
	//bucle para si no esta logueado te lleve al login
	if(!localStorage.id || localStorage.id=='null'){
		//alert(localStorage.id);
		window.location.href='login.html'
	}
	//para cuando mostrarmos los datos en la tabla
  $('#dataTable').DataTable( {
        "ajax": "/cliente?id="+localStorage.id,
        "columns": [
            { "data": "codServicio" },
            { "data": "tipoServicio" }
        ]
    });
    
    //boton del cerrar sesion
     $('#boton').click( function () {
	    
 		localStorage.id= null;
		window.location.href='login.html'
	});
	
});



