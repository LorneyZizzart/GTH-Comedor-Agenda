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
%>

<section class="content-header">
    <h1>
        Planificación 
        <small>Estratégica</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active">Mailbox</li>
    </ol>
</section>

<section class="content">
    <div class="row">
        <div class="col-md-4">                      
            <div class="menu_objetivo"></div>           
        </div>

        <div class="col-md-8">
            <div class="box box-purple">               
                <!-- /.box-header -->
                <div class="box-body no-padding contenedor_planifica">                    

                </div>
                <!-- /.box-body -->
                <div class="box-footer no-padding">

                </div>
            </div>
            <!-- /. box -->
        </div>
        <!-- /.col -->
    </div>
    <!-- /.row -->
</section>
<%@ include file= "../../masterPage/complemento/footer.jsp" %> 

<script type="text/javascript" language="javascript">

    $(document).ready(function () {

        $(".menu_objetivo").load("menu.jsp");
    });

</script>