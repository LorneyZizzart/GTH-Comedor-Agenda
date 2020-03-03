<%@page import="Entidad.C_TipoComensal"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="Entidad.C_TipoComida"%>
<%@page import="Entidad.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<jsp:useBean id="_consultaUser" class="Controlador.UsuarioController" />
<jsp:useBean id="_tipoComida" class="Controlador.C_TipoComidaController"/>
<jsp:useBean id="_tipoComensal" class="Controlador.C_TipoComensalesController"/>
<%
    List<Usuario> Usuarios = new ArrayList<Usuario>();
    Usuarios = _consultaUser.GetAllUser();
    
    List<C_TipoComida> listaTipoComida = new ArrayList<C_TipoComida>();
    listaTipoComida = _tipoComida.getAllTipoComida();
    
    List<C_TipoComensal> listaComensal = new ArrayList<C_TipoComensal>();
    listaComensal = _tipoComensal.getAllTipoComensal();
    
//    DateFormat dateFormat = new SimpleDateFormat("HH:mm");
//    String dataStart = request.getParameter("fechaInicio");
//    String dataNow = request.getParameter("fechaNow");
//    Date dateHora = new Date();
//    String horaNow[] = dateFormat.format(dateHora).split(":");
%>
<input type="hidden" value="<%=listaTipoComida.size()%>" name="lengthComida" id="lengthComida">
<form id="form_guardar" method="post" class="form_guardar">
             <div class="box-body" style="padding-top: 0;">
                        <div class="form-group row">
                            <label class="col-md-6 col-sm-12">
                                <input type="radio" name="funcionario" class="minimal" value="1" checked >
                                Funcionario 
                            </label>
                            <label class="col-md-6 col-sm-12">
                                <input type="radio" name="funcionario" class="minimal" value="0">
                                No funcionario
                            </label>
                        </div>
                        <div id="nombreComensal" class="form-group">
                            <label for="nombreCompleto">Nombre completo</label>
                            <input type="text" class="form-control" id="nombreCompleto" name="nombreCompleto">
                        </div>
                        <div id="celularComensal" class="form-group">
                            <label for="celular">Celular de referencia</label>
                            <input type="number" class="form-control" id="celular" name="celular">
                        </div>
                        <div id="idComensal" class="form-group">
                        <label class="control-label" style="padding: 2% 0 0 0;">Comensal</label>
                        <div class="input-group" style="width: 100%;">
                          <select id="idEmpleado" name="idEmpleado" class="form-control selectFuncionario" style="width: 100%;">
                              <option value="0" selected disabled>Selecione un funcionario</option>
                          <%
                                    for(Usuario item : Usuarios){
                                        if(item.getEstado() == 1){
                                            %>
                                   <option value="<%=item.getUser_id()%>"><%=item.getNombre()%></option>
                                    <%
                                        }
                                    }
                         %>
                        </select>  
                        </div>                        
                      </div>
                        <div class="form-group">
                            <label>Fecha</label>
                            <div class="input-group date">
                              <div class="input-group-addon">
                                <i class="fa fa-calendar"></i>
                              </div>
                              <input type="text" class="form-control pull-right" name="fi" id="datepicker1" autocomplete="off">                              
                            </div>
                            <label id="errorDate" style="color: red">Fecha incorrecto debe ser igual o mayor de hoy</label>
                        </div> 
                        <div class="form-group row">
                            <label class="col-md-4" >
                                <strong>Tipo de comensal</strong>
                            </label>
                            <label class="col-md-4">
                                <input type="radio" name="ocacional" class="minimal" checked disabled>
                                Ocasional 
                            </label>
                            <label class="col-md-4">
                                <input type="radio" name="mensual" class="minimal" disabled>
                                Mensual
                            </label>
                        </div>  
                       <input type="hidden" value="0" name="tipoComensal" id="tipoComensal">

                        <div class="form-group">
                            <label class="control-label" style="padding: 2% 0 0 0;">Comida</label>
                            <div class="input-group" style="width: 100%;">
                              <select id="idTipoComida" name="idTipoComida" class="form-control" style="width: 100%;">
                                <%
                                    for(C_TipoComida item : listaTipoComida){
                                %>
                                    <option value="<%=item.getIdTipoComida()%>"><%=item.getNombreComida()%></option>
                                <%
                                    }
                                %>
                            </select>  
                            </div>                        
                        </div> 
                        <div class="form-group" >
                            <label>Cantidad</label>
                            <input type="number" class="form-control" id="cantidad"  name="cantidad" value="1">                            
                        </div>
                        <div class="form-group">
                            <label>Observaciones</label>
                            <textarea class="form-control" rows="3" id="observacion"  name="observacion"></textarea>
                        </div>
                        
             </div>
                    <div class="box-footer">
                        <button type="button" class="btn btn-default pull-left" data-dismiss="modal"><i class="fa fa-close"></i> Cancelar</button>
                        <button type="submit" class="btnGuardar btn-purple pull-right"><i class="fa fa-save"></i> Guardar</button>
                    </div>
                </form>
        <div id="mensaje"></div>
