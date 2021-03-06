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
    Calendar fechaAnticipacion = Calendar.getInstance();
    Date dateNow = formatter.parse(fechaAnticipacion.get(Calendar.DATE)+"/"+(fechaAnticipacion.get(Calendar.MONTH)+1)+"/"+fechaAnticipacion.get(Calendar.YEAR));
    fechaAnticipacion.setTime(dateNow);
//    System.out.print("fecha now: "+fechaAnticipacion.get(Calendar.DATE)+"/"+fechaAnticipacion.get(Calendar.MONTH)+"/"+fechaAnticipacion.get(Calendar.YEAR));
    //variable para almacenar la fecha de inicio
    Calendar auxDateStart = Calendar.getInstance();
    //variable para obtener la hora de hoy
    Date dateHora = new Date();
    String horaNow[] = dateFormat.format(dateHora).split(":");
    Date dateStart = formatter.parse(dataStart);
    auxDateStart.setTime(dateStart);
    
    List<C_Empleado_Reserva> reservasNow = new ArrayList<C_Empleado_Reserva>();
    List<C_TipoComensal> listaComensal = new ArrayList<C_TipoComensal>();
    List<C_TipoComida> listaTipoComida = new ArrayList<C_TipoComida>();
    listaComensal = _tipoComensal.getAllTipoComensal();
    listaTipoComida = _tipoComida.getAllTipoComida();
    reservasNow = _empleadoReserva.getReservaByIdDate(Integer.parseInt(idUsuario), fecha[2]+"/"+fecha[1]+"/"+fecha[0]);
//    System.out.print("fecha now "+fechaAnticipacion.getTime());    
    fechaAnticipacion.add(Calendar.DATE, listaComensal.get(1).getDiasAnticipacion());
//    System.out.print("fecha reserva: "+auxDateStart.getTime());
//    System.out.print("dias anticipación: "+fechaAnticipacion.getTime());
    if(auxDateStart.after(fechaAnticipacion) || auxDateStart.equals(fechaAnticipacion)){
        tipoComensal = listaComensal.get(1).getNombreComensal();
    }else{
        tipoComensal = listaComensal.get(0).getNombreComensal();
    }   

%>
<input type="hidden" value="<%=listaTipoComida.size()%>" name="lengthComida" id="lengthComida">
<form id="form_guardar" method="post" class="form_guardar">
    <input type="hidden" value="<%=idUsuario%>" name="idUsuario" id="idUsuario">
    <input type="hidden" value="<%=dataStart%>" name="fechaInicio" id="fechaInicio">
    <input type="hidden" value="<%=dataEnd%>" name="fechaFin" id="fechaFin">
                    <div class="box-body">
                        <div class="form-group col-md-12">
                            <div class=" col-sm-6"><p >Comensal: <span class="badge bg-purple"><%=tipoComensal%></span>  </p> </div>   
                            <div class=" col-sm-6"><label> <input  id="repetir" name="repetir" type="checkbox" class="minimal"> Repetir en el mes </label></div>   
                            
                        </div> 
                        
                        <div class="form-group col-md-12">
                            <h4 style="color: #501482" class="page-header">Tipos de alimentos</h4>
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
                                <label class="col-md-5 ">
                                    <input <%=estado%> id="posicion" type="checkbox" class="minimal posicion<%=contador%>"> <%=item.getNombreComida()%>
                                </label>
                               
                                <div class="form-group">
<!--                                    <select class="form-control cantidad<%=contador%> form-cantidad" id="cantidad" name="cantidad<%=item.getNombreComida()%>" disabled>
                                      <option disabled selected="selected">Cantidad</option>
                                      <option>1</option>
                                      <option>2</option>
                                      <option>3</option>
                                    </select>-->
                                    <div class="input-group margin">
                                        <select class="form-control cantidad<%=contador%> form-cantidad" id="cantidad" name="cantidad<%=item.getNombreComida()%>" disabled>
                                            <option disabled selected="selected">Cantidad</option>
                                            <option>1</option>
                                            <option>2</option>
                                            <option>3</option>
                                            <option value="4">mas...</option>
                                        </select>
                                        <span class="input-group-btn">&#160;</span>
                                        <span class="input-group-btn">&#160;</span>
                                        <span class="input-group-btn">&#160;</span>
                                        <span class="input-group-btn">&#160;</span>
                                        <span class="input-group-btn">
                                            <button id="btn<%=contador%>" type="button" class="btn btn-xs btn-primary" disabled><i class="fa fa-plus-square"></i></button>
                                        </span>
                                        <span class="input-group-btn">&#160;</span>
                                        <span class="input-group-btn">&#160;</span>
                                        <span class="input-group-btn">
                                            <button id="btnMenos<%=contador%>" type="button" class="btn btn-xs btn-info" disabled><i class="fa fa-minus-square"></i></button>
                                        </span>
                                    </div>
                                    <!--<button type="button" class="btn btn-info align-left" disabled><i class="fa fa-plus-square"></i></button>-->
                                </div>
                              <% } } %>
                        </div>  
                        <div class="form-group">
                            <label>Observación</label>
                            <!--<input type="number" class="form-control cantidad<%=contador%> form-cantidad"/>-->
                            <textarea class="form-control" rows="3" id="observacion"  name="observacion" readonly></textarea>
                            <input type="hidden" id="observacionDes" name="observacionDes"/>
                            <input type="hidden" id="observacionAlm" name="observacionAlm"/>
                            <input type="hidden" id="observacionCen" name="observacionCen"/>
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
    
