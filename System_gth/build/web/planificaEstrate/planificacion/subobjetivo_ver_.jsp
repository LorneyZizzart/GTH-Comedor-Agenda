<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Entidad.Plan_accion"%>
<%@page import="Entidad.Plan_subobjetivo"%>
<%@page import="Entidad.Login_Entidad"%>
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="verSubObjetivos" class="Controlador.Plan_subobjetivoController" />
<jsp:useBean id="verPlanes" class="Controlador.Plan_accionController" />

<%    String subobjetivo_id = request.getParameter("id").replace(" ", "+");
    subobjetivo_id = _encript.ValorADesencriptar(subobjetivo_id);
    Plan_subobjetivo sub = new Plan_subobjetivo();
    sub = null;
    HttpSession sesionmenus = request.getSession();

    sub = verSubObjetivos.GetSubobjetivobyId(Integer.parseInt(subobjetivo_id));

    List<Plan_accion> planes = new ArrayList<Plan_accion>();
    planes = verPlanes.GetAllPlan_accionBySubobjetivo_id(Integer.parseInt(subobjetivo_id));

%>


<div class="row">
    <div class="col-xs-12">            
        <div class="box box-purple">
            <div class="box-header">   
                <h3 class="box-title">Planes de Acción</h3>
                <a href="#" class="btn-purple btn-right_nivel planaccion_crear" data-id="<%=sub.getPlan_subobjetivo_id()%>" data-toggle="tooltip" title="Añadir Plan de Acción"><i class="fa fa-plus"></i></a>                       
            </div>
            <div class="box-body">
                <dl class="dl-horizontal">
                    <dt>Subobjetivo</dt>
                    <dd><%=sub.getTitulo()%></dd>
                    <dt>Descripción</dt>
                    <dd><%=sub.getDescripcion()%></dd>                                                         
                </dl>
            </div>
            <!-- /.box-header -->

            <div class="box-body table-responsive">
                <h4>Lista Planes de Acción</h4>
                <table id="table_planaccion" class="table table-bordered table-striped">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Título</th>                                 
                            <th>Contexto Institucional</th>
                            <th style="width:70px">Matriz</th>
                            <th>Archivos</th>
                            <th>Criterio</th>
                            <th style="width:70px">Opciones</th>
                        </tr>
                    </thead>
                    <tbody> 
                        <%
                            int cont = 0;
                            for (Plan_accion p : planes) {
                                cont++;
                                String id = _encript.ValorAEncriptar(Integer.toString(p.getPlan_accion_id()));

                        %>
                        <tr>
                            <td><%=cont%></td>
                            <td><%=p.getNombre()%></td>
                            <td><%=p.getContexto()%></td>
                            <td>
                                <a data-accion="<%=id%>" class="matriz_edita btn btn-xs btn-info edit_button" data-toggle="tooltip" data-placement="bottom" title="Editar Matriz"><i class="fa fa-edit"></i></a>
                                <a data-accion="<%=id%>" class="matriz_ver btn btn-xs btn-primary edit_button" data-toggle="tooltip" data-placement="bottom" title="Ver"><i class="fa fa-search"></i></a>  
                            </td>
                            <td><a data-accion="<%=id%>" class="ver_archivos btn btn-xs btn-info" data-toggle="tooltip" data-placement="bottom" title="Ver archivos"><i class="fa fa-file"></i></a></td>
                            <td><label class="criterio_plan_Accion" data-id="<%=id%>"> <% if (p.getCriterio() != null) {
                                    out.print(p.getCriterio());
                                } else {
                                    out.print("No Tiene");
                                }%></label></td>
                            <td>
                                <a data-id="<%=p.getPlan_subobjetivo_id()%>" data-accion="<%=id%>" class="planaccion_edita btn btn-xs btn-info" data-toggle="tooltip" data-placement="bottom" title="Editar"><i class="fa fa-edit"></i></a>
                                <a data-id="<%=p.getPlan_subobjetivo_id()%>" data-accion="<%=id%>" class="planaccion_elimi btn btn-xs btn-danger" data-toggle="tooltip" data-placement="bottom" title="Eliminar"> <i class="fa fa-trash-o"></i></a>                                
                            </td>
                        </tr>
                        <%
                            }
                        %>

                    </tbody>
                    <tfoot>
                        <tr>
                            <th>#</th>
                            <th>Título</th>                                 
                            <th>Contexto Institucional</th>
                            <th>Matriz</th>
                            <th>Archivos</th>
                            <th>Criterio</th>
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

<!-- /.row -->
<div class="modal fade" id="crear_matriz">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                <h4 id="titleModalMatriz" class="modal-title">title</h4>
            </div>
            <div class="modal-body cuerpo_registro"></div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>

