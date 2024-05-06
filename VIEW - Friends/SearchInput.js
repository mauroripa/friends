function showOptions() {
    // Pulisce le opzioni della tendina
    var dataList = document.getElementById("options");
    dataList.innerHTML = "";

    // Ottenere il valore dell'input di ricerca
    var searchQuery = document.getElementById("searchInput").value.toLowerCase();

    // Ottenere tutti gli elementi del documento HTML
    var allElements = document.querySelectorAll('*');

    // Array per memorizzare gli elementi che corrispondono alla ricerca
    var results = [];

    // Effettua la ricerca all'interno degli elementi
    allElements.forEach(function (element) {
        var text = element.innerText || element.textContent;
        if (text.toLowerCase().startsWith(searchQuery)) {
            results.push(text);
        }
    });

    // Aggiungi le opzioni alla tendina
    results.forEach(function (result) {
        var option = document.createElement("option");
        option.value = result;
        dataList.appendChild(option);
    });
}

function redirectToPage() {
var searchQuery = document.getElementById('searchInput').value.toLowerCase();

if (searchQuery === "location" || searchQuery === "luoghi" || searchQuery==="posti" || searchQuery ==="set") {
    window.location.href = "location.html";
} else if (searchQuery === "gadget" || searchQuery === "oggetti") {
    window.location.href = "gadget.html";
} else if (searchQuery === "personaggi" || searchQuery === "protagonisti" || searchQuery === "ross" || searchQuery === "rachel" || searchQuery === "chandler" || searchQuery === "monica" || searchQuery === "joey" || searchQuery === "phoebe" || searchQuery==="joy") {
    window.location.href = "personaggi.html#" + searchQuery;
} else if (searchQuery === "backstage" || searchQuery === "dietro le quinte") {
    window.location.href = "backstage.html";
} else if (searchQuery === "home" || searchQuery === "homepage" || searchQuery ==="news" || searchQuery ==="storia" ){
window.location.href ="index.html";
} else if(searchQuery==="area riservata" || searchQuery === "login" || searchQuery ==="accesso" || searchQuery==="admin"){
    window.location.href="login.html";
}
else {
    // Nessuna corrispondenza, puoi gestire questa situazione come preferisci
    alert("Nessuna corrispondenza trovata per: " + searchQuery);
}
}

// Reindirizza quando viene selezionata un'opzione dalla tendina di ricerca
document.getElementById("searchInput").addEventListener("keypress", function (event) {
    if (event.key === "Enter") {
        // Impedisce l'invio del modulo per default
        event.preventDefault();
        
        // Chiama la funzione per reindirizzare alla pagina
        redirectToPage();
    }
});
