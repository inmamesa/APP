
async function iniciarSesion() {
  let datos = {};
  datos.nombre = document.getElementById('nombre_cliente').value;
  datos.dni = document.getElementById('pass_cliente').value;
  
  const request = await fetch('/login/cliente', {
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
   	localStorage.id=respuesta;
    window.location.href = 'cliente.html'
  }
  
}