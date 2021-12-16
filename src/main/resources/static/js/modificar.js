$(document).ready(function() {	
	if(!localStorage.codigo || localStorage.codigo=='null'){
		window.location.href='login.html'
	}
	//alert(localStorage.codigo+"con"+localStorage.idCliente);
    $.ajax({
     		url : '/trabajador/cliente/'+localStorage.idCliente})
     		.done(function(msg){
				document.getElementById('txtDni').value=msg.dni;
				document.getElementById('txtNombre').value=msg.nombre;
				document.getElementById('txtApellido').value=msg.apellidos;
			});
     		
});
async function modificar() {
  
  let datos={};
  datos.dni=document.getElementById('txtDni').value;
  datos.nombre=document.getElementById('txtNombre').value;
  datos.apellidos=document.getElementById('txtApellido').value;

  
  const request = await fetch('/trabajador/'+localStorage.codigo+'/cliente/'+localStorage.idCliente+'/modificar', {
    method: 'PUT',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
  body: JSON.stringify(datos)
  
 });
  window.location.href='trabajador.html';
}