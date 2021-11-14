function sendPost(name,description,email) {
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
