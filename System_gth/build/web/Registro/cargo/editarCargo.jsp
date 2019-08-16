<%@page import="Entidad.Cargo"%>
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="_cargo" class="Controlador.CargoController" />
<% 
    int idCargo = 0;
    String idEncript = request.getParameter("id"); 
    Cargo cargo = new Cargo();
    try {
        idCargo = Integer.parseInt(_encript.ValorADesencriptar(idEncript));
        cargo = _cargo.getCargoByCargoId(idCargo);
    }catch (Exception e) {
        idCargo = 0;
    } 
%>
<form id="form_guardar" method="post" class="form_guardar">
    <input type="hidden" value="<%=idCargo%>" name="idCargo" id="idCargo">
    
                    <div class="box-body">
                        <div class="form-group">
                            <label>Nombre</label>
                            <input type="text" class="form-control" id="nombre" name="nombre" value="<%=cargo.getNombre()%>">                            
                        </div> 
                        <div class="form-group">
                            <label>DescripciÛn</label>
                            <textarea class="form-control" rows="3" id="descripcion"  name="descripcion"><%=cargo.getDescripcion()%></textarea>                     
                        </div> 
                        <div class="form-group">
                            <label>Estado</label>
                            <%
                                String select = "";
                                if(cargo.getEstado() > 0){
                                    select = "checked";
                                }
                            %>
                            <label> <input type="checkbox" name="estado" id="estado"  class="flat-red" <%=select%>></label>                
                        </div>
                    </div>

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
                            min: 3,
                            max: 100,
                            message: 'El nombre tiene que ser mas de 3 y menos de 100 caracteres'
                        },
                        regexp: {
                            regexp: /^([-a-z()0-9_-¿¡¬√»… ÃÕ—“”‘Ÿ⁄€›‡·‚„ËÈÏÌÒÚÛ˘˙˚¸-\s])+$/i,
                            message: 'El nombre del cargo solo puede contener letras, n˙meros y guiones bajos.'
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
                url: "guardarCargo.jsp",
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