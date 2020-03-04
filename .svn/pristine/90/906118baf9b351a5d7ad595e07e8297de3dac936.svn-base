<%@page import="Entidad.Plan_indica_resultado"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Entidad.Plan_matriz"%>
<%@page import="Entidad.Plan_accion"%>
<%@page import="Entidad.Plan_subobjetivo"%>
<%@ include file= "../../masterPage/complemento/print_heat.jsp" %> 
<%@page import="Entidad.Plan_objetivo"%>
<jsp:useBean id="verPlanObjetivos" class="Controlador.Plan_objetivoController" />
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<%
    String objetivo_id = request.getParameter("objetivo_id").replace(" ", "+");
    objetivo_id = _encript.ValorADesencriptar(objetivo_id);
    Plan_objetivo plan_objetivos = new Plan_objetivo();
    plan_objetivos = verPlanObjetivos.GetplanObjetivobyIdprint(Integer.parseInt(objetivo_id));

    int cuenta_objetivo = 1;
    int cuenta_subObjetivo = 0;
    int cuenta_plan_accion = 0;
%>
<style>
    #header, #footer {
        display: none;
    }
    @media print
    {
        #header, #footer {
            position: fixed;
            display: block;
            top: 0;
        }
        #footer {
            bottom: 0;
        }
    }
</style>
<div style="padding-left: 50px; padding-right: 30px">
    <!-- Main content -->

    <!-- title row -->
    <div class="row" id="hheader">
        <div class="col-xs-12">
            <h3 class="page-header">
                <i class="fa fa-line-chart"></i> Planificación estratégica
                <small class="pull-right"><img src="../../dist/img/ico_uab.png" alt="UAB"></small>
            </h3>
        </div>
        <!-- /.col -->
    </div>      

    <div class="row">
        <!-- accepted payments column -->
        <div class="col-xs-12">
            <h3><b><%=cuenta_objetivo%>. Objetivo: <%=plan_objetivos.getTitulo()%></b></h3>
            <br><%=plan_objetivos.getCreditacion()%>
            <%for (Plan_subobjetivo elem : plan_objetivos.getPlan_subobjetivos()) {
                    cuenta_subObjetivo++;
            %>
            <h3><%=cuenta_objetivo%>.<%=cuenta_subObjetivo%>. Subobjetivo: <%=elem.getTitulo()%></h3>
            <br><%=elem.getDescripcion()%>

            <%
                for (Plan_accion pa : elem.getPlan_accion()) {
                    cuenta_plan_accion++;
            %>
            <h4><%=cuenta_objetivo%>.<%=cuenta_subObjetivo%>.<%=cuenta_plan_accion%>. Plan de Acción: <%=pa.getNombre()%> </h4>          
            <br>Creiterio: <%=pa.getCriterio()%>

            <%
                Plan_matriz matriz = new Plan_matriz();
                matriz = pa.getPlan_Matriz();
                if (matriz != null) {
            %>
            <h4>Matriz Documento Historia </h4>
            <b>Que Hacer</b>
            <%=matriz.getQue_hacer()%>
            <b>Responsable: </b><%=matriz.getResponsable()%><br>
            <b>Como hacer</b>
            <%=matriz.getComo()%>
            <b>Documento Generado: </b><%=matriz.getDocumento_generadi()%><br>
            <b>Presupuesto: </b><%=matriz.getPresupuesto()%> B.s.<br>
            <%
                List<Plan_indica_resultado> indicadores = new ArrayList<Plan_indica_resultado>();
                indicadores = matriz.getPlan_indica_resultado();
                if (indicadores.size() > 0) {
            %>
            <h4>Indicadores de Resultados</h4>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Nombre</th>
                        <th>Fecha</th>
                        <th>Indicador</th>
                    </tr>
                </thead>
                <tbody>
                    <%int cuentaindica = 0;
                        for (Plan_indica_resultado indica : indicadores) {
                            cuentaindica++;
                    %>
                    <tr>
                        <td><%=cuentaindica%></td>
                        <td><%=indica.getNombre()%></td>
                        <td><%=indica.getFecha()%></td>
                        <td><%=indica.getEstado_nombre()%></td>
                    </tr>
                    <%
                            }

                        }
                    %>
                </tbody>
            </table>               

            <%
                        }
                    }
                }
            %>
        </div>

        <!-- /.col -->
    </div>
    <!-- /.row -->

    <!-- /.content -->
</div>
<!-- ./wrapper -->
<script>
    window.print();
</script>