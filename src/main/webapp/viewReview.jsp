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

    <main class="w-75 m-auto">

        <table class="table table-striped border">
            <thead>
            <tr>
                <th>Title: ${review.title}</th>
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

            <c:if test="${reviewerId == 1}">
                <tfoot>
                    <a href="<%=request.getContextPath()%>/display_update_post/${review.id_reviews}" class="btn btn-secondary">Edit Review</a>
                    <a type="button"
                       class="btn btn-danger"
                       href="<%=request.getContextPath()%>/delete_review/${review.id_reviews}"
                       onclick="return confirm('Are you sure you want to delete this item? This CANNOT be undone.');">Delete</a>
                </tfoot>
            </c:if>
        </table>

        <img src="images/gamer.png" alt="One Does not Simply" class="center">

    </main>

    <div id="clear"></div>
</div>
<div id="main_content_bottom"></div>

<jsp:include page="footer.jsp" />

</div>
</body>

</html>
