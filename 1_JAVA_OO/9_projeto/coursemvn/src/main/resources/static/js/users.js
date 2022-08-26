// Call the dataTables jQuery plugin
$(document).ready(function() {
    loadUsers();
  $('#users').DataTable();
});

async function loadUsers(){
  const request = await fetch('api/users', {
    method: 'GET',
    headers: getHeaders()
  });
  const users = await request.json();
  console.log(users);

  let listHtml = '';
  for(let user of users){
    let bottonToDelete = '<a href="#" onclick="deleteUser('+ user.id +')" class="btn btn-danger btn-circle"><i class="fas fa-trash"></i></a>';
    let phone = user.phone == null ? '----' : user.phone;
    let userHtml = '<tr><td>'+
                    user.id +'</td><td>'+
                    user.name +'</td><td>'+
                    user.lastname +'</td><td>'+
                    user.email +'</td><td>'+
                    phone +'</td><th>'+
                    bottonToDelete +'</th></tr>';
    listHtml += userHtml;
  }
  document.querySelector('#users tbody').outerHTML = listHtml;
}

function getHeaders(){
    return{
        'Accept' : 'application/json',
        'Content-type' : 'application/json',
        'Authorization' : localStorage.token
    }
}

async function deleteUser(id){
    if(!confirm('Do you want to delete this user')){
        return;
    }
    const request = await fetch('api/user/' + id, {
        method: 'DELETE',
        headers: getHeaders()
    });
    location.reload();
}