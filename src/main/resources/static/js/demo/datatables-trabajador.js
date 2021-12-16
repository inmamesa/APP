// Call the dataTables jQuery plugin
$(document).ready(function() {	
	//alert(localStorage.codigo);
	//bucle para cuando no esta registrado no entre y te mande al login
	if(!localStorage.codigo || localStorage.codigo=='null'){
		window.location.href='login.html'
	}
	//coger los campos de la tabla
  var table=$('#dataTableTrabajador').DataTable( {
        "ajax": "/trabajador?codigo="+localStorage.codigo,
        "columns": [
            { "data": "id" },
            { "data": "dni" },
            { "data": "nombre" },
            { "data": "apellidos" }
        ]
    } );
    
    //para coger el cliente seleccionado
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
    //boton para el borrar cliente una vez que esta seleccionado en la tabla
    $('#button').click( function () {
 
     	$.ajax({
     		url : '/trabajador/eliminar?idCliente='+rowSelected.cells[0].innerText, 
     		type: 'DELETE'
    	});
    	table.row('.selected').remove().draw( false ); 
    });
    //boton para que nos coja el cliente seleccionado para el modificar y nos lleve al formulario 
    $('#button3').click( function () {
 
 		localStorage.idCliente=rowSelected.cells[0].innerText;
 		table.row('.selected').remove().draw( false );
    	window.location.href='modificar.html'
    
    });
    
    //cerrar sesion
    $('#boton').click( function () {
	    //alert(localStorage.codigo);
 		localStorage.codigo= null;
		window.location.href='login.html'
	});
     	
    

});