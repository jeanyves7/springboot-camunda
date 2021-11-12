function sendPost(name,description) {
    console.log("data")
    let variables= {
        project: {
                value: {
                    name:name.value,
                    description: description.value
                }
            }
        }

    console.log(JSON.stringify(variables));
    var xhr = new XMLHttpRequest();
    xhr.open("POST","http://localhost:9099/engine-rest/process-definition/key/fyp-projects/start");
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(JSON.stringify({
        variables
    }));
    console.log("fnish");
}
