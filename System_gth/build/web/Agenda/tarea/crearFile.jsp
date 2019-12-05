<%
    String idTarea = request.getParameter("id");
%>
<form id="form_guardar"  class="form_guardar" action="" enctype="multipart/form-data" method="post">
    <div id="imagenSubida"></div>
    
                    <div class="form-group" >
                            <label>Título</label>
                            <input type="text" class="form-control" id="titulo"  name="titulo">                            
                    </div> 
                    <div class="box-body">
                        <div class="form-group">
                            <!--<input type="file" name="file2" />-->
                            <input type="file" class="form-control-file" name="image" id="image" onchange="nameImage(this.value)"><br>
                        </div>
                        
                    </div>
                    <!-- /.box-body -->

                    <div class="box-footer">
                        <button type="button" class="btn btn-default pull-left btn-rlistFile" data-dismiss="modal"><i class="fa fa-arrow-left"></i> Volver</button>
                        <button type="button" class="btn-purple pull-right upload"><i class="fa fa-save"></i> Guardar</button>
                    </div>
</form>
<script type="text/javascript">  
    var nombreFichero = 'user.png';
    $(document).ready(function() {
        cargarImagen('../../folder_picture/'+nombreFichero);
        
    });
    function nameImage(fic) {
        fic = fic.split('\\');
        nombreFichero = fic[fic.length-1];
//        alert(fic[fic.length-1]);
      }
    $(".upload").on('click', function() {
        var formData = new FormData();
        var files = $('#image')[0].files[0];
        formData.append('file',files);
        $.ajax({
            url: 'guardarFile.jsp?id=<%=idTarea%>',
            type: 'post',
            data: formData, 
            contentType: false,
            processData: false,
            success: function(response) {
                if (response != 0) {
//                    $(".card-img-top").attr("src", response);
//                    cargarImagen('../../folder_picture/diagrama-de-sectores.png');
                        cargarImagen('../../folder_picture/'+nombreFichero);
                } else {
                    alert('Formato de imagen incorrecto.');
                }
            }
        });
        return false;
    });
    
    function cargarImagen(src){
        $.post('imagen.jsp',
            {src:src},
                    function (html) {
                    $("#imagenSubida").removeClass('loader');
                    $("#imagenSubida").html(html);
                    }
             ).fail(function (jqXHR, textStatus, errorThrown)
        {
                var alerta = "<p class='bg-danger'>error: "+errorThrown+"</p>";
                $("#imagenSubida").removeClass('loader');
                $("#imagenSubida").html(alerta);
       }); 
    }
    
    $(".btn-rlistFile").click(function (e) {
        $("#titleModal").html("Archivos relacionados");
        e.preventDefault();
        e.stopImmediatePropagation();
            $('#formulario_registro').modal('show');
            $(".cuerpo_registro").html('');
            $(".cuerpo_registro").addClass('loader');
            
            $.post('listFile.jsp',
            {id: localStorage.getItem("idTarea")},
                    function (html) {
                    $(".cuerpo_registro").removeClass('loader');
                    $(".cuerpo_registro").html(html);
                    }
             ).fail(function (jqXHR, textStatus, errorThrown)
            {
                var alerta = "<p class='bg-danger'>error: "+errorThrown+"</p>";
                $(".cuerpo_registro").removeClass('loader');
                $(".cuerpo_registro").html(alerta);
            });
    }); 
    
    $('.form_guardar').bootstrapValidator({
        }).on('success.form.bv', function (e) {
            // Prevent submit form
            e.preventDefault();
            $("#mensaje").show();
            $("#mensaje").addClass("loader");


            var $form = $(e.target),
                    validator = $form.data('bootstrapValidator');
            $.ajax({
                type: "POST",
                contentType: 'multipart/form-data',
                url: "guardarFile.jsp",
                type: 'POST',
                data: $(".form_guardar").serialize(),
                success: function (data)
                {
                    $("#mensaje").removeClass("loader");
                    $("#mensaje").html(data);
                }, error: function (XMLHttpRequest, textStatus, errorThrown) {
                    $("#mensaje").removeClass("loader");
                    var menn = "<p class='text-red'>Se produjo un error " + errorThrown + "  " + textStatus + "</p>";
                    $("#mensaje").html(menn);
                }
            });
        });

</script>
