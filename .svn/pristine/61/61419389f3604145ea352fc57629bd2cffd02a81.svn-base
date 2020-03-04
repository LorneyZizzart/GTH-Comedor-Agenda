<%@page import="Entidad.Plan_indica_resultado"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Entidad.Plan_matriz"%>
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="matriz_ver" class="Controlador.Plan_matrizController" />

<%
    String plan_accion_id = request.getParameter("id_pla_ac").replace(" ", "+");
    //out.print(plan_accion_id);
    plan_accion_id = _encript.ValorADesencriptar(plan_accion_id);
    //out.print(plan_accion_id);
    Plan_matriz matriz = new Plan_matriz();

    //matriz = matriz_ver.getMatrizByPlanAccionIdCalendario((Integer.parseInt(plan_accion_id)));
    matriz = matriz_ver.getMatrizByIndicadorId((Integer.parseInt(plan_accion_id)));
%>
<div class="panel-body">
    <b>Que hacer :</b> <%if (matriz != null) {
            out.print(matriz.getQue_hacer());
        }%>

    <b>Responsable :</b><%if (matriz != null) {
            out.print(matriz.getResponsable());
        }%>
    <br><br>
    <b>Como: </b> <%if (matriz != null) {
            out.print(matriz.getComo());
        }%>

    <b>Documento generado :</b> <%if (matriz != null) {
            out.print(matriz.getDocumento_generadi());
        }%>
    <br><br>
    <b>Presupuesto :</b> <%if (matriz != null) {
            out.print(matriz.getPresupuesto() + "Bs.");
        }%>
<br><br>
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">Indicador de Resultado</h3>
        </div>
        <div class="panel-body">
            <table class="table table-striped">
                <thead>
                <th>#</th>
                <th>Nombre</th>
                <th>Fecha</th>
                <th>Indicador</th>                   
                </thead>
                <tbody>
                    <%
                        int contador = 0;
                        List<Plan_indica_resultado> indicadores = new ArrayList<Plan_indica_resultado>();
                        indicadores = matriz.getPlan_indica_resultado(); //indicador_ver.GetAllIndicadorByEmepleado(Integer.toString(2), Integer.toString(matriz.getPlan_matriz_id()));
                        for (Plan_indica_resultado i : indicadores) {
                            contador++;
                    %>
                    <tr>
                        <td><%=contador%></td>
                        <td><%=i.getNombre()%></td>
                        <td><%=i.getFecha()%></td>
                        <td><%=i.getEstado_nombre()%></td>
                        
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
    </div>

</div>