// ===============   varibles de reserva -> daniel
    let Desayuno = 0;    
    let Almuerzo = 0;
    let Cena = 0;
    var arrayReser = ["","",""];
    
    
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
              $('.cantidad'+element).val("Cantidad");
            }
       });  
    });
   
//=============    cuando es mas de 4 platos -> daniel ===========================
    function llenarObservacion(){
        let palabra = "";
        arrayReser.forEach(function (element){
            palabra += element;
        });
        $("textarea#observacion").text(palabra);
    }   
    array.forEach(function (element){
        $('.cantidad'+ element).change(function() {
            if($(this).val() == 4){
                if(element == 1){
                    $('#btn'+ element).attr("disabled", false);
                    $('#btnMenos'+ element).attr("disabled", false);
                    Desayuno = 4;   
                    arrayReser[0] = "4 Desayunos, ";
                    $('#observacionDes').val("4 Desayunos");
                    llenarObservacion();
                }
                if(element == 2){
                    $('#btn'+ element).attr("disabled", false);
                    $('#btnMenos'+ element).attr("disabled", false);
                    Almuerzo = 4;
                    arrayReser[1] = "4 Almuerzos, ";
                    $('#observacionAlm').val("4 Almuerzos");
                    llenarObservacion();
                }
                if(element == 3){
                    $('#btn'+ element).attr("disabled", false);
                    $('#btnMenos'+ element).attr("disabled", false);
                    Cena = 4;
                    arrayReser[2] = "4 Cenas, ";
                    $('#observacionCen').val("4 Cenas");
                    llenarObservacion();
                }
            }else{
                if(element == 1){
                    $('#btn'+ element).attr("disabled", true);
                    $('#btnMenos'+ element).attr("disabled", true);   
                    arrayReser[0] = "";
                    $('#observacionDes').val("");
                    llenarObservacion();
                }
                if(element == 2){
                    $('#btn'+ element).attr("disabled", true);
                    $('#btnMenos'+ element).attr("disabled", true); 
                    arrayReser[1] = "";
                    $('#observacionAlm').val("");
                    llenarObservacion();
                }
                if(element == 3){
                    $('#btn'+ element).attr("disabled", true);
                    $('#btnMenos'+ element).attr("disabled", true); 
                    arrayReser[2] = ""; 
                    $('#observacionCen').val("");
                    llenarObservacion();
                }
            }
        });  
    });
    array.forEach(function (element){
        $('#btn'+ element).click(function(){
//            console.log(element);
            if(element == 1){
                Desayuno++;   
                arrayReser[element-1] = Desayuno+" Desayunos, ";
                $('#observacionDes').val(Desayuno+" Desayunos");
                llenarObservacion();
            }
            if(element == 2){
                Almuerzo++;  
                arrayReser[element-1] = Almuerzo+" Almuerzos, ";
                $('#observacionAlm').val(Almuerzo+" Almuerzos");
                llenarObservacion();
            }
            if(element == 3){
                Cena++;  
                arrayReser[element-1] = Cena+" Cenas, ";
                $('#observacionCen').val(Cena+" Cenas");
                llenarObservacion();
            }
        });
    });
    array.forEach(function (element){
        $('#btnMenos'+ element).click(function(){
            console.log(element);
            if(element == 1){
                Desayuno--; 
                if(Desayuno < 4){
                    arrayReser[element-1] = "";
                    $('#observacionDes').val("");
                    llenarObservacion();
                    $('.cantidad'+element).val("3");
                    $('#btn'+ element).attr("disabled", true);
                    $('#btnMenos'+ element).attr("disabled", true); 
                }else{
                    arrayReser[element-1] = Desayuno+" Desayunos, ";
                    $('#observacionDes').val(Desayuno+" Desayunos");
                    llenarObservacion();
                }
            }
            if(element == 2){
                Almuerzo--;
                if(Almuerzo < 4){
                    arrayReser[element-1] = "";
                    $('#observacionAlm').val("");
                    llenarObservacion();
                    $('.cantidad'+element).val("3");
                    $('#btn'+ element).attr("disabled", true);
                    $('#btnMenos'+ element).attr("disabled", true); 
                }else{
                    arrayReser[element-1] = Almuerzo+" Almuerzos, ";
                    $('#observacionAlm').val(Almuerzo+" Almuerzos");
                    llenarObservacion();
                }
            }
            if(element == 3){
                Cena--;
                if(Cena < 4){
                    arrayReser[element-1] = "";
                    $('#observacionCen').val("");
                    llenarObservacion();
                    $('.cantidad'+element).val("3");
                    $('#btn'+ element).attr("disabled", true);
                    $('#btnMenos'+ element).attr("disabled", true); 
                }else{
                    arrayReser[element-1] = Cena+" Cenas, ";
                    $('#observacionCen').val(Cena+" Cenas");
                    llenarObservacion();
                }
            }
        });
    });
    
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