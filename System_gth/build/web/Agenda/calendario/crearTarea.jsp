<%@page import="java.util.Calendar"%>
<%@page import="Entidad.Empleado"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>   
<%@page import="Entidad.A_EstadoTarea"%>
<%@page import="Entidad.A_TipoTarea"%>
<%@page import="Entidad.A_RepeticionTarea"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<jsp:useBean id="_tipoTarea" class="Controlador.A_TipoTareaController"/>
<jsp:useBean id="_empleado" class="Controlador.EmpleadoController" />
<jsp:useBean id="_estadoTarea" class="Controlador.A_EstadoTareaController"/>
<jsp:useBean id="_repeticionTarea" class="Controlador.A_RepeticionTareaController"/>
<%
    String idUsuario = request.getParameter("idUser");    
    String dataStart = request.getParameter("fechaInicio");
    String dataEnd = request.getParameter("fechaFin");
    List<A_EstadoTarea> listaEstadoTarea = new ArrayList<A_EstadoTarea>();
    List<A_TipoTarea> listaTipoTarea = new ArrayList<A_TipoTarea>();
    List<A_RepeticionTarea> listaRepeticionTarea = new ArrayList<A_RepeticionTarea>();
    List<Empleado> listaEmpleado = new ArrayList<Empleado>();
    listaRepeticionTarea = _repeticionTarea.getAllRepeticionTarea();
    listaEstadoTarea = _estadoTarea.getAllEstadoTarea();
    listaTipoTarea = _tipoTarea.getAllTipoTarea();
    listaEmpleado = _empleado.GetAllEmpleado();
    SimpleDateFormat parseador = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
    Calendar calendar = Calendar.getInstance();  
    
    Date dateStart = parseador.parse(dataStart);
    Date dateEnd = parseador.parse(dataEnd);
    calendar.setTime(dateEnd);
    calendar.add(Calendar.DAY_OF_MONTH, -1);
    dateEnd = parseador.parse(String.valueOf(calendar.get(Calendar.DATE)+"/"+(Integer.parseInt(String.valueOf(calendar.get(Calendar.MONTH)))+1)+"/"+calendar.get(Calendar.YEAR)));
    
