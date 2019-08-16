<%@page import="Entidad.Opcion"%>
<%@page import="Entidad.Menu"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<jsp:useBean id="getunOpcion" class="Controlador.OpcionController" />
<%
    int idOpcion = 0;
    Opcion opcion = new Opcion();
    try {
        idOpcion = Integer.parseInt(request.getParameter("id"));
        opcion = getunOpcion.GetOpcionById(idOpcion);
    } catch (Exception e) {
        idOpcion = 0;
    }
%>
<jsp:useBean id="consultaMenu" class="Controlador.MenuController" />
<jsp:useBean id="_character" class="Controlador.CharacterController" />
<%
    List<Menu> ListaMenu = new ArrayList<Menu>();
    ListaMenu = consultaMenu.getAllMenu();
%>
                <form id="form_opcion_guardar" method="post" class="form_opcion_guardar">
                    <input type="hidden" value="<%=idOpcion%>" name="id" id="id">
                    <div class="box-body">
                        <div class="form-group">
                            <label>Menú</label>
                            <select class="form-control select2" name='idMenu' id='idMenu' style="width: 100%;" disabled>
                                <option value="">- Seleccionar -</option>
                                <% for (Menu i : ListaMenu) {
                                        String select = "";
                                        if (opcion.getMenu_id() == i.getMenu_id()) {
                                            select = "selected='selected'";
                                        }
                                %>
                                <option value="<%=i.getMenu_id()%>" <%=select%>><%=i.getNombre()%></option>
                                <%
                                    }
                                %>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Nombre Opción</label>
                            <input type="text" class="form-control" id="opcion_nombre"  name="opcion_nombre" placeholder="Ingresar Nombre" value="<%=_character.CharacterUCFirst(opcion.getNombre())%>" disabled>                            
                        </div>                        
                        <div class="form-group">
                            <label>Estado</label>
                            <%
                                String select = "";
                                if (opcion.getEstado() > 0) {
                                    select = "checked";
                                }%>
                            <label> <input type="checkbox" name="opcion_estado" id="opcion_estado"  class="flat-red" <%=select%> disabled></label>
                        </div>

                        <div class="form-group">
                            <label>Posición</label>
                            <input type="text" class="form-control" id="opcion_posicion" name="opcion_posicion" placeholder="Ingresar Posición" value="<%=opcion.getOrden()%>" disabled>
                        </div>

                        <div class="form-group">
                            <label>Url</label>
                            <input type="text" class="form-control"  id="opcion_url" name="opcion_url" placeholder="Icono" value="<%=opcion.getUrl()%>" disabled>
                        </div>      
                        <div class="form-group">
                            <label>Descripción</label>
                            <input type="text" class="form-control"  id="opcion_descripcion" name="opcion_descripcion" placeholder="Icono" value="<%=opcion.getDescriocion()%>" disabled>
                        </div> 
                    </div>
                    <!-- /.box-body -->

                    <div class="box-footer">
                        <button type="button" class="btn btn-default btn_canselar"><i class="fa fa-close"></i> Cancelar</button>
                        <button type="button" class="btn btn-danger pull-right btn_eliminar"><i class="fa fa-trash-o"></i> Eliminar</button>
                    </div>
                </form>
                <div id="mensaje"></div>

<script>
    $(function () {
        $('.select2').select2()
    });
</script>

<script type="text/javascript">
    $(document).ready(function () {

        $(".btn_eliminar").click(function () {
            var id_menu = $("#id").val();
            $("#mensaje").show();
            $("#mensaje").addClass("loader");
            $.post('eliminaopcion_elimina.jsp',
                    {id: id_menu},
                    function (html) {
                        $("#mensaje").removeClass('loader');
                        $("#mensaje").html(html);
                    }
            );
        });
    });
</script>