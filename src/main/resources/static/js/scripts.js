$(function(){
    getAllAudience();

    $('#showNewCategory').on('click', function (){
        $('#titleCat').text('Nueva categoria');
        $('#blqTblCategory').slideUp();
        $('#blqCategory').slideDown();
        $("#saveCategory").show();
        $("#updateCategory").hide();
    });

    $(document).on('click', '#saveCategory', function (){
        if( $('#nameCategory').val() == '' || $('#descriptionCategory').val() == '' ){
            alert('¡Campo vacio!, debe ingresar todos los valores'); return;
        }
        saveCategory()
    });
    $(document).on('click', '#updateCategory', function (){
        if( $('#nameCategory').val() == '' || $('#descriptionCategory').val() == '' ){
            alert('¡Campo vacio!, debe ingresar todos los valores'); return;
        }
        updateCategory()
    });
    $(document).on('click', '#btnOMCategory', function (){
        getAllCategory();
        $("#modAudience").modal("hide");
        $("#modCategory").modal("show");
    });

    $(document).on('click', '#saveAudience', function (){
        if( $('#ownerAudience').val() == '' || $('#nameAudience').val() == ''  || $('#descriptionAudience').val() == '' || $('#capacityAudience').val() == '' || $('#categoryAudience').val() == '' ){
            alert('¡Campo vacio!, debe ingresar todos los valores'); return;
        }
        saveAudience()
    });

    $(document).on('click', '.CH', function () { ch( $(this) ); });

});





function getAllCategory(){

    /*let tbl=`<tr>
                <td>cat1</td>
                <td>this is a test</td>
                <td class="text-center">
                    <div class="btn-group btn-group-sm">
                        <button type="button" class="btn btn-warning" onclick="getCategoryById(1)" title="Actualizar"><i class="fa-solid fa-pen-to-square"></i></button>
                                <button type="button" class="btn btn-danger" idr="1" title="Eliminar"><i class="fa-solid fa-trash"></i></button>
                    </div>
                </td>
            </tr>`;
    $("#tblCategory tbody").append(tbl);*/

    $.ajax({
        url : "api/Category/all",
        type : 'GET',
        dataType : 'json',
        success : function(p) {
            console.log(p);
            $("#tblCategory tbody").empty();
            for(i=0;i<p.length;i++){
                let tbl=`<tr>
                            <td>${p[i].name}</td>
                            <td>${p[i].description}</td>
                            <td class="text-center">
                            <div class="btn-group btn-group-sm">
                                <button type="button" class="btn btn-warning" onclick="getCategoryById(${p[i].id})" title="Actualizar"><i class="fa-solid fa-pen-to-square"></i></button>
                                <button type="button" class="btn btn-danger" onclick="deleteById(${p[i].id})" title="Eliminar"><i class="fa-solid fa-trash"></i></button>
                            </div>
                        </td>
                        </tr>`;
                $("#tblCategory tbody").append(tbl);
            }
            $('#blqTblCategory').slideDown();
            $('#blqCategory').slideUp();
        },
        error : function(xhr, status) {
            alert('ha sucedido un problema');
        },
        complete : function(xhr, status) {
            //  alert('Petición realizada');
        }
    });
}
function getCategoryData(){
    let data = {
        id:$("#idCategory").val(),
        name:$("#nameCategory").val(),
        description:$("#descriptionCategory").val()
    }
    return data;
}
function saveCategory(){
    let data = getCategoryData();
    data.id = null;
    let dataToSend = JSON.stringify(data);
    $.ajax({
        url  : "api/Category/save",
        type : 'POST',
        data : dataToSend,
        contentType : 'application/json',
        success : function(p) {
            cleanData();
            getAllCategory();
        },
        error : function(xhr, status) {
            alert('ha sucedido un problema');
        },
        complete : function(xhr, status) {
            //  alert('Petición realizada');
        }
    });
}
function updateCategory(){
    let data = getCategoryData();
    let dataToSend = JSON.stringify(data);
    $.ajax({
        url : "api/Category/update",
        type : 'PUT',
        data:dataToSend,
        contentType : 'application/json',
        success : function(p) {
            cancelUpdateCategory();
            getAllCategory();
        },
        error : function(xhr, status) {
            alert('ha sucedido un problema');
        },
        complete : function(xhr, status) {
            //  alert('Petición realizada');
        }
    });
}
function cleanData(){
    $("#idCategory").val("");
    $("#nameCategory").val("");
    $("#descriptionCategory").val("");
}
function getCategoryById(idCat){
    $.ajax({
        url : "api/Category/"+idCat,
        type : 'GET',
        dataType : 'json',
        success : function(p) {
            $("#idCategory").val(p.id);
            $("#nameCategory").val(p.name);
            $("#descriptionCategory").val(p.description);
            $('#titleCat').text('Actualizar categoria');
            $('#blqTblCategory').slideUp();
            $('#blqCategory').slideDown();
            $("#saveCategory").hide();
            $("#updateCategory").show();
        },
        error : function(xhr, status) {
            alert('ha sucedido un problema');
        },
        complete : function(xhr, status) {
            //  alert('Petición realizada');
        }
    });
}
function cancelUpdateCategory(){
    cleanData();
    $(".updateCategory").hide();
    $(".saveCategory").show();
}
function deleteById(idCat){
    $.ajax({
        url : "api/Category/"+idCat,
        type : 'DELETE',
        dataType : 'json',
        success : function(p) {
            cleanData();
            getAllCategory();
        },
        error : function(xhr, status) {
            alert('ha sucedido un problema');
        },
        complete : function(xhr, status) {
            //  alert('Petición realizada');
        }
    });
}

