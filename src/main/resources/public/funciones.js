function capitalizarPrimeraLetra(texto) {
    var primeraLetra = texto.charAt(0).toUpperCase();
    var restoTexto = texto.slice(1).toLowerCase();
    return primeraLetra + restoTexto;
}

function convertirMayusculas(document) {
    var patente = document.toUpperCase();
    return patente;
}

function validarFrase(frase) {
    var regex = /^([a-zA-Z]{2}[0-9]{4}|[a-zA-Z]{4}[0-9]{2})$/;
    console.log(frase)
    if (!regex.test(frase)) {
        console.log("La frase no cumple con el formato requerido.");
        alert("La frase no cumple con el formato requerido.");
        return false;
    }

    return true;
}
