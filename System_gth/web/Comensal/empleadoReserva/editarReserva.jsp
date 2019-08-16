<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="Entidad.C_Empleado_Reserva"%>
<%@page import="Entidad.C_TipoComensal"%>
<%@page import="Entidad.C_TipoComida"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<jsp:useBean id="_tipoComida" class="Controlador.C_TipoComidaController"/>
<jsp:useBean id="_tipoComensal" class="Controlador.C_TipoComensalesController"/>
<jsp:useBean id="_reservaEmpleado" class="Controlador.C_EmpleadoReservaController"/>
<%  
    int idReserva = Integer.parseInt(request.getParameter("id"));
    String nombreReserva = request.getParameter("nombre");  
    String data = request.getParameter("fechaInicial");
    String dataNow = request.getParameter("fechaNow");
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    DateFormat dateFormat = new SimpleDateFormat("HH:mm");
//    variable para obtener la fecha recibida
    Date dateStart = formatter.parse(data);
//    variable para obtener la fecha de hoy
    Date date = formatter.parse(dataNow);
//    variable para obtener la hora de hoy
    Date dateHora = new Date();
    String horaNow[] = dateFormat.format(dateHora).split(":");
    String tipoComensal = null;
    String estado = "";

    List<C_TipoComensal> listaComensal = new ArrayList<C_TipoComensal>();
    C_Empleado_Reserva empleadoReserva = new C_Empleado_Reserva();
    listaComensal = _tipoComensal.getAllTipoComensal();
    empleadoReserva = _reservaEmpleado.getReservaEmpleadoById(idReserva);
    for (C_TipoComensal item : listaComensal) {
        if(item.getTipoComensal_id() == empleadoReserva.getIdTipoComensal()){
            tipoComensal = item.getNombreComensal();
        }
    }
    String horaAnticipacion[] = empleadoReserva.getHorasAnticipacion().split(":");
    String horaComida[] = empleadoReserva.getHora().split(":");
//    System.out.print("HoraNow: "+Integer.parseInt(horaNow[0]));
//    System.out.print("Hora: "+(Integer.parseInt(horaComida[0])-Integer.parseInt(horaAnticipacion[0])));
    
    if(dateStart.before(date)){
        estado = "disabled";
    }else if(date.before(dateStart)){
//        falta aun validar la hora de reserva de desayuno
         estado = "";
    }else{
//        hay que comparar las fechas que sean iguales para que solo esa x la hora
         if(Integer.parseInt(horaNow[0]) > (Integer.parseInt(horaComida[0])-Integer.parseInt(horaAnticipacion[0]))){
            estado = "disabled";
         }else{
            estado = ""; 
         }
         
    }
%>
<form id="form_guardar" method="post" class="form_guardar">
    <input type="hidden" value="<%=idReserva%>" name="id" id="id">
                    <div class="box-body">
                         <div class="form-group">
                            <p>Comensal: <span class="badge bg-purple"><%=tipoComensal%></span>  </p> 
                        </div> 
                            <h4 style="color: #501482" class="page-header">Tipos de alimento</h4>
                        <div class="form-group groupTipoAlimento">

                                <label class="col-md-5">
                                    <i class="fa fa-spoon"></i> <%=nombreReserva%>
                                </label>
                                <div style="padding: 0" class="col-md-7">
                                    <input disabled type="text" class="form-control" id="cantidad" name="cantidad" value="<%=empleadoReserva.getCantidad()%>">    
                                </div>

                        </div>  <br>
                        <div class="form-group">
                            <label>Observación</label>
                            <textarea <%=estado%> class="form-control" rows="3" id="observacion"  name="observacion"><%=empleadoReserva.getObservacion()%></textarea>
                        </div>
                    </div>
                    <!-- /.box-body -->

                    <div class="box-footer">
                        <button type="button" class="btn btn-danger pull-left btn_eliminar" <%=estado%>><i class="fa fa-trash"></i> Cancelar</button>
                        <button type="submit" class="btn-purple pull-right" <%=estado%> ><i class="fa fa-refresh"></i> Actualizar</button>
                    </div>
                </form>
        <div id="mensaje"></div>
<script type="text/javascript">
$(document).ready(function () {
    
        $('.form_guardar').bootstrapValidator({
//            SOLO VALIDA TRES TIPOS DE COMIDAS [DESAYUNO, ALMUERZO, CENA]
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                idTipoComensal: {
                    validators: {
                        notEmpty: {
                            message: 'El tipo de comensal es requerido'
                        }
                    }
                },
                cantidad: {
                    message: 'El valor no es valido.',
                    validators: 
                    {
                        notEmpty: 
                        {
                            message: 'La cantidad no puede ser vacio. '
                        },
                        stringLength: 
                        {
                            min: 1,
                            max: 2,
                            message: 'Solo puede tener 2 caracteres.'
                        },
                        integer: {
                            message: 'El valor debe ser un número entero.'
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
                url: "actualizarReserva.jsp",
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
        
        $(".btn_eliminar").click(function () {
            $("#mensaje").show();
            $("#mensaje").addClass("loader");
            $.post('eliminarReserva.jsp',
                    {id: $("#id").val()},
                    function (html) {
                        $("#mensaje").removeClass('loader');
                        $("#mensaje").html(html);
                    }
            );
        });
        
    });
</script>