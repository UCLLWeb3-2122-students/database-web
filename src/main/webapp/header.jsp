<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    <h1>Mijn huisdieren</h1>
    <nav>
        <ul>
            <li ${param.actual eq 'Home'?"id = actual":""}>
                <a id="goHome"
                   href="Controller?command=Home">Home</a></li>
            <li ${param.actual eq 'voegToe'?"id = actual":""}>
                <a href="Controller?command=AddForm">Voeg Toe</a></li>
            <li ${param.actual eq 'Overzicht'?"id = actual":""}>
                <a href="Controller?command=Overview">Overzicht</a></li>
          
        </ul>
    </nav>
</header>