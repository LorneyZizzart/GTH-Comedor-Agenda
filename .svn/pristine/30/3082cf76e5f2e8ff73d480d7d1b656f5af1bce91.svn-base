<%@page import="Entidad.Menu"%>
<%@page import="Entidad.Opcion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<jsp:useBean id="getunOpcion" class="Controlador.OpcionController" />
<jsp:useBean id="_character" class="Controlador.CharacterController" />
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
<%
    List<Menu> ListaMenu = new ArrayList<Menu>();
    ListaMenu = consultaMenu.getAllMenu();
%>
                <form id="form_opcion_guardar" method="post" class="form_opcion_guardar">
                    <input type="hidden" value="<%=idOpcion%>" name="id" id="id">
                    <div class="box-body">
                        <div class="form-group">
                            <label>Menú</label>
                            <select class="form-control select2" name='idMenu' id='idMenu' style="width: 100%;">
                                <option value="">Selecione una opción</option>
                                <% for (Menu i : ListaMenu) {
                                        String select = "";
                                        if (opcion.getMenu_id() == i.getMenu_id()) {
                                            select = "selected='selected'";
                                        }
                                %>
                                <option value="<%=i.getMenu_id()%>" <%=select%>><%=_character.CharacterUCFirst(i.getNombre())%></option>
                                <%
                                    }
                                %>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Nombre Opción</label>
                            <input type="text" class="form-control" id="opcion_nombre"  name="opcion_nombre" placeholder="Ingresar Nombre" value="<%=_character.CharacterUCFirst(opcion.getNombre())%>">                            
                        </div>                        
                        <div class="form-group">
                            <label>Estado</label>
                            <%
                                String select = "";
                                if (opcion.getEstado() > 0) {
                                    select = "checked";
                                }%>
                            <label> <input type="checkbox" name="opcion_estado" id="opcion_estado"  class="flat-red" <%=select%>></label>
                        </div>

                        <div class="form-group">
                            <label>Posición</label>
                            <input type="text" class="form-control" id="opcion_posicion" name="opcion_posicion" placeholder="Ingresar Posición" value="<%=opcion.getOrden()%>">
                        </div>

                        <div class="form-group">
                            <label>Url</label>
                            <input type="text" class="form-control"  id="opcion_url" name="opcion_url" placeholder="Icono" value="<%=opcion.getUrl()%>">
                        </div>      
                        <div class="form-group">
                            <label>Descripción</label>
                            <input type="text" class="form-control"  id="opcion_descripcion" name="opcion_descripcion" placeholder="Icono" value="<%=opcion.getDescriocion()%>">
                        </div> 
                    </div>
                    <!-- /.box-body -->

                    <div class="box-footer">
                        <button type="button" class="btn btn-default pull-left" data-dismiss="modal"><i class="fa fa-close"></i> Cancelar</button>
                        <button type="submit" class="btn-purple pull-right"><i class="fa fa-refresh"></i> Actualizar</button>
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
        $('.form_opcion_guardar').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                opcion_nombre: {
                    message: 'El nombre no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'El nombre no puede ser vacio. '
                        }
                    }
                },
                opcion_posicion: {
                    messaje: 'Numero Posicion no es valido',
                    validators: {
                        notEmpty: {
                            message: 'Posicion no puede ser vacio. '
                        },
                        integer: {
                            message: 'El valor tiene que ser numero'
                        }
                    }
                },
                opcion_url: {
                    message: 'URL no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'URL no puede ser vacio. '
                        }
                    }
                },
                idMenu: {
                    validators: {
                        notEmpty: {
                            message: 'Menú es requerido'
                        }
                    }
                },
                opcion_descripcion: {
                    validators: {
                        notEmpty: {
                            message: 'Descripción es requerido'
                        }
                    }
                }
            }
        }).on('success.form.bv', function (e) {            
            e.preventDefault();
            $("#mensaje").show();
            $("#mensaje").addClass("loader");

            var $form = $(e.target),
                    validator = $form.data('bootstrapValidator');
            $.ajax({
                type: "POST",
                url: "opcion_guardar.jsp",
                data: $(".form_opcion_guardar").serialize(),
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
    });
</script>