%>
<form id="form_guardar" method="post" class="form_guardar" enctype="multipart/form-data">
    <input type="hidden" value="0" name="id" id="id">
    <input type="hidden" value="<%=idUsuario%>" name="idUsuario" id="idUsuario">
    <input type="hidden" value="<%=formateador.format(dateEnd)%>" name="ff" id="ff">
                    <div class="box-body">
                        <div class="form-group" >
                            <label>T�tulo</label>
                            <input type="text" class="form-control" id="titulo"  name="titulo">                            
                        </div>                         
                        <div class="form-group">
                            <label>Color</label>

                            <div class="input-group my-colorpicker2">
                                <input type="text" class="form-control" name="color">
                              <div class="input-group-addon">
                                <i></i>
                              </div>
                            </div>
                            <!-- /.input group -->
                        </div>
                        <div class="form-group">
                            <label>Descripci�n</label>
                            <textarea class="form-control" rows="3" id="descripcion"  name="descripcion"></textarea>
                        </div>
                        <div class="form-group" >
                            <label>Seleccionar archivo</label>
                            <input type="file" id="archivo"  name="archivo" onchange="cargarArchivo(this)"> 
                            <input type="submit" name="proceso" value="procesar">
                            <input type="hidden" name="nombreArchivo">
                            <iframe name="null" style="display: none;"></iframe>
                        </div>
                        <div class="form-group col-md-6" style="padding-right: 0;padding-left: 0;">
                            <label>Fecha incio:</label>
                            <div class="input-group date">
                              <div class="input-group-addon">
                                <i class="fa fa-calendar"></i>
                              </div>
                                <input type="text" class="form-control pull-right" name="fi" id="datepicker1" value="<%=formateador.format(dateStart)%>">
                            </div>
                        </div>
                        <div class="bootstrap-timepicker col-md-6" style="padding-right: 0;padding-left: 0;">
                            <div class="form-group">
                              <label>Hora</label>

                              <div class="input-group">
                                  <input type="text" class="form-control timepicker" name="horaInicio">

                                <div class="input-group-addon">
                                  <i class="fa fa-clock-o"></i>
                                </div>
                              </div>
                              <!-- /.input group -->
                            </div>
                            <!-- /.form group -->
                        </div>
                        <div class="form-group col-md-6" style="padding-right: 0;padding-left: 0;">
                            <label>Fecha final</label>
                            <div class="input-group date">
                              <div class="input-group-addon">
                                <i class="fa fa-calendar"></i>
                              </div>
                                <input type="text" class="form-control pull-right" name="fechaFinal" id="datepicker2" value="<%=formateador.format(dateEnd)%>">
                            </div>
                        </div>
                        <div class="bootstrap-timepicker col-md-6" style="padding-right: 0;padding-left: 0;">
                            <div class="form-group">
                              <label>Hora</label>

                              <div class="input-group">
                                <input type="text" class="form-control timepicker" name="horaFinal">

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
                                            %>
                                   <option value="<%=item.getIdRepeticionTarea()%>"><%=item.getNombreRepeticion()%></option>
                               <% } } %>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Categoria</label>
                            <select id="idCategoria" name="idCategoria"  class="form-control select2" style="width: 100%;" >
                                <option disabled selected="selected" value="0">Selecione una opci�n</option>
                              <%
                                    for(A_TipoTarea item : listaTipoTarea){
                                        if(item.getEstadoTipoTarea()== 1){
                                            %>
                                   <option value="<%=item.getIdTipoTarea()%>"><%=item.getNombreTarea()%></option>
                               <% } } %>
                            </select>
                        </div>
                        <div class="form-group frm-funcionario">
                            <label>Funcionario(s)</label>
                            <select name="funcionario" class="form-control select2" multiple="multiple" data-placeholder="Selecionar funcionario" style="width: 100%;">
                              <%
                                    for(Empleado item : listaEmpleado){
                                        if(item.getEstado()== 1){
                                            %>
                                   <option value="<%=item.getEmpleado_id()%>"><%=item.getApellido_paterno()%> <%=item.getApellido_materno()%> <%=item.getNombre()%></option>
                               <% } } %>
                            </select>
                        </div>
                         <div class="form-group">
                            <label>Estado</label>
                            <select name="idEstado" class="form-control select2" style="width: 100%;">
                              <option disabled selected="selected">Selecione una opci�n</option>
                              <%
                                    for(A_EstadoTarea item : listaEstadoTarea){
                                        if(item.getEstadoEstadoTarea()== 1){
                                            %>
                                   <option value="<%=item.getIdEstadoTarea()%>"><%=item.getNombreEstadoTarea()%></option>
                               <% } } %>
                            </select>
                        </div>
                    </div>
                    <!-- /.box-body -->

                    <div class="box-footer">
                        <button type="button" class="btn btn-default pull-left" data-dismiss="modal"><i class="fa fa-close"></i> Cancelar</button>
                        <button type="submit" class="btn-purple pull-right"><i class="fa fa-save"></i> Guardar</button>
                    </div>
                </form>
        <div id="mensaje"></div>
<script type="text/javascript">

    function cargarArchivo(elemento){
        var file = elemento.files[0];
        var objHidden = document.getElementsByName("nombreArchivo");
        objHidden.value = file.name;
        document.getElementsByName('#form_guardar').target = "null";
        document.getElementsByName('#form_guardar').action = "procesoArchivo";
        document.getElementsByName('#form_guardar').submit;
//        console.log(objHidden.value);
        alert("proceso terminado");
    }

    $(document).ready(function () {
        $(".frm-funcionario").hide();
        $('#idCategoria').on('change', function() {
            if(this.value == '3')
            $(".frm-funcionario").show();
            else $(".frm-funcionario").hide();
        });

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
                hoarInicio:{
                    message: 'La hora no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'La hora no puede ser vacio.'
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


</script>