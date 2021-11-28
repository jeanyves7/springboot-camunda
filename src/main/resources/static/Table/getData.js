function createTable(tableData) {
    var table = document.getElementById('tableApproved');
    var tableBody = document.createElement('tbody');

    tableData.forEach(function(rowData) {
        var row = document.createElement('tr');

        rowData.forEach(function(cellData) {
            var cell = document.createElement('td');
            cell.appendChild(document.createTextNode(cellData));
            row.appendChild(cell);
        });

        tableBody.appendChild(row);
    });

    table.appendChild(tableBody);

}


function create(){
    var theUrl=window.location.origin+"/api/camunda/projects";
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", theUrl, false ); // false for synchronous request
    xmlHttp.send( null );
    var listTemp=JSON.parse(xmlHttp.responseText);
    var result = [];
    var keys = Object.keys(listTemp);
    keys.forEach(function(key){
        result.push([listTemp[key].id,listTemp[key].name,listTemp[key].description,listTemp[key].isValidated,listTemp[key].notified]);
    });

    createTable(result);
    document.getElementById("show-btn").disabled = true;
}

function sendNotification(){
    let variables= {
        project: {
            value: {
                name:"name.value",
            }
        }
    }
    var xhr = new XMLHttpRequest();
    xhr.open("POST",window.location.origin+"/engine-rest/process-definition/key/sendOnDate/start");
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(JSON.stringify({
        variables
    }));
    location.reload();
}