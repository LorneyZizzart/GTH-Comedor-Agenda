
<%@page import="Entidad.Empleado"%>
<%@page import="Entidad.Evento_Actividad"%>
<%@page import="Entidad.Evento"%>
<jsp:useBean id="Actividad_lista" class="Controlador.Evento_ActividadController" />

<%@ include file= "../../masterPage/complemento/head.jsp" %> 
<%    HttpSession sesionmenus = request.getSession();
    if (sesionmenus.getAttribute("USUARIO") != null) {
%>
<%@ include file= "../../masterPage/complemento/menu.jsp" %> 
<%    }
%>
<jsp:useBean id="consultaEvento" class="Controlador.EventoController" />
<jsp:useBean id="consultaActividad" class="Controlador.Evento_ActividadController" />
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="_character" class="Controlador.CharacterController" />
<%
    String e_acti_id = request.getParameter("actividad_id");

    Evento_Actividad actividad = new Evento_Actividad();
    actividad = consultaActividad.GetActividadesByActividad_id(Integer.parseInt(e_acti_id));


%>
<section class="content-header">
    <h1>
        Actividad <%=actividad.getNombre_actividad()%>
    </h1>
    <ol class="breadcrumb">
        <li><a href="../../"><i class="fa fa-dashboard"></i> Inicio</a></li>        
        <li><a href="../../Eventos/evento/"><i class="fa fa-dashboard"></i> Eventos</a></li>

    </ol>
</section>

<section class="content">
    <div class="row">
        <div class="col-xs-12">            

            <div class="box box-purple">
                <div class="box-header">
                    <h3 class="box-title">Registrar Asistencia</h3>

                </div>
                <!-- /.box-header -->
                <div class="box-body table-responsive">
                    <div class="box-body table-responsive">
                        <link rel="stylesheet" href="camara/style.css">
                        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/webrtc-adapter/3.3.3/adapter.min.js"></script>
                        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/vue/2.1.10/vue.min.js"></script>
                        <script type="text/javascript" src="https://rawgit.com/schmich/instascan-builds/master/instascan.min.js"></script>

                        <div id="app">
                            <input type="hidden" name="actividad_id" id="actividad_id" value="<%=e_acti_id%>">
                            <div class="sidebar row">
                                <div class="col-md-12">
                                    <section class="cameras">
                                        <h2>Camaras</h2>
                                        <ul>
                                            <li v-if="cameras.length === 0" class="empty">No se encontro camaras</li>
                                            <li v-for="camera in cameras">
                                                <span v-if="camera.id == activeCameraId" :title="formatName(camera.name)" class="active">{{ formatName(camera.name) }}</span>
                                                <span v-if="camera.id != activeCameraId" :title="formatName(camera.name)">
                                                    <a @click.stop="selectCamera(camera)">{{ formatName(camera.name) }}</a>
                                                </span>
                                            </li>
                                        </ul>
                                    </section>
                                </div>
                                
                            </div>
                        </div>
                        <div class="preview-container">
                            <video id="preview"></video>
                        </div>
                        <script type="text/javascript" src="camara/app.js"></script>
                    </div>
                    <!-- /.box-body -->
                </div>
                <!-- /.box -->
            </div>
            <!-- /.col -->
        </div>
        <!-- /.row -->
        <!--Modal-->

</section>

<!--Modal-->

<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" id="registro_actividad_evento">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title" id="titleModal" >Modal Header</h4>
            </div>
            <div class="modal-body cuerpo_registro">
                <p>Some text in the modal.</p>
            </div> 
        </div>
    </div>
</div> 

<div class="mensajeDelete"></div>
<%@ include file= "../../masterPage/complemento/footer.jsp" %>

