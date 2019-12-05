<%@page import="Entidad.Empleado"%>
<%@page import="Entidad.Evento"%>
<%@page import="Entidad.Area"%> 
<%@ include file= "../../masterPage/complemento/head.jsp" %> 
<%    HttpSession sesionmenus = request.getSession();
    if (sesionmenus.getAttribute("USUARIO") != null) {
%>
<%@ include file= "../../masterPage/complemento/menu.jsp" %> 
<%    }
%>
<jsp:useBean id="consultaEvento" class="Controlador.EventoController" />
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="_character" class="Controlador.CharacterController" />
<%
    String e_cod_id = request.getParameter("iddsesasdasdf");
    e_cod_id = e_cod_id.replace(" ", "+");

    int e_evento_id = Integer.parseInt(_encript.ValorADesencriptar(e_cod_id));
    Evento evento = new Evento();

    evento = consultaEvento.GetEventobyId(e_evento_id);

    List<Empleado> Empleados = new ArrayList<Empleado>();
    Empleados = consultaEvento.GetAllEmpleadoEvento(e_evento_id);
%>

<section class="content-header">
    <h1>
        Evento
        <small><%=evento.getNombre_evento()%></small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="../../"><i class="fa fa-dashboard"></i> Inicio</a></li>        
    </ol>
</section>

<section class="content">
    <div class="row">
        <div class="col-xs-12">            

            <div class="box box-purple">
                <div class="box-header">
                    <h3 class="box-title">Lista de participantes</h3>                           
                </div>
                <!-- /.box-header -->
                <div class="box-body table-responsive">
                    <div class="row">
                        <%
                            int contador = 0;
                            for (Empleado em : Empleados) {
                                contador++;
                        %>
                        <div class="col-md-3">
                            <div class="box box-purple">
                                <div class="box-body box-profile">
                                    <img class="img-responsive" src="../../images/logo_uab_3.jpg" alt="User profile picture">

                                    <h4  class="text-muted text-center"><%=evento.getNombre_evento()%></h4>

                                    <div class="row">
                                        <div class="col-md-1"></div>
                                        <div class="col-md-10">
                                            <center><div id="output_<%=em.getEmpleado_id()%>" class="img-thumbnail img-bordered"></div></center>
                                        </div>
                                        <div class="col-md-1"></div>
                                    </div>


                                    <ul class="list-group list-group-unbordered">
                                        <li class="list-group-item">
                                            <h3 class="profile-username text-center"><%=em.getApellido_paterno()%> <%=em.getApellido_materno()%> </h3>
                                            <h3 class="profile-username text-center"><%=em.getNombre()%> </h3>
                                        </li>
                                        <!--<li class="list-group-item">
                                        <center><%=_encript.ValorAEncriptar(Integer.toString(em.getEmpleado_id()))%></center>
                                        </li> -->                                       
                                    </ul>

                                </div>
                                <!-- /.box-body -->
                            </div>
                        </div>
                        <%
                            }
                        %>

                    </div>
                </div>
                <!-- /.box-body -->
            </div>
            <!-- /.box -->
            <a href="evento_credencial_print.jsp?iddsesasdasdf=<%=e_cod_id%>" target="_blank" class="btn btn-primary"><i class="fa fa-print"></i> Print</a>
        </div>
        <!-- /.col -->
    </div>
    <!-- /.row -->
    <!--Modal-->

</section>

<!--Modal-->

<div class="modal fade" role="dialog"  id="registro_persona_evento">
    <div class="modal-dialog modal-lg">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title" id="titleModal">Modal Header</h4>
            </div>
            <div class="modal-body cuerpo_registro">
                <p>Some text in the modal.</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>

    </div>
</div>
<div class="mensajeDelete"></div>
<%@ include file= "../../masterPage/complemento/footer.jsp" %>

<!--Genera QR-->
<script src="../../dist/js/qr/jquery.qrcode.min.js"></script>

<script type="text/javascript">
    $(document).ready(function () {
        $(function () {
            $("#example1").DataTable();
        });

        jQuery(function () {
    <% for (Empleado e : Empleados) {
    %>
            jQuery('#output_<%=e.getEmpleado_id()%>').qrcode("<%=Integer.toString(e.getEmpleado_id())%>");
    <%
        }
    %>

        })

    });
</script>