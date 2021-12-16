$(document).ready(function() {	
	//bucle para que si no esta registrado no pueda entrar en la pagina y nos mande al login
	if(!localStorage.codigo || localStorage.codigo=='null'){
		window.location.href='login.html'
	}
	
});
//funcion para llamar desde el boton cuando le de a guardar en el formulario
async function registrar() {
  
  let datos={};
  //cogemos los datos introducidos
  datos.dni=document.getElementById('txtDni').value;
  datos.nombre=document.getElementById('txtNombre').value;
  datos.apellidos=document.getElementById('txtApellido').value;
  
  //indicamos su ruta con el codigo del trabajador para que lo registre en ese trabajador
  const request = await fetch('/trabajador/'+localStorage.codigo+'/registrar', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
  body: JSON.stringify(datos)
  
 });
 //lo llevamos a la pagina de mostrar para que nos muestre que esta registrado correctamente
  window.location.href='trabajador.html';
}