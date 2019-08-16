<jsp:useBean id="_encript" class="Controlador.EncriptionController" />

<%
    String valor = "Roberto Mñana sera un diía";
    String Encriptado = _encript.ValorAEncriptar(valor);
    out.print("Encriptado: " + Encriptado + "<br>");
    String Desencriptado = _encript.ValorADesencriptar(Encriptado);
    out.print("DesEncriptado: " + Desencriptado);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Documento sin título</title>
    </head>

    <body>

        <center style="min-width:580px;width:100%">
            <table style="background-color:#fff;background-image:none;background-position:top left;background-repeat:repeat;border-bottom:1px solid #bcbcbc;border-collapse:collapse;border-spacing:0;display:table;margin:10px 0 15px 0;padding:0;text-align:left;vertical-align:top;width:100%">
                <tbody>
                    <tr style="padding:0;text-align:left;vertical-align:top">
                        <th style="Margin:0 auto;color:#322f37;line-height:1.3;margin:0 auto;text-align:left;">
                            <table style="text-align:left;vertical-align:top;width:100%">
                                <tbody>
                                    <tr style="padding:0;text-align:left;vertical-align:top">
                                        <th>
                                            <a href="#" target="_blank">
                                                <img src="http://localhost:8080/System_gth/images/Logo_gth.png" alt="GTH" style="Margin:0 auto;border:none;border-bottom:1px solid #6441a4;clear:both;display:block;float:none;margin:0 auto;max-width:100%;outline:0;padding:25px 0;text-align:center;text-decoration:none;width:102px!important">
                                            </a>
                                        </th>                                        
                                    </tr>
                                </tbody>
                            </table>

                        </th>
                    </tr>
                </tbody>
            </table>

            <table style="border-collapse:collapse;border-spacing:0;padding:0;text-align:left;vertical-align:top;width:100%">
                <tbody>
                    <tr style="padding:0;text-align:left;vertical-align:top">
                        <th>
                            ¡Hola, carlosrobertomarca! Us ted fue selecionado para evaluar a RACAROLOEROB ATRO A ONONO es tosos estas asdkfjkal jkasf ñlaksjdf asdf ahsjdfh asldkjfhal ksdjfhl kajsdfhl k
                        </th>                                                        
                    </tr>
                </tbody>
            </table>

        </center>

    </body>
</html>
