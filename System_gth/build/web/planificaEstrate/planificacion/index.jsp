<%@page import="Entidad.Plan_objetivo"%>
<jsp:useBean id="verPlanObjetivos" class="Controlador.Plan_objetivoController" />
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<%@ include file= "../../masterPage/complemento/head.jsp" %> 
<%    int empleado_id = 0;
    HttpSession sesionmenus = request.getSession();
    if (sesionmenus.getAttribute("USUARIO") != null) {
%>
<%@ include file= "../../masterPage/complemento/menu.jsp" %> 
<%        DatoUsuario = (Login_Entidad) sesion.getAttribute("USUARIO");
        empleado_id = DatoUsuario.getEmpleado_id();
    }

    List<Plan_objetivo> plan_objetivos = new ArrayList<Plan_objetivo>();
    plan_objetivos = verPlanObjetivos.GetAllPlanObjetivobyUser(empleado_id);
%>
<style type="text/css" class="init">

    td.details-control {
        background: url('../../dist/img/details_open.png') no-repeat center center;
        cursor: pointer;
    }
    tr.shown td.details-control {
        background: url('../../dist/img/details_close.png') no-repeat center center;
    }

</style>
<section class="content-header">
    <h1>
        Planificación  
        <small> Estratégica</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="../../"><i class="fa fa-dashboard"></i> Inicio</a></li>

    </ol>
</section>

