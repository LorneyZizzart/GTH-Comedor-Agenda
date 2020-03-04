<%@page import="Entidad.Plan_matriz"%>
<%@page import="Entidad.Login_Entidad"%>
<jsp:useBean id="crearPlanMatriz" class="Controlador.Plan_matrizController" />
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
    
    String plan_accion_di_encrip = request.getParameter("plan_accion_id_encrip");
    String id_sub_ob = request.getParameter("sub_objetivo_id");
    
    Login_Entidad DatoUsuario = new Login_Entidad();
    DatoUsuario = (Login_Entidad) sesion.getAttribute("USUARIO");
    
    String plan_accion_id = request.getParameter("plan_accion_id");
    String plan_accion_estado = request.getParameter("plan_accion_estado");
    String mat_quehacer = request.getParameter("mat_quehacer");
    String mat_responsable = request.getParameter("mat_responsable");
    String mat_como = request.getParameter("mat_como");
    String mat_documento = request.getParameter("mat_documento");
    String mat_indicador_nombre = request.getParameter("mat_indicador_nombre");
    String mat_fecha = request.getParameter("mat_fecha");
    String mat_indicador = request.getParameter("mat_indicador");
    String Plan_matriz_id = request.getParameter("Plan_matriz_id");
    String presupuesto = request.getParameter("mat_presupuesto");
    
    Plan_matriz matriz = new Plan_matriz();
    matriz.setPlan_matriz_id(Integer.parseInt(Plan_matriz_id));
    matriz.setQue_hacer(mat_quehacer);
    matriz.setResponsable(mat_responsable);
    matriz.setComo(mat_como);
    matriz.setDocumento_generadi(mat_documento);
    matriz.setIndicadores_resultado(mat_indicador_nombre);
    matriz.setFecha(mat_fecha);
    matriz.setIndicador(mat_indicador);
    matriz.setPlan_accion_id(Integer.parseInt(plan_accion_id));
    matriz.setEmpleado_id(DatoUsuario.getEmpleado_id());
    matriz.setEstado(Integer.parseInt(plan_accion_estado));
    matriz.setPresupuesto(Float.parseFloat(presupuesto));
    
    String mensaje = crearPlanMatriz.SaveorUpdateMatriz(matriz);
    String[] palabras = mensaje.split("##");
    String mensajeSave = palabras[0];
    String idmatriz = palabras[1];
    if (mensajeSave.equalsIgnoreCase("Ok")) {
%>
Guardado

<script type="text/javascript">
    /*$(document).ready(function () {
     $(".mensaje").hide(1500, function () {
     location.reload();
     });
     $("form")[0].reset();
     });*/
    
    // $('#Plan_matriz_id').val(<%=idmatriz%>)
    
    $(".contenedor_planifica").html('');
    $(".contenedor_planifica").addClass('loader');
    
    $.post('../plan_accion/plan_accion_ver.jsp',
            {id_pla_ac: '<%=plan_accion_di_encrip%>',
                id: 'id_sub_ob'},
            function (html) {
                $(".contenedor_planifica").html(html);
                $(".contenedor_planifica").removeClass('loader');
            }
    ).fail(function (jqXHR, textStatus, errorThrown)
    {
        var alerta = "<p class='bg-danger'>error: " + errorThrown + "</p>";
        $(".contenedor_planifica").html(alerta);
        $(".contenedor_planifica").removeClass('loader');
        
    });
</script>
<%
} else {%>
<div class="alert alert-danger alert-dismissible">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
    <h4><i class="icon fa fa-ban"></i> Alerta!</h4>
    <%=mensaje%>
</div>
<%  }
    }%>