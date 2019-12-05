<%@page import="Entidad.A_Tarea"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Entidad.A_ProcedimientoTarea"%>
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="_proceso" class="Controlador.A_ProcedimientoTareaController"/>
<jsp:useBean id="_path" class="Controlador.A_PathProcedimientoTareaController" />
<%
    String[] id = request.getParameter("id").split("%"); 
    A_ProcedimientoTarea procedimiento = new A_ProcedimientoTarea();
    procedimiento = _proceso.getProcedimientoById(Integer.parseInt(id[0]));
    List<A_Tarea> listaPath = new ArrayList<A_Tarea>();
    listaPath = _path.getAllPathProcedimiento(Integer.parseInt(id[0]));  
%>
<style>
    
    
    input[type=file] {
    opacity: 0;
    width: 100%;
    height: 100%;
    overflow: hidden;
}
 
#upload { 
    width: 162px;
    height: 35px;
    color: #fff;
    background-color: #511583;
    border-color: #3b0e5f;
    padding: 6px 12px;
    font-size: 14px;
    line-height: 1.42857143;
    border-radius: 3px;
    box-shadow: none;
    border: 1px solid transparent;
}
</style>
<form id="formGuardarProceso" method="post" class="formGuardarProceso">
    <input type="hidden" value="update" name="proceso" id="proceso">   
    <input type="hidden" value="<%=request.getParameter("id")%>%<%=procedimiento.getNombreProcedimiento()%>" name="id" id="id">
                    <div class="box-body">
                        <div class="form-group" >
                            <label>Nombre</label>
                            <input type="text" class="form-control" id="nombre"  name="nombre" value="<%=procedimiento.getNombreProcedimiento()%>">                            
                        </div>                         
                       
                        <div class="form-group">
                            <label>Descripción</label>
                            <textarea class="textarea"  id="descripcion"  name="descripcion" style="width: 100%; height: 300px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;"><%=procedimiento.getDescripcionProcedimiento()%></textarea>
                        </div>
                        <div class="form-group">
                            <label class="col-md-12" style="padding: 0">Cargar imagen </label>
                            <div class="col-md-8" style="padding-left: 0;">
                              <input type="text" class="form-control col-md-10" id="tituloImage"  name="tituloImage" placeholder="Título de la imagen"> 
                            </div> 
                            <div  id="upload" class="text-center col-md-4">                             
                                <input style="position: absolute;" name="file-input" id="file-input" type="file" value="" accept="image/jpg,image/jpeg,image/png,image/gif,image"/>
                                <label><i class="fa fa-upload"></i>  Subir imagen </label>
                            </div>
                        </div>
                        <div id="divImage" class="form-group col-md-12" style="margin: 10px 0 10px 0; padding: 0;">
                            <%
                                for (A_Tarea path : listaPath) {

            %>
                            <div id="divimgSalida<%=path.getIdPathProcedimiento()%>" class="col-md-2 text-center cont-image" style="border: solid 1px #aba8a8; margin: 2px;padding: 0; border-radius: 5px;">
                                <label id="imgSalida"><%=path.getNombrePath()%></label>
                                <a onclick="eliminarImagen(<%=path.getIdPathProcedimiento()%>)" id="imgSalida" type="button" class="btn-purple pull-right eliminarImage" style="padding: 0px 4px;cursor:pointer;"><i class="fa fa-close"></i></a>
                                <img id="imgSalida" width="100%" height="100%" src="../../folder_picture/Procesos/<%=path.getPathImage()%>" />
                            </div>
    <%  } %>
                        </div>
                        
                    </div>
                    <!-- /.box-body -->

                    <div class="box-footer">
                        <button type="button" class="btn btn-default pull-left btn-cProcess" data-dismiss="modal"><i class="fa fa-arrow-left"></i> Volver</button>
                        <button type="submit" class="btn-purple pull-right"><i class="fa fa-save"></i> Guardar</button>
                    </div>
                </form>
        <div id="mensaje"></div>
