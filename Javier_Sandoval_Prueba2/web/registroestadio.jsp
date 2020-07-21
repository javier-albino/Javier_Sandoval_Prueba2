
<%@page import="dao.CiudadDAO"%>
<%@page import="modelos.Estadio"%>
<%@page import="dao.EstadioDAO"%>
<%@page import="modelos.Ciudad"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% if (session.getAttribute("usuario") == null) {
        response.sendRedirect("index.jsp?msj=No te pases");
    } else {
        Estadio a = new Estadio();
        if (request.getParameter("id") != null) {
            a = new EstadioDAO().obtenerEstadio(Integer.parseInt(request.getParameter("id")));
        }
%>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Producto</title>
    </head>
    <body>
    <center>
        <h1>Registar Estadio</h1>
        <% if(request.getParameter("msj")!= null){%>
        <h3><%= request.getParameter("msj") %></h3>
        <%}%>
        <form action="ControladorEstadio" method="post">
            <input type ="hidden" name="accion" value="1">
            <table>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre"/></td>
                </tr>
                <tr>
                    <td>Capacidad</td>
                    <td><input type="number" name="capacidad"/></td>
                <tr>
                    <td>Ciudad</td>
                    <td>
                        <select name="ciudad">
                            <option value="0">Seleccione</option>
                            <% ArrayList<Ciudad> Ciudades = new CiudadDAO().obtenerCiudades();
                                for (Ciudad c : Ciudades) {%>
                            <option value="<%= c.getId()%>" >
                                <%= c.getNombre()%>   

                            </option>
                            <% } %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><input type="reset" value="Limpiar"/></td>
                    <td><input type="submit" value="Registrar"/></td>

                </tr>
            </table>
        </form>
        <% if (request.getParameter("msj") != null) {%>
        <h4><%= request.getParameter("msj")%></h4>
        <%}%>

    </center>
</body>
</html>
<% }%>