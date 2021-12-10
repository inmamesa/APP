// Call the dataTables jQuery plugin
$(document).ready(function() {	
	alert("no puede entrar es privada"+localStorage.codigo);
	if(localStorage.codigo==""){
		window.location.href='login.html'
	}
	
  var table=$('#dataTableTrabajador').DataTable( {
        "ajax": "/trabajador?codigo="+localStorage.codigo,
        "columns": [
            { "data": "id" },
            { "data": "dni" },
            { "data": "nombre" },
            { "data": "apellidos" }
        ]
    } );
    
    //document.querySelectorAll("#dataTableTrabajador");
    var rowSelected;
    $('#dataTableTrabajador tbody').on( 'click', 'tr', function () {
        if ( $(this).hasClass('selected') ) {
            $(this).removeClass('selected');
        }else {
            $('#dataTableTrabajador').DataTable().$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
            rowSelected = this;     
        }
    } );
    
    $('#button').click( function () {
 
     	$.ajax({
     		url : '/trabajador/eliminar?idCliente='+rowSelected.cells[0].innerText, 
     		type: 'DELETE'
    	});
    	table.row('.selected').remove().draw( false ); 
    });
    $('#boton').click( function () {
	    alert(localStorage.codigo);
 		localStorage.codigo==0;
		window.location.href='login.html'
	});
     	
    
});



