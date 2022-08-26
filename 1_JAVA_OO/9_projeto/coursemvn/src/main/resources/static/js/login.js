$(document).ready(function(){

});

async function loginUser(){
    var user = new Object();
    user.email = document.getElementById('InputEmail').value;
    user.password = document.getElementById('InputPassword').value;

    console.log(user);

    const request = await fetch('api/login', {
        method: 'POST',
        headers: {
            'Accept': 'Application/json',
            'Content-Type': 'Application/json'
        },
        body: JSON.stringify(user)
    });
    const response = await request.text();

    if(response != 'FAIL'){
        localStorage.token = response;
        localStorage.email = user.email;
        window.location.href = 'users.html'
    }else
        alert("Incorrect credential")
java    }
}