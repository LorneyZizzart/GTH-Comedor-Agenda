<%@page import="Entidad.View_Empleado_Gestion"%>
<%@page import="Entidad.Cuestionario_gestion"%>
<%@ include file= "../../masterPage/complemento/head.jsp" %> 

<%    HttpSession sesionmenus = request.getSession();
    if (sesionmenus.getAttribute("USUARIO") != null) {
%>
<%@ include file= "../../masterPage/complemento/menu.jsp" %> 
<%        DatoUsuario = (Login_Entidad) sesion.getAttribute("USUARIO");
    }
%>
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="_ciclo" class="Controlador.Cuestionario_gestionController" />

<%
    int id_ciclo = 0;
    String idEncriptCiclo = request.getParameter("c").replace(" ", "+");
    id_ciclo = Integer.parseInt(_encript.ValorADesencriptar(idEncriptCiclo));

    Cuestionario_gestion ciclo = new Cuestionario_gestion();
    ciclo = _ciclo.GetCuestionario_gestionById(id_ciclo);

    List<View_Empleado_Gestion> listaEmpleado = new ArrayList<View_Empleado_Gestion>();
    listaEmpleado = ciclo.getEmpleados();
%>

<section class="content-header">
    <h1>
        GTH 
        <small> Evaluar</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Inicio</a></li>
        <li class="active">Personal a evaluar</li>
    </ol>
</section>

<section class="content">
    <div class="row">
        <div class="col-xs-12">            

            <div class="box box-purple">
                <div class="box-header">
                    <h3 class="box-title">Lista personal a evaluar <%=ciclo.getNombre()%></h3>                    
                </div>
                <div class="box-body table-responsive">
                    <input type="hidden" name="id_ciclo_gestion" id="id_ciclo_gestion" value="<%=id_ciclo%>" >
                    <table  id="example1" class="table table-bordered table-striped">
                        <thead>
                            <tr>
                                <th>#</th><th>Departamento</th><th>Nombre</th><th>Cargo</th><th>Estado</th><th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <%  int cont = 0;
                                for (View_Empleado_Gestion item : listaEmpleado) {
                                    cont++;
                            %>
                            <tr>   
                                <td><%=cont%> </td>
                                <td><%=item.getNombre_departamento()%></td>
                                <td><%=item.getNombre_empleado()%></td>
                                <td><%=item.getNombre_cargo()%></td>
                                <td>   
                                    <% if (item.getEstado_evaluadores() == -1) {%>
                                    <a href="#" class="btn btn-xs btn-danger" data-toggle="tooltip" data-placement="bottom" data-original-title="No tiene evaluación  ">
                                        <i class="fa fa-user"></i>
                                        <i class="fa fa-close"></i>
                                        <i class="fa fa-close"></i>..
                                    </a>
                                    <%}%>

                                    <% if (item.getEstado_evaluadores() == 0) {%>
                                    <a href="#" class="btn btn-xs btn-danger" data-toggle="tooltip" data-placement="bottom" data-original-title="Elegir Evaluadores">
                                        <i class="fa fa-user"></i>
                                        <i class="fa">....</i>
                                        <i class="fa">....</i>
                                    </a>
                                    <%}%>

                                    <% if (item.getEstado_evaluadores() == 1) {%>
                                    <a href="#" class="btn btn-xs btn-warning" data-toggle="tooltip" data-placement="bottom" data-original-title="Completar Evaluadores">
                                        <i class="fa fa-user"></i>                                         
                                        <i class="fa fa-check"></i>
                                        <i class="fa">....</i>
                                    </a>
                                    <%}%>

                                    <% if (item.getEstado_evaluadores() == 2) {%>
                                    <a href="#" class="btn btn-xs btn-success" data-toggle="tooltip" data-placement="bottom" data-original-title="Evaluadores Completado">
                                        <i class="fa fa-user"></i>
                                        <i class="fa fa-check"></i>
                                        <i class="fa fa-check"></i>
                                    </a>
                                    <%}%>

                                    <!-- esta parte para el estado de correo -->
                                    <%//=item.getEstado_correo()
                                    %>
                                    <% if (item.getEstado_correo() <= 0) {
                                    %>
                                    <a href="#" class="btn btn-xs btn-danger" data-toggle="tooltip" data-placement="bottom" data-original-title="No se envió correos">
                                        <i class="fa fa-envelope"></i>
                                        <i class="fa">....</i>
                                        <i class="fa">....</i>
                                    </a>
                                    <%}%>
                                    <% if (item.getEstado_correo() == 1) {%>
                                    <a href="#" class="btn btn-xs btn-warning" data-toggle="tooltip" data-placement="bottom" data-original-title="Completar Envió correo">
                                        <i class="fa fa-envelope"></i>                                         
                                        <i class="fa fa-check"></i>
                                        <i class="fa">....</i>
                                    </a>
                                    <%}%>

                                    <% if (item.getEstado_correo() == 2) {%>
                                    <a href="#" class="btn btn-xs btn-success" data-toggle="tooltip" data-placement="bottom" data-original-title="Correos Enviados">
                                        <i class="fa fa-envelope"></i>
                                        <i class="fa fa-check"></i>
                                        <i class="fa fa-check"></i>
                                    </a>
                                    <%}%>


                                </td>
                                <td>
                                    <a class="btn btn-xs btn-success add_evaluator" data-idEmple="<%=item.getEmpleado_id()%>" data-gestion="<%=ciclo.getCuestionario_gestion_id()%>"> 
                                        <i class="fa fa-user"></i>
                                        Añadir Evaluador
                                    </a>
                                    <a class="btn btn-xs btn-warning send_mail_view" data-idEmple="<%=item.getEmpleado_id()%>" data-gestion="<%=ciclo.getCuestionario_gestion_id()%>">
                                        <i class="fa fa-envelope"></i>
                                        Enviar Correo
                                    </a>
                                    <a class="btn btn-xs btn-info tracing_view" data-idEmple="<%=item.getEmpleado_id()%>" data-gestion="<%=ciclo.getCuestionario_gestion_id()%>">
                                        <i class="fa fa-search"></i>
                                        Ver seguimiento 
                                    </a>
                                </td>
                            </tr>
                            <%

                                }%>
                        </tbody>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>

