<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Entidad.A_Tarea"%>
<jsp:useBean id="_tarea" class="Controlador.A_TareaController"/>
<jsp:useBean id="_proceso" class="Controlador.A_ProcedimientoTareaController" />
<%
    String[] id = request.getParameter("id").split("%"); 
    A_Tarea tarea = new A_Tarea();
    List<A_Tarea> procesos = new ArrayList<A_Tarea>();
    tarea = _tarea.getTareaByTitulo(id[0], Integer.parseInt(id[1]));
    if(Integer.parseInt(id[2]) == 1){
        tarea = _tarea.getTareaById(tarea.getIdTarea());
        procesos = _proceso.getAllProcedimientoTarea(tarea.getTitulo(),tarea.getIdUserCrea());
    }else{
        procesos = _proceso.getAllProcedimientoTarea(id[0], Integer.parseInt(id[1]));
    }
%>
<div style=" padding: 0 2% 2% 2%; border: solid 1px #d2d2d2; background-color: white;">
    <!--titulo-->

        <div class="box-header" style="padding: 0;margin: 27px 0 0 0"> 
            <div class="text-center">
                <h4 class="box-title" style="font-weight: bold"><%=tarea.getTitulo()%></h4>
            </div>   
            <div class="col-md-12" style="margin-top: 20px; padding: 0">
                <div class="col-md-6 col-xs-12" style="padding-left: 10px;">
                    <p> <a class="name">Tipo de repetición: </a><%=tarea.getNombreRepeticion()%></p>
                </div>
                <div class="col-md-6 col-xs-12" style="padding-left: 10px;">
                    <p> <a class="name">Fecha de inicio: </a><%=tarea.getFechaInicio()%> <%=tarea.getHoraInicio()%> </p>
                </div>
                <div class="col-md-6 col-xs-12" style="padding-left: 10px;">
                    <p> <a class="name">Dias: </a>
                        <%if(tarea.getLunes()> 0){%>
                        <span >Lunes </span>
                        <% } if(tarea.getMartes()> 0){%>
                        <span>Martes </span>
                        <% } if(tarea.getMiercoles()> 0){%>
                        <span>Miercoles </span>
                        <% } if(tarea.getJueves()> 0){%>
                        <span>Jueves </span>
                        <% } if(tarea.getViernes()> 0){%>
                        <span>Viernes </span>
                        <% } if(tarea.getSabado()> 0){%>
                        <span>Sábado </span>
                        <% } if(tarea.getDomingo()> 0){%>
                        <span>Domingo </span></p>
                        <% }%>
                </div>
                <%
                if(Integer.parseInt(id[2]) == 1){
                %>
                <div class="col-md-6 col-xs-12" style="padding-left: 10px;">
                    <p> <a class="name">Estado: </a><%=tarea.getNombreEstadoTarea()%></p>
                </div>
                 <%  } %>
            </div>
        </div>     
                <div class="box-body">
                    <p><%=tarea.getDescripcion()%></p>
                    <%
                                int contador = 0;
                                for (A_Tarea p : procesos) {
                                    contador++;

            %>

            <h5 class="box-title" style="font-weight: bold"><%=contador%>. <%=p.getNombreProcedimiento()%></h5>
             <p><%=p.getDescripcionProcedimiento()%></p>
    <%  } %>
                </div>
</div>