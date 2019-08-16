
<%@page import="Entidad.C_TipoComensal"%>
<%@ include file= "../../masterPage/complemento/head.jsp" %> 
<%    HttpSession sesionmenus = request.getSession();
    if (sesionmenus.getAttribute("USUARIO") != null) {
%>
<%@ include file= "../../masterPage/complemento/menu.jsp" %> 
<%    }
%>
<jsp:useBean id="_empleadoReserva" class="Controlador.C_EmpleadoReservaController" />
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<%
    List<C_TipoComensal> listaReservas = new ArrayList<C_TipoComensal>();
    listaReservas = _empleadoReserva.getAllReservaEmpleado();
%>
<section class="content-header">
    <h1>
        Registro
        <small> de reservas</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Inicio</a></li>
        <li class="active">Lista de tipo de comidas</li>
    </ol>
</section>

<section class="content">
    <div class="row">
        <div class="col-xs-12">            

            <div class="box box-purple">
                <div class="box-header">
                    <h3 class="box-title">Lista de reservas</h3>
                    <button type="button" class="formNuevo btn-purple pull-right" data-toggle="modal tooltip" data-target="#modal-default" data-placement="bottom" title="Crear reporte">
                        <i class="fa fa-file-pdf-o"></i> Crear reporte
                    </button>
                    <input type="hidden" value="<%=_encript.ValorAEncriptar(Integer.toString(DatoUsuario.getUser_id()))%>%>" name="idUsuario" id="idUsuario">
                </div>
                <!-- /.box-header -->
                <div class="box-body table-responsive">
                    <table id="example1" class="table table-bordered table-striped">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Nombre completo</th>
                                <th>Tipo de alimento</th>
                                <th style="width: 8%">Fecha</th>
                                <th>Cantidad</th>
                                <th>Observaciones</th>
                                <th>Costo</th>
                                <th style="width: 10%">Descuento de comensal</th>
                                <th style="width: 10%">Descuento de adicional</th>
                                <th style="width: 6%">Precio total</th>
                                <th>Comensal</th>
                                <th style="width: 8%">Fecha de registro</th>
                                <th style="width: 8%">Fecha de actualizacion</th>
                                <th style="width: 1%">Opciones</th>
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
                                <td><%= item.getObservacion()%></td>
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
                                <td><%= item.getFechaRegistro()%></td>
                                <td><%= item.getFechaActualizacion()%></td>
                                <td class="text-center">
                                    <div class="btn-group ">
                                        <a data-id="<%=_encript.ValorAEncriptar(Integer.toString(item.getIdEmpleadoReserva()))%>" class="formEdit btn btn-xs btn-primary edit_button" data-toggle="tooltip" data-placement="bottom" title="Editar"><i class="fa fa-edit"></i></a>                                
                                        <a data-id="<%=_encript.ValorAEncriptar(Integer.toString(item.getIdEmpleadoReserva()))%>" class="formEliminar btn btn-danger btn-xs delete_button" data-toggle="tooltip" data-placement="bottom" title="Eliminar"> <i class="fa fa-trash-o"></i></a>                                
                                    </div>
                                </td>
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
                                <th>Observaciones</th>
                                <th>Costo</th>
                                <th>Descuento de comensal</th>
                                <th>Descuento de adicional</th>
                                <th>Precio total</th>
                                <th>Comensal</th>
                                <th>Fecha de registro</th>
                                <th>Fecha de actualizacion</th>
                                <th>Opciones</th>
                            </tr>
                        </tfoot>
                    </table>
                         
                </div>
                <!-- /.box-body -->
            </div>
            <!-- /.box -->
        </div>
        <!-- /.col -->
    </div>
    <!-- /.row -->
    <!--Modal-->
    <div class="modal fade" id="formulario_registro">
        <div class="modal-dialog">
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
</section>
<%@ include file= "../../masterPage/complemento/footer.jsp" %> 
<script>
    $('.formNuevo').tooltip({ boundary: 'window' })
    $('#example').tooltip({ boundary: 'window' })
        
    $(function () {
        $("#example1").DataTable();
    });   
    
    $(".formNuevo").click(function (e) {
        $("#titleModal").html("Generar reporte");
        $(".modal-dialog").width(500);
        e.preventDefault();
        e.stopImmediatePropagation();
            $('#formulario_registro').modal('show');
            $(".cuerpo_registro").html('');
            $(".cuerpo_registro").addClass('loader');
            //$.post('lista_cuenta_duplicada.jsp',
            $.post('crearReporte.jsp',
            {id: $(this).attr('data-id')},
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
    
     //Form para editar 
    $(".formEdit").click(function (e){
        e.preventDefault();
        e.stopImmediatePropagation();
        $("#titleModal").html("Editar reserva");
        $(".modal-dialog").width(400);
        $('#formulario_registro').modal('show');
        $(".cuerpo_registro").html('');
        $(".cuerpo_registro").addClass('loader');
        $.post('editarReserva.jsp',
            {id: $(this).attr('data-id')},
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
    
    //Form para eliminar 
    $(".formEliminar").click(function (e){
        $("#titleModal").html("Eliminar reserva");
        e.preventDefault();
        e.stopImmediatePropagation();
        
        $('#formulario_registro').modal('show');
        $(".cuerpo_registro").html('');
        $(".cuerpo_registro").addClass('loader');
        
        $.post('eliminarReserva.jsp',
            {id: $(this).attr('data-id')},
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
