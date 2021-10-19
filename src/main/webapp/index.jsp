<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<jsp:include page="head.jsp">
    <jsp:param name="title" value="Home"/>
</jsp:include>
<body>
<div id="container">
    <jsp:include page="header.jsp">
        <jsp:param name="actual" value="Home"/>
    </jsp:include>
        <main>
        <h2>Mijn liefste huisdieren</h2>
        <p>Maak kennis met mijn liefste huisdieren. Hoe heten ze, hoeveel
            eten ze, ... Ik noteer het hier allemaal.</p>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quia
            culpa esse. Delectus nemo similique reiciendis provident quas sunt
            fuga numquam neque quibusdam eum libero eius sit nam asperiores sequi
            voluptatum!</p>
    </main>
    <jsp:include page="footer.jsp"/>
</div>
</body>
</html>