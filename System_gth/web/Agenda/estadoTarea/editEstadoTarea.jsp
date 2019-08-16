<%@page import="Entidad.A_EstadoTarea"%>
<jsp:useBean id="_estadoTarea" class="Controlador.A_EstadoTareaController"/>
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<%
    String idEstadoTarea = _encript.ValorADesencriptar(request.getParameter("id"));
    A_EstadoTarea estadoTarea = new A_EstadoTarea();
    estadoTarea = _estadoTarea.getEstadoTareaById(Integer.parseInt(idEstadoTarea));
    
%>
<form id="form_guardar" method="post" class="form_guardar">
    <input type="hidden" value="<%=idEstadoTarea%>" name="id" id="id">
                    <div class="box-body">                         
                        <div class="form-group" >
                            <label>Tipo de tarea</label>
                            <input type="text" class="form-control" id="nombre"  name="nombre" value="<%=estadoTarea.getNombreEstadoTarea()%>">                            
                        </div>
                        <div class="form-group">
                            <label>Estado</label>
                            <%
                                String select = "";
                                if(estadoTarea.getEstadoEstadoTarea()> 0){
                                    select = "checked";
                                }
                            %>
                            <label><input type="checkbox" name="estado" id="estado"  class="flat-red" <%=select%>></label>
                        </div>
                    </div>
                    <!-- /.box-body -->

                    <div class="box-footer">
                        <button type="button" class="btn btn-default pull-left" data-dismiss="modal"><i class="fa fa-close"></i> Cancelar</button>
                        <button type="submit" class="btn-purple pull-right"><i class="fa fa-refresh"></i> Actualizar</button>
                    </div>
                </form>
        <div id="mensaje"></div>
<script type="text/javascript">
    $(document).ready(function () {
        $('.form_guardar').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                nombre:{
                    message: 'El nombre no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'El nombre no puede ser vacio. '
                        },
                        stringLength: {
                            min: 6,
                            max: 30,
                            message: 'El nombre tiene que ser mas de 6 y menos de 30 caracteres'
                        },
                        regexp: {
                            regexp: /^([-a-z0-9_-��������������������������������-\s])+$/i,
                            message: 'El nombre solo puede constar de letras, n�meros y guiones bajos.'
                        }
                    }
                }
            }
        }).on('success.form.bv', function (e) {
            // Prevent submit form
            e.preventDefault();
            $("#mensaje").show();
            $("#mensaje").addClass("loader");


            var $form = $(e.target),
                    validator = $form.data('bootstrapValidator');
            $.ajax({
                type: "POST",
                url: "guardarEstadoTarea.jsp",
                data: $(".form_guardar").serialize(),
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