function getAllAudience(){
    $.ajax({
        url : "api/Audience/all",
        type : 'GET',
        dataType : 'json',
        success : function(p) {
            console.log(p);
            $("#blqAudience").empty();
            for(let i=0;i<p.length;i++){
                let card=`<div class="col-md-4">
                            <div class="card m-2">
                              <img class="card-img-top" src="img/audi.jfif" alt="Card image">
                              <div class="card-body">
                                <h4 class="card-title">${p[i].name}</h4>
                                <p class="card-text">${p[i].description}</p>
                                <span class="card-text">Capacidad: ${p[i].capacity}</span>
                                <span class="card-text float-end">Categoria: ${p[i].category.name}</span>
                                <div class="d-flex mt-3">
                                    <button class="btn btn-primary btn-sm  ms-auto">Alquilar</button>
                                </div>
                              </div>
                            </div>
                          </div>`;
                $("#blqAudience").append(card);
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
function getAudienceData(){
    let data = {
        id:$("#idAudience").val(),
        owner:$("#ownerAudience").val(),
        name:$("#nameAudience").val(),
        description:$("#descriptionAudience").val(),
        capacity:$("#capacityAudience").val(),
        category:{ id:$("#categoryAudience").val() }
    }
    return data;
}
function saveAudience(){
    let data = getAudienceData();
    data.id = null;
    let dataToSend = JSON.stringify(data);
    $.ajax({
        url  : "api/Audience/save",
        type : 'POST',
        data : dataToSend,
        contentType : 'application/json',
        success : function(p) {
            cleanData();
            $("#modAudience").modal("hide");
            getAllAudience();
        },
        error : function(xhr, status) {
            alert('ha sucedido un problema');
        },
        complete : function(xhr, status) {
            //  alert('Petición realizada');
        }
    });
}
function getAllCategoryAud(){
    $.ajax({
        url : "api/Category/all",
        type : 'GET',
        dataType : 'json',
        success : function(p) {
            console.log(p);
            $("#tblCategory tbody").empty();
            let opt=[];
            for(i=0;i<p.length;i++){
                opt[i]=`<option value="${p[i].id}">${p[i].name}</option>`;
            }
            $("#categoryAudience").html('<option value="">seleccione...</option>'+opt);
            $('#blqTblCategory').slideDown();
            $('#blqCategory').slideUp();
        },
        error : function(xhr, status) {
            alert('ha sucedido un problema');
        },
        complete : function(xhr, status) {
            //  alert('Petición realizada');
        }
    });
}





function ch( $this ) {
    $this.children().last().hasClass('fa-plus') ? $this.children().last().removeClass('fa-plus').addClass('fa-minus') : $this.children().last().removeClass('fa-minus').addClass('fa-plus');
}