<script type="text/javascript">
    var nombreFichero = '';
    var numImage = 0;
    var listaImage = [];
    
    $(function() {
  $('#file-input').change(function(e) { 
      if(e != undefined){
                var f = e.target.files,
            len = f.length;
        for (var i=0;i<len;i++){
            nombreFichero = f[i].name;
        }
      addImage(e); 
      }      
       
     });

     function addImage(e){
      
      var file = e.target.files[0],
      imageType = /image.*/;
    
      if (!file.type.match(imageType))
       return;
  
      var reader = new FileReader();
      reader.onload = fileOnload;
      reader.readAsDataURL(file);
     }     
  
     function fileOnload(e) {
        $('#divImage').append('<div id="divimgSalida'+numImage+'" class="col-md-2 text-center cont-image" style="border: solid 1px #aba8a8; margin: 2px;padding: 0;border-radius: 5px;"> \n\
                                <label id="imgSalida'+numImage+'">'+$('#tituloImage').val()+'</label>\n\
                                <a onclick="eliminarImagen('+numImage+')" id="imgSalida'+numImage+'" type="button" class="btn-purple pull-right eliminarImage" style="padding: 0px 4px;cursor:pointer;"><i class="fa fa-close"></i></a>\n\
                                <img id="imgSalida'+numImage+'" width="100%" height="100%" src="" /> \n\
                            </div>');
      var result=e.target.result;
      $('.cont-image #imgSalida'+numImage).attr("src",result);
      
//      console.log("result: ", result);
      listaImage.push({id:numImage, titulo:$('#tituloImage').val(), nameImage:nombreFichero, path:$('#file-input')[0].files[0]});
  
//      saveImageDB($('#tituloImage').val(), nombreFichero);

     console.log(listaImage);
//     saveImage(e);
     numImage++; 
     $('#tituloImage').val('');
     }
    });
    
    function eliminarImagen(e){
        $("#divimgSalida"+e).remove();
        
        for (var i = 0; i < listaImage.length; i++) {
            if (listaImage[i].id == e) {
              listaImage.splice(i, 1);
              break;
            }
          }
          
       $.ajax({
            url: 'eliminarPathProceso.jsp',
            data:{idPath:e},
            type: 'post',
            success: function(response) {}
        });     
    }
    
    $(document).ready(function () {
//      -- ocultar select multiple
      $(".textarea").wysihtml5();
        $('.formGuardarProceso').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                nombre:{
                    message: 'El nombre no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'El nombre no puede ser vacio. '
                        },
                        stringLength: {
                            min: 3,
                            max: 30,
                            message: 'El nombre tiene que ser mas de 3 y menos de 30 caracteres'
                        },
                        regexp: {
                            regexp: /^([-a-z0-9_-ÀÁÂÃÈÉÊÌÍÑÒÓÔÙÚÛÝàáâãèéìíñòóùúûü-\s])+$/i,
                            message: 'El nombre solo puede constar de letras, números y guiones bajos.'
                        }
                    }
                },
                descripcion:{
                    message: 'La descripción no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'La descripción no puede ser vacio.'
                        },
                        stringLength: {
                            min: 5,
                            max: 500,
                            message: 'La descripción debe contener de 5 a 500 caracteres.'
                        },
                        regexp: {
                            regexp: /^([-a-z/()*.,%&$#¿?¡!0-9_-ÀÁÂÃÈÉÊÌÍÑÒÓÔÙÚÛÝàáâãèéìíñòóùúûü-\s])+$/i,
                            message: 'El nombre de usuario solo puede constar de letras, números y guiones bajos.'
                        }
                    }
                }
            }
        }).on('success.form.bv', function (e) {
            // Prevent submit form
            
            e.preventDefault();
            $("#mensaje").show();
            $("#mensaje").addClass("loader");

            var $form = $(e.target),
                    validator = $form.data('bootstrapValidator');
            $.ajax({
                type: "POST",
                url: "guardarProceso.jsp",
                data: $(".formGuardarProceso").serialize(),
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
    });
    
    $(".btn-cProcess").click(function (e) {
        $("#titleModal").html("Procesos");
        e.preventDefault();
        e.stopImmediatePropagation();
            $('#formulario_registro').modal('show');
            $(".cuerpo_registro").html('');
            $(".cuerpo_registro").addClass('loader');
            
            $.post('procesosTarea.jsp',
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

</script>