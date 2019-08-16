<%@page import="java.util.ArrayList"%>
<%@page import="Entidad.View_Empleado_Gestion"%>
<%@page import="java.util.List"%>
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="_cuestionarioGestion" class="Controlador.Cuestionario_gestionController" />
<%
    String idCicloEncript = _encript.ValorADesencriptar(request.getParameter("id")).replace(" ", "+");  
    List<View_Empleado_Gestion> listaEmpleado = new ArrayList<View_Empleado_Gestion>();
    int idCiclo = 0;
    
    try {
        idCiclo = Integer.parseInt(idCicloEncript);
        listaEmpleado = _cuestionarioGestion.GetAllEmpleadoNoRegistradoEnGestion(idCiclo);
    }catch (Exception e) {
        idCiclo = 0;
    }   
    
%>
<form id="form_guardar" method="post" class="form_guardar">
    <input type="hidden" value="<%=_encript.ValorAEncriptar(idCicloEncript)%>" name="id" id="id">
    <button type="button" class="agregarEmpleado btn-purple pull-right">
    <i class="fa fa-save"></i><b> Guardar</b>
    </button> 
<br><br>

<table id="tableListEmploy" class="table table-bordered table-hover">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Nombre completo</th>
                                <th>Departamento</th>
                                <th>Cargo</th>
                                <th class="text-right" style="width: 10%">
                                    <button type="button" class="btn btn-default btn-sm checkbox-toggle comprobar" data-toggle="tooltip" data-placement="bottom" title="Marcar todos"><i class="fa fa-square-o"></i>
                                </button>
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                             int contador = 0;
                                for(View_Empleado_Gestion item : listaEmpleado){
                                    contador++;
                            %>
                            <tr>
                                <td class="text-center"><%=contador%> <input type="hidden" name="posicion_celda" value="<%=contador%>" class="posicion_celda"> </td>
                                <input hidden> 
                                <td><input hidden value="<%=item.getEmpleado_id()%>" name="idEmpleado<%=contador%>" id="idEmpleado<%=contador%>"><%=item.getNombre_empleado()%></td>
                                <td><%=item.getNombre_departamento()%></td>
                                <td><%=item.getNombre_cargo()%></td>
                                <td class="text-center"><input class="selectEmpleado<%=contador%>" name="agregarEmpleado" id="agregarEmpleado" type="checkbox" data-placement="left" data-toggle="tooltip" title="Marcar"></td>
                            </tr>
                            <%
                                    
                                }
                            %>

                        </tbody>
                        <tfoot>
                            <tr>
                                <th>#</th>
                                <th>Nombre completo</th>
                                <th>Departamento</th>
                                <th>Cargo</th>
                                <th class="text-center">Marcar</th>
                            </tr>
                        </tfoot>
                    </table>
</form>                          
<script type="text/javascript"> 
        
    $('#formNuevo').tooltip({ boundary: 'window' })
    $(function () {
        $("#tableListEmploy").DataTable();
    });
    
        $(".agregarEmpleado").click(function (){    
            var jsonEmpleados = {};
            var array = [];
            var empleado = [];
        
         var valor = $(".posicion_celda").each(function () {
            var id = $(this).val();
            array.push(id);
        });
        array.forEach(function (element) {
            if( $('.selectEmpleado'+element).prop('checked') ) {
               empleado.push({
                    "idEmpleado" :  $('#idEmpleado' + element).val()
                });
            }
        });
        jsonEmpleados.idCiclo = $("#id").val();
        jsonEmpleados.empleados = empleado;
        var jsonString = JSON.stringify(jsonEmpleados);
        console.log(jsonString);

        $.ajax({
                type: "POST",
                url: "guardarCuestionarioGestionEmpleado.jsp",
                data: {"Object" :jsonString},
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
        

    
    
    
</script>