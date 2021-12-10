$(document).ready(function() {	
	if(localStorage.codigo==""){
		window.location.href='login.html'
	}
	
});
async function registrar() {
  
  let datos={};
  datos.dni=document.getElementById('txtDni').value;
  datos.nombre=document.getElementById('txtNombre').value;
  datos.apellido=document.getElementById('txtApellido').value;
  
  const request = await fetch('/trabajador/'+localStorage.codigo+'/registrar', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
  body: JSON.stringify(datos)
  
 });
  window.location.href='trabajador.html';
}