<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <div class="container-fluid">
            <a class="navbar-brand" href="<%=request.getContextPath()%>/index.jsp">BandBuds Reviews</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="<%=request.getContextPath()%>/index.jsp">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<%=request.getContextPath()%>/viewGames">View Reviews</a>
                    </li>
                    <c:choose>
                        <c:when test="${username == null}">
                            <li>
                                <a class="nav-link" href="<%=request.getContextPath()%>/logIn">Login</a>
                            </li>
                        </c:when>
                        <c:otherwise>
                        <li class="nav-item">
                            <a class="nav-link" href="<%=request.getContextPath()%>/viewProfile">${username}</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="<%=request.getContextPath()%>/addReview.jsp">Add Review</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="<%=request.getContextPath()%>/logOut">Log Out</a>
                        </li>
                        </c:otherwise>
                    </c:choose>
            </div>
        </div>
    </nav>
</header>
