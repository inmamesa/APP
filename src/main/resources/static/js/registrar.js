$(document).ready(function() {	
	
});
async function Registrar() {
  
  let datos={};
  datos.dni=document.getElementById('txtDni').value;
  datos.nombre=document.getElementById('txtNombre').value;
  datos.apellido=document.getElementById('txtApellido').value;
  
  const request = await fetch('/trabajador/registrar?cod='+localStorage.cod, {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });
  body: JSON.stringify(datos)

  const respuesta = await request.json();
  }