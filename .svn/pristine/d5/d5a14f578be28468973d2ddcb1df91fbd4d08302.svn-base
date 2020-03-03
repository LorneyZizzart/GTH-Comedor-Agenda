<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Entidad.Login_Entidad"%>
<%@page import="Entidad.Plan_subobjetivo"%>
<%@page import="Entidad.Plan_objetivo"%>
<jsp:useBean id="verPlanObjetivos" class="Controlador.Plan_objetivoController" />
<jsp:useBean id="verPlanSubObjetivos" class="Controlador.Plan_subobjetivoController" />
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />

<%    String objetivo_id = request.getParameter("id").replace(" ", "+");
    objetivo_id = _encript.ValorADesencriptar(objetivo_id);
    HttpSession sesionmenus = request.getSession();
    if (sesionmenus.getAttribute("USUARIO") != null) {

    }

    Plan_objetivo plan_objetivos = new Plan_objetivo();
    plan_objetivos = verPlanObjetivos.GetplanObjetivobyId(Integer.parseInt(objetivo_id));

    List<Plan_subobjetivo> subobjetivos = new ArrayList<Plan_subobjetivo>();
    subobjetivos = verPlanSubObjetivos.GetAllSubobjeticosbyIdObjetivo(Integer.parseInt(objetivo_id));
%>

<style type="text/css" class="init">

    td.details-control-subob {
        background: url('../../dist/img/details_open.png') no-repeat center center;
        cursor: pointer;
    }
    tr.shown td.details-control-subob {
        background: url('../../dist/img/details_close.png') no-repeat center center;
    }

</style>
<div class="row">
    <div class="col-xs-12">            
        <div class="box box-purple">
            <div class="box-header">                            
                <h3 class="box-title">Subobjetivos</h3>
                <a href="#" class="btn-purple btn-right_nivel subobjetivo_crear" data-id="<%=plan_objetivos.getPlan_objetivo_id()%>" data-toggle="tooltip" title="Añadir Subobjetivos"><i class="fa fa-plus"></i></a>   
            </div>
            <div class="box-body">
                <dl class="dl-horizontal">   
                    <dt>Objetivo</dt>
                    <dd><%=plan_objetivos.getTitulo()%></dd>
                    <dt>Descripción</dt>
                    <dd><%=plan_objetivos.getCreditacion()%></dd>                            
                    <dt>Gestion</dt>
                    <dd><%=plan_objetivos.getGestion()%></dd>                            
                </dl>
            </div>

            <div class="box-body table-responsive">
                <h4>Lista de Subobjetivos</h4>
                <table id="table_sub_ob" class="table table-bordered table-striped">
                    <thead>
                        <tr>
                            <th></th>
                            <th>#</th>
                            <th>Título</th>                                 
                            <th>Descripción</th>
                            <th style="width: 10%">Opciones</th>
                        </tr>
                    </thead>
                    <tbody> 
                        <%
                            int contador = 0;
                            for (Plan_subobjetivo sub : subobjetivos) {
                                contador++;
                                String id = _encript.ValorAEncriptar(Integer.toString(sub.getPlan_subobjetivo_id()));
                        %>
                        <tr>
                            <td class="details-control-subob" data-id="<%=id%>" ></td>
                            <td><%=contador%></td>
                            <td><%=sub.getTitulo()%></td>
                            <td><%if (sub.getDescripcion().length() >= 50) {
                                        out.print(sub.getDescripcion().substring(0,50) + ".....");
                                    } else {
                                        out.println(sub.getDescripcion());
                                    }
                                %></td>
                            <td>
                                <a href="subobjetivo_ver.jsp?id=<%=id%>" class="btn btn-xs btn-primary edit_button" data-toggle="tooltip" data-placement="bottom" title="Ver"><i class="fa fa-search"></i></a>  
                                <a data-id="<%=id%>" class="subobjetivo_edita btn btn-xs btn-info edit_button" data-toggle="tooltip" data-placement="bottom" title="Editar"><i class="fa fa-edit"></i></a>
                                <a data-id="<%=id%>" class="subobjetivo_elimi btn btn-xs btn-danger delete_button" data-toggle="tooltip" data-placement="bottom" title="Eliminar"> <i class="fa fa-trash-o"></i></a>                                
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


<div class="modal fade" id="crear_subobjetivo">
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

<script type="text/javascript">
    function formato(d, b) {

        var fila = $('<div/>')
                .addClass('loader')
                .text(' Cargando ... ');
        $.post('subobjetivo_ver_.jsp',
                {id: b},
                function (html) {
                    fila.html(html);
                    fila.removeClass('loader');
                });
        return fila;
    }

    $(document).ready(function () {
        $(function () {
            $("#table_sub_ob").DataTable();
        });
        var table = $('#table_sub_ob').DataTable( );
        $('#table_sub_ob tbody').on('click', 'td.details-control-subob', function (e) {
            e.stopImmediatePropagation();
            var tr = $(this).closest('tr');
            var row = table.row(tr);
            var id = $(this).attr('data-id');

            if (row.child.isShown()) {
                row.child.hide();
                tr.removeClass('shown');
            } else {
                row.child(formato(row.data(), id)).show();
                tr.addClass('shown');
            }
        });
        $(".subobjetivo_crear").click(function (e) {
            e.preventDefault();
            e.stopImmediatePropagation();
            $("#titleModal").html("Crear Subobjetivo");
            $('#crear_subobjetivo').modal('show');
            $(".cuerpo_registro").html('');
            $(".cuerpo_registro").addClass('loader');
            //$.post('lista_cuenta_duplicada.jsp',
            $.post('subobjetivo_crear.jsp',
                    {objetivo_id: $(this).attr('data-id')},
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

        $(".subobjetivo_edita").click(function (e) {
            e.preventDefault();
            e.stopImmediatePropagation();
            $("#titleModal").html("Actualizar Subobjetivo");
            $('#crear_subobjetivo').modal('show');
            $(".cuerpo_registro").html('');
            $(".cuerpo_registro").addClass('loader');
            //$.post('lista_cuenta_duplicada.jsp',
            $.post('subobjetivo_crear.jsp',
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

        $(".subobjetivo_elimi").click(function (e) {
            e.preventDefault();
            e.stopImmediatePropagation();
            $("#titleModal").html("Eliminar Subobjetivo");
            $('#crear_subobjetivo').modal('show');
            $(".cuerpo_registro").html('');
            $(".cuerpo_registro").addClass('loader');
            //$.post('lista_cuenta_duplicada.jsp',
            $.post('subobjetivo_elimina.jsp',
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
    });
</script>