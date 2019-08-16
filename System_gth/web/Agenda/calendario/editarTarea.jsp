<%@page import="Entidad.A_Tarea"%>
<%@page import="Entidad.A_EstadoTarea"%>
<%@page import="Entidad.A_TipoTarea"%>
<%@page import="Entidad.A_RepeticionTarea"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<jsp:useBean id="_tipoTarea" class="Controlador.A_TipoTareaController"/>
<jsp:useBean id="_estadoTarea" class="Controlador.A_EstadoTareaController"/>
<jsp:useBean id="_tarea" class="Controlador.A_TareaController"/>
<jsp:useBean id="_repeticionTarea" class="Controlador.A_RepeticionTareaController"/>
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<%
    String id = request.getParameter("id"); 
    List<A_EstadoTarea> listaEstadoTarea = new ArrayList<A_EstadoTarea>();
    List<A_TipoTarea> listaTipoTarea = new ArrayList<A_TipoTarea>();
    List<A_RepeticionTarea> listaRepeticionTarea = new ArrayList<A_RepeticionTarea>();
    listaRepeticionTarea = _repeticionTarea.getAllRepeticionTarea();
    A_Tarea tarea = new A_Tarea();
    tarea = _tarea.getTareaById(Integer.parseInt(id));
    listaEstadoTarea = _estadoTarea.getAllEstadoTarea();
    listaTipoTarea = _tipoTarea.getAllTipoTarea();
%>
<form id="form_guardar" method="post" class="form_guardar">
    <input type="hidden" value="<%=id%>" name="id" id="id">
    <input type="hidden" value="0" name="idUsuario" id="idUsuario">
    <input type="hidden" value="<%=tarea.getFechaFinal()%>" name="ff" id="ff">
                    <div class="box-body">
                        <div class="form-group" >
                            <label>T�tulo</label>
                            <input type="text" class="form-control" id="titulo"  name="titulo" value="<%=tarea.getTitulo()%>" >                            
                        </div>                         
                        <div class="form-group">
                            <label>Color</label>

                            <div class="input-group my-colorpicker2">
                                <input type="text" class="form-control" name="color" value="<%=tarea.getColor()%>">
                              <div class="input-group-addon">
                                <i></i>
                              </div>
                            </div>
                            <!-- /.input group -->
                        </div>
                        <div class="form-group">
                            <label>Descripci�n</label>
                            <textarea class="form-control" rows="3" id="descripcion"  name="descripcion"><%=tarea.getDescripcion()%></textarea>
                        </div>
                        <div class="form-group col-md-6" style="padding-right: 0;padding-left: 0;">
                            <label>Fecha incio:</label>
                            <div class="input-group date">
                              <div class="input-group-addon">
                                <i class="fa fa-calendar"></i>
                              </div>
                              <input type="text" class="form-control pull-right" name="fi" id="datepicker1" value="<%=tarea.getFechaInicio()%>">
                            </div>
                        </div>
                        <div class="bootstrap-timepicker col-md-6" style="padding-right: 0;padding-left: 0;">
                            <div class="form-group">
                              <label>Hora</label>

                              <div class="input-group">
                                  <input type="text" class="form-control timepicker" name="horaInicio" value="<%=tarea.getHoraInicio()%>">

                                <div class="input-group-addon">
                                  <i class="fa fa-clock-o"></i>
                                </div>
                              </div>
                              <!-- /.input group -->
                            </div>
                            <!-- /.form group -->
                        </div>
                        <div class="form-group col-md-6" style="padding-right: 0;padding-left: 0;">
                            <label>Fecha final:</label>
                            <div class="input-group date">
                              <div class="input-group-addon">
                                <i class="fa fa-calendar"></i>
                              </div>
                              <input type="text" class="form-control pull-right" name="fechaFinal" id="datepicker2" value="<%=tarea.getFechaFinal()%>">
                            </div>
                        </div>
                        <div class="bootstrap-timepicker col-md-6" style="padding-right: 0;padding-left: 0;">
                            <div class="form-group">
                              <label>Hora</label>

                              <div class="input-group">
                                <input type="text" class="form-control timepicker" name="horaFinal" value="<%=tarea.getHoraFinal()%>">

                                <div class="input-group-addon">
                                  <i class="fa fa-clock-o"></i>
                                </div>
                              </div>
                              <!-- /.input group -->
                            </div>
                            <!-- /.form group -->
                        </div>
                        <div class="form-group">
                            <label>Repetir cada</label>
                            <select name="idRepeticion"  class="form-control select2" style="width: 100%;">
                              <option disabled selected="selected">Selecione una opci�n</option>
                              <%
                                    
                                    for(A_RepeticionTarea item : listaRepeticionTarea){
                                        if(item.getEstadoRepeticion()== 1){
                                        String Seleccionar = "";    
                                    if (item.getIdRepeticionTarea() == tarea.getIdRepeticionTarea()) {
                                            Seleccionar = "Selected";
                                        }
                                    %>
                                   <option value="<%=item.getIdRepeticionTarea()%>" <%=Seleccionar%>><%=item.getNombreRepeticion()%></option>
                               <% } } %>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Categoria</label>
                            <select name="idCategoria"  class="form-control select2" style="width: 100%;">
                              <option disabled selected="selected">Selecione una opci�n</option>
                              <%
                                    String Select = "";
                                    for(A_TipoTarea item : listaTipoTarea){
                                        if(item.getEstadoTipoTarea()== 1){
                                            
                                    if (item.getIdTipoTarea()== tarea.getIdTipoTarea()) {
                                            Select = "Selected";
                                        }
                                    %>
                                   <option value="<%=item.getIdTipoTarea()%>" <%=Select%>><%=item.getNombreTarea()%></option>
                               <% } } %>
                            </select>
                        </div>
                         <div class="form-group">
                            <label>Estado</label>
                            <select name="idEstado" class="form-control select2" style="width: 100%;">
                              <option disabled selected="selected">Selecione una opci�n</option>
                              <%
                                    String Selec = "";
                                    for(A_EstadoTarea item : listaEstadoTarea){
                                        if(item.getEstadoEstadoTarea()== 1){
                                            if (item.getIdEstadoTarea()== tarea.getIdEstadoTarea()) {
                                            Selec = "Selected";
                                        }
                                            %>
                                   <option value="<%=item.getIdEstadoTarea()%>" <%=Selec%>><%=item.getNombreEstadoTarea()%></option>
                               <% } } %>
                            </select>
                        </div>
                    </div>
                    <!-- /.box-body -->

                    <div class="box-footer">
                        <button type="button" class="btn btn-danger pull-left btn_eliminar"><i class="fa fa-trash"></i> Eliminar</button>
                        <button type="submit" class="btn btn-purple pull-right"><i class="fa fa-refresh"></i> Actualizar</button>
                    </div>
                </form>
        <div id="mensaje"></div>
