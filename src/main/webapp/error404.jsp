<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@page isErrorPage="true" %>
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Foutje"/>
</jsp:include>
<body>
<div id="container">
    <jsp:include page="header.jsp">
        <jsp:param name="actual" value="Er liep iets fout"/>
    </jsp:include>
    <main>
        <h2>Oei</h2>
        <p>Er liep iets fout. Probeer nog een keertje... </p>
        <p>Info voor ontwikkelaars: Je vroeg een pagina die niet bestaat (404) </p>

    </main>
    <jsp:include page="footer.jsp"/>
</div>
</body>
</html>
