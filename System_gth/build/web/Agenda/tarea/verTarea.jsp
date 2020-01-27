<%@page import="Entidad.A_RepeticionTarea"%>
<%@page import="Entidad.A_PathTarea"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Entidad.A_Tarea"%>
<jsp:useBean id="_tarea" class="Controlador.A_TareaController"/>
<jsp:useBean id="_proceso" class="Controlador.A_ProcedimientoTareaController" />
<jsp:useBean id="_path" class="Controlador.A_PathTareaController"/>
<jsp:useBean id="_pathProceso" class="Controlador.A_PathProcedimientoTareaController" />
<jsp:useBean id="_repeticionTarea" class="Controlador.A_RepeticionTareaController"/>
<%
    String[] id = request.getParameter("id").split("%"); 
    A_Tarea tarea = new A_Tarea();
    List<A_Tarea> procesos = new ArrayList<A_Tarea>();
    List<A_PathTarea> listaPath = new ArrayList<A_PathTarea>();
    List<A_Tarea> listaPathProceso = new ArrayList<A_Tarea>();
    List<A_RepeticionTarea> listaRepeticionTarea = new ArrayList<A_RepeticionTarea>();
    listaRepeticionTarea = _repeticionTarea.getAllRepeticionTarea();
    tarea = _tarea.getTareaByTitulo(id[0], Integer.parseInt(id[1]));

    listaPath = _path.getAllPath(id[0], Integer.parseInt(id[1]));

    if(Integer.parseInt(id[2]) == 1){
        tarea = _tarea.getTareaById(tarea.getIdTarea());
        procesos = _proceso.getAllProcedimientoTarea(tarea.getTitulo(),tarea.getIdUserCrea());
    }else{
        for(A_RepeticionTarea r : listaRepeticionTarea){
            if(r.getIdRepeticionTarea() == tarea.getIdRepeticionTarea()){
                tarea.setNombreRepeticion(r.getNombreRepeticion());
            }
        }
        procesos = _proceso.getAllProcedimientoTarea(id[0], Integer.parseInt(id[1]));
    }
%>
<div style=" padding: 0 2% 2% 2%; border: solid 1px #d2d2d2; background-color: white;">
    <div id="documento">
                <div class="box-header" style="margin: 27px 0 0 0"> 
            <div class="text-center">
                <h4 class="box-title" style="font-weight: bold"><%=tarea.getTitulo()%></h4>
            </div>   
        </div>     
            <div class="box-body">
                <div class="row"></div>
                <div class="col-md-6 col-xs-12" >
                    <p> <a class="name">Tipo de repetición: </a><%=tarea.getNombreRepeticion()%></p>
                </div>
                <div class="col-md-6 col-xs-12">
                    <p> <a class="name">Fecha de inicio: </a><%=tarea.getFechaInicio()%> <%=tarea.getHoraInicio()%> </p>
                </div>
                <div class="col-md-6 col-xs-12">
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
                <div class="col-md-6 col-xs-12">
                    <p> <a class="name">Estado: </a><%=tarea.getNombreEstadoTarea()%></p>
                </div>
                 <%  } %>
                <div class="col-md-12 text-justify" ><p><%=tarea.getDescripcion()%></p></div>
                    
                    <div class="col-md-12">
                        <%
                                for (A_PathTarea path : listaPath) {

            %>
                            <div id="divimgSalida" class="col-md-2 text-center cont-image" style="border: solid 1px #aba8a8; margin: 2px;padding: 0;border-radius: 5px;">
                                
                                <img id="imgSalida'+numImage+'" width="100%" height="100%" src="../../folder_picture/Tareas/<%=path.getPathImage()%>" />
                                <label id="imgSalida"><%=path.getNombrePath()%></label>
                            </div>
    <%  } %>
                    </div>
                    <%
                                int contador = 0;
                                for (A_Tarea p : procesos) {
                                    listaPathProceso = _pathProceso.getAllPathProcedimiento(p.getIdProcedimiento());
                                    contador++;

            %>
            <div class="col-md-12 text-justify">
               <h5 class="box-title" style="font-weight: bold"><%=contador%>. <%=p.getNombreProcedimiento()%></h5>
             <p><%=p.getDescripcionProcedimiento()%></p> 
            </div>
            
             <div class="col-md-12">
<%
                                for (A_Tarea pathProceso : listaPathProceso) {

            %>
                            <div id="divimgSalida" class="col-md-2 text-center cont-image" style="border: solid 1px #aba8a8; margin: 2px;padding: 0;border-radius: 5px;">
                                
                                <img id="imgSalida'+numImage+'" width="100%" height="100%" src="../../folder_picture/Procesos/<%=pathProceso.getPathImage()%>" />
                                <label id="imgSalida"><%=pathProceso.getNombrePath()%></label>
                            </div>
    <%  } %> </div>
                 <%   }   %>
    
                </div>
    </div>



</div>
<script>
    $("#formulario_registro #btn-print-div").click(function () {
        
         $("#documento").print({
            addGlobalStyles : true,
            stylesheet : null,
            rejectWindow : true,
            noPrintSelector : ".no-print",
            iframe : true,
            append : null,
            prepend : null
                });        
    }) 
</script>