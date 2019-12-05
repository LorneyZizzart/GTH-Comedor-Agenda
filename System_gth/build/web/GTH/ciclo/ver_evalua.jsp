<%@page import="Entidad.Cliente"%>
<%@page import="Entidad.View_Empleado_Encuesta"%>
<%@page import="Entidad.Cuestionario"%>
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="_reporteCuestionarios" class="Controlador.Ciclo_reporteController" />
<%
    int idCiclo = 0;
    String idEncriptCiclo = request.getParameter("c").replace(" ", "+");
    try {
        idCiclo = Integer.parseInt(_encript.ValorADesencriptar(idEncriptCiclo));
    } catch (Exception e) {
        idCiclo = 0;
    }

    //out.print("CICLO ID = " + idCiclo);
    List<Cuestionario> cuestionarios = new ArrayList<Cuestionario>();
    cuestionarios = _reporteCuestionarios.GetAllCuestionarios(idCiclo);
%>
<%@ include file= "../../masterPage/complemento/head.jsp" %> 
<%    HttpSession sesionmenus = request.getSession();
    if (sesionmenus.getAttribute("USUARIO") != null) {
%>
<%@ include file= "../../masterPage/complemento/menu.jsp" %> 
<%        DatoUsuario = (Login_Entidad) sesion.getAttribute("USUARIO");
    }
%>

<section class="content-header">
    <h1>
        Ver 
        <small> Personal</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Inicio</a></li>
        <li class="active">Lista de Ciclos</li>
    </ol>
</section>

<section class="content">
    <div class="row">
        <div class="col-xs-12">            

            <div class="box box-purple">
                <div class="box-header">
                    <h3 class="box-title">Persona a evaluar</h3>                    
                    <input type="hidden" value="q" name="idUsuario" id="idUsuario">
                </div>
                <!-- /.box-header -->
                <div class="box-body table-responsive">
                    <%
                        for (Cuestionario c : cuestionarios) {
                    %>
                    <h3><%=c.getNombre()%> - <%=c.getCuestionario_id()%> </h3>
                    <%
                        if (c.getView_Empleado_Encuesta().size() > 0) {
                    %>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Nombre</th>                                 
                                <th>Autoevaluacion</th>
                                <th>Jefe</th>
                                <th>Pares</th>
                                <th>Bajos</th>
                                <th>Clientes</th>                                
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                int conta = 0;
                                for (View_Empleado_Encuesta e : c.getView_Empleado_Encuesta()) {
                                    conta++;
                            %>
                            <tr>
                                <td><%=conta%></td>
                                <td><%=e.getNombre_empleado()%></td>
                                <td><%if (e.getAuto_evaluacion() != "") {
                                        out.print(e.getAuto_evaluacion());
                                    }%></td>
                                <td><%
                                    for (View_Empleado_Encuesta jefe : e.getJefes()) {
                                        out.print(jefe.getNombre_empleado() + "<Br>");
                                    }
                                    %></td>
                                <td><%
                                    for (View_Empleado_Encuesta pare : e.getPares()) {
                                        out.print(pare.getNombre_empleado() + "<Br>");
                                    }
                                    %></td>
                                <td><%
                                    if (e.getBajos() != null) {
                                        for (View_Empleado_Encuesta bajos : e.getBajos()) {
                                            out.print(bajos.getNombre_empleado() + "<Br>");
                                        }
                                    }

                                    %></td>
                                <td><%                                    
                                    if (e.getClientes() != null) {
                                        for (Cliente cli : e.getClientes()) {
                                            out.print(cli.getNombre() + "<Br>");
                                        }
                                    }
                                    %></td>
                            </tr>
                            <%                                }
                            %>
                        </tbody>                        
                    </table> <%
                        }
                    %>


                    <%
                        }
                    %>

                </div>
                <!-- /.box-body -->
            </div>
            <!-- /.box -->
        </div>
        <!-- /.col -->
    </div>
    <!-- /.row -->
</section>
<%@ include file= "../../masterPage/complemento/footer.jsp" %> 