<script type="text/javascript">
    function formatomatriz(d, b) {

        var fila = $('<div/>')
                .addClass('loader')
                .text(' Cargando ... ');
        /*$.post('../plan_accion/matriz_nuevo.jsp',
         {id_pla_ac: b},
         function (html) {
         fila.html(html);
         fila.removeClass('loader');
         });*/
        $.ajax({
            data: {"id_pla_ac": b},
            type: "GET",
            dataType: "html",
            url: "../plan_accion/matriz_nuevo.jsp",
        }).done(function (data, textStatus, jqXHR) {
            if (console && console.log) {
                console.log("La solicitud se ha completado correctamente.");
                fila.html(data);
            }
        }).fail(function (jqXHR, textStatus, errorThrown) {
            if (console && console.log) {
                console.log("La solicitud a fallado: " + textStatus);
                fila.html("La solicitud a fallado: " + textStatus);
            }
        });
        fila.removeClass('loader');
        return fila;
    }
    $(document).ready(function () {
        $(function () {
            $("#table_planaccion").DataTable();
        });
        var tabless = $('#table_planaccion').DataTable();

        $('#table_planaccion tbody').on('click', '.matriz_edita', function (e) {
            e.stopImmediatePropagation();
            var tr = $(this).closest('tr');
            var row = tabless.row(tr);
            var id = $(this).attr('data-accion');


            if (row.child.isShown()) {
                row.child.hide();
                tr.removeClass('shown');
            } else {
                row.child(formatomatriz(row.data(), id)).show();
                tr.addClass('shown');
            }
        });

        $(".planaccion_crear").click(function (e) {
            e.preventDefault();
            e.stopImmediatePropagation();
            $("#titleModal").html("Crear Plan de acción");
            $('#crear_planificacion').modal('show');
            $(".cuerpo_registro").html('');
            $(".cuerpo_registro").addClass('loader');
            //$.post('lista_cuenta_duplicada.jsp',
            $.post('../plan_accion/plan_accion_crear.jsp',
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



        $(".planaccion_edita").click(function (e) {
            e.preventDefault();
            e.stopImmediatePropagation();
            $("#titleModal").html("Editar Plan de acción");
            $('#crear_planificacion').modal('show');
            $(".cuerpo_registro").html('');
            $(".cuerpo_registro").addClass('loader');
            //$.post('lista_cuenta_duplicada.jsp',
            $.post('../plan_accion/plan_accion_crear.jsp',
                    {id: $(this).attr('data-id'),
                        id_pla_ac: $(this).attr('data-accion')},
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




        $(".planaccion_elimi").click(function (e) {
            e.preventDefault();
            e.stopImmediatePropagation();
            $("#titleModal").html("Eliminar Plan de acción");
            $('#crear_planificacion').modal('show');
            $(".cuerpo_registro").html('');
            $(".cuerpo_registro").addClass('loader');
            //$.post('lista_cuenta_duplicada.jsp',
            $.post('../plan_accion/plan_accion_elimina.jsp',
                    {id: $(this).attr('data-id'),
                        id_pla_ac: $(this).attr('data-accion')},
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

        $(".matriz_editas").click(function (e) {
            e.preventDefault();
            e.stopImmediatePropagation();
            $("#titleModalMatriz").html("Crear Matriz");
            $('#crear_matriz').modal('show');
            $(".cuerpo_registro").html('');
            $(".cuerpo_registro").addClass('loader');
            //$.post('lista_cuenta_duplicada.jsp',
            $.post('../plan_accion/matriz_nuevo.jsp',
                    {
                        id_pla_ac: $(this).attr('data-accion')},
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

        $(".matriz_ver").click(function (e) {
            e.preventDefault();
            e.stopImmediatePropagation();
            $("#titleModalMatriz").html("Ver Matriz");
            $('#crear_matriz').modal('show');
            $(".cuerpo_registro").html('');
            $(".cuerpo_registro").addClass('loader');
            //$.post('lista_cuenta_duplicada.jsp',
            $.post('../plan_accion/matriz_ver.jsp',
                    {
                        id_pla_ac: $(this).attr('data-accion')},
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

        $(".ver_archivos").click(function (e) {
            e.preventDefault();
            e.stopImmediatePropagation();
            $("#titleModalMatriz").html("Ver Archivos");
            $('#crear_matriz').modal('show');
            $(".cuerpo_registro").html('');
            $(".cuerpo_registro").addClass('loader');
            //$.post('lista_cuenta_duplicada.jsp',
            $.post('../plan_accion/plan_archivos.jsp',
                    {
                        id_pla_ac: $(this).attr('data-accion')},
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

        $(".criterio_plan_Accion").click(function (e) {
            e.preventDefault();
            e.stopImmediatePropagation();
            $("#titleModal").html("Actualiza Criterio");
            $('#crear_planificacion').modal('show');
            $(".cuerpo_registro").html('');
            $(".cuerpo_registro").addClass('loader');
            //$.post('lista_cuenta_duplicada.jsp',
            $.post('../plan_accion/plan_accion_criterio.jsp',
                    {
                        id_pla_ac: $(this).attr('data-id')},
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