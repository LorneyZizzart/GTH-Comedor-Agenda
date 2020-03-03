<%@page import="Entidad.Departamento"%>
<%@page import="Entidad.A_RepeticionTarea"%>
<%@page import="Entidad.A_Tarea"%> 
<%@ include file= "../../masterPage/complemento/head.jsp" %> 
<%    HttpSession sesionmenus = request.getSession();
    if (sesionmenus.getAttribute("USUARIO") != null) {
%>
<%@ include file= "../../masterPage/complemento/menu.jsp" %> 
<%    }
%>
<jsp:useBean id="_tarea" class="Controlador.A_TareaController" />
<jsp:useBean id="_repeticion" class="Controlador.A_RepeticionTareaController" />
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="_character" class="Controlador.CharacterController" />
<jsp:useBean id="_departamento" class="Controlador.DepartamentoController" />
<%
    List<A_RepeticionTarea> listaR = new ArrayList<A_RepeticionTarea>();
    List<Departamento> ListaDepartamento = new ArrayList<Departamento>();
    ListaDepartamento = _departamento.GetAllDepartamento();
    String[] listaRe = new String[]{"Todo", "Hoy", "Semanal", "Quincenal", "Mensual", "Semestral", "Anual", "Predeterminado" , "General"};
    listaR = _repeticion.getAllRepeticionTarea();
%>
<input type="hidden" value="<%=DatoUsuario.getUser_id()%>" name="idUsuario" id="idUsuario">
<section class="content-header">
    <h1>
        Registro
        <small> de tareas</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Inicio</a></li>
        <li class="active">Lista de tareas</li>
    </ol>
</section>


<section class="content">    
        <div class="box" style="border-top: none">
            <div class="box-header">
                <div class="row">
                    <div class="col-sm-12 col-md-4">
                            <div  class="form-group">
                                <label class="col-md-3 control-label" style="padding: 2% 0 0 0;">Departamento: </label>

                            <div class="col-md-9 col-xs-12 input-group">
                              <select id="idDepartamento" name="idDepartamento"  class="form-control select2" style="width: 100%;">
                                  <option value="0" selected>Todos</option>
                                  <%
                                      int d = 0;
                                      for (Departamento item : ListaDepartamento) {
                                          %>
                                          <option value="<%=item.getDepartamento_id()%>" ><%=item.getNombre()%></option>                            
                                  <% d++; }  %>
                              </select>
                            </div>
                            </div>
                    </div>
                    <div id="listFuncionarios" class="col-sm-12 col-md-4">
                            
                    </div>
                    <div class="col-sm-12 col-md-4">
                            <div id="sfi" class="form-group">
                                <label class="col-md-2 control-label" style="padding: 2% 0 0 0;">Ver:</label>

                            <div class="col-md-10 col-xs-12 input-group">
                              <select id="idRepeat" name="idRepeticion"  class="form-control selectRepeticion" style="width: 100%;">
                                  <%
                                      int contador = 0;
                                      for(String r : listaRe){
                                          String select = "";
                                          if(contador==1)
                                              select = "Selected";
                                          %>
                                          <option value="<%=contador%>" <%=select%>><%=r%></option>                            
                                  <% contador++; }  %>
                              </select>
                            </div>
                            </div>
                    </div>
                    <div class="col-sm-12 col-md-4">
                        <div id="sfi" class="form-group">
                            <label class="col-sm-3 control-label" style="padding: 2% 0 0 0;">Fecha incio:</label>
                            <div class="input-group date col-sm-9 col-xs-12">
                              <div class="input-group-addon">
                                <i class="fa fa-calendar"></i>
                              </div>
                              <input type="text" class="form-control pull-right" name="fi" id="dp1" autocomplete="off">
                            </div>
                        </div>       
                    </div>
                    <div class="col-sm-12 col-md-4">
                        <div id="sfi" class="form-group">
                            <label class="col-md-3 control-label" style="padding: 2% 0 0 0;">Fecha final:</label>
                            <div class="input-group date col-md-9 col-xs-12">
                              <div class="input-group-addon">
                                <i class="fa fa-calendar"></i>
                              </div>
                              <input type="text" class="form-control pull-right" name="fi" id="dp2" autocomplete="off">
                            </div>
                        </div>       
                    </div>
                    <div class="col-xs-12 col-md-4">
                        <button id="filtrarTarea" type="button" class="btn-purple btn-block" ><i class="fa fa-search"></i> Filtrar</button>   
                    </div>
                    
                    
                </div>  
                
            </div>
        </div>
     
    
   <div id="tablaTarea" class="row"></div>
   
</section>
<%@ include file= "../../masterPage/complemento/footer.jsp" %> 
<script>
     
    var fechaInicio  = "", fechaFinal = "";
    $(document).ready(function() {
        estadoDate(true);
        renderTable(0, 1, fechaInicio, fechaFinal);
        renderListFuncionarios(0);
    });
    $('#idDepartamento').on('change', function() { 
        renderListFuncionarios(this.value);
    });
    function renderListFuncionarios(idDepartamento){
        $.post('listaFuncionarios.jsp',
            {idD: idDepartamento},
                    function (html) {
                    $("#listFuncionarios").removeClass('loader');
                    $("#listFuncionarios").html(html);
                    }
             ).fail(function (jqXHR, textStatus, errorThrown)
        {
            
                var alerta = "<p class='bg-danger'>error: "+errorThrown+"</p>";
                $("#listFuncionarios").removeClass('loader');
                $("#listFuncionarios").html(alerta);
       }); 
    }
    $('#dp1').datepicker({
            format: 'dd/mm/yyyy',
            autoclose: true
    });
    $('#dp2').datepicker({
            format: 'dd/mm/yyyy',
            autoclose: true
    });
 
    $('#idRepeat').on('change', function() {       
        if(this.value == '7'){
            estadoDate(false);
        }else{
            estadoDate(true);
            $('#dp1').val('');$('#dp2').val('');
        }        
    });
    
    $('#filtrarTarea').click(function (){
        fechaInicio = $('#dp1').val(); fechaFinal = $('#dp2').val();
        renderTable($('#idFuncionario').val(), $('#idRepeat').val(), fechaInicio, fechaFinal);
    })
    $('#btnRefresh').click(function (){
        fechaInicio = $('#dp1').val(); fechaFinal = $('#dp2').val();
        renderTable($('#idFuncionario').val(), $('#idRepeat').val(), fechaInicio, fechaFinal);
    })
    
    function renderTable(idU, idR, fi, ff){
        $.post('listaTarea.jsp',
            {idUsuario: idU, idRepeat: idR, fi:fi, ff:ff},
                    function (html) {
                    $("#tablaTarea").removeClass('loader');
                    $("#tablaTarea").html(html);
                    }
             ).fail(function (jqXHR, textStatus, errorThrown)
        {
                var alerta = "<p class='bg-danger'>error: "+errorThrown+"</p>";
                $("#tablaTarea").removeClass('loader');
                $("#tablaTarea").html(alerta);
       }); 
    }
    
    function estadoDate(valor){
        $('#dp1').prop('disabled', valor);
        $('#dp2').prop('disabled', valor);
    }
</script>
