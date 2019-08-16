<!-- bootstrap wysihtml5 - text editor -->
<link rel="stylesheet" href="../../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
<%@page import="java.util.List"%>
<%@ include file= "../../masterPage/complemento/head.jsp" %> 

<%    HttpSession sesionmenus = request.getSession();
    if (sesionmenus.getAttribute("USUARIO") != null) {
%>
<%@ include file= "../../masterPage/complemento/menu.jsp" %> 
<%    }
%>
<%@page import="Entidad.Estado_civil"%>
<%@page import="Entidad.Pais"%>
<%@page import="Entidad.Empleado"%>
<%@page import="Entidad.Empleado_cargo"%>
<jsp:useBean id="_estadoCivil" class="Controlador.Estado_civilController" />
<jsp:useBean id="_pais" class="Controlador.PaisController" />
<jsp:useBean id="_empleado" class="Controlador.EmpleadoController" />
<jsp:useBean id="_cargo" class="Controlador.Empleado_cargoController" />
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="_character" class="Controlador.CharacterController" />
<% int idEmpleado = 0;
    String idEncript = request.getParameter("i");

    List<Estado_civil> listaEstadoCivil = new ArrayList<Estado_civil>();
    listaEstadoCivil = _estadoCivil.GetAllEstadoCivil();

    List<Pais> listaPais = new ArrayList<Pais>();
    listaPais = _pais.GetAllPais();

    List<Empleado_cargo> listaCargo = new ArrayList<Empleado_cargo>();

    Empleado empleado = new Empleado();

    try {
        idEmpleado = Integer.parseInt(_encript.ValorADesencriptar(idEncript));
        empleado = _empleado.GetEmpleadoByID(idEmpleado);
        listaCargo = _cargo.GetAllEnpleado_cargoByEmpleadoId(idEmpleado);
    } catch (Exception e) {
        idEmpleado = 0;
    }
%>


<section class="content-header">
    <h1>
        Historial
        <small>Funcionario</small><input type="hidden" id="idEmpleado_id" value="<%=idEmpleado%>">
    </h1>
    <ol class="breadcrumb">
        <li><a href="../../masterPage/complemento/index.jsp"><i class="fa fa-home"></i> Home</a></li>
        <li><a href="./index.jsp"><i class="fa fa-th-list"></i> Lista de funcionarios</a></li>
        <li class="active">Mas información</li>

    </ol>
</section>

