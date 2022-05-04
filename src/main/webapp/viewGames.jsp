<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<jsp:include page="head.jsp" />
<title>View Games</title>

<body class="container-fluid">

<jsp:include page="header.jsp" />

<div id="main_content_top"></div>
<div id="main_content">

    <jsp:include page="main.jsp" />
    <c:forEach var="review" items="${reviews}">
        <table class="table table-striped border">
            <thead>
                <tr>
                    <th>Title: <c:out value="${review.title}"/></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Review: ${review.review}</td>
                </tr>
                <tr>
                    <td>Reviewer: ${review.reviewer_id}</td>
                </tr>
            </tbody>
        </table>
    </c:forEach>
    <div id="clear"></div>
</div>
<div id="main_content_bottom"></div>

<jsp:include page="footer.jsp" />

</div>
</body>

</html>