<script>
    $(document).ready(function() {
        $('#errorDate').hide();
        $('#nombreComensal').hide(); 
        $('#celularComensal').hide()
        for(var i = 0; i <= $('#lengthComida').val(); i++){
                    $('.posicion'+i).attr('disabled', true)
        } 
        $('.selectFuncionario').select2();
        $('#datepicker1').datepicker({
            format: 'dd/mm/yyyy',
            autoclose: true,
            minDate: new Date()
        });
        
        var array = [];
        for(var i = 1; i <= $("#lengthComida").val(); i++){
            array.push(i);
        }
        
        array.forEach(function (element){
        $('.posicion'+ element).change(function() {
            if(this.checked) {
              $('.cantidad'+element).prop("disabled", false);
              $('.cantidad'+element).val("1");
            } else {
              $('.cantidad'+element).prop("disabled", true);
              $('.cantidad'+element).val("Cantidad");
            }
            });  
        });
        
        $('input[name=funcionario]').on('change', function() {
            if(this.value == 1){
                celularComensal
                $('#nombreComensal').hide('fast'); 
                $('#celularComensal').hide('fast'); 
                $('#idComensal').show('slow');
            }else{
                $('#idComensal').hide('fast');
                $('#nombreComensal').show('slow');
                $('#celularComensal').show('slow');

            }                
        })
        
        $('#datepicker1').on('change', function() {
            var dateNow = new Date();
            var inputDate = (this.value).toString().split('/');
            var date = new Date(inputDate[2]+"-"+inputDate[1]+"-"+inputDate[0])
            date.setDate(date.getDate()+1)
            
            if(date >= dateNow){
                $('#errorDate').hide();
                for(var i = 0; i <= $('#lengthComida').val(); i++){
                    $('.posicion'+i).attr('disabled', false)
                }
                if(Math.round((date.getTime()-dateNow.getTime())/ (1000*60*60*24)) >= <%=listaComensal.get(1).getDiasAnticipacion()%>){
                    $('#tipoComensal').val('1')
                    $('input[name=mensual]').attr('checked', true)
                    $('input[name=ocacional]').attr('checked', false)                      
                }else{
                    $('#tipoComensal').val('0')
                    $('input[name=ocacional]').attr('checked', true)
                    $('input[name=mensual]').attr('checked', false)
                }
            }else{
                for(var i = 0; i <= $('#lengthComida').val(); i++){
                    $('.posicion'+i).attr('disabled', true)
                } 
                $('input[name=ocacional]').attr('checked', false)
                $('input[name=mensual]').attr('checked', false)
                $('#errorDate').show();
                  
            }
            
            
        })
        
        $('.form_guardar').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                nombreCompleto: {
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
                            regexp: /^([-a-z0-9_-��������������������������������-\s])+$/i,
                            message: 'El nombre de usuario solo puede constar de letras, n�meros y guiones bajos.'
                        }
                    }
                },
                celular:{
                    message: 'El celular no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'El campo no puede ser vacio. '
                        }
                    }
                },
                idEmpleado:{
                    message: 'El empleado no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'Debe seleccionar un funcionario. '
                        }
                    }
                },
                fi: {
                    message: 'El campo no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'El campo no puede ser vacio. '
                        }
                    }
                },
                idTipoComida: {
                    message: 'El campo no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'El campo no puede ser vacio. '
                        }
                    }
                },
                cantidad: {
                    message: 'El campo no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'El campo no puede ser vacio. '
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
                url: "guardarReserva.jsp",
                data: $(".form_guardar").serialize(),
                success: function (data)
                {
                    $('.btnGuardar').prop("disabled",true);
                    $("#mensaje").removeClass("loader");
                    $("#mensaje").html(data);
                }, error: function (XMLHttpRequest, textStatus, errorThrown) {
                    $('.btnGuardar').prop("disabled",true);
                    $("#mensaje").removeClass("loader");
                    var menn = "<p class='text-red'>Se produjo un error " + errorThrown + "  " + textStatus + "</p>";
                    $("#mensaje").html(menn);
                }
            });
        });
        
    })
    
    
</script>