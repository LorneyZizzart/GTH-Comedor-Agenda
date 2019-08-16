<%@page import="Entidad.C_TipoComensal"%> 
<%@ include file= "../../masterPage/complemento/head.jsp" %> 
<%    HttpSession sesionmenus = request.getSession();
    if (sesionmenus.getAttribute("USUARIO") != null) {
%>
<%@ include file= "../../masterPage/complemento/menu.jsp" %> 
<%    }
%>
<jsp:useBean id="_tipoComensal" class="Controlador.C_TipoComensalesController" />
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="_character" class="Controlador.CharacterController" />
<%
    List<C_TipoComensal> lista = new ArrayList<C_TipoComensal>();
    lista = _tipoComensal.getAllTipoComensal();
%>
<section class="content-header">
    <h1>
        Registro
        <small> de comensales</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Inicio</a></li>
        <li class="active">Lista de comensales</li>
    </ol>
</section>

<section class="content">
    <div class="row">
        <div class="col-xs-12">            

            <div class="box box-purple">
                <div class="box-header">
                    <h3 class="box-title">Lista de Comensales</h3>
                    <a data-id="<%=_encript.ValorAEncriptar(Integer.toString(DatoUsuario.getUser_id()))%>" style="cursor:pointer;" class="formNuevo btn-purple pull-right" data-toggle="modal tooltip" data-target="#modal-default" data-placement="bottom" title="Añadir comensal">
                        <i class="fa fa-plus"></i>
                    </a>
                </div>
                <!-- /.box-header -->
                <div class="box-body table-responsive">
                    <table id="example1" class="table table-bordered table-striped">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Nombre</th>
                                <th>Descuento desayuno</th>  
                                <th>Descuento almuerzo</th>  
                                <th>Descuento cena</th>  
                                <th>Día inicio</th>     
                                <th>Usuario creado</th>                                
                                <th>Fecha de registro</th>
                                <th>Fecha de actualización</th>                                  
                                <th>Estado</th>
                                <th style="width: 10%">Opciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                int contador = 0;
                                for (C_TipoComensal item : lista) {
                                    contador++;

                            %>
                            <tr>
                                <td><%=contador%></td>
                                <td><%=_character.CharacterUCFirst(item.getNombreComensal())%></td>                         
                                <td><%= item.getDescuentoDesayuno()%> Bs.</td>
                                <td><%= item.getDescuentoAlmuerzo()%> Bs.</td>
                                <td><%= item.getDescuentoCena()%> Bs.</td>
                                <td><%= item.getDiaInicio()%></td>
                                <td><%= item.getUsuarioCrea()%></td>
                                <td><%= item.getFechaRegistro()%></td>
                                <td><%= item.getFechaActualizacion()%></td>
                                
                                <td><% if (item.getEstado() == 1) {%><span class="badge bg-green">Activo</span> </td><%} else {%><span class="badge bg-red">Inactivo</span> </td><%}%> 
                                <td class="text-center">
                                    <div class="btn-group ">
                                        <a data-id="<%=_encript.ValorAEncriptar(Integer.toString(item.getTipoComensal_id()))%>" class="formEdit btn btn-xs btn-primary edit_button" data-toggle="tooltip" data-placement="bottom" title="Editar"><i class="fa fa-edit"></i></a>                                
                                        <a data-id="<%=_encript.ValorAEncriptar(Integer.toString(item.getTipoComensal_id()))%>" class="formEliminar btn btn-danger btn-xs delete_button" data-toggle="tooltip" data-placement="bottom" title="Eliminar"> <i class="fa fa-trash-o"></i></a>                                
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
                                <th>Nombre</th>
                                <th>Descuento desayuno</th>  
                                <th>Descuento almuerzo</th>  
                                <th>Descuento cena</th>    
                                <th>Día inicio</th>     
                                <th>Usuario creado</th>                                
                                <th>Fecha de registro</th>
                                <th>Fecha de actualización</th>                                   
                                <th>Estado</th>
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
    })
    
    $(".formNuevo").click(function (e) {
        $("#titleModal").html("Crear comensal");
        e.preventDefault();
        e.stopImmediatePropagation();
            $('#formulario_registro').modal('show');
            $(".cuerpo_registro").html('');
            $(".cuerpo_registro").addClass('loader');
            //$.post('lista_cuenta_duplicada.jsp',
            $.post('crearComensal.jsp',
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
        $("#titleModal").html("Editar comensal");
        $('#formulario_registro').modal('show');
        $(".cuerpo_registro").html('');
        $(".cuerpo_registro").addClass('loader');
        $.post('editarComensal.jsp',
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
        $("#titleModal").html("Eliminar comensal");
        e.preventDefault();
        e.stopImmediatePropagation();
        
        $('#formulario_registro').modal('show');
        $(".cuerpo_registro").html('');
        $(".cuerpo_registro").addClass('loader');
        
        $.post('eliminarComensal.jsp',
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
