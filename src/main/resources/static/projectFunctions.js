function addProject(name, description, email) {
    let variables= {
        project: {
                value: {
                    name:name.value,
                    description: description.value,
                    email: email.value
                }
            }
        }

    var xhr = new XMLHttpRequest();
    xhr.open("POST",window.location.origin+"/engine-rest/process-definition/key/fyp-projects/start");
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(JSON.stringify({
        variables
    }));
}

function checkCredentials(userName,userPassword){
    var theUrl=window.location.origin+"/api/camunda/logIn?userName="+userName.value+"&userPassword="+userPassword.value;
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", theUrl, false ); // false for synchronous request
    xmlHttp.send( null );

    if(xmlHttp.responseText==="true"){
     document.location.href="/Table/professorPage.html";
    }
}

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

    // document.body.appendChild(table);
}
function create(){
    var theUrl=window.location.origin+"/api/camunda/projects";
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", theUrl, false ); // false for synchronous request
    xmlHttp.send( null );


    createTable([["row 1, cell 1", "row 1, cell 2"], ["row 2, cell 1", "row 2, cell 2"]]);
}

