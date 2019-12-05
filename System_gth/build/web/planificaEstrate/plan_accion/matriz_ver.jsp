<%@page import="Entidad.Plan_matriz"%>

<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="matriz_ver" class="Controlador.Plan_matrizController" />
<%
    String plan_accion_id = request.getParameter("id_pla_ac").replace(" ", "+");
    plan_accion_id = _encript.ValorADesencriptar(plan_accion_id);
    String Plan_matriz_id = "0";

    Plan_matriz matriz = new Plan_matriz();
    matriz = matriz_ver.getMatrizByPlanAccionId(Integer.parseInt(plan_accion_id));
    if (matriz != null) {
        Plan_matriz_id = Integer.toString(matriz.getPlan_matriz_id());
    }
%>
<div class="wrapper">
    <!-- Main content -->
    <section class="invoice">
        <!-- title row -->
        <div class="row">
            <div class="col-xs-12">
                <h2 class="page-header">
                    <i class="fa fa-line-chart"></i> Matriz Documento Historia
                    <!--<small class="pull-right">Date: 2/10/2014</small>-->
                </h2>
            </div>
            <!-- /.col -->
        </div>
        <div class="row invoice-info">
            <div class="col-sm-12 invoice-col">

                <strong>Que hacer: </strong><br>
                <p><%if (matriz != null) {
                        out.print(matriz.getQue_hacer());
                    }%>                 
                </p>
                <strong>Responsable: </strong><br>
                <p><%if (matriz != null) {
                        out.print(matriz.getResponsable());
                    }%>
                </p>
                <strong>Como: </strong><br>
                <p><%if (matriz != null) {
                        out.print(matriz.getComo());
                    }%>
                </p>
                <strong>Documento generado: </strong><br>
                <p><%if (matriz != null) {
                        out.print(matriz.getDocumento_generadi());
                    }%>
                </p>
                <strong>Indicador de Resultado: </strong><br>
                <strong>Nombre: </strong><br>
                <p><%if (matriz != null) {
                        out.print(matriz.getIndicadores_resultado());
                    }%>
                </p>
                <strong>Fecha: </strong><br>
                <p><%if (matriz != null) {
                        out.print(matriz.getFecha());
                    }%>
                </p>
                <strong>Indicador: </strong><br>
                <p><%if (matriz != null) {
                        out.print(matriz.getIndicador());
                    }%>
                </p>
            </div>      
        </div>
    </section>
</div>



