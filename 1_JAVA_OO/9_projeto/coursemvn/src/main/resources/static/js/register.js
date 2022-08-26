$(document).ready(function(){
    
});

async function registerUser(){
    var data = new Object();

    data.name = document.getElementById('FirstName').value,
    data.lastname = document.getElementById('LastName').value,
    data.email = document.getElementById('InputEmail').value,
    data.phone = document.getElementById('InputPhone').value,
    data.password = document.getElementById('InputPassword').value

    console.log(data);

    let repeatPassword = document.getElementById('RepeatPassword').value;
    if(data.password != repeatPassword){
        alert('Passwords are different');
        return;
    }

    const request = await fetch('api/user', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data),
    });
    alert("The account was created successfully");
    window.location.href = 'login.html';
}
