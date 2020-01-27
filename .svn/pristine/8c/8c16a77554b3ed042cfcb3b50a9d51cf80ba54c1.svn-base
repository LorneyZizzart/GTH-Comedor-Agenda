<%@page import="Entidad.A_PathTarea"%>
<%@page import="Entidad.A_Tarea"%>
<%@page import="Entidad.A_EstadoTarea"%>
<%@page import="Entidad.A_RepeticionTarea"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<jsp:useBean id="_estadoTarea" class="Controlador.A_EstadoTareaController"/>
<jsp:useBean id="_tarea" class="Controlador.A_TareaController"/>
<jsp:useBean id="_repeticionTarea" class="Controlador.A_RepeticionTareaController"/>
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="_path" class="Controlador.A_PathTareaController"/>
<%
    String[] id = request.getParameter("id").split("%"); 
    List<A_EstadoTarea> listaEstadoTarea = new ArrayList<A_EstadoTarea>();
    List<A_RepeticionTarea> listaRepeticionTarea = new ArrayList<A_RepeticionTarea>();
    List<A_PathTarea> listaPath = new ArrayList<A_PathTarea>();

    listaRepeticionTarea = _repeticionTarea.getAllRepeticionTarea();
    A_Tarea tarea = new A_Tarea();
    tarea = _tarea.getTareaByTitulo(id[0], Integer.parseInt(id[1]));
    listaEstadoTarea = _estadoTarea.getAllEstadoTarea();
    listaPath = _path.getAllPath(id[0], Integer.parseInt(id[1]));
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
<form id="form_guardar" method="post" class="form_guardar">
    <input type="hidden" value="update" name="proceso" id="proceso">
    <input type="hidden" value="<%=tarea.getIdTarea()%>" name="id" id="id">
    <input type="hidden" value="<%=id[0]%>" name="oldTitulo" id="oldTitulo">
    <input type="hidden" value="<%=id[1]%>" name="idFunc" id="idFunc">
                    <div class="box-body">                      
                        <div class=" form-group" >
                            <label>Título</label>
                            <input type="text" class="form-control" id="titulo"  name="titulo" value="<%=tarea.getTitulo()%>">                            
                        </div>                         
                        <div id="campoDescripcion" class="form-group">
                            <label>Descripción </label>
                            <textarea class="textarea"  id="descripcion"  name="descripcion" style="width: 100%; height: 300px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;"><%=tarea.getDescripcion()%></textarea>
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
                                for (A_PathTarea path : listaPath) {

                                    %>
                                  <div id="divimgSalida<%=path.getIdPath()%>" class="col-md-2 text-center cont-image" style="border: solid 1px #aba8a8; margin: 2px;padding: 0; border-radius: 5px;">
                                        <label id="imgSalida"><%=path.getNombrePath()%></label>
                                        <a onclick="eliminarImagen(<%=path.getIdPath()%>)" id="imgSalida<%=path.getIdPath()%>" type="button" class="btn-purple pull-right eliminarImage" style="padding: 0px 4px;cursor:pointer;"><i class="fa fa-close"></i></a>
                                        <img id="imgSalida<%=path.getIdPath()%>" width="100%" height="100%" src="../../folder_picture/Tareas/<%=path.getPathImage()%>" />
                                    </div>
                            <%  } %>
                        </div>
                        <div class="row" >
                                                       <div class="form-group col-md-6">
                            <label>Repetir cada</label>
                            <select id="idRepeticion" name="idRepeticion"  class="form-control select2" style="width: 100%;">
                                <option value="0" disabled selected="selected">Selecione una opción</option>
                              <%
                                    for(A_RepeticionTarea item : listaRepeticionTarea){
                                        String select = "";
                                        String disabled = "";
                                        if(tarea.getIdRepeticionTarea() == item.getIdRepeticionTarea())
                                            select = "Selected";
                                        if(item.getEstadoRepeticion() != 1){
                                            disabled = "disabled";
                                        }                                       
                                            %>
                                   <option value="<%=item.getIdRepeticionTarea()%>" <%=select%> <%=disabled%>><%=item.getNombreRepeticion()%></option>
                               <% } %>
                            </select>
                        </div>
                            <div id="fechaInicio" class="form-group col-md-6" >
                            <label>Fecha incio:</label>
                            <div class="input-group date">
                              <div class="input-group-addon">
                                <i class="fa fa-calendar"></i>
                              </div>
                                <input type="text" class="form-control pull-right" name="fi" id="datepicker1" autocomplete="off" value="<%=tarea.getFechaInicio()%>">
                            </div>
                        </div> 
                        </div>


                        
                            <div class="row row-days">
                                <div class="form-group col-sm-1 col-day">
                                    <label>D</label>
                                    <%
                                        String d = "";
                                        if(tarea.getDomingo() > 0){
                                            d = "checked";
                                        }
                                    %>
                                    <input type="checkbox" name="D" id="D"  class="flat-red" <%=d%>>
                                </div>
                                <div class="form-group col-sm-1 col-day">
                                    <label>L</label>
                                    <%
                                        String l = "";
                                        if(tarea.getLunes()> 0){
                                            l = "checked";
                                        }
                                    %>
                                    <input type="checkbox" name="L" id="L"  class="flat-red" <%=l%>>
                                </div>
                                <div class="form-group col-sm-1 col-day">
                                    <label>M</label>
                                    <%
                                        String ma = "";
                                        if(tarea.getMartes()> 0){
                                            ma = "checked";
                                        }
                                    %>
                                    <input type="checkbox" name="Ma" id="Ma"  class="flat-red" <%=ma%>>
                                </div>
                                <div class="form-group col-sm-1 col-day">
                                    <label>M</label>
                                    <%
                                        String mi = "";
                                        if(tarea.getMiercoles()> 0){
                                            mi = "checked";
                                        }
                                    %>
                                    <input type="checkbox" name="Mi" id="Mi"  class="flat-red" <%=mi%>>
                                </div>
                                <div class="form-group col-sm-1 col-day">
                                    <label>J</label>
                                    <%
                                        String j = "";
                                        if(tarea.getJueves()> 0){
                                            j = "checked";
                                        }
                                    %>
                                    <input type="checkbox" name="J" id="J"  class="flat-red" <%=j%>>
                                </div>
                                <div class="form-group col-sm-1 col-day">
                                    <label>V</label>
                                    <%
                                        String v = "";
                                        if(tarea.getViernes()> 0){
                                            v = "checked";
                                        }
                                    %>
                                    <input type="checkbox" name="V" id="V"  class="flat-red" <%=v%>>
                                </div>
                                <div class="form-group col-sm-1 col-day">
                                    <label>S</label>
                                    <%
                                        String s = "";
                                        if(tarea.getSabado()> 0){
                                            s = "checked";
                                        }
                                    %>
                                    <input type="checkbox" name="S" id="S"  class="flat-red" <%=s%>>
                                </div>
                            </div>
                            
                            <div id="horaInicio" class="bootstrap-timepicker" style="padding-right: 0;padding-left: 0;">
                            <div class="form-group">
                              <label>Hora</label>

                              <div class="input-group">
                                  <input type="text" class="form-control timepicker" name="horaInicio" autocomplete="off" <%=tarea.getHoraInicio()%>>

                                <div class="input-group-addon">
                                  <i class="fa fa-clock-o"></i>
                                </div>
                              </div>
                              <!-- /.input group -->
                            </div>
                            <!-- /.form group -->
                        </div>
                         <div class="form-group">
                            <label>Estado</label>
                            <select name="idEstado" class="form-control select2" style="width: 100%;">
                              <option disabled selected="selected">Selecione una opción</option>
                              <%
                                    for(A_EstadoTarea item : listaEstadoTarea){
                                        String select = "";
                                        if(tarea.getIdEstadoTarea() == item.getIdEstadoTarea())
                                            select = "Selected";
                                        if(item.getEstadoEstadoTarea()== 1){
                                            %>
                                   <option value="<%=item.getIdEstadoTarea()%>" <%=select%>><%=item.getNombreEstadoTarea()%></option>
                               <% } } %>
                            </select>
                        </div>
                    
                    <!-- /.box-body -->
                    </div>  
                    <div class="box-footer">
                        <button type="button" class="btn btn-default pull-left" data-dismiss="modal"><i class="fa fa-close"></i> Cancelar</button>
                        <button type="submit" class="btn-purple pull-right"><i class="fa fa-save"></i> Guardar</button>
                    </div>
                </form>
        <div id="mensaje"></div>
