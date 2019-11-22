<%@page import="Entidad.A_EstadoTarea"%>
<%@page import="Entidad.A_RepeticionTarea"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<jsp:useBean id="_estadoTarea" class="Controlador.A_EstadoTareaController"/>
<jsp:useBean id="_repeticionTarea" class="Controlador.A_RepeticionTareaController"/>
<%
    String idUsuario = request.getParameter("id");    
    List<A_EstadoTarea> listaEstadoTarea = new ArrayList<A_EstadoTarea>();

    List<A_RepeticionTarea> listaRepeticionTarea = new ArrayList<A_RepeticionTarea>();
    listaRepeticionTarea = _repeticionTarea.getAllRepeticionTarea();
    listaEstadoTarea = _estadoTarea.getAllEstadoTarea();

%>
<form id="form_guardar" method="post" class="form_guardar" enctype="multipart/form-data">
    <input type="hidden" value="insert" name="proceso" id="proceso">
    <input type="hidden" value="0" name="id" id="id">
    <input type="hidden" value="<%=idUsuario%>" name="idUsuario" id="idUsuario">
                    <div class="box-body">
                        <div class="form-group" >
                            <label>TÌtulo</label>
                            <input type="text" class="form-control" id="titulo"  name="titulo">                            
                        </div>                         
                        <div id="description" class="form-group">
                            <label>DescripciÛn </label>
                            <textarea  class="textarea"  id="descripcion"  name="descripcion" style="width: 100%; height: 300px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;"></textarea>
                            <!--<textarea id="descripcion"  name="descripcion"></textarea>-->
                        </div>
                        <div class="form-group">
                            <label>Cargar imagen </label>
                            <input type="text" class="form-control" id="tituloImage"  name="tituloImage" placeholder="TÌtulo de la imagen"> 
                            <input name="file-input" id="file-input" type="file"/>
                        </div>
                        <div id="divImage" class="form-group row" style="margin: 2px;">
                        </div>
                        <div class="row" >
                            <div class="form-group col-md-6">
                            <label>Repetir cada</label>
                            <select id="idRepeticion" name="idRepeticion"  class="form-control select2" style="width: 100%;">
                                <option value="0" disabled selected="selected">Selecione una opciÛn</option>
                              <%
                                    for(A_RepeticionTarea item : listaRepeticionTarea){
                                        if(item.getEstadoRepeticion()== 1){
                                            %>
                                   <option value="<%=item.getIdRepeticionTarea()%>"><%=item.getNombreRepeticion()%></option>
                               <% } } %>
                            </select>
                        </div>
                        <div id="fechaInicio" class="form-group col-md-6" >
                            <label>Fecha incio:</label>
                            <div class="input-group date">
                              <div class="input-group-addon">
                                <i class="fa fa-calendar"></i>
                              </div>
                              <input type="text" class="form-control pull-right" name="fi" id="datepicker1" autocomplete="off">
                            </div>
                        </div>
                        </div>
                        
                            <div class="row row-days">
                                <div class="form-group col-sm-1 col-day">
                                    <label>Domingo</label>
                                    <input type="checkbox" name="D" id="D"  class="flat-red">
                                </div>
                                <div class="form-group col-sm-1 col-day">
                                    <label>Lunes</label>
                                    <input type="checkbox" name="L" id="L"  class="flat-red">
                                </div>
                                <div class="form-group col-sm-1 col-day">
                                    <label>Martes</label>
                                    <input type="checkbox" name="Ma" id="Ma"  class="flat-red">
                                </div>
                                <div class="form-group col-sm-1 col-day">
                                    <label>Miercoles</label>
                                    <input type="checkbox" name="Mi" id="Mi"  class="flat-red">
                                </div>
                                <div class="form-group col-sm-1 col-day">
                                    <label>Jueves</label>
                                    <input type="checkbox" name="J" id="J"  class="flat-red">
                                </div>
                                <div class="form-group col-sm-1 col-day">
                                    <label>Viernes</label>
                                    <input type="checkbox" name="V" id="V"  class="flat-red">
                                </div>
                                <div class="form-group col-sm-1 col-day">
                                    <label>S·bado</label>
                                    <input type="checkbox" name="S" id="S"  class="flat-red">
                                </div>
                            </div>
                            
                            <div id="horaInicio" class="bootstrap-timepicker" style="padding-right: 0;padding-left: 0;">
                            <div class="form-group">
                              <label>Hora</label>

                              <div class="input-group">
                                  <input type="text" class="form-control timepicker" name="horaInicio" autocomplete="off">

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
                              <option disabled selected="selected">Selecione una opciÛn</option>
                              <%
                                    for(A_EstadoTarea item : listaEstadoTarea){
                                        String select = "";
                                        if(item.getIdEstadoTarea() == 6)
                                            select = "Selected";
                                        if(item.getEstadoEstadoTarea()== 1){
                                            %>
                                   <option value="<%=item.getIdEstadoTarea()%>" <%=select%>><%=item.getNombreEstadoTarea()%></option>
                               <% } } %>
                            </select>
                        </div>
                       
                    </div>
                    <!-- /.box-body -->

                    <div class="box-footer">
                        <button type="button" class="btn btn-default pull-left" data-dismiss="modal"><i class="fa fa-close"></i> Cancelar</button>
                        <button id="btnGuardar" type="submit" class="btn-purple pull-right"><i class="fa fa-save"></i> Guardar</button>
                        <button id="btnProcess" type="button" class="btn-purple pull-right" data-dismiss="modal"><i class="fa fa-plus"></i> Agregar procesos</button>
                    </div>
                </form>
        <div id="mensaje"></div>
