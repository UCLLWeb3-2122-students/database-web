<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<jsp:include page="head.jsp">
    <jsp:param name="title" value="Bekijk alle dieren"/>
</jsp:include><body>
<div id="container">
    <jsp:include page="header.jsp">
        <jsp:param name="actual" value="Overzicht"/>
    </jsp:include>
    <main>
        <c:choose>
            <%--@elvariable id="animals" type="domain.model.Animal"--%>
            <c:when test="${not empty animals}">
                <h2>Bekijk alle dieren</h2>

                <table>
                    <thead>
                    <tr>
                        <th>Naam</th>
                        <th>Soort</th>
                        <th>Voedsel</th>
                    </thead>
                    <tbody>
                    <c:forEach var="animal" items="${animals}">
                        <tr>
                            <td>${animal.name}
                            </td>
                            <td>${animal.type}
                            </td>
                            <td>${animal.food}
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                <p>Er zijn geen dieren </p>
            </c:otherwise>
        </c:choose>
        <%--@elvariable id="last" type="domain.model.Animal"--%>
        <c:if test="${not empty last}">
            <p>Het laatste dier dat je hebt toegevoegd heet ${last.name} </p>
        </c:if>

    </main>
    <jsp:include page="footer.jsp"/>
</div>
</body>
</html>