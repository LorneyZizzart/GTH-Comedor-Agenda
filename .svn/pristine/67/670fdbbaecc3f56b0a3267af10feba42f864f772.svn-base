<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Entidad.A_Tarea"%> 
<jsp:useBean id="_proceso" class="Controlador.A_ProcedimientoTareaController" />
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<%
    String[] id = request.getParameter("id").split("%"); 
    List<A_Tarea> listaP = new ArrayList<A_Tarea>();
    listaP = _proceso.getAllProcedimientoTarea(id[0],Integer.parseInt(id[1]));
%>
<div class="box-header" style="padding: 0 0 2% 0">
        <h3 class="box-title">Lista de Procesos</h3>
        <a data-id="<%=request.getParameter("id")%>" style="cursor:pointer;" class="formNewProcess btn-purple pull-right" data-toggle="modal tooltip" data-target="#modal-default" data-placement="bottom" title="Añadir proceso">
                        <i class="fa fa-plus"></i>
         </a>
    </div>
<div class="box-body table-responsive" style="padding: 0px 5px 30px 5px;">
                    <table id="example1" class="display table table-bordered table-striped">
                        <thead>
                            <tr>
                                <th style="width: 2%">#</th>
                                <th style="width: 30%">Nombre</th>
                                <!-- /<th style="width: 20%">Descripción</th>-->
                                <th class="text-center" style="width: 5%">Opciones</th>
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
                                <td><a data-id="<%=p.getIdProcedimiento()%>"class="verProceso" style="cursor:pointer;"><%=p.getNombreProcedimiento()%> </a>    </td>                    
                                <td class="text-center">
                                    <div class="btn-group ">
                                        <a data-id="<%=p.getIdProcedimiento()%>%<%=request.getParameter("id")%>" class="formEditProcess btn btn-xs btn-primary edit_button" data-toggle="tooltip" data-placement="bottom" title="Editar"><i class="fa fa-edit"></i></a>                                
                                        <a data-id="<%=p.getIdProcedimiento()%>%<%=request.getParameter("id")%>" class="formDeletProcess btn btn-danger btn-xs delete_button" data-toggle="tooltip" data-placement="bottom" title="Eliminar"> <i class="fa fa-trash-o"></i></a>                                
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
        $("#formulario_registro #modelViewTarea").removeClass( "modelViewTarea");
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
    
    $(".verProceso").click(function (e){
        e.preventDefault();
        e.stopImmediatePropagation();
        $("#titleModal").html("Proceso");
        $("#formulario_registro #modelViewTarea").addClass('modelViewTarea');
        $('#formulario_registro').modal('show');
        $(".cuerpo_registro").html('');
        $(".cuerpo_registro").addClass('loader');
        $.post('verProceso.jsp',
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
        $("#formulario_registro #modelViewTarea").removeClass( "modelViewTarea");
        $("#titleModal").html("Nuevo proceso");
        e.preventDefault();
        e.stopImmediatePropagation();
            $('#formulario_registro').modal('show');
            $(".cuerpo_registro").html('');
            $(".cuerpo_registro").addClass('loader');
            //$.post('lista_cuenta_duplicada.jsp',
            var id = $(this).attr('data-id').split("%");
            //console.log("title: ", id(0));
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
        $("#formulario_registro #modelViewTarea").removeClass( "modelViewTarea");
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
