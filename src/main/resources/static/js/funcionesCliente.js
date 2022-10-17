$(document).ready(function(){
    getAllClient();
});

function getAllClient(){
    $.ajax({
        url : "api/Client/all",
        type : 'GET',
        dataType : 'json',
        success : function(p) {
            console.log(p);
            $("#resultsClient").empty();
            for(i=0;i<p.length;i++){
                let k=`<table class="table table-dark table-striped" >
                
                <tr>
                <th>Email</th>
                <th>Nombre</th>
                <th>Password</th>
                <th>Edad</th>
                </tr>

                <tr>
                <td>${p[i].email}</td>
                <td>${p[i].name}</td>
                <td>${p[i].password}</td>
                <td>${p[i].age}</td>
                </tr>

                                
                <button class='text-danger' onclick='getClientById(${p[i].idClient})'>Actualizar</button>
                <button class='text-danger' onclick='deleteById(${p[i].idClient})'>Borrar!</button>

 

                        </table>`;
                $("#resultsClient").append(k);
            }
        },
        error : function(xhr, status) {
            alert('ha sucedido un problema');
        },
        complete : function(xhr, status) {
            //  alert('Petición realizada');
        }
    });
}
function getClientData(){
    let cli={
        idClient:$("#idCliente").val(),
        email:$("#emailCliente").val(),
        name:$("#nombreCliente").val(),
        password:$("#passwordCliente").val(),
        age:$("#ageCliente").val()
    }
    return cli;
}
function cleanData(){
        idClient:$("#idCliente").val();
        email:$("#emailCliente").val();
        name:$("#nombreCliente").val();
        password:$("#passwordCliente").val();
        age:$("#ageCliente").val();
}
function saveClient(){

    let data=getClientData();
    data.id=null;
    let dataToSend=JSON.stringify(data);
    $.ajax({
        url : "api/Client/save",
        type : 'POST',
        data:dataToSend,
        contentType : 'application/json',
        success : function(p) {
            console.log(p);
            cleanData();
            getAllClient();
        },
        error : function(xhr, status) {
            alert('ha sucedido un problema');
        },
        complete : function(xhr, status) {
            //  alert('Petición realizada');
        }
    });
}
function getClientById(idCli){
    $(".saveButtonJL").hide();
    $(".updateButtonJL").show();
    $.ajax({
        url : "api/Client/"+idCli,
        type : 'GET',
        dataType : 'json',
        success : function(p) {
            console.log(p);
            id:$("#idCliente").val(p.id);
            email:$("#emailCliente").val(p.email);
            name:$("#nombreCliente").val(p.name);
            password:$("#passwordCliente").val(p.password);
            age:$("#ageCliente").val(p.age);
        },
        error : function(xhr, status) {
            alert('ha sucedido un problema');
        },
        complete : function(xhr, status) {
            //  alert('Petición realizada');
        }
    });
}
function cancelUpdateClient(){
    cleanData();
    $(".saveButtonJL").show();
    $(".updateButtonJL").hide();
}
function updateClient(){

    let data=getClientData();
    let dataToSend=JSON.stringify(data);
    $.ajax({
        url : "api/Client/update",
        type : 'PUT',
        data:dataToSend,
        contentType : 'application/json',
        success : function(p) {
            console.log(p);
            cancelUpdateClient();
            getAllClient();

        },
        error : function(xhr, status) {
            alert('ha sucedido un problema');
        },
        complete : function(xhr, status) {
            //  alert('Petición realizada');
        }
    });
}

function deleteById(idCli){
    $.ajax({
        url : "api/Client/"+idCli,
        type : 'DELETE',
        dataType : 'json',
        success : function(p) {
            console.log(p);
            cleanData();
            getAllClient();
        },
        error : function(xhr, status) {
            alert('ha sucedido un problema');
        },
        complete : function(xhr, status) {
            //  alert('Petición realizada');
        }
    });
}