<%@page import="Entidad.Plan_accion"%>
<%@page import="Entidad.Plan_subobjetivo"%>
<%@page import="Entidad.Login_Entidad"%>

<%@ include file= "../../masterPage/complemento/head.jsp" %> 
<%    
    HttpSession sesionmenuss = request.getSession();
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
        <li><a href="../../"><i class="fa fa-dashboard"></i> Inicio</a></li>
        <li class="active"><a href="../planificacion">Lista de Planificaciones</a></li>
        <li class="active">Lista de subobjetivos</li>
    </ol>
</section>

<section class="content">
    <jsp:include page= "subobjetivo_ver_.jsp"/>    
</section>

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
<%@ include file= "../../masterPage/complemento/footer.jsp" %> 

