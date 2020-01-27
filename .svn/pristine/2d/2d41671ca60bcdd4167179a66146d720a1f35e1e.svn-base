<%@page import="Entidad.A_Tarea"%>
<jsp:useBean id="_tarea" class="Controlador.A_TareaController"/>
<%
    String id = request.getParameter("id");
    A_Tarea tarea = new A_Tarea();
    tarea = _tarea.getTareaPersonalById(Integer.parseInt(id));
    
%>
<form id="form_guardar" method="post" class="form_guardar">
    <input type="hidden" value="<%=id%>" name="id" id="id">
    <div class="box-body">
                        <div class="form-group" >
                            <label>Título</label>
                            <input type="text" class="form-control" id="titulo"  name="titulo" value="<%=tarea.getTitulo()%>">                            
                        </div> 
                        <div  class="form-group">
                            <label>Descripción </label>
                            <textarea class="form-control" id="descripcion"  name="descripcion" rows=5 ><%=tarea.getDescripcion()%></textarea>
                        </div>
    </div>
    <div class="box-footer">
        <button type="button" class="btn btn-default pull-left" data-dismiss="modal"><i class="fa fa-close"></i> Cancelar</button>
        <button type="submit" class="btn-purple pull-right"><i class="fa fa-save"></i> Guardar</button>
    </div>                
    </form>
    <div  id="mensaje"></div>
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
                titulo:{
                    message: 'El título no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'El título no puede ser vacio. '
                        },
                        stringLength: {
                            min: 3,
                            max: 30,
                            message: 'El título tiene que ser mas de 6 y menos de 30 caracteres'
                        },
                        regexp: {
                            regexp: /^([-a-z0-9_-ÀÁÂÃÈÉÊÌÍÑÒÓÔÙÚÛİàáâãèéìíñòóùúûü-\s])+$/i,
                            message: 'El título solo puede constar de letras, números y guiones bajos.'
                        }
                    }
                },
                descripcion:{
                    message: 'La descripcion no es valido.',
                    validators: {
                        notEmpty: {
                            message: 'La descripcion no puede ser vacio. '
                        },
                        stringLength: {
                            min: 1,
                            max: 2000,
                            message: 'La descripcion tiene que ser mas de 1 y menos de 2000 caracteres'
                        },
                        regexp: {
                            regexp: /^([-a-z.,0-9-_-ÀÁÂÃÈÉÊÌÍÑÒÓÔÙÚÛİàáâãèéìíñòóùúûü-\s])+$/i,
                            message: 'El nombre solo puede constar de letras, números y guiones bajos.'
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
                url: "guardarTarea.jsp",
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