console.log("Js vinculado")



//Manejar la solicitud del formulario granja
document.getElementById('granja_form').addEventListener('submit', function (event) {
    event.preventDefault();
    fetch('/gold/actions/granja', {
      method: 'POST'
    })
    .then(response => response.text())//La respuesta viene en formato texto
    .then(data => {
        let parrafo = document.createElement("P")
        parrafo.textContent = `En la granja ha obtenido: ${data} de oro`
        parrafo.classList.add("adicion");
        console.log(parrafo)
        document.getElementById('respuesta_div').appendChild(parrafo); // Actualiza el contenido del div con la respuesta recibida
    })
    .catch(error => {
      console.error('Error:', error);
    });
  });