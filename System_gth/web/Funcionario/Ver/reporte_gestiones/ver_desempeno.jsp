<%@page import="Entidad.Cuestionario_gestion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<jsp:useBean id="_cuestionario_gestion" class="Controlador.Cuestionario_gestionController" />
<%
    List<Cuestionario_gestion> gestiones = new ArrayList<Cuestionario_gestion>();
    gestiones = _cuestionario_gestion.GetAllCuestionario_gestion();
%>

<center>
    <select class="form-control select_ciclo" style="width: 160px">
        <option value="0">Selecione Ciclo</option>
        <%
            for (Cuestionario_gestion g : gestiones) {
        %>
        <option value="<%=g.getCuestionario_gestion_id()%>"><%=g.getNombre()%></option>
        <%
            }
        %>                    
    </select>
</center>
<br>
<br>

<div id="funcnionario_rep_desempeno"></div>


<script>
    $(".select_ciclo").change(function () {
        var select_getion = $(this).val();
        var emple_id = $('#idEmpleado_id').val();
        if (select_getion > 0) {
            $("#funcnionario_rep_desempeno").html("");
            $("#funcnionario_rep_desempeno").addClass("loader");
            $.ajax({
                type: "POST",
                url: "reporte_gestiones/reporte_gestion.jsp",
                data: {gestion_id: select_getion,
                    empleado_id: emple_id},
                success: function (data)
                {
                    $("#funcnionario_rep_desempeno").removeClass("loader");
                    $("#funcnionario_rep_desempeno").html(data);
                }, error: function (XMLHttpRequest, textStatus, errorThrown) {
                    $("#funcnionario_rep_desempeno").removeClass("loader");
                    var menn = "<p class='text-red'>Se produjo un error " + errorThrown + "  " + textStatus + "</p>";
                    $("#funcnionario_rep_desempeno").html(menn);
                }
            });
        }
    });
</script>