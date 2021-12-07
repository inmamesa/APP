// Call the dataTables jQuery plugin
$(document).ready(function() {	
	
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
    
});



