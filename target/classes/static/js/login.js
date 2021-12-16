
//funcion para ponerla en el html cuando le de al boton realice la funcion
async function iniciarSesion() {
  let datos = {};
  //cogemos los datos introducidos 
  datos.nombre = document.getElementById('nombre_cliente').value;
  datos.dni = document.getElementById('pass_cliente').value;
  
  //lo realizamos por metodo post y guarda los datos para comprobarlos
  const request = await fetch('/login/cliente', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
  });

  const respuesta = await request.text();
  
  //comprobamos si son correctos o no y si lo son nos manda a la siguiente pagina
  if(respuesta == 'KO'){
  	alert("Los datos son incorrectos. Por favor intentelo nuevamente.");
  }else{
   	localStorage.id=respuesta;
    window.location.href = 'cliente.html'
  }
  
}