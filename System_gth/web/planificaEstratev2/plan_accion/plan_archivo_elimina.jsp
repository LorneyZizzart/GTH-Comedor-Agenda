<jsp:useBean id="guardar_file" class="Controlador.Plan_accion_filesController" /> 
<%@page import="Entidad.Plan_accion_files"%>
<%@page import="Entidad.Login_Entidad"%>
<%
    HttpSession sesion = request.getSession();
    //out.print(sesion.getAttribute("USUARIO"));
    if (session.getAttribute("USUARIO") == null) {
%>
<div class="alert alert-danger alert-dismissible">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
    <h4><i class="icon fa fa-ban"></i> Alerta!</h4>
    Termino su sesión, ingrese nuevamente haga clic <a href="../../"> aquí.</a>
</div>
<%
} else {
    Login_Entidad DatoUsuario = new Login_Entidad();
    DatoUsuario = (Login_Entidad) sesion.getAttribute("USUARIO");
    Plan_accion_files f = new Plan_accion_files();
    String id_file = request.getParameter("id");
    String id_encrip = request.getParameter("id_pla_ac");

    f.setEstado(6);
    f.setEmpleado_id(DatoUsuario.getEmpleado_id());
    f.setPlan_accion_files_id(Integer.parseInt(id_file));
    String resultado = guardar_file.DeleteFile(f);
    if (resultado.equalsIgnoreCase("Ok")) {%>

<div class=" text-center alert alert-success alert-dismissible">
    <h4><i class="icon fa fa-check"></i> Guardado</h4>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        $(".loading_file").hide(1500, function () {
            $("#titleModal").html("Archivos Adjuntos");
            $('#crear_planificacion').modal('show');
            $(".cuerpo_registro").html('');
            $(".cuerpo_registro").addClass('loader');


            $.post('../plan_accion/plan_archivos.jsp',
                    {id_pla_ac: '<%=id_encrip%>'},
                    function (html) {
                        $(".cuerpo_registro").html(html);
                        $(".cuerpo_registro").removeClass('loader');
                    }
            ).fail(function (jqXHR, textStatus, errorThrown)
            {
                var alerta = "<p class='bg-danger'>error: " + errorThrown + "</p>";
                $(".cuerpo_registro").html(alerta);
                $(".cuerpo_registro").removeClass('loader');

            });
        });
        $("form")[0].reset();
    });
</script>
<%} else {
            out.print("<div class='alert alert-danger' role='alert'> <strong>Upss!</strong>Se produjo un error al  guardar. " + resultado + "</div>");
        }
    }%>