
<%@page import="Entidad.Usuario"%>
<%@page import="Entidad.C_TipoComida"%>
<%@page import="Entidad.C_TipoComensal"%>
<%@ include file= "../../masterPage/complemento/head.jsp" %> 
<%    HttpSession sesionmenus = request.getSession();
    if (sesionmenus.getAttribute("USUARIO") != null) {
%>
<%@ include file= "../../masterPage/complemento/menu.jsp" %> 
<%    }
%>
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="_tipoComida" class="Controlador.C_TipoComidaController"/>
<jsp:useBean id="_tipoComensal" class="Controlador.C_TipoComensalesController"/>
<jsp:useBean id="consultaUser" class="Controlador.UsuarioController" />
<%
    List<Usuario> Usuarios = new ArrayList<Usuario>();
    Usuarios = consultaUser.GetAllUser();
    String[] listaRe = new String[]{"Todo", "Hoy", "Predeterminado"};
    List<C_TipoComida> listaTipoComida = new ArrayList<C_TipoComida>();
    List<C_TipoComensal> listaComensal = new ArrayList<C_TipoComensal>();
    listaTipoComida = _tipoComida.getAllTipoComida();
    listaComensal = _tipoComensal.getAllTipoComensal();
%>
<section class="content-header">
    <h1>
        Registro
        <small> de reservas</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Inicio</a></li>
        <li class="active">Lista de reservas</li>
    </ol>
</section>

<section class="content">
    <div class="box box-purple" >
            <div class="box-header">
                <div class="row">
                    <div class="col-sm-12 col-md-4">
                        <div class="form-group">
                            <label class="col-md-3 control-label" style="padding: 0;">Tipo funcionario:</label>
                            <div class="col-md-9 col-xs-12 input-group">
                              <select id="tipoFuncionario" name="tipoFuncionario" class="form-control" style="width: 100%;">
                                <option value="0" selected>Todos</option>
                                <option value="1">Funcionario</option>
                                <option value="2">No Funcionario</option>
                            </select>  
                            </div>                        
                        </div>  
                    </div>
                    <div class="col-sm-12 col-md-4">
                         <div class="form-group">
                                <label class="col-md-3 control-label" style="padding: 1% 0 0 0;">Tipos de comensal:</label>
                                <div class="col-md-9 col-xs-12 input-group">
                                   <select id="idTipoCo" name="idTipoCo" class="form-control selectComensal" multiple="multiple" data-placeholder="Selelcione una opción"
                                        style="width: 100%;">
                                       <option value="0" selected>Todos</option>
                                  <%
                                    for(C_TipoComensal item : listaComensal){
                                        if(item.getEstado() == 1){
                                            %>
                                   <option value="<%=item.getTipoComensal_id()%>"><%=item.getNombreComensal()%></option>
                                    <%
                                        }
                                    }
                                  %>
                                </select> 
                                </div>
                                
                              </div>      
                    </div>
                    <div class="col-sm-12 col-md-4">
                        <div class="form-group">
                            <label class="col-md-3 control-label" style="padding: 1% 0 0 0;">Tipos de alimento:</label>
                            <div class="col-md-9 col-xs-12 input-group">
                               <select id="idTipoAl" name="idTipoAl" class="form-control selectComida" multiple="multiple" data-placeholder="Selecione una opción"
                                        style="width: 100%;">
                                   <option value="0" selected>Todos</option>
                                  <%
                                    for(C_TipoComida item : listaTipoComida){
                                        if(item.getEstado() == 1){
                                            %>
                                   <option value="<%=item.getIdTipoComida()%>"><%=item.getNombreComida()%></option>
                                    <%
                                        }
                                    }
                                  %>
                                </select> 
                            </div>
                                
                              </div>      
                    </div>
                    <div class="col-sm-12 col-md-3">
                        <div class="form-group">
                        <label class="col-md-3 control-label" style="padding: 2% 0 0 0;">Comensal:</label>
                        <div class="col-md-9 col-xs-12 input-group">
                          <div id="listaComensal"></div> 
                        </div>                        
                      </div>
                    </div>
                    
                    <div class="col-sm-12 col-md-3">
                            <div id="sfi" class="form-group">
                                <label class="col-md-2 control-label" style="padding: 2% 0 0 0;">Ver:</label>

                            <div class="col-md-10 col-xs-12 input-group">
                              <select id="idRepeat" name="idRepeat"  class="form-control selectRepeticion" style="width: 100%;">
                                  <%
                                      int c = 0;
                                      for(String r : listaRe){
                                          String select = "";
                                          if(c==1)
                                              select = "Selected";
                                          %>
                                          <option value="<%=c%>" <%=select%>><%=r%></option>                            
                                  <% c++; }  %>
                              </select>
                            </div>
                            </div>
                    </div>
                    
                    <div class="col-sm-12 col-md-3">
                        <div id="sfi" class="form-group">
                            <label class="col-sm-4 control-label" style="padding: 2% 0 0 0;">Fecha incio:</label>
                            <div class="input-group date col-sm-8">
                              <div class="input-group-addon">
                                <i class="fa fa-calendar"></i>
                              </div>
                              <input type="text" class="form-control pull-right" name="fi" id="dp1" autocomplete="off">
                            </div>
                        </div>       
                    </div>
                    <div class="col-sm-12 col-md-3">
                        <div id="sfi" class="form-group">
                            <label class="col-sm-4 control-label" style="padding: 2% 0 0 0;">Fecha final:</label>
                            <div class="input-group date col-sm-8">
                              <div class="input-group-addon">
                                <i class="fa fa-calendar"></i>
                              </div>
                              <input type="text" class="form-control pull-right" name="fi" id="dp2" autocomplete="off">
                            </div>
                        </div>       
                    </div>
                    
                    <div class="col-xs-12 col-md-2 pull-right">
                        <button id="filtrarTarea" type="button" class="btn-purple btn-block" ><i class="fa fa-search"></i> Filtrar</button>   
                        
                    </div>
                </div>  
                
            </div>
        </div>
    
    <div id="tablaReservas" class="row"></div>
    
    
    <!-- /.row -->
    <!--Modal-->
    <div class="modal fade" id="formulario_registro">
        <div class="modal-dialog modal-dialog-edit">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span></button>
                    <h4 id="titleModal" class="modal-title">title</h4>
                </div>
                <div class="modal-body cuerpo_registro"></div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>
