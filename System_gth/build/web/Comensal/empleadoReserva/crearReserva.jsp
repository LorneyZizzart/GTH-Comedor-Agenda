<%@page import="java.text.DateFormat"%>
<%@page import="Entidad.C_Empleado_Reserva"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="Entidad.C_TipoComensal"%>
<%@page import="Entidad.C_TipoComida"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<jsp:useBean id="_tipoComida" class="Controlador.C_TipoComidaController"/>
<jsp:useBean id="_tipoComensal" class="Controlador.C_TipoComensalesController"/>
<jsp:useBean id="_empleadoReserva" class="Controlador.C_EmpleadoReservaController"/>
<%  
    String idUsuario = request.getParameter("idUser");
    String dataStart = request.getParameter("fechaInicio");
    String dataEnd = request.getParameter("fechaFin");    
    String dataNow = request.getParameter("fechaNow");
    String diaInicio = request.getParameter("diaInicio");
    String tipoComensal = null;
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    DateFormat dateFormat = new SimpleDateFormat("HH:mm");
    //para enviar la fecha y revise si existe registros
    String fecha[] = dataStart.split("/");
    //variable para obtener la fecha de hoy
    Calendar dateNow = Calendar.getInstance();
    //variable para almacenar la fecha de inicio
    Calendar Month = Calendar.getInstance();
    //variable para obtener la hora de hoy
    Date dateHora = new Date();
    String horaNow[] = dateFormat.format(dateHora).split(":");
    Date dateStart = formatter.parse(dataStart);
    Month.setTime(dateStart);
    List<C_Empleado_Reserva> reservasNow = new ArrayList<C_Empleado_Reserva>();
    List<C_TipoComensal> listaComensal = new ArrayList<C_TipoComensal>();
    List<C_TipoComida> listaTipoComida = new ArrayList<C_TipoComida>();
    listaComensal = _tipoComensal.getAllTipoComensal();
    listaTipoComida = _tipoComida.getAllTipoComida();
    reservasNow = _empleadoReserva.getReservaByIdDate(Integer.parseInt(idUsuario), fecha[2]+"/"+fecha[1]+"/"+fecha[0]);
    
    for(C_TipoComensal item : listaComensal){
        if(Integer.parseInt(diaInicio) >= item.getDiaInicio() && item.getEstado() == 1){
            tipoComensal = item.getNombreComensal();
        }
//        else if(dateNow.get(Calendar.MONTH) != Month.get(Calendar.MONTH)&& item.getEstado() == 1){
//            tipoComensal = item.getNombreComensal();
//        }
    }

%>
<input type="hidden" value="<%=listaTipoComida.size()%>" name="lengthComida" id="lengthComida">
<form id="form_guardar" method="post" class="form_guardar">
    <input type="hidden" value="<%=idUsuario%>" name="idUsuario" id="idUsuario">
    <input type="hidden" value="<%=dataStart%>" name="fechaInicio" id="fechaInicio">
    <input type="hidden" value="<%=dataEnd%>" name="fechaFin" id="fechaFin">
                    <div class="box-body">
                        <div class="form-group">
                            <p>Comensal: <span class="badge bg-purple"><%=tipoComensal%></span>  </p>                             
                        </div> 
                        
                        <h4 style="color: #501482" class="page-header">Tipos de alimentos</h4>
                        <div class="form-group groupTipoAlimento">
                            <%
                                int contador = 0;    
                                for(C_TipoComida item : listaTipoComida){
                                    contador++;
                                    String estado = "";
                                                                                                        
                                    if(item.getEstado() == 1){
                                        String horaAnticipacion[] = item.getHorasAnticipacion().split(":");
                                        String horaComida[] = item.getHora().split(":"); 
                                        
                                        for(C_Empleado_Reserva reserva : reservasNow){
                                            if(reserva.getIdTipoComida() == item.getIdTipoComida()){
                                                estado = "disabled";
                                            }
                                        }
                                        if(dataStart.equals(dataNow)){
                                            if(Integer.parseInt(horaNow[0]) > (Integer.parseInt(horaComida[0])-Integer.parseInt(horaAnticipacion[0]))){
                                                estado = "disabled";
                                            }else{
                                               estado = ""; 
                                            }
                                        }
                                        
                                %>
                                <label class="col-md-5">
                                    <input <%=estado%> id="posicion" type="checkbox" class="minimal posicion<%=contador%>"> <%=item.getNombreComida()%>
                                </label>
                                <div style="padding: 0" class="col-md-7">
                                    <input type="text" class="form-control cantidad<%=contador%>" id="cantidad" name="cantidad<%=item.getNombreComida()%>" disabled>    
                                </div>
                              <% } } %>
                        </div>  
                        <div class="form-group">
                            <label>Observación</label>
                            <textarea class="form-control" rows="3" id="observacion"  name="observacion"></textarea>
                        </div>
                    </div>
                    <!-- /.box-body -->

                    <div class="box-footer">
                        <button type="button" class="btn btn-default pull-left" data-dismiss="modal"><i class="fa fa-close"></i> Cerrar</button>
                        <button type="submit" class="btn-purple pull-right"><i class="fa fa-calendar-check-o"></i> Reservar</button>
                    </div>
                </form>
        <div id="mensaje"></div>
<script type="text/javascript">
$(document).ready(function () {
    var array = [];
    for(var i = 1; i <= $("#lengthComida").val(); i++){
        array.push(i);
    }
    array.forEach(function (element){
      $('.posicion'+ element).change(function() {
            if(this.checked) {
              $('.cantidad'+element).prop("disabled", false);
              $('.cantidad'+element).val("1");
            } else {
              $('.cantidad'+element).prop("disabled", true);
              $('.cantidad'+element).val("");
            }
       });  
    })
    
        $('.form_guardar').bootstrapValidator({
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
                url: "guardarReservaEmpleado.jsp",
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