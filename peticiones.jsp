<%-- 
    Document   : peticiones
    Created on : 28/09/2021, 08:33:17 PM
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>

//Importar las librerias
<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@page import="java.sql.SQLException"%>
<%@page import="logica.Contacto"%>
<%@page import="java.util.logging.Arrays"%>
<%@page import="java.util.logging.List"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.ArrayList"%>
<%@page import="application/json;charset=iso-8859-1" language="java" pageEncoding="iso-8859-1" session="true"%>

<% //Iniciar la respuesta json
    
    Contacto cl = new Contacto();
    String respuesta = "{";

//Listar las tareas o los procesos a realizar

    List<String> tareas = Arrays.asList(new String []){
        "actualizarcontacto",
        "eliminarcontacto",
        "listar contacto",
        "guardar contacto"
    });
    
    String proceso = "" + request.getParameter("proceso");

//Validacion de parametros utilizados en cada uno de los procesos

    if (tareas.contains(proceso)){
        respuesta += "/"ok/": true,";
        
        //Iniciar los respectivos procesos
        if(proceso.equals())
    }

%>