<section class="content">
    <div class="row">
        <div class="col-xs-12">            

            <div class="box box-purple">
                <div class="box-header">
                    <h3 class="box-title">Lista de Objetivos</h3>
                    <a href="#" class="btn-purple btn-right_nivel planificacion_crear" data-toggle="tooltip" title="Añadir planificación"><i class="fa fa-plus"></i></a>   
                </div>
                <!-- /.box-header -->
                <div class="row">
                    <div class="col-md-4"></div>
                    <div class="col-md-4">
                        <select class="form-control">
                            <option>2020</option>
                            <option>2019</option>
                            <option>2018</option>
                        </select>
                    </div>
                    <div class="col-md-4"></div>
                </div>


                <div class="box-body table-responsive">
                    <table id="example" class="table table-bordered cell-border">
                        <thead>
                            <tr>
                                <th></th>
                                <th>#</th>
                                <th>Título</th>                                 
                                <th>Descripción</th>
                                <th>Gestión</th>
                                <th style="width: 10%">Opciones</th>
                            </tr>
                        </thead>
                        <tbody> 
                            <%
                                int contador = 0;
                                for (Plan_objetivo p : plan_objetivos) {
                                    contador++;
                                    String id = _encript.ValorAEncriptar(Integer.toString(p.getPlan_objetivo_id()));
                            %>
                            <tr role="row" class="odd"> 
                                <td class="details-control" data-id="<%=id%>" ></td>
                                <td><%=contador%></td>
                                <td><%=p.getTitulo()%></td>
                                <td><%
                                    if (p.getCreditacion().length() == 50) {
                                        out.print(p.getCreditacion() + "......");
                                    } else {
                                        out.print(p.getCreditacion());
                                    }%></td>
                                <td><%=p.getGestion()%></td>
                                <td>
                                    <a href="objetivo_ver.jsp?id=<%=id%>" class="btn btn-xs btn-primary edit_button" data-toggle="tooltip" data-placement="bottom" title="Ver"><i class="fa fa-search"></i></a>  
                                    <a data-id="<%=id%>" class="plan_edita btn btn-xs btn-info edit_button" data-toggle="tooltip" data-placement="bottom" title="Editar"><i class="fa fa-edit"></i></a>
                                    <a data-id="<%=id%>" class="plan_elimi btn btn-xs btn-danger delete_button" data-toggle="tooltip" data-placement="bottom" title="Eliminar"> <i class="fa fa-trash-o"></i></a>                                                                    
                                </td>
                            </tr>
                            <%
                                }
                            %>

                        </tbody>
                        <tfoot>
                            <tr>
                                <th></th>
                                <th>#</th>
                                <th>Título</th>                                 
                                <th>Descripción</th>
                                <th>Gestión</th>
                                <th style="width: 10%">Opciones</th>
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


    <!-- /.row -->
    <div class="modal fade" id="crear_planificacion">
        <div class="modal-dialog modal-lg">
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
<script type="text/javascript" language="javascript" class="init">
    function format(d, b) {

        var fila = $('<div/>')
                .addClass('loader')
                .text(' Cargando ... ');
        $.post('objetivo_ver_.jsp',
                {id: b},
                function (html) {
                    fila.html(html);
                    fila.removeClass('loader');
                });
        return fila;
    }

    $(document).ready(function () {
        var table = $('#example').DataTable( );

        $('#example tbody').on('click', 'td.details-control', function () {
            var tr = $(this).closest('tr');
            var row = table.row(tr);
            var id = $(this).attr('data-id');

            if (row.child.isShown()) {
                row.child.hide();
                tr.removeClass('shown');
            } else {
                row.child(format(row.data(), id)).show();
                tr.addClass('shown');
            }
        });

        $(".planificacion_crear").click(function (e) {
            e.preventDefault();
            e.stopImmediatePropagation();
            $("#titleModal").html("Crear Objetivo");
            $('#crear_planificacion').modal('show');
            $(".cuerpo_registro").html('');
            $(".cuerpo_registro").addClass('loader');
            //$.post('lista_cuenta_duplicada.jsp',
            $.post('plan_nuevo.jsp',
                    {id: $(this).attr('data-id')},
                    function (html) {

                        $(".cuerpo_registro").removeClass('loader');
                        $(".cuerpo_registro").html(html);
                    }
            ).fail(function (jqXHR, textStatus, errorThrown)
            {
                var alerta = "<p class='bg-danger'>error: " + errorThrown + "</p>";
                $(".cuerpo_registro").removeClass('loader');
                $(".cuerpo_registro").html(alerta);
            });
        });

        $(".plan_edita").click(function (e) {
            e.preventDefault();
            e.stopImmediatePropagation();
            $("#titleModal").html("Editar Planificación");
            $('#crear_planificacion').modal('show');
            $(".cuerpo_registro").html('');
            $(".cuerpo_registro").addClass('loader');
            //$.post('lista_cuenta_duplicada.jsp',
            $.post('plan_nuevo.jsp',
                    {id: $(this).attr('data-id')},
                    function (html) {
                        $(".cuerpo_registro").removeClass('loader');
                        $(".cuerpo_registro").html(html);
                    }
            ).fail(function (jqXHR, textStatus, errorThrown)
            {
                var alerta = "<p class='bg-danger'>error: " + errorThrown + "</p>";
                $(".cuerpo_registro").removeClass('loader');
                $(".cuerpo_registro").html(alerta);
            });
        });

        $(".plan_elimi").click(function (e) {
            e.preventDefault();
            e.stopImmediatePropagation();
            $("#titleModal").html("Elimina Planificación");
            $('#crear_planificacion').modal('show');
            $(".cuerpo_registro").html('');
            $(".cuerpo_registro").addClass('loader');
            //$.post('lista_cuenta_duplicada.jsp',
            $.post('plan_nuevo_elimina.jsp',
                    {id: $(this).attr('data-id')},
                    function (html) {
                        $(".cuerpo_registro").removeClass('loader');
                        $(".cuerpo_registro").html(html);
                    }
            ).fail(function (jqXHR, textStatus, errorThrown)
            {
                var alerta = "<p class='bg-danger'>error: " + errorThrown + "</p>";
                $(".cuerpo_registro").removeClass('loader');
                $(".cuerpo_registro").html(alerta);
            });
        });

    }
    );
</script>
