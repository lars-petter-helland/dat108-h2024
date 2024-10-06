"use strict";
console.clear();

/*
  /api/personer gir en respons slik:
[
  {
    "firstName": "Charles",
    "lastName": "Dickens",
    "alder": 60
  },
  {
    "firstName": "Lewis",
    "lastName": "Carroll",
    "alder": 42
  },
  ...
]
 */

// 1. Hente data ----------------------------------------------------------------

const url = 'http://localhost:8080/api/personer';

fetch(url)  // Et asynkront kall til API-endepunket. Returnerer et Promise-objekt.
            // Blokkerer ikke, men kommer tilbake og utfører then() når klar.

  .then(response => response.json())        	// Parser Response-objekt når klart.
  .then(personer => insertHtmlTable(personer)) 	// Setter inn en HTML-tabell når klart.
  .catch(error => console.log(error));

// 2. Vise data -----------------------------------------------------------------

function insertHtmlTable(plist) {

  const table = document.getElementById("persontabellen");
  
  // Table head --------------------------------------------------------------
  
  const headRow = document.createElement('tr');
  const headers = ['Fornavn', 'Etternavn', 'Alder'];
  for (const header of headers) {
		const th = document.createElement('th'); 
		th.textContent = header;
		headRow.appendChild(th);
  }
  table.appendChild(headRow);

  // Table body --------------------------------------------------------------

  for (const person of plist) {
    const bodyRow = document.createElement('tr');
    for (const prop in person) {
      const td = document.createElement('td');
      td.textContent = person[prop]; 
      bodyRow.appendChild(td);
    }
	table.appendChild(bodyRow);
  }
}

