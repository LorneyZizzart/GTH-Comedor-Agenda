<%@page import="Entidad.Empleado"%>
<%@ include file= "../../masterPage/complemento/head.jsp" %> 

<%    HttpSession sesionmenus = request.getSession();
    if (sesionmenus.getAttribute("USUARIO") != null) {
%>
<%@ include file= "../../masterPage/complemento/menu.jsp" %> 
<%    }
%>

<jsp:useBean id="_encript" class="Controlador.EncriptionController" />
<jsp:useBean id="_character" class="Controlador.CharacterController" />
<jsp:useBean id="_empleado" class="Controlador.EmpleadoController" />
<%
    int idEmpleado = 0;
    String idEncript = request.getParameter("i");
    idEncript = idEncript.replace(" ", "+");
    idEmpleado = Integer.parseInt(_encript.ValorADesencriptar(idEncript));
    Empleado empleado = new Empleado();
    empleado = _empleado.GetEmpleadoByID(idEmpleado);
%>

<link href="./fotografia/statics/main.css" rel="stylesheet" type="text/css"/>
<link href="./fotografia/jcrop/jquery.Jcrop.min.css" rel="stylesheet" type="text/css"/>
<script>
    var examples = [];
</script>

<section class="content-header">
    <h1>
        Registro
        <small> de Empleados</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="../../masterPage/complemento/index.jsp"><i class="fa fa-home"></i> Home</a></li>
        <li class="active">Editar Fotografia</li>
    </ol>
</section>
<section class="content">

    <div class="row">
        <div class="col-xs-12">            

            <div class="box box-purple">
                <div class="box-header">
                    <h3 class="box-title">Editar Fotografia</h3>

                </div>


                <div class="row">
                    <div class="col-sm-6 col-md-4"> 
                        <div class="thumbnail"> 
                            <img alt="Fotografia Personal"  style="width: 100%; height: auto;  display: block;" src="../../folder_picture/<%=empleado.getFoto()%>" data-holder-rendered="true"> 
                            <div class="caption"> 
                                <h3><%=empleado.getNombre()%> <%=empleado.getApellido_paterno()%> <%=empleado.getApellido_materno()%></h3> 

                            </div> 
                        </div> 
                    </div>
                </div>


                <div class="row">
                    <div class="col-md-4">
                        <div id="userpic" class="userpic">
                            <div class="js-preview userpic__preview"></div>
                            <div class="btn btn-success js-fileapi-wrapper">
                                <div class="js-browse">
                                    <span class="btn-txt">Seleccionar Foto</span>
                                    <input type="file" name="filedata"/>
                                </div>
                                <div class="js-upload" style="display: none;">
                                    <div class="progress progress-success"><div class="js-progress bar"></div></div>
                                    <span class="btn-txt">Guardar</span>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-8">
                        <!--Div donde cargara el la imagen para recortar-->
                        <div id="popup" class="popup" style="display: none;">
                            <div class="popup__body"><div class="js-img"></div></div>
                            <div style="margin: 0 0 5px; text-align: center;">
                                <div class="js-upload btn btn_browse btn_browse_small">Upload</div>
                            </div>
                        </div>
                    </div>
                </div>


                <!-- /.box-body -->
            </div>
            <!-- /.box -->
        </div>
        <!-- /.col -->
    </div>
    <!-- /.row -->
    <!--Modal-->

</section>
<%@ include file= "../../masterPage/complemento/footer.jsp" %> 


<script>
    examples.push(function () {
        $('#userpic').fileapi({
            //url: 'http://192.168.12.110:8080/rep_jas_youtube/subirFoto.jsp',
            url: 'subirFoto.jsp?cod_per=<%=idEmpleado%>',
            accept: 'image/*',
            imageSize: {minWidth: 200, minHeight: 200},
            elements: {
                active: {show: '.js-upload', hide: '.js-browse'},
                preview: {
                    el: '.js-preview',
                    width: 200,
                    height: 200
                },
                progress: '.js-progress'
            },
            onSelect: function (evt, ui) {
                var file = ui.files[0];

                if (!FileAPI.support.transform) {
                    alert('Your browser does not support Flash :(');
                } else if (file) {
                    $('#popup').modal({
                        closeOnEsc: true,
                        closeOnOverlayClick: false,
                        onOpen: function (overlay) {
                            $(overlay).on('click', '.js-upload', function () {
                                $.modal().close();
                                $('#userpic').fileapi('upload');
                            });

                            $('.js-img', overlay).cropper({
                                file: file,
                                bgColor: '#fff',
                                maxSize: [$(window).width() - 200, $(window).height() - 200],
                                minSize: [200, 200],
                                selection: '90%',
                                onSelect: function (coords) {
                                    $('#userpic').fileapi('crop', file, coords);
                                }
                            });
                        }
                    }).open();
                }
            }
        });
    });
</script>
<script src="//yandex.st/highlightjs/7.2/highlight.min.js"></script>
<script src="//yandex.st/jquery/easing/1.3/jquery.easing.min.js"></script>


<script>
    var FileAPI = {
        debug: true
        , media: true
        , staticPath: './FileAPI/'
    };
</script>
<script src="./fotografia/FileAPI/FileAPI.min.js"></script>
<script src="./fotografia/FileAPI/FileAPI.exif.js"></script>
<script src="./fotografia/jquery.fileapi.js"></script>
<script src="./fotografia/jcrop/jquery.Jcrop.min.js"></script>
<script src="./fotografia/statics/jquery.modal.js"></script>


<script>
    jQuery(function ($) {
        var $blind = $('.splash__blind');

        $('.splash')
                .mouseenter(function () {
                    $('.splash__blind', this)
                            .animate({top: -10}, 'fast', 'easeInQuad')
                            .animate({top: 0}, 'slow', 'easeOutBounce')
                            ;
                })
                .click(function () {
                    if (!FileAPI.support.media) {
                        $blind.animate({top: -$(this).height()}, 'slow', 'easeOutQuart');
                    }

                    FileAPI.Camera.publish($('.splash__cam'), function (err, cam) {
                        if (err) {
                            alert("Unfortunately, your browser does not support webcam.");
                        } else {
                            $('.splash').off();
                            $blind.animate({top: -$(this).height()}, 'slow', 'easeOutQuart');
                        }
                    });
                });

        function _getCode(node, all) {
            var code = FileAPI.filter($(node).prop('innerHTML').split('\n'), function (str) {
                return !!str;
            });
            if (!all) {
                code = code.slice(1, -2);
            }

            var tabSize = (code[0].match(/^\t+/) || [''])[0].length;

            return $('<div/>')
                    .text($.map(code, function (line) {
                        return line.substr(tabSize).replace(/\t/g, '   ');
                    }).join('\n'))
                    .prop('innerHTML')
                    .replace(/ disabled=""/g, '')
                    ;
        }


// Init examples
        FileAPI.each(examples, function (fn) {
            fn();
        });
    });
</script>