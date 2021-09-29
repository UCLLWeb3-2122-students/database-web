<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Voeg een dier toe"/>
</jsp:include>
<body>
<div id="container">
    <jsp:include page="header.jsp">
        <jsp:param name="actual" value="voegToe"/>
    </jsp:include>

    <main>
        <%--@elvariable id="errors" type="java.util.Arrays"--%>
        <c:if test="${not empty errors}">
            <div class="alert alert-danger">
                <ul>
                    <c:forEach items="${errors}" var="error">
                        <li>${error}</li>
                    </c:forEach>
                </ul>
            </div>
        </c:if>
        <h2>Voeg je huisdier toe</h2>

        <form method="POST" action="Controller?command=Add" novalidate>

            <p class="form-group ${nameClass}">
                <label class="control-label" for="name">Naam:</label>
                <input id="name" name="name" type="text"
                       value="${namePreviousValue}">
            </p>

            <p class="form-group ${typeClass}">
                <label class="control-label" for="type">Soort:</label>
                <input id="type" name="type" type="text"
                       value="${typePreviousValue}">
            </p>

            <p class="form-group ${foodClass}">
                <label for="food">Aantal keer eten per dag:</label>
                <input
                        id="food" name="food" type="number" class="error"
                        max="10" min="1" value="${foodPreviousValue}">
            </p>
            <p>
                <input id="submit" type="submit" value="Verstuur">
            </p>
        </form>
    </main>
    <jsp:include page="footer.jsp"/>
</div>
</body>
</html>