</section>
<%@ include file= "../../masterPage/complemento/footer.jsp" %> 
<script>
    $('.formNuevo').tooltip({ boundary: 'window' })
    $('#example').tooltip({ boundary: 'window' })
        
    $(function () {
        $("#example1").DataTable();
    });  
    var fechaInicio  = "", fechaFinal = "";
    $(document).ready(function() {
        $('.selectComensal').select2();
        $('.selectComida').select2();
        $('.selectFuncionario').select2();
        $('.formNuevo').tooltip({ boundary: 'window' });
        $('#example').tooltip({ boundary: 'window' });
        $('#dp1').datepicker({
            format: 'dd/mm/yyyy',
            autoclose: true
        });
        $('#dp2').datepicker({
                format: 'dd/mm/yyyy',
                autoclose: true
        });
        estadoDate(true);
        renderTable("0%2", $('#idRepeat').val(), fechaInicio, fechaFinal, $('#idTipoCo').val(), $('#idTipoAl').val(), 0);
        
        renderListComensal(0)

        
        $('#tipoFuncionario').on('change', function() { 
            renderListComensal(this.value)
        });
        
    });
    $('#filtrarTarea').click(function (){
        fechaInicio = $('#dp1').val(); fechaFinal = $('#dp2').val();
        renderTable($('#idEmpleado').val(), $('#idRepeat').val(), fechaInicio, fechaFinal, $('#idTipoCo').val(), $('#idTipoAl').val(), $('#tipoFuncionario').val());
    })
     $('#idRepeat').on('change', function() {       
        if(this.value == '2'){
            estadoDate(false);
        }else{
            estadoDate(true);
            $('#dp1').val('');$('#dp2').val('');
        }        
    });
    $(".formNuevo").click(function (e) {
        $("#titleModal").html("Generar reporte");
        $(".modal-dialog").width(500);
        e.preventDefault();
        e.stopImmediatePropagation();
            $('#formulario_registro').modal('show');
            $(".cuerpo_registro").html('');
            $(".cuerpo_registro").addClass('loader');
            //$.post('lista_cuenta_duplicada.jsp',
            $.post('crearReporte.jsp',
            {id: $(this).attr('data-id')},
                    function (html) {
                    $(".cuerpo_registro").removeClass('loader');
                    $(".cuerpo_registro").html(html);
                    }
             ).fail(function (jqXHR, textStatus, errorThrown)
            {
                var alerta = "<p class='bg-danger'>error: "+errorThrown+"</p>";
                $(".cuerpo_registro").removeClass('loader');
                $(".cuerpo_registro").html(alerta);
            });
    });
    function estadoDate(valor){
        $('#dp1').prop('disabled', valor);
        $('#dp2').prop('disabled', valor);
    }
    function renderTable(idE, idR, fi, ff, co, al, tipoFuncionario){
        $.post('listaReserva.jsp',
            {idEmpleado:idE, idRepeticion:idR, fi:fi, ff:ff, co:co, al:al, tipoFuncionario:tipoFuncionario},
                    function (html) {
                    $("#tablaReservas").removeClass('loader');
                    $("#tablaReservas").html(html);
                    }
             ).fail(function (jqXHR, textStatus, errorThrown)
        {
                var alerta = "<p class='bg-danger'>error: "+errorThrown+"</p>";
                $("#tablaReservas").removeClass('loader');
                $("#tablaReservas").html(alerta);
       }); 
    }
    
    function renderListComensal(idTipoComensal){
        $.post('listaComensal.jsp',
            {idTipoComensal:idTipoComensal},
                    function (html) {
                    $("#listaComensal").removeClass('loader');
                    $("#listaComensal").html(html);
                    }
             ).fail(function (jqXHR, textStatus, errorThrown)
        {
                var alerta = "<p class='bg-danger'>error: "+errorThrown+"</p>";
                $("#listaComensal").removeClass('loader');
                $("#listaComensal").html(alerta);
       }); 

    }
</script>
