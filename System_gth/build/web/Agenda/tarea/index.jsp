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
<%
    List<A_RepeticionTarea> listaR = new ArrayList<A_RepeticionTarea>();
    String[] listaRe = new String[]{"Todo", "Hoy", "Semanal", "Quincenal", "Mensual", "Semestral", "Anual"};
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
    <div class="row">
        <div class="col-xs-4">
        <div class="box" style="border-top: none">
            <div class="box-header">
                <div class="form-group">
                    <label for="inputEmail3" class="col-sm-2 control-label" style="padding: 7px 0 0 10%;">Ver</label>

                  <div class="col-sm-10">
                    <select id="idRepeat" name="idRepeticion"  class="form-control selectRepeticion" style="width: 100%;">
                        <option value="0" disabled selected="selected">Selecione una opción</option>
                        <%
                            int c = 0;
                            for(String r : listaRe){ 
                                %>
                                <option value="<%=c%>"><%=r%></option>                            
                        <% c++; }  %>
                    </select>
                  </div>
                </div>
            </div>
        </div>
    </div>
    </div>   
    
   <div id="tablaTarea" class="row"></div>
   
</section>
<%@ include file= "../../masterPage/complemento/footer.jsp" %> 
<script>
    
    $(document).ready(function() {
        renderTable($('#idUsuario').val(), 0);
          
    });
    $('#idRepeat').on('change', function() {       
        renderTable($('#idUsuario').val(), this.value);
    });
    
    function renderTable(idU, idR){
        $.post('listaTarea.jsp',
            {idUsuario: idU, idRepeat: idR},
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
</script>
