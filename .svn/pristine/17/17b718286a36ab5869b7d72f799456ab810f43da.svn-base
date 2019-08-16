<%@page import="Entidad.Menu"%>
<jsp:useBean id="getunMenu" class="Controlador.MenuController" />
<jsp:useBean id="_character" class="Controlador.CharacterController" />
<%
    int idMenu = 0;
    Menu menu = new Menu();
    try {
        idMenu = Integer.parseInt(request.getParameter("id"));
        menu = getunMenu.getMenuById(idMenu);
    } catch (Exception e) {
        idMenu = 0;
    }
%>
                <form id="form_menu_guardar"  class="form_menu_guardar">
                    <input type="hidden" value="<%=idMenu%>" name="id" id="id">
                    <div class="box-body">
                        <div class="form-group">
                            <label>Nombre</label>
                            <input type="text" class="form-control" id="modulo_nombre"  name="modulo_nombre" placeholder="Ingresar Nombre" value="<%=_character.CharacterUCFirst(menu.getNombre())%>" disabled>                            
                        </div>                        
                        <div class="form-group">
                            <label>Estado</label>
                            <%
                                String select = "";
                                if (menu.getEstado() > 0) {
                                    select = "checked";
                                }%>
                            <label> <input type="checkbox" name="modulo_estado" id="modulo_estado"  class="flat-red" <%=select%> disabled></label>
                        </div>

                        <div class="form-group">
                            <label>Posición</label>
                            <input type="text" class="form-control" id="modulo_posicion" name="modulo_posicion" placeholder="Ingresar Posición" value="<%=menu.getPosicion()%>" disabled>
                        </div>

                        <div class="form-group">
                            <label>Icono</label>
                            <input type="text" class="form-control"  id="modulo_icono" name="modulo_icono" placeholder="Icono" value="<%=menu.getIcono()%>" disabled>
                        </div>                        
                    </div>
                    <!-- /.box-body -->

                    <div class="box-footer">
                        <button type="button" class="btn btn-default pull-left" data-dismiss="modal"><i class="fa fa-close"></i> Cancelar</button>
                        <button type="button" class="btn_eliminar btn btn-danger pull-right"><i class="fa fa-trash-o"></i> Eliminar</button>
                    </div>
                </form>
                <div id="mensaje"></div>
                
<script type="text/javascript">
    $(document).ready(function () {
        $(".btn_eliminar").click(function () {
            var id_menu = $("#id").val();
            $("#mensaje").show();
            $("#mensaje").addClass("loader");
            $.post('eliminaMenu_elimina.jsp',
                    {id: id_menu},
                    function (html) {
                        $("#mensaje").removeClass('loader');
                        $("#mensaje").html(html);
                    }
            );
        });
    });
</script>