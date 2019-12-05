<%@page import="Entidad.Plan_subobjetivo"%>
<%@page import="Entidad.Plan_objetivo"%>


<%@ include file= "../../masterPage/complemento/head.jsp" %> 
<%    HttpSession sesionmenuss = request.getSession();
    if (sesionmenuss.getAttribute("USUARIO") != null) {
%>
<%@ include file= "../../masterPage/complemento/menu.jsp" %> 
<%        DatoUsuario = (Login_Entidad) sesion.getAttribute("USUARIO");
        //empleado_id = DatoUsuario.getEmpleado_id();
    }
%>
<section class="content-header">
    <h1>
        Planificación  
        <small> Estratégica</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="../../"><i class="fa fa-dashboard"></i>Inicio </a></li>
        <li><a href="index.jsp"><i class="fa fa-dashboard"></i> Objetivos</a></li>

    </ol>
</section>

<section class="content">
    <%@ include file= "objetivo_ver_.jsp" %>
</section>


<%@ include file= "../../masterPage/complemento/footer.jsp" %> 
