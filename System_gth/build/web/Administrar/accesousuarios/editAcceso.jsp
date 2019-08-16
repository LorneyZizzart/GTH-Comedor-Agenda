<%@page import="java.math.BigInteger"%>
<%@page import="java.security.*"%>
<%@page import="Entidad.Opcion"%>
<%@page import="Entidad.Menu"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Entidad.Usuario_opcion"%>
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="_menu" class="Controlador.MenuController" />
<jsp:useBean id="_opciones" class="Controlador.Usuario_opcionController" />
<%
    String idEncript = request.getParameter("id");
    int id_user = Integer.parseInt(_encript.ValorADesencriptar(idEncript));
    
    List<Menu> menus = new ArrayList<Menu>();
    menus = _menu.getAllMenuAndOpcion();
//
//    int id_user = Integer.parseInt(request.getParameter("id"));
    List<Usuario_opcion> opciones_user = new ArrayList<Usuario_opcion>();
    opciones_user = _opciones.GetAllUsuarioOpcionByUser_id(id_user);
%> 
                <div class="box-header">
                    <h3 class="box-title">Lista de Modulos y Accesos</h3>
                </div>
                <!-- /.box-header -->
                <div class="box-body"><input type="hidden" id="idUser_sys" name="idUser_sys" value="<%=id_user%>"  >
                    <%
                        for (Menu item : menus) {
                    %>
                    <div>
                        <div class="box-header with-border">
                            <h3 class="box-title"><i class="<%=item.getIcono()%>"></i>  <%=item.getNombre()%></h3>
                            <div class="box-tools">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                            </div>
                        </div>
                        <div class="box-body no-padding">
                            <ul class="nav nav-pills nav-stacked">                                                                
                                <% for (Opcion o : item.getOpciones()) {
                                        String checked = "";
                                        for (Usuario_opcion opcion : opciones_user) {
                                            if (o.getOpcion_id() == opcion.getOpcion_id()) {
                                                checked = "checked";
                                            }
                                        }
                                %>
                                <li>
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" name="ids" id="ids" class="ids" value="<%=o.getOpcion_id()%>" <%=checked%>> <%=o.getNombre()%>
                                        </label>
                                    </div>                                           
                                </li>
                                <%
                                    }
                                %>
                            </ul>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <%
                        }
                    %>

                    <div id="mensaje"></div>
                    <!-- /. box -->
                </div>
                <!-- /.box-body -->


<script type="text/javascript">
    $(document).ready(function () {
        $(".btn_actualiza_acceso").click(function () {

            var id_menu = $("#id").val();
            $("#mensaje").show();
            $("#mensaje").addClass("loader");

            var checkboxValues = new Array();
            $('input[name="ids"]:checked').each(function () {
                //var id = $(this).attr('id');
                //var value = $(this).val();
                if ($(this).prop('checked')) {
                    checkboxValues.push($(this).val());
                }
            });
            //alert(checkboxValues);
            $.post('guarda_accesos.jsp',
                    {ids: checkboxValues},
                    function (html) {
                        $("#mensaje").removeClass('loader');
                        $("#mensaje").html(html);
                    }
            );
        });

        $('.ids').change(function ()
        {
            var opcion = $(this).val();
            var user = $("#idUser_sys").val();
            //alert(this.checked);
            if (this.checked == true) {
                //añadimos
                $.post('guarda_accesos.jsp',
                        {opcion: opcion,
                            user: user,
                            accion: 1},
                        function (html) {
                            if (html.trim() == "Ok") {
                                toastr.success("Añadido Correctamente.");
                            } else {
                                toastr.error("Se produjo un error."+html);
                            }
                        });

            } else {
                //Eliminamos
                $.post('guarda_accesos.jsp',
                        {opcion: opcion,
                            user: user,
                            accion: 2},
                        function (html) {
                            if (html.trim() == "Ok") {
                                toastr.success("Quitado Correctamente.");
                            } else {
                                toastr.error("Se produjo un error."+html);
                            }
                        });
            }
        });
    });
</script>