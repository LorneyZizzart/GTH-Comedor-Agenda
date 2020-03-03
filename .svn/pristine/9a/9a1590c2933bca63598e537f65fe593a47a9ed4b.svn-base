<%@page import="Entidad.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Entidad.C_TipoComensal"%>
<jsp:useBean id="_empleadoReserva" class="Controlador.C_EmpleadoReservaController" />
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="consultaUser" class="Controlador.UsuarioController" />

<%
   List<C_TipoComensal> listaReservas = new ArrayList<C_TipoComensal>();
    int idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
    int idRepeticion = Integer.parseInt(request.getParameter("idRepeticion"));
    String fi = request.getParameter("fi");
    String ff = request.getParameter("ff");
    List<String> idsComensal =  new ArrayList<String>();
    List<String> idsComida = new ArrayList<String>();
    
    try { 
        
        if (request.getParameterValues("co[]") != null) {
            String[] comensales  = request.getParameterValues("co[]");
            for (String c : comensales) {
                idsComensal.add(c);
            }
        }
    } catch (Exception e) {
    }
    
    try {
        if (request.getParameterValues("al[]") != null) {
            String[] comidas = request.getParameterValues("al[]");
            for (String c : comidas) {
                idsComida.add(c);
            }
        }
    } catch (Exception e) {
    }
    
    listaReservas = _empleadoReserva.getAllReservaEmpleado(idEmpleado, idRepeticion, fi, ff, idsComensal, idsComida);
%>
        <div class="col-xs-12">            

            <div class="box box-purple">
                <div class="box-header">
                    <h3 class="box-title">Lista de reservas</h3>
                    <button type="button" class="formNuevo btn-purple pull-right" data-toggle="modal tooltip" data-target="#modal-default" data-placement="bottom" title="Crear reporte">
                        <i class="fa fa-file-pdf-o"></i>
                    </button>
                </div>
                <!-- /.box-header -->
                <div class="box-body table-responsive">
                    <table id="example1" class="table table-bordered table-striped">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Nombre completo</th>
                                <th>Tipo de alimento</th>
                                <th>Fecha</th>
                                <th>Cantidad</th>
                                <th>Costo</th>
                                <th>Descuento</th>
                                <th>Descuento adicional</th>
                                <th>Precio total</th>
                                <th>Comensal</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                int contador = 0;
                                for (C_TipoComensal item : listaReservas) {
                                    contador++;

                            %>
                            <tr>
                                <td><%=contador%></td>
                                <td><%=item.getNombreEmpleado()%></td>                         
                                <td><%= item.getNombreComida()%></td>
                                <td><%= item.getFecha()%></td>
                                <td><%= item.getCantidad()%></td>
                                <td><%= item.getCosto()%> Bs.</td>
                                <%
                                   if(item.getIdTipoComida() == 1){
                                      %><td><%= item.getDescuentoDesayuno()%> Bs.</td><% 
                                   }else if(item.getIdTipoComida() == 2){
                                      %><td><%= item.getDescuentoAlmuerzo()%> Bs.</td><% 
                                   }else if(item.getIdTipoComida() == 3){
                                      %><td><%= item.getDescuentoCena()%> Bs.</td><%  
                                   }
                                %>
                                <td><%= item.getDescuentoAdicional()%> Bs.</td>
                                <%
                                   if(item.getIdTipoComida() == 1){
                                      %><td><%=((item.getCosto()-item.getDescuentoDesayuno())-item.getDescuentoAdicional())*item.getCantidad()%> Bs.</td><% 
                                   }else if(item.getIdTipoComida() == 2){
                                      %><td><%= ((item.getCosto()-item.getDescuentoAlmuerzo())-item.getDescuentoAdicional())*item.getCantidad()%> Bs.</td><% 
                                   }else if(item.getIdTipoComida() == 3){
                                      %><td><%= ((item.getCosto()-item.getDescuentoCena())-item.getDescuentoAdicional())*item.getCantidad()%> Bs.</td><%  
                                   }
                                %>
                                <td><%= item.getNombreComensal()%></td>
                            </tr>
                            <%
                                }
                            %>
                        </tbody>
                        <tfoot>
                            <tr>
                                <th>#</th>
                                <th>Nombre completo</th>
                                <th>Tipo de alimento</th>
                                <th>Fecha</th>
                                <th>Cantidad</th>
                                <th>Costo</th>
                                <th>Descuento</th>
                                <th>Descuento adicional</th>
                                <th>Precio total</th>
                                <th>Comensal</th>
                            </tr>
                        </tfoot>
                    </table>
                         
                </div>
                <!-- /.box-body -->
            </div>
            <!-- /.box -->
        </div>
        <!-- /.col -->

        <!-- /.col -->
        <div class="modal fade" id="formulario_registro">
        <div class="modal-dialog modal-comensal">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span></button>
                    <h4 id="titleModal" class="modal-title">title</h4>
                </div>
                <div class="modal-body cuerpo_registro"></div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>
<script>
    $(function () {
        $("#example1").DataTable();
    });            
    $(".formNuevo").click(function (e) {
        $("#titleModal").html("Generar reporte");
        e.preventDefault();
        e.stopImmediatePropagation();
            $('#formulario_registro').modal('show');
            $(".cuerpo_registro").html('');
            $(".cuerpo_registro").addClass('loader');
            //$.post('lista_cuenta_duplicada.jsp',
            $.post('crearReporte.jsp',
            {e: $(this).attr('data-id')},
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