<%@page import="Entidad.Empleado"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<jsp:useBean id="_empleado" class="Controlador.EmpleadoController" />
<%
    String idUsuario =  request.getParameter("id");
    List<Empleado> listaEmpleado = new ArrayList<Empleado>();
    listaEmpleado = _empleado.GetAllEmpleado();
%>
<form id="frm_guardar" method="post" class="frm_guardar" >
    <input type="hidden" value="0" name="id" id="id">
    <input type="hidden" value="<%=idUsuario%>" name="idUsuario" id="idUsuario">
    <div class="box-body">
                        <div class="form-group" >
                            <label>Paso</label>
                            <input type="text" class="form-control" id="paso"  name="paso">                            
                        </div> 
                        <div class="form-group col-md-6" style="padding-right: 10px; padding-left: 0px;">
                        <label>Responsable</label>
                            <input type="text" class="form-control" id="responsable"  name="responsable">   
                        </div>
                        <div class="form-group col-md-6 frm-funcionario" style="margin-top: 2px; padding-right: 0px; padding-left: 0px; margin-bottom: 39px;">
                        <label>Funcionario(s)</label>
                        <select name="funcionario" class="form-control select3" multiple="multiple" data-placeholder="Selecionar funcionario" style="width: 100%;">
                                <%
                                    for(Empleado item : listaEmpleado){
                                    if(item.getEstado()== 1){
                                %>
                            <option value="<%=item.getEmpleado_id()%>"><%=item.getApellido_paterno()%> <%=item.getApellido_materno()%> <%=item.getNombre()%></option>
                             <% } } %>
                        </select>
                        </div>
                        <div class="col-md-12" style="padding: 0;">
                            <div class="form-group">
                            <label>Actividad</label>
                            <textarea class="form-control" rows="3" id="actividad"  name="actividad"></textarea>
                        </div>
                        <div class="form-group">
                            <label>Documento de trabajo</label>
                            <textarea class="form-control" rows="3" id="documento"  name="documento"></textarea>
                        </div>
                        </div>
                        
                        <div class="form-group col-md-6" style="padding-right: 10px; padding-left: 0px;">
                            <label>Fecha incio:</label>
                            <div class="input-group date">
                              <div class="input-group-addon">
                                <i class="fa fa-calendar"></i>
                              </div>
                                <input type="text" class="form-control pull-right" name="fi" id="datepicker3">
                            </div>
                        </div>
                        <div class="bootstrap-timepicker col-md-6" style="padding-right: 0px; padding-left: 0px;">
                            <div class="form-group">
                              <label>Hora</label>

                              <div class="input-group">
                                  <input type="text" class="form-control timepicker" name="hi">

                                <div class="input-group-addon">
                                  <i class="fa fa-clock-o"></i>
                                </div>
                              </div>
                              <!-- /.input group -->
                            </div>
                            <!-- /.form group -->
                        </div>
                        <div class="col-md-12" style="padding: 0;">
                            <div class="form-group col-md-6" style="padding-right: 10px; padding-left: 0px;">
                            <label>Fecha final</label>
                            <div class="input-group date">
                              <div class="input-group-addon">
                                <i class="fa fa-calendar"></i>
                              </div>
                                <input type="text" class="form-control pull-right" name="ff" id="datepicker4">
                            </div>
                        </div>
                        <div class="bootstrap-timepicker col-md-6" style="padding-right: 0px; padding-left: 0px;">
                            <div class="form-group">
                              <label>Hora</label>

                              <div class="input-group">
                                <input type="text" class="form-control timepicker" name="hf">

                                <div class="input-group-addon">
                                  <i class="fa fa-clock-o"></i>
                                </div>
                              </div>
                              <!-- /.input group -->
                            </div>
                            <!-- /.form group -->
                        </div>
                        </div>
                        
                        <div class="form-group">
                            <label>Estado</label>
                            <input type="checkbox" name="estado" id="estado"  class="flat-red">
                        </div>
                    <!-- /.box-body -->
    </div>
    <div class="box-footer">
        <button type="button" class="btn btn-default pull-left" data-dismiss="modal"><i class="fa fa-close"></i> Cancelar</button>
        <button type="submit" class="btn-purple pull-right"><i class="fa fa-save"></i> Guardar</button>
    </div>                
    </form>
    <div  id="message" style="margin: 2%;"></div>
