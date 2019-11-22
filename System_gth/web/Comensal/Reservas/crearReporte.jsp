<%@page import="Entidad.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Entidad.C_TipoComida"%>
<%@page import="Entidad.C_TipoComensal"%>
<jsp:useBean id="_tipoComida" class="Controlador.C_TipoComidaController"/>
<jsp:useBean id="_tipoComensal" class="Controlador.C_TipoComensalesController"/>
<jsp:useBean id="consultaUser" class="Controlador.UsuarioController" />
<% 
    List<C_TipoComida> listaTipoComida = new ArrayList<C_TipoComida>();
    List<C_TipoComensal> listaComensal = new ArrayList<C_TipoComensal>();
    listaTipoComida = _tipoComida.getAllTipoComida();
    listaComensal = _tipoComensal.getAllTipoComensal();
    List<Usuario> Usuarios = new ArrayList<Usuario>();
    Usuarios = consultaUser.GetAllUser();
%>
         <form id="form_guardar" method="post" class="form_guardar">
             
                    <div class="box-body" style="padding-top: 0;">
                        <div class="form-group">
                                <h4 style="color: #501482;" class="page-header"><i class="fa fa-user"></i> Comensal: </h4>
                                <select name="e" class="form-control selectComensal" data-placeholder="Selelcione una opción"
                                        style="width: 100%;">
                                     <option value="0" selected>Todos</option>
                                  <%
                                    for(Usuario item : Usuarios){
                                        if(item.getEstado() == 1){
                                            %>
                                   <option value="<%=item.getEmpleado_id()%>"><%=item.getNombre()%></option>
                                    <%
                                        }
                                    }
                         %>
                                </select>
                        </div>
                        <div class="form-group col-md-6" style="padding-right: 0;padding-left: 0;">
                            <label>Fecha incio:</label>
                            <div class="input-group date">
                              <div class="input-group-addon">
                                <i class="fa fa-calendar"></i>
                              </div>
                              <input type="text" class="form-control pull-right" name="fi" id="datepicker1" autocomplete="off">
                            </div>
                        </div>  
                        <div class="form-group col-md-6" style="padding-right: 0;padding-left: 0;">
                            <label>Fecha final:</label>
                            <div class="input-group date">
                              <div class="input-group-addon">
                                <i class="fa fa-calendar"></i>
                              </div>
                              <input type="text" class="form-control pull-right" name="ff" id="datepicker2" autocomplete="off">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-md-3 " style="padding-right: 0;">Ordenar :</label>
                            <label class="col-md-5 "><input type="checkbox" name="oA" id="oA"  class="flat-red"> Alfabéticamente</label>
                            <label class="col-md-4 "><input type="checkbox" name="oF" id="oF"  class="flat-red" checked> Fecha</label>
                        </div> 
                        <div class="form-group">
                                <h4 style="color: #501482;" class="page-header"><i class="fa fa-object-ungroup"></i> Tipos de comensal</h4>
                                <select name="c" class="form-control selectComensal" multiple="multiple" data-placeholder="Selelcione una opción"
                                        style="width: 100%;">
                                  <%
                                    for(C_TipoComensal item : listaComensal){
                                        if(item.getEstado() == 1){
                                            %>
                                   <option value="<%=item.getTipoComensal_id()%>"><%=item.getNombreComensal()%></option>
                                    <%
                                        }
                                    }
                                  %>
                                </select>
                              </div>
                            
                            <div class="form-group">
                                <h4 style="color: #501482; margin-top: 4%;" class="page-header"><i class="fa fa-cutlery"></i> Tipos de alimento</h4>
                                <select name="a" class="form-control selectComida" multiple="multiple" data-placeholder="Selecione una opción"
                                        style="width: 100%;">
                                  <%
                                    for(C_TipoComida item : listaTipoComida){
                                        if(item.getEstado() == 1){
                                            %>
                                   <option value="<%=item.getIdTipoComida()%>"><%=item.getNombreComida()%></option>
                                    <%
                                        }
                                    }
                                  %>
                                </select>
                              </div>
                        
                    </div>
                    <!-- /.box-body -->

                    <div class="box-footer">
                        <button type="button" class="btn btn-default pull-left" data-dismiss="modal"><i class="fa fa-close"></i> Cancelar</button>
                        <button type="submit" class="btnReport btn-purple pull-right"><i class="fa fa-print"></i> Generar Reporte</button>
                    </div>
                </form>
        <div id="mensaje"></div>
    <script type="text/javascript">
    $(document).ready(function () {
        //Initialize Select2 Elements
        $('.selectComensal').select2();
        $('.selectComida').select2();
         //Datemask dd/mm/yyyy
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
                fi:{
                    message: 'El campo no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'El campo no puede ser vacio. '
                        }
                    }
                },
                ff:{
                    message: 'El campo no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'El campo no puede ser vacio. '
                        }
                    }
                },
                c:{
                    message: 'El campo no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'El campo no puede ser vacio. '
                        }
                    }
                },
                a:{
                    message: 'El campo no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'El campo no puede ser vacio. '
                        }
                    }
                }
            }
        }).on('success.form.bv', function (e) {
            e.colspan;
            // Prevent submit form
            e.preventDefault();
            var a = document.createElement("a");
                    a.target = "_blank";
                    a.href = "generarReporte.jsp?"+$(".form_guardar").serialize();
                    a.click();
            
        });
        
//        $(".btnReport").click(function () {
//            var a = document.createElement("a");
//            a.target = "_blank";
//            a.href = "generarReporte.jsp";
//            a.click();
//            $.post('generarReporte.jsp',
//                  {fechaInicio : $('#datepicker1').val(),
//                   fechaFinal : $('#datepicker2').val(),
//                   tipoComensal: $('idComensal').val(),
//                   tipoComida: $('idComida').val()}
//            );
//        });
    });


</script>