<section class="content">

    <div class="row">
        <div class="col-md-3">
            <div class="box ">
                <div class="box-body box-profile">
                    <img class="profile-user-img img-responsive img-circle" src="../../dist/img/user2-160x160.jpg" alt="User profile picture">

                    <h3 class="profile-username text-center"><%=_character.CharacterUCFirst(empleado.getNombre())%> <%=_character.CharacterUCFirst(empleado.getApellido_paterno())%> <%=_character.CharacterUCFirst(empleado.getApellido_materno())%></h3>
                </div>
                <!-- /.box-body -->
            </div>
            <%
                for (Empleado_cargo item : listaCargo) {
                    if (item.getActivo() == 1) {
            %>
            <div class="box ">
                <div class="box-header with-border">
                    <h3 class="box-title">Mas información</h3>
                </div>
                <!-- /.box-header -->
                <div class="box-body">

                    <strong><i class="fa  fa-check-circle-o"></i> Cargo</strong>

                    <p class="pull-right"><%=_character.CharacterUCFirst(item.getCargo_nombre())%></p>
                    <hr>

                    <strong><i class="fa fa-dot-circle-o"></i> Departamento</strong>

                    <p class="pull-right"><%=_character.CharacterUCFirst(item.getDepartamento_nombre())%></p>

                    <hr>
                    <strong><i class="fa fa-circle-o"></i> Grupo</strong>

                    <p class="pull-right">
                        <%=_character.CharacterUCFirst(item.getNivel_nombre())%>
                    </p>



                </div>
                <!-- /.box-body -->
            </div>
            <!-- /.box -->
            <%  }
                }%>
        </div>
        <!-- /.col -->
        <div class="col-md-9">
            <div class="nav-tabs-custom">
                <ul class="nav nav-tabs">
                    <li class="active"><a href="#cargo" data-toggle="tab">Cargos</a></li>                    
                    <li><a href="#desempeno" data-toggle="tab">Desempeño</a></li>
                    <li><a href="#retroalimentacion" data-toggle="tab">Feedback</a></li>
                </ul>
                <div class="tab-content">
                    <div class="active tab-pane" id="cargo">

                        <ul class="timeline timeline-inverse">
                            <%
                                for (Empleado_cargo item : listaCargo) {
                                    if (item.getActivo() == 1) {
                            %>
                            <li class="time-label">
                                <span class="bg-green">
                                    <%=item.getFecha_creacion()%>
                                </span>
                            </li>
                            <%
                            } else {
                            %>

                            <li class="time-label">
                                <span class="bg-red">
                                    <%=item.getFecha_creacion()%>
                                </span>
                            </li>
                            <%
                                }
                            %>

                            <li>
                                <i class="fa fa-user bg-aqua-active"></i>
                                <div class="timeline-item">

                                    <h3 class="timeline-header"><a>Función</a></h3>

                                    <div class="timeline-body">
                                        <p class="timeline-header no-border">
                                            <strong><i class="fa  fa-check-circle-o"></i> Cargo:</strong>
                                            <%=_character.CharacterUCFirst(item.getCargo_nombre())%>
                                        </p>
                                        <p class="timeline-header no-border">
                                            <strong><i class="fa fa-dot-circle-o"></i> Departamento: </strong>
                                            <%=_character.CharacterUCFirst(item.getDepartamento_nombre())%>
                                        </p>
                                        <p class="timeline-header no-border">
                                            <strong><i class="fa fa-circle-o"></i> Grupo:</strong>
                                            <%=_character.CharacterUCFirst(item.getNivel_nombre())%>
                                        </p>
                                        <p class="timeline-header no-border">
                                            <strong><i class="fa fa-calendar"></i> Fecha inicio: </strong>
                                            <%=item.getFecha_inicio()%>
                                        </p>
                                        <p class="timeline-header no-border">
                                            <strong><i class="fa fa-calendar"></i> Fecha final:</strong>
                                            <%=item.getFecha_fin()%>
                                        </p>
                                    </div>
                                    <div class="timeline-footer">
                                        <%
                                            if (item.getActivo() != 1) {
                                        %>
                                        <span class="badge bg-red">INACTIVO</span>
                                        <%
                                        } else {
                                        %>
                                        <span class="badge bg-green">ACTIVO</span>
                                        <%
                                            }
                                        %>
                                    </div>
                                </div>
                            </li>
                            <%
                                }
                            %>

                            <li>
                                <i class="fa fa-clock-o bg-gray"></i>
                            </li>
                        </ul>

                    </div>
                    <!-- /.tab-pane -->


                    <div class="tab-pane" id="desempeno">
                        <div class="post">
                            <%@ include file= "reporte_gestiones/ver_desempeno.jsp" %> 
                        </div>
                    </div>

                    <!-- div retroalimentacion -->

                    <div class="tab-pane" id="retroalimentacion">
                        <%@ include file= "retro_alimentacion/retro_lista.jsp" %>
                    </div>
                    <!-- /.tab-pane -->
                </div>
                <!-- /.tab-content -->
            </div>
            <!-- /.nav-tabs-custom -->
        </div>
        <!-- /.col -->
    </div>
    <!-- /.row -->

</section>
<!-- Bootstrap WYSIHTML5 -->

<%@ include file= "../../masterPage/complemento/footer.jsp" %> 
<script>


</script>