<script type="text/javascript">

    $(document).ready(function () {
        //Timepicker
    $(".timepicker").timepicker({
      showInputs: false
    });
        //Initialize Select2 Elements
        $(".select3").select2();
        //Date picker
        $('#datepicker3').datepicker({
            format: 'dd/mm/yyyy',
          autoclose: true
        });
        $('#datepicker4').datepicker({
            format: 'dd/mm/yyyy',
          autoclose: true
        });
        $('.frm_guardar').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                paso:{
                    message: 'El campo no es valido.',
                    validators: {
                        notEmpty: 
                        {
                            message: 'El campo no puede ser vacio. '
                        },
                        stringLength: 
                        {
                            min: 1,
                            max: 2,
                            message: 'Solo puede tener 2 caracteres.'
                        },
                        integer: {
                            message: 'El valor debe ser un n˙mero entero.'
                        }
                    }
                },
                responsable:{
                    message: 'El campo no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'El campo no puede ser vacio. '
                        },
                        stringLength: {
                            min: 3,
                            max: 30,
                            message: 'Tiene que ser mas de 6 y menos de 30 caracteres'
                        },
                        regexp: {
                            regexp: /^([-a-z0-9_-¿¡¬√»… ÃÕ—“”‘Ÿ⁄€›‡·‚„ËÈÏÌÒÚÛ˘˙˚¸-\s])+$/i,
                            message: 'El nombre solo puede constar de letras, n˙meros y guiones bajos.'
                        }
                    }
                },
                actividad:{
                    message: 'El campo no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'El campo no puede ser vacio. '
                        },
                        stringLength: {
                            min: 3,
                            max: 400,
                            message: 'Tiene que ser mas de 6 y menos de 30 caracteres'
                        },
                        regexp: {
                            regexp: /^([-a-z0-9_-¿¡¬√»… ÃÕ—“”‘Ÿ⁄€›‡·‚„ËÈÏÌÒÚÛ˘˙˚¸-\s])+$/i,
                            message: 'Solo puede constar de letras, n˙meros y guiones bajos.'
                        }
                    }
                },
                documento:{
                    message: 'El campo no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'El campo no puede ser vacio. '
                        },
                        stringLength: {
                            min: 1,
                            max: 400,
                            message: 'Tiene que ser mas de 1 y menos de 400 caracteres'
                        },
                        regexp: {
                            regexp: /^([-a-z0-9_-¿¡¬√»… ÃÕ—“”‘Ÿ⁄€›‡·‚„ËÈÏÌÒÚÛ˘˙˚¸-\s])+$/i,
                            message: 'Solo puede constar de letras, n˙meros y guiones bajos.'
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
                hi:{
                    message: 'La hora no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'La hora no puede ser vacio.'
                        }
                    }
                },
                ff:{
                    message: 'La fecha final no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'La fecha final no puede ser vacio.'
                        }
                    }
                },
                hf:{
                    message: 'La hora no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'La hora no puede ser vacio.'
                        }
                    }
                }
            }
        }).on('success.form.bv', function (e) {
            // Prevent submit form
            e.preventDefault();
            $("#message").show();
            $("#message").addClass("loader");


            var $form = $(e.target),
                    validator = $form.data('bootstrapValidator');
            $.ajax({
                type: "POST",
                url: "guardarProcedimientoTarea.jsp",
                data: $(".frm_guardar").serialize(),
                success: function (data)
                {
                    $("#message").removeClass("loader");
                    $("#message").html(data);
                }, error: function (XMLHttpRequest, textStatus, errorThrown) {
                    $("#message").removeClass("loader");
                    var menn = "<p class='text-red'>Se produjo un error " + errorThrown + "  " + textStatus + "</p>";
                    $("#message").html(menn);
                }
            });
        });
    });


</script>