<script type="text/javascript">
    $(document).ready(function () {
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
        $('#datepicker2').datepicker({
            format: 'dd/mm/yyyy',
          autoclose: true
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
                    message: 'El nombre no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'El nombre no puede ser vacio. '
                        },
                        stringLength: {
                            min: 3,
                            max: 30,
                            message: 'El nombre tiene que ser mas de 6 y menos de 30 caracteres'
                        },
                        regexp: {
                            regexp: /^([-a-z0-9_-��������������������������������-\s])+$/i,
                            message: 'El nombre solo puede constar de letras, n�meros y guiones bajos.'
                        }
                    }
                },
                color:{
                    message: 'El color no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'El color no puede ser vacio.'
                        },
                        stringLength: {
                            min: 7,
                            max: 20,
                            message: 'El color debe contener 7 a 20 caracteres.'
                        },
                        regexp: {
                            regexp: /^([a-z0-9.,()#_-��������������������������������-\s])+$/i,
                            message: 'El color solo puede constar de n�meros, #, (), comas, puntos y letras.'
                        }
                    }
                },
                descripcion:{
                    message: 'La descripci�n no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'La descripci�n no puede ser vacio.'
                        },
                        stringLength: {
                            min: 5,
                            max: 500,
                            message: 'La descripci�n debe contener de 5 a 500 caracteres.'
                        },
                        regexp: {
                            regexp: /^([-a-z0-9_-��������������������������������-\s])+$/i,
                            message: 'El nombre de usuario solo puede constar de letras, n�meros y guiones bajos.'
                        }
                    }
                },
                fi:{
                    message: 'La fecha de inicio no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'La fecha de inicio no puede ser vacio.'
                        }
                    }
                },
                fechaFinal:{
                    message: 'La fecha final no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'La fecha final no puede ser vacio.'
                        }
                    }
                },
                idCategoria:{
                    message: 'La categoria no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'La categoria no puede ser vacio.'
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
        
        $(".btn_eliminar").click(function () {
            $("#mensaje").show();
            $("#mensaje").addClass("loader");
            $.post('eliminarTarea.jsp',
                    {id: $("#id").val()},
                    function (html) {
                        $("#mensaje").removeClass('loader');
                        $("#mensaje").html(html);
                    }
            );
        });
    });


</script>