<!--Modal-->
<div class="modal fade" id="mod_lista_cuestionario">
    <div class="modal-dialog" style="width:90%;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                <h4 id="titleModal" class="modal-title">title</h4>
            </div>
            <div class="modal-body cuerpo_cuestionario">
                <button type="button" class="btn btn-default pull-left" data-dismiss="modal"><i class="fa fa-close"></i> Cancelar</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>                                

<!--Modal-->
<div class="modal fade" id="mod_vista_enviar_correo">
    <div class="modal-dialog" style="width:90%;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                <h4 id="titleModal_correo" class="modal-title">title</h4>
            </div>
            <div class="modal-body cuerpo_ver_envia_correo">
                <button type="button" class="btn btn-default pull-left" data-dismiss="modal"><i class="fa fa-close"></i> Cancelar</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div> 


<!--Modal-->
<div class="modal fade" id="mod_vista_seguimiento">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                <h4 id="titleModal_seguimiento" class="modal-title">title</h4>
            </div>
            <div class="modal-body cuerpo_ver_seguimiento">
                <button type="button" class="btn btn-default pull-left" data-dismiss="modal"><i class="fa fa-close"></i> Cancelar</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div> 


<%@ include file= "../../masterPage/complemento/footer.jsp" %> 

<script type="text/javascript">
    $(document).ready(function () {

        $(function () {
            $("#example1").DataTable();
        });
        $(".send_mail_view").on("click", function () {
            var id_empleado = $(this).attr('data-idEmple');
            var id_ciclo = $(this).attr('data-gestion');
            //alert(id_empleado + " " + id_ciclo);*/
            $("#titleModal_correo").html("Enviar Correo Electronico ");
            $('#mod_vista_enviar_correo').modal('show');
            $(".cuerpo_ver_envia_correo").html('');
            $(".cuerpo_ver_envia_correo").addClass('loader');
            $.post('ver_enviar_correo.jsp',
                    {id_emple: id_empleado,
                        id_ciclo: id_ciclo},
                    function (html) {
                        $(".cuerpo_ver_envia_correo").removeClass('loader');
                        $(".cuerpo_ver_envia_correo").html(html);
                    }
            ).fail(function (jqXHR, textStatus, errorThrown)
            {
                var alerta = "<p class='bg-danger'>error: " + errorThrown + "</p>";
                $(".cuerpo_ver_envia_correo").removeClass('loader');
                $(".cuerpo_ver_envia_correo").html(alerta);
            });
        });
        $(".add_evaluator").on("click", function () {
            //console.log($(this).text());
            var id_empleado = $(this).attr('data-idEmple');
            var id_ciclo = $(this).attr('data-gestion');
            //alert(id_empleado + " " + id_ciclo);*/
            $("#titleModal").html("Lista Evaluaciones ");
            $('#mod_lista_cuestionario').modal('show');
            $(".cuerpo_cuestionario").html('');
            $(".cuerpo_cuestionario").addClass('loader');

            $.post('muestra_lista_evaluacion.jsp',
                    {id_emple: id_empleado,
                        id_ciclo: id_ciclo},
                    function (html) {
                        $(".cuerpo_cuestionario").removeClass('loader');
                        $(".cuerpo_cuestionario").html(html);
                    }
            ).fail(function (jqXHR, textStatus, errorThrown)
            {
                var alerta = "<p class='bg-danger'>error: " + errorThrown + "</p>";
                $(".cuerpo_cuestionario").removeClass('loader');
                $(".cuerpo_cuestionario").html(alerta);
            });
        });
        
        $(".tracing_view").on("click", function () {
            var id_empleado = $(this).attr('data-idEmple');
            var id_ciclo = $(this).attr('data-gestion');
            //alert(id_empleado + " " + id_ciclo);*/
            $("#titleModal_seguimiento").html("Seguimiento a evaluación");
            $('#mod_vista_seguimiento').modal('show');
            $(".cuerpo_ver_seguimiento").html('');
            $(".cuerpo_ver_seguimiento").addClass('loader');
            $.post('ver_seguimiento.jsp',
                    {id_emple: id_empleado,
                        id_ciclo: id_ciclo},
                    function (html) {
                        $(".cuerpo_ver_seguimiento").removeClass('loader');
                        $(".cuerpo_ver_seguimiento").html(html);
                    }
            ).fail(function (jqXHR, textStatus, errorThrown)
            {
                var alerta = "<p class='bg-danger'>error: " + errorThrown + "</p>";
                $(".cuerpo_ver_seguimiento").removeClass('loader');
                $(".cuerpo_ver_seguimiento").html(alerta);
            });
        });
        
        
    });
</script>