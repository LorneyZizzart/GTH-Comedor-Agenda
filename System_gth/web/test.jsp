<jsp:useBean id="_encripta" class="Controlador.EncriptionController" />
<%@page import="Entidad.Log"%>
<%@page import="java.net.NetworkInterface"%>
<%@page import="java.net.InetAddress"%>
<%@page import="java.net.SocketException"%>
<%    
    Log log_save = new Log();
    
    String log_ip = "";
    String mac_log = "";
    String dato_nav_log = "";
    String navegador_log = "";
    String sis_op_log = "";
    InetAddress ip = InetAddress.getLocalHost();
    out.println("Direccion IP : " + ip.getHostAddress());
    log_ip = ip.getHostAddress();

    NetworkInterface network = NetworkInterface.getByInetAddress(ip);

    byte[] mac = network.getHardwareAddress();

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < mac.length; i++) {
        sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
    }
    out.println("<br>Direcion Mac : " + sb.toString());
    mac_log = sb.toString();

    String browserDetails = request.getHeader("User-Agent");
    String userAgent = browserDetails;
    String user_ = userAgent.toLowerCase();

    String os = "";
    String browser = "";

    dato_nav_log = browserDetails;
    out.print("<br>User Agent for the request is===>" + browserDetails);
    //=================OS=======================
    if (userAgent.toLowerCase().indexOf("windows") >= 0) {
        os = "Windows";
    } else if (userAgent.toLowerCase().indexOf("mac") >= 0) {
        os = "Mac";
    } else if (userAgent.toLowerCase().indexOf("x11") >= 0) {
        os = "Unix";
    } else if (userAgent.toLowerCase().indexOf("android") >= 0) {
        os = "Android";
    } else if (userAgent.toLowerCase().indexOf("iphone") >= 0) {
        os = "IPhone";
    } else {
        os = "UnKnown, More-Info: " + userAgent;
    }
    //===============Browser===========================
    if (user_.contains("msie")) {
        String substring = userAgent.substring(userAgent.indexOf("MSIE")).split(";")[0];
        browser = substring.split(" ")[0].replace("MSIE", "IE") + "-" + substring.split(" ")[1];
    } else if (user_.contains("safari") && user_.contains("version")) {
        browser = (userAgent.substring(userAgent.indexOf("Safari")).split(" ")[0]).split("/")[0] + "-" + (userAgent.substring(userAgent.indexOf("Version")).split(" ")[0]).split("/")[1];
    } else if (user_.contains("opr") || user_.contains("opera")) {
        if (user_.contains("opera")) {
            browser = (userAgent.substring(userAgent.indexOf("Opera")).split(" ")[0]).split("/")[0] + "-" + (userAgent.substring(userAgent.indexOf("Version")).split(" ")[0]).split("/")[1];
        } else if (user_.contains("opr")) {
            browser = ((userAgent.substring(userAgent.indexOf("OPR")).split(" ")[0]).replace("/", "-")).replace("OPR", "Opera");
        }
    } else if (user_.contains("chrome")) {
        browser = (userAgent.substring(userAgent.indexOf("Chrome")).split(" ")[0]).replace("/", "-");
    } else if ((user_.indexOf("mozilla/7.0") > -1) || (user_.indexOf("netscape6") != -1) || (user_.indexOf("mozilla/4.7") != -1) || (user_.indexOf("mozilla/4.78") != -1) || (user_.indexOf("mozilla/4.08") != -1) || (user_.indexOf("mozilla/3") != -1)) {
        //browser=(userAgent.substring(userAgent.indexOf("MSIE")).split(" ")[0]).replace("/", "-");
        browser = "Netscape-?";

    } else if (user_.contains("firefox")) {
        browser = (userAgent.substring(userAgent.indexOf("Firefox")).split(" ")[0]).replace("/", "-");
    } else if (user_.contains("rv")) {
        browser = "IE-" + user_.substring(user_.indexOf("rv") + 3, user_.indexOf(")"));
    } else {
        browser = "UnKnown, More-Info: " + userAgent;
    }
    navegador_log = browser;
    sis_op_log = os;
    out.println("<br>Operating System======>" + os);
    out.println("<br>Browser Name==========>" + browser);


//log_save.setEmpleado_id(id_usuario_log);
log_save.setEmpleado_id(1);
log_save.setIp(log_ip);
log_save.setMac(mac_log);
log_save.setDato_navegador(dato_nav_log);
log_save.setNombre_navegador(navegador_log);
%>
Valor a encripta 
<%

String en  = "3468";
out.print("Encriptado = "+_encripta.ValorAEncriptar(en));
%>




