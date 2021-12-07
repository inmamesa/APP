
async function iniciarSesion() {

  let datos = {};
  datos.nombre = document.getElementById('nombre_trabajador').value;
  datos.dni = document.getElementById('pass_trabajador').value;
  
  const request = await fetch('/login/trabajador', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
  });

  const respuesta = await request.text();

  if(respuesta == 'KO'){
	  alert("Los datos son incorrectos. Por favor intentelo nuevamente.");
  }else{
   	localStorage.codigo=respuesta;
    window.location.href = 'trabajador.html'
  }
  
}