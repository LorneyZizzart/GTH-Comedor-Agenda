<%@page import="Entidad.Tipo"%>
<%@page import="Entidad.Pregunta"%>
<%@page import="java.util.*"%>
<jsp:useBean id="_pregunta" class="Controlador.PreguntaController"/>
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="_tipoPregunta" class="Controlador.TipoController" />
<%
    String idPreguntaEncript = request.getParameter("id");

    int idPregunta = 0;
    Pregunta pregunta = new Pregunta();   
    
    List<Tipo> listaTipoPregunta = new ArrayList<Tipo>();
    listaTipoPregunta = _tipoPregunta.GetAllTipo();

    try {
        idPregunta = Integer.parseInt(request.getParameter("id"));
        pregunta = _pregunta.GetPreguntaByPregunta_Id(idPregunta);
    }catch (Exception e) {
        idPregunta = 0;
    }
%>
<form id="form_guardar" method="post" class="form_guardar">
    <input type="hidden" value="<%=idPregunta%>" name="id" id="id">
            <div class="box-body">
               <div class="form-group">
                <label>Tipo</label>
                <select disabled name="idTipo" class="form-control select2" style="width: 100%;">
                  <option>Selecione una opción</option>
                  <%
                    for (Tipo item : listaTipoPregunta) {
                        String Select = "";
                        if(item.getTipo_id() == pregunta.getTipo_id())
                            Select = "Selected";
                    %>
                    <option value="<%=item.getTipo_id()%>" <%=Select%>><%=item.getNombre()%></option>
                    <% } %>
                </select>
              </div>
                <div class="form-group">
                   <label>Pregunta</label>
                   <input disabled type="text" class="form-control" id="pregunta"  name="pregunta" value="<%=pregunta.getNombre()%>">                            
                </div>                  
                <div class="form-group">
                   <label>Orden</label>
                   <input disabled type="text" class="form-control" id="orden"  name="orden" value="<%=pregunta.getOrden()%>">                            
                </div>
                <div class="form-group">
                    <label>Estado</label>
                    <%
                     String select = "";
                      if(pregunta.getEstado() > 0){
                          select = "checked";
                      }
                    %>
                     <label> <input type="checkbox" name="estado" id="estado"  class="flat-red" <%=select%>></label>
                </div>
                    </div>
                    <div class="box-footer">
                        <button type="button" class="btn btn-default pull-left" data-dismiss="modal"><i class="fa fa-close"></i> Cancelar</button>
                        <button type="button" class="btn btn-danger pull-right btn_eliminar"><i class="fa fa-trash-o"></i> Eliminar</button>
                    </div>
 </form>
<div id="mensajeDelete"></div>
<script type="text/javascript">
    $(function () {
        $('.select2').select2()
    });
    
    $(document).ready(function () {
        $(".btn_eliminar").click(function () {
            var id = $("#id").val();
            $("#mensajeDelete").show();
            $("#mensajeDelete").addClass("loader");
            $.post('deletePregunta.jsp',
                    {id: id},
                    function (html) {
                        $("#mensajeDelete").removeClass('loader');
                        $("#mensajeDelete").html(html);
                    }
            );
        });
    });
</script>