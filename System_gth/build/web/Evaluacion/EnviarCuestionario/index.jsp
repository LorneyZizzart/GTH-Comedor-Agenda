<%@page import="Entidad.Cliente"%>
<%@page import="Entidad.View_Empleado_Encuesta"%>
<%@page import="Entidad.Cuestionario"%>
<%@ include file= "../../masterPage/complemento/head.jsp" %> 

<%    HttpSession sesionmenus = request.getSession();
    if (sesionmenus.getAttribute("USUARIO") != null) {
%>
<%@ include file= "../../masterPage/complemento/menu.jsp" %>
<%        DatoUsuario = (Login_Entidad) sesion.getAttribute("USUARIO");
    }
%>
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="_cuestionario" class="Controlador.CuestionarioController" />
<jsp:useBean id="_cuestionarioEmpleado" class="Controlador.Cuestionario_empleadoController" />
<%
    String idEncript = request.getParameter("e").replace(" ", "+");;
    int idCuestionario = 0;
    Cuestionario cuestionario = new Cuestionario();
    List<View_Empleado_Encuesta> listaEmpleadoCuestionario = new ArrayList<View_Empleado_Encuesta>();
    try {
        idCuestionario = Integer.parseInt(_encript.ValorADesencriptar(idEncript));
        cuestionario = _cuestionario.GetCuestionariobyCuestionario_id(idCuestionario);
        listaEmpleadoCuestionario = _cuestionarioEmpleado.GetEmpleadosEncuentaByCuestionarioID(idCuestionario);
    } catch (Exception e) {
        idCuestionario = 0;
    }
%>
<section class="content-header">
    <h1>
        <%=cuestionario.getNombre()%>
        <small> cuestionario</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="../../masterPage/complemento/index.jsp"><i class="fa fa-home"></i> Home</a></li>
        <li><a href="../Cuestionario/index.jsp"><i class="fa fa-th-list"></i> Lista de cuentas</a></li>
        <li class="active">Envios de cuestionario</li>
    </ol>
</section>

