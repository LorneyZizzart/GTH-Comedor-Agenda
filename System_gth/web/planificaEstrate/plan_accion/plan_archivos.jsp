<%@page import="Entidad.Plan_accion_files"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="get_file" class="Controlador.Plan_accion_filesController" /> 
<%
    String id_pla_ac = request.getParameter("id_pla_ac").replace(" ", "+");
    id_pla_ac = _encript.ValorADesencriptar(id_pla_ac);
    //out.print(id_pla_ac);

    List<Plan_accion_files> files = new ArrayList<Plan_accion_files>();
    files = get_file.GetAllFileByPlanacionid(Integer.parseInt(id_pla_ac));
%>
<div class="box-body no-padding">
    <table class="table table-condensed">
        <tr>
            <th style="width: 10px">#</th>
            <th>Nombre</th>            
            <th></th>
        </tr>
        <%
            int conta = 0;
            for (Plan_accion_files f : files) {
                conta++;
        %>
        <tr>
            <td><%=conta%></td>
            <td><%=f.getNombre()%></td>            
            <td style="width: 100px; ">
                <a data-id="<%=f.getPlan_accion_files_id()%>" target="_blank" href="../files/<%=f.getNombre_archivo()%>" class="btn btn-xs btn-info" data-toggle="tooltip" title="Descargar"><i class="fa fa-cloud-download"></i></a>
                <a data-id="<%=f.getPlan_accion_files_id()%>" class="file_elimi btn btn-xs btn-danger" data-toggle="tooltip" data-placement="bottom" title="Eliminar"> <i class="fa fa-trash-o"></i></a>
            </td>
        </tr>  
        <%
            }
        %>

    </table>
</div>

<form id ="mi_form_file" class="mi_form_file" name ="mi_form_file">
    <div class="box-body">
        <div class="form-group">
            <label class="col-sm-2 control-label">Subir archivo </label>
            <div class="col-sm-8">
                <input type="file" name="file" size="50" id="file" class="btn btn-default"/>
            </div>
            <div class="col-sm-2">
                <input type="submit" value="Guardar Archivo" id="guardar_file" class="btn btn-purple guardar_file" name="guardar_file" />
            </div>
        </div>

        <input type="hidden" name="id_pla_ac" id="id_pla_ac" value="<%=id_pla_ac%>">  
    </div>
</form>
<div class="loading_file"></div>
<script type="text/javascript">
    $(document).ready(function () {

        $(".mi_form_file").submit(function (evt) {
            evt.preventDefault();
            $(".loading_file").addClass('loader');
            var id = $('#id_pla_ac').val();
            var codigo_personal = "10";//$('#cod_admin').val();
            var formData = new FormData($(this)[0]);
            //var formData = $(".mi_form_file").serialize();
            $.ajax({
                url: '../plan_accion/upload.jsp?id=' + id + '&codigo_personal=' + codigo_personal,
                type: 'POST',
                data: formData,
                async: false,
                cache: false,
                contentType: false,
                enctype: 'multipart/form-data',
                processData: false,
                success: function (response) {
                    $(".loading_file").removeClass('loader');
                    $(".loading_file").html(response);
                }
            });
            return false;
        });


        $(".file_elimi").click(function (e) {
            e.preventDefault();
            e.stopImmediatePropagation();
            $(".loading_file").addClass('loader');

            $.post('../plan_accion/plan_archivo_elimina.jsp',
                    {id: $(this).attr('data-id')},
                    function (html) {
                        $(".loading_file").removeClass('loader');
                        $(".loading_file").html(html);
                    }
            ).fail(function (jqXHR, textStatus, errorThrown)
            {
                var alerta = "<p class='bg-danger'>error: " + errorThrown + "</p>";
                $(".loading_file").removeClass('loader');
                $(".loading_file").html(alerta);
            });
        });


    });

</script>