<script type="text/javascript">
    
    var numImage = 1;
    
    $("#file-input").click(function (e) {
        
        
        
        console.log("num: ", numImage);
    });
    

 $(function() {
  $('#file-input').change(function(e) {      
      addImage(e); 
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
        $('#divImage').append('<div id="divimgSalida'+numImage+'" class="col-md-2 text-center cont-image" style="border: solid 1px #aba8a8; margin: 2px;padding: 0;"> \n\
                                <label id="imgSalida'+numImage+'">'+$('#tituloImage').val()+'</label>\n\
                                <a onclick="eliminarImagen(imgSalida'+numImage+')" id="imgSalida'+numImage+'" type="button" class="btn-purple pull-right eliminarImage" style="padding: 0px 4px;cursor:pointer;"><i class="fa fa-close"></i></a>\n\
                                <img id="imgSalida'+numImage+'" width="100%" height="100%" src="" /> \n\
                            </div>');
      var result=e.target.result;
      $('.cont-image #imgSalida'+numImage).attr("src",result);
      
      console.log("result: ", result);
      
      $.post('guardarFile.jsp',
            {id: 1, path:result},
                    function (html) {
                    $("#imgSalida"+numImage).removeClass('loader');
                    $("#imgSalida"+numImage).html(html);
                    }
             ).fail(function (jqXHR, textStatus, errorThrown)
            {
                var alerta = "<p class='bg-danger'>error: "+errorThrown+"</p>";
                $("#imgSalida"+numImage).removeClass('loader');
                $("#imgSalida"+numImage).html(alerta);
            });
     numImage++; 
     $('#tituloImage').val('');
     }
    });
    
    function eliminarImagen(e){
        $("#div"+e[1].id).remove();
    }
    
    $(document).ready(function () {
//
//        $('#descripcion').Editor();
//        $('#descripcion').Editor('setText', ['<p style="color:#a29e9e;">DescripciÛn de la tarea</p>']);
    //bootstrap WYSIHTML5 - text editor
    $(".textarea").wysihtml5();
    $('#btnProcess').hide();
        //Timepicker
    $(".timepicker").timepicker({
      showInputs: false,
      defaultTime: false
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
//        ocultar select multiple
        $(".row-days").hide();
        $("#horaInicio").hide();
        $('#idRepeticion').on('change', function() {
            
            switch(this.value){
                case '1':
                    $(".row-days").hide();
                    $("#horaInicio").hide();
                    break;
                case '2':
                    $(".row-days").hide();
                    $("#horaInicio").show();
                    break;
                case '3':
                    $("#horaInicio").hide();
                    $(".row-days").show();
                    break;
                case '4':
                    $("#horaInicio").hide();
                    $(".row-days").hide();
                    break;
                case '5':
                    $("#horaInicio").hide();
                    $(".row-days").hide();
                    break;
                case '6':
                    $("#horaInicio").hide();
                    $(".row-days").hide();
                    break;
                case '7':
                    $("#horaInicio").hide();
                    $(".row-days").hide();
                    break;
                default:
                    $(".row-days").hide();
                    $("#horaInicio").hide();
                    
            }

        });
//      -- ocultar select multiple   
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
                            regexp: /^([-a-z0-9_-¿¡¬√»… ÃÕ—“”‘Ÿ⁄€›‡·‚„ËÈÏÌÒÚÛ˘˙˚¸-\s])+$/i,
                            message: 'El titulo solo puede constar de letras, n˙meros y guiones bajos.'
                        }
                    }
                },
                descripcion:{
                    message: 'La descripciÛn no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'La descripciÛn no puede ser vacio.'
                        },
                        stringLength: {
                            min: 5,
                            max: 500,
                            message: 'La descripciÛn debe contener de 5 a 500 caracteres.'
                        },
                        regexp: {
                            regexp: /^([-a-z/()*.,%&$#ø?°!0-9_-¿¡¬√»… ÃÕ—“”‘Ÿ⁄€›‡·‚„ËÈÏÌÒÚÛ˘˙˚¸-\s])+$/i,
                            message: 'El nombre de usuario solo puede constar de letras, n˙meros y guiones bajos.'
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
                    message: 'El estado no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'El estado no puede ser vacio.'
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
    });
   
    
    $("#btnProcess").click(function (e) {
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