<script type="text/javascript">
    
    var nombreFichero = 'notImage.jpg';
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
        $('#divImage').append('<div id="divimgSalida'+numImage+'" class="col-md-2 text-center cont-image" style="border: solid 1px #aba8a8; margin: 2px;padding: 0; border-radius: 5px;"> \n\
                                <label id="imgSalida'+numImage+'">'+$('#tituloImage').val()+'</label>\n\
                                <a onclick="eliminarImagen('+numImage+')" id="imgSalida'+numImage+'" type="button" class="btn-purple pull-right eliminarImage" style="padding: 0px 4px;cursor:pointer;"><i class="fa fa-close"></i></a>\n\
                                <img id="imgSalida'+numImage+'" width="100%" height="100%" src="" /> \n\
                            </div>');
      var result=e.target.result;
      $('.cont-image #imgSalida'+numImage).attr("src",result);
      
//      console.log("result: ", result);
      listaImage.push({id:numImage, titulo:$('#tituloImage').val(), nameImage:nombreFichero, path:e});
  
//      saveImageDB($('#tituloImage').val(), nombreFichero);

     console.log(listaImage);
     saveImage(e);
     numImage++; 
     $('#tituloImage').val('');
     }
    });
    
    function saveImage(e) {        
//      PARA GUARDAR LA IMAGEN
        var formData = new FormData();
        var files = $('#file-input')[0].files[0];
//        var files = e;

        formData.append('file',files);
        $.ajax({
            url: 'guardarFile.jsp',
            type: 'post',
            data: formData, 
            contentType: false,
            processData: false,
            success: function(data) {

            }
        });
    }
    
    function saveImageDB(idTarea, name, path){
        $.ajax({
            url: 'guardarFileDB.jsp',
            data:{idTarea:idTarea, name:name, path:path},
            type: 'post',
            success: function(response) {
                if (response != 0) {
//                    $(".card-img-top").attr("src", response);
//                    cargarImagen('../../folder_picture/diagrama-de-sectores.png');
//                        cargarImagen('../../folder_picture/'+nombreFichero);
                } else {
                    alert('Formato de imagen incorrecto.');
                }
            }
        });
    }
    
    function eliminarImagen(e){
        $("#divimgSalida"+e).remove();
        
        for (var i = 0; i < listaImage.length; i++) {
            if (listaImage[i].id == e) {
              listaImage.splice(i, 1);
              break;
            }
          }
          
       $.ajax({
            url: 'eliminarPath.jsp',
            data:{idPath:e},
            type: 'post',
            success: function(response) {}
        });     
    }
    
    
    $(document).ready(function () {
    //bootstrap WYSIHTML5 - text editor
    $(".textarea").wysihtml5();

    //Timepicker
    $(".timepicker").timepicker({
      showInputs: false
    });
        //color picker with addon
    $(".my-colorpicker2").colorpicker();
        //Initialize Select2 Elements
        $(".select2").select2();
        //Date picker
        $('#datepicker1').datepicker({
            format: 'dd/mm/yyyy',
          autoclose: true
        });
        switch($('#idRepeticion').val()){
            case '1':
                    $(".row-days").hide();
                    $("#fechaInicio").show();
                    $("#horaInicio").hide();
                    break;
                case '2':
                    $("#fechaInicio").show();
                    $(".row-days").hide();
                    $("#horaInicio").show();
                    break;
                case '3':
                    $("#horaInicio").hide();
                    $("#fechaInicio").show();
                    $(".row-days").show();
                    break;
                case '4':
                    $("#horaInicio").hide();
                    $(".row-days").hide();
                    $("#fechaInicio").show();
                    break;
                case '5':
                    $("#horaInicio").hide();
                    $(".row-days").hide();
                    $("#fechaInicio").show();
                    break;
                case '6':
                    $("#horaInicio").hide();
                    $(".row-days").hide();
                    $("#fechaInicio").show();
                    break;
                case '7':
                    $("#horaInicio").hide();
                    $(".row-days").hide();
                    $("#fechaInicio").show();
                    break;
                default:
                    $(".row-days").hide();
                    $("#fechaInicio").hide();
                    $("#horaInicio").hide();
            
        }
//        ocultar select multiple
        $('#idRepeticion').on('change', function() {
            
            switch(this.value){
                case '1':
                    $(".row-days").hide();
                    $("#fechaInicio").show();
                    $("#horaInicio").hide();
                    break;
                case '2':
                    $("#fechaInicio").show();
                    $(".row-days").hide();
                    $("#horaInicio").show();
                    break;
                case '3':
                    $("#horaInicio").hide();
                    $("#fechaInicio").show();
                    $(".row-days").show();
                    break;
                case '4':
                    $("#horaInicio").hide();
                    $(".row-days").hide();
                    $("#fechaInicio").show();
                    break;
                case '5':
                    $("#horaInicio").hide();
                    $(".row-days").hide();
                    $("#fechaInicio").show();
                    break;
                case '6':
                    $("#horaInicio").hide();
                    $(".row-days").hide();
                    $("#fechaInicio").show();
                    break;
                case '7':
                    $("#horaInicio").hide();
                    $(".row-days").hide();
                    $("#fechaInicio").show();
                    break;
                default:
                    $(".row-days").hide();
                    $("#fechaInicio").hide();
                    $("#horaInicio").hide();
                    
            }
       
        });
    });
    
    $('.form_guardar').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                titulo:{
                    message: 'El titulo no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'El titulo no puede ser vacio. '
                        },
                        stringLength: {
                            min: 3,
                            max: 100,
                            message: 'El titulo tiene que ser mas de 3 y menos de 100 caracteres'
                        },
                        regexp: {
                            regexp: /^([-a-z0-9_-ÀÁÂÃÈÉÊÌÍÑÒÓÔÙÚÛÝàáâãèéìíñòóùúûü-\s])+$/i,
                            message: 'El titulo solo puede constar de letras, números y guiones bajos.'
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
                },
                idEstado:{
                    message: 'El estado no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'El estado no puede ser vacio.'
                        }
                    }
                },
                idRepeticion:{
                    message: 'La repeticón no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'La repeticón no puede ser vacio.'
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
                url: "guardarTarea.jsp",
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