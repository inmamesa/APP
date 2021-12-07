// Call the dataTables jQuery plugin
$(document).ready(function() {	
	
  $('#dataTable').DataTable( {
        "ajax": "/cliente?id="+localStorage.id,
        "columns": [
            { "data": "codServicio" },
            { "data": "tipoServicio" }
        ]
    } );
});



