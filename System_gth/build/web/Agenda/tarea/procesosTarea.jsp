<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Entidad.A_Tarea"%> 
<jsp:useBean id="_proceso" class="Controlador.A_ProcedimientoTareaController" />
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<%
    String idTarea = request.getParameter("id");
    List<A_Tarea> listaP = new ArrayList<A_Tarea>();
    listaP = _proceso.getAllProcedimiento(Integer.parseInt(idTarea));
%>
<div class="box-header" style="padding: 0 0 2% 0">
        <h3 class="box-title">Lista de Procesos</h3>
         <a data-id="<%=idTarea%>" style="cursor:pointer;" class="formNewProcess btn-purple pull-right" data-toggle="modal tooltip" data-target="#modal-default" data-placement="bottom" title="Añadir proceso">
                        <i class="fa fa-plus"></i>
         </a>
    </div>
<div class="box-body table-responsive" style="padding: 0px 5px 30px 5px;">
                    <table id="example1" class="display table table-bordered table-striped">
                        <thead>
                            <tr>
                                <th style="width: 2%">#</th>
                                <th style="width: 20%">Nombre</th>
                                <th>Descripción</th>
                                <th style="width: 5%">Opciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                int contador = 0;
                                for (A_Tarea p : listaP) {
                                    contador++;

                            %>
                            <tr>
                                <td><%=contador%></td>
                                <td><%=p.getNombreProcedimiento()%></td>                         
                                <td><%=p.getDescripcionProcedimiento()%></td>
                                <td class="text-center">
                                    <div class="btn-group ">
                                        <a data-id="<%=_encript.ValorAEncriptar(Integer.toString(p.getIdProcedimiento()))%>" class="formEditProcess btn btn-xs btn-primary edit_button" data-toggle="tooltip" data-placement="bottom" title="Editar"><i class="fa fa-edit"></i></a>                                
                                        <a data-id="<%=_encript.ValorAEncriptar(Integer.toString(p.getIdProcedimiento()))%>" class="formDeletProcess btn btn-danger btn-xs delete_button" data-toggle="tooltip" data-placement="bottom" title="Eliminar"> <i class="fa fa-trash-o"></i></a>                                
                                    </div>
                                </td>
                            </tr>
                            <%
                                }
                            %>
                        </tbody>
                    </table>
                         
                </div>
<script>
    $(document).ready(function() {
    $('.formNewProcess').tooltip({ boundary: 'window' })
    $('.formEditProcess').tooltip({ boundary: 'window' })
    $('.formDeletProcess').tooltip({ boundary: 'window' })

} );
    
     $(".formEditProcess").click(function (e){
        $(".modal-dialog-edit").width("25%");
        $(".modal-dialog-edit").css('margin-right', "37.5%");
        $(".modal-dialog-edit").css('margin-left', "37.5%");
        e.preventDefault();
        e.stopImmediatePropagation();
        $("#titleModal").html("Editar tarea");
        $('#formulario_registro').modal('show');
        $(".cuerpo_registro").html('');
        $(".cuerpo_registro").addClass('loader');
        $.post('editarProceso.jsp',
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

    $(".formNewProcess").click(function (e) {
        $(".modal-dialog-edit").width("25%");
        $(".modal-dialog-edit").css('margin-right', "37.5%");
        $(".modal-dialog-edit").css('margin-left', "37.5%");
        $("#titleModal").html("Nuevo proceso");
        e.preventDefault();
        e.stopImmediatePropagation();
            $('#formulario_registro').modal('show');
            $(".cuerpo_registro").html('');
            $(".cuerpo_registro").addClass('loader');
            //$.post('lista_cuenta_duplicada.jsp',
            $.post('crearProceso.jsp',
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
    
    $(".formDeletProcess").click(function (e){
        $(".modal-dialog-edit").width("25%");
        $(".modal-dialog-edit").css('margin-right', "37.5%");
        $(".modal-dialog-edit").css('margin-left', "37.5%");
        $("#titleModal").html("Eliminar proceso");
        e.preventDefault();
        e.stopImmediatePropagation();
        
        $('#formulario_registro').modal('show');
        $(".cuerpo_registro").html('');
        $(".cuerpo_registro").addClass('loader');
        
        $.post('deleteProceso.jsp',
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
