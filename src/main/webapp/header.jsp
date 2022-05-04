<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary rounded">
        <div class="container-fluid">
            <a class="navbar-brand" href="index.jsp">Band Buds Reviews</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
                    aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                    <a class="nav-link active" aria-current="page" href="index.jsp">Home</a>
                    <a class="nav-link" href="<%=request.getContextPath()%>/viewGames">View Reviews</a>
                    <a class="nav-link" href="addGame.jsp">Add Review</a>

                </div>
            </div>
        </div>
    </nav>
</header>
