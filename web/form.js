document.addEventListener("DOMContentLoaded", function () {
    let btn = document.getElementById("btnReg");
    btn.addEventListener("click", async evento => {
      evento.preventDefault()
      await regProd();
      document.getElementById("miFormulario").reset(); // Utiliza el método reset() del formulario para limpiarlo
    });
});
 
let regProd = async () => {
  let campos = {};
  campos.nombre = document.getElementById("nombre").value;
  campos.marca = document.getElementById("marca").value;
  campos.costo = document.getElementById("costo").value;
  campos.cantidad_disponible = document.getElementById("cantidad_disponible").value;
  try {
    const peticion = await fetch("http://localhost:8080/productos/crear", {
      method: "POST",
      headers: {
        "Accept": "application/json",
        "Content-Type": "application/json"
      },
      body: JSON.stringify(campos),
    });
  } catch (error) {
    console.log(error);
  }
};

