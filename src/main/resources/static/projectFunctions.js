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
    xhr.open("POST","http://localhost:9099/engine-rest/process-definition/key/fyp-projects/start");
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(JSON.stringify({
        variables
    }));
}

function checkCredentials(userName,userPassword){
    var theUrl="http://localhost:9099/api/camunda/logIn?userName="+userName.value+"&userPassword="+userPassword.value;
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", theUrl, false ); // false for synchronous request
    xmlHttp.send( null );

    if(xmlHttp.responseText==="true"){
     document.location.href="/camundapostgres/static/index.html";
    }

}