<!-- Main content -->
<section class="content">
    <div class="row">
        <div class="col-xs-12">            
            <div class="box box-purple">
                <div class="box-header with-border">
                    <h3 class="box-title">Eniviar cuestionario</h3>
                    <!-- /.box-tools -->
                    <div id="mensaje"></div>
                </div>
                <form id="form_enviar" method="post" class="form_enviar">
                    <input type="hidden" value="<%=cuestionario.getCuestionario_id()%>" name="idCuestionario" id="idCuestionario">
                    <div class="box-body no-padding">

                        <div class="table-responsive mailbox-messages table-responsive">
                            <table class="table table-hover table-striped">
                                <thead>
                                    <tr>
                                        <th class="text-center">#</th>
                                        <th>Nombre</th>
                                        <th style="width: 5%">Autoevaluación</th>
                                        <th style="width: 19%">Jefes</th>
                                        <th style="width: 19%">Pares</th>
                                        <th style="width: 19%">Bajos</th>
                                        <th style="width: 19%">Clientes</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        int contador = 0;
                                        for (View_Empleado_Encuesta empleado : listaEmpleadoCuestionario) {
                                            contador++;
                                    %>
                                    <tr>
                                        <td class="text-center"><%=contador%> <input type="hidden" name="posicion_celda" value="<%=contador%>" class="posicion_celda"> </td>

                                <input type="hidden" value="<%=empleado.getEmpleado_id()%>" name="idEmpleado<%=contador%>" id="idEmpleado<%=contador%>">
                                <td class="mailbox-name"><%=empleado.getNombre_empleado()%></td>
                                <td class="text-center"><input class="autoEvaluacion" name="autoEvaluacion" id="autoEvaluacion<%=contador%>" type="checkbox"></td>
                                <td class="mailbox-subject">
                                    <div class="form-group">
                                        <select name="idJefe<%=contador%>" id="idJefe<%=contador%>"  class="form-control select2" multiple="multiple" style="width: 100%;">
                                            <%
                                                for (View_Empleado_Encuesta jefe : empleado.getJefes()) {
                                                    String Select = "";
                                                    for(View_Empleado_Encuesta auxJefe : empleado.getSelect_Jefes()){
                                                        if(jefe.getEmpleado_id() == auxJefe.getEmpleado_id())
                                                            Select = "Selected";
                                                    }
                                            %>
                                            <option value="<%=jefe.getEmpleado_id()%>" <%=Select%>><%=jefe.getNombre_empleado()%></option>
                                            <% }%>
                                        </select>
                                    </div>
                                </td>
                                <td class="mailbox-attachment">
                                    <div class="form-group">
                                        <select name="idPar<%=contador%>" id="idPar<%=contador%>" class="form-control select2" multiple="multiple" style="width: 100%;">
                                            <%
                                                for (View_Empleado_Encuesta pares : empleado.getPares()) {
                                                    String Select = "";
                                                    for(View_Empleado_Encuesta auxPares : empleado.getSelect_Pares()){
                                                        if(pares.getEmpleado_id() == auxPares.getEmpleado_id())
                                                            Select = "Selected";
                                                    }

                                            %>
                                            <option value="<%=pares.getEmpleado_id()%>" <%=Select%>><%=pares.getNombre_empleado()%></option>
                                            <% }%>
                                        </select>
                                    </div>
                                </td>
                                <td class="mailbox-date">
                                    <div class="form-group">
                                        <select name="idBajo<%=contador%>" id="idBajo<%=contador%>" class="form-control select2" multiple="multiple" style="width: 100%;">
                                            <%
                                                for (View_Empleado_Encuesta bajo : empleado.getBajos()) {
                                                    String Select = "";
                                                    for(View_Empleado_Encuesta auxBajo : empleado.getSelect_Bajos()){
                                                        if(bajo.getEmpleado_id() == auxBajo.getEmpleado_id())
                                                            Select = "Selected";
                                                    }
                                            %>
                                            <option value="<%=bajo.getEmpleado_id()%>" <%=Select%>><%=bajo.getNombre_empleado()%></option>
                                            <% }%>
                                        </select>
                                    </div>
                                </td>
                                <td class="mailbox-date">
                                    <div class="form-group">
                                        <select name="idCliente<%=contador%>" id="idCliente<%=contador%>" class="form-control select2" multiple="multiple" style="width: 100%;">
                                            <%
                                                for (Cliente cliente : empleado.getClientes()) {
                                                    String Select = "";
                                                    for(Cliente auxCliente : empleado.getSelect_Clientes()){
                                                        if(cliente.getCliente_id() == auxCliente.getCliente_id())
                                                            Select = "Selected";
                                                    }

                                            %>
                                            <option value="<%=cliente.getCliente_id()%>" <%=Select%>><%=cliente.getNombre()%></option>
                                            <% } %>
                                        </select>
                                    </div>
                                </td>
                                </tr>
                                <%   }%>
                                </tbody>
                            </table>
                            <!-- /.table -->
                        </div>
                        <!-- /.mail-box-messages -->
                    </div>
                    <div class="box-footer no-padding">
                        <div class="mailbox-controls">
                            <!-- Check all button -->
                            <!--<button type="submit" class="btn-purple pull-right btn-enviar"><i class="fa fa-save"></i> Guardar </button>-->
                            <button type="button" class="btn-purple pull-right btn-enviar_datos"><i class="fa fa-save"></i> Guardar </button>
                            <br><br>
                        </div>
                    </div>
                </form>
                                
            </div>
            <!-- /.box -->
        </div>
        <!-- /.col -->
    </div>
    <!-- /.row -->
</section>
<%@ include file= "../../masterPage/complemento/footer.jsp" %> 
<script type="text/javascript">
    $(function () {
        $('.select2').select2()
    });


    $(".btn-enviar_datos").click(function () {
        var jsonEncuesta = {};
        var array = [];
        var funcionario = [];
        var valor = $(".posicion_celda").each(function () {
            var id = $(this).val();
            array.push(id);
        });
        array.forEach(function (element) {
            
            funcionario.push({
               "idEmpleado" :  $('#idEmpleado' + element).val(),
               "autoEvaluacion" : $(".autoEvaluacion").val(),
               "jefe" : [{
                   "idJefe" : $('#idJefe' + element).val()
               }],
               "par" : [{
                   "idPar" : $('#idPar' + element).val()
               }],
               "bajo" : [{
                   "idBajo" : $('#idBajo' + element).val()
               }],
               "cliente" : [{
                   "idCliente" : $('#idCliente' + element).val()
               }]
            });

        });
        jsonEncuesta.idCuestionario = $("#idCuestionario").val();
        jsonEncuesta.empleado = funcionario;
        var jsonString = JSON.stringify(jsonEncuesta);
        console.log(jsonString);
        $.ajax({
            type: "POST",
            url: "guardarEncuestador.jsp",
            data: {"Object" :jsonString},
            success: function (data)
            {
                $("#mensaje").removeClass("loader");
                $("#mensaje").html(data);
            }, error: function (XMLHttpRequest, textStatus, errorThrown) {
                $("#mensaje").removeClass("loader");
                var menn = "<p class='text-red'>Se produjo un error " + errorThrown + "  " + textStatus + "</p>";
                $("#mensaje").html(menn);
            }
        });
    });
</script>