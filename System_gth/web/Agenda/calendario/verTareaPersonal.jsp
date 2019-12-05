<%@page import="Entidad.A_Tarea"%>
<jsp:useBean id="_tarea" class="Controlador.A_TareaController"/>
<%
    String id = request.getParameter("id");
    A_Tarea tarea = new A_Tarea();
    tarea = _tarea.getTareaPersonalById(Integer.parseInt(id));
    
%>
<div class="box-header text-center" >
     <h4 class="box-title" style="font-weight: bold"><%=tarea.getTitulo()%></h4>
</div>
<div class="box-body text-justify" >
    <p><%=tarea.getDescripcion()%></p>
</div>
<div class="box-footer">
        <a data-id="<%=id%>" type="button" class="btnEliminar btn btn-danger pull-left" ><i class="fa fa-trash"></i> Eliminar</a>
        <a data-id="<%=id%>" type="button" class="btnEditar btn btn-primary pull-right"><i class="fa fa-edit"></i> Modificar</a>
</div> 
<div  id="mensaje"></div>
<script type="text/javascript">
    $(".btnEliminar").click(function () {
            $("#mensaje").show();
            $("#mensaje").addClass("loader");
            $.post('eliminarTarea.jsp',
                    {id: $(this).attr('data-id')},
                    function (html) {
                        $("#mensaje").removeClass('loader');
                        $("#mensaje").html(html);
                    }
            );
        });
        
    $(".btnEditar").click(function (e){
        e.preventDefault();
        e.stopImmediatePropagation();
        $("#titleModal").html("Editar nota personal");
        $('#formulario_registro').modal('show');
        $(".cuerpo_registro").html('');
        $(".cuerpo_registro").addClass('loader');
        $.post('editarTarea.jsp',
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