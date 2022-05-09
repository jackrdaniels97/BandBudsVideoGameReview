<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<jsp:include page="head.jsp" />
<title>View Games</title>

<body class="container-fluid">

<jsp:include page="header.jsp" />

<div id="main_content_top"></div>
<div id="main_content">

    <jsp:include page="main.jsp" />
    <br />
    <c:forEach var="review" items="${reviews}">
        <table class="table table-striped border w-75 mx-auto">
            <thead>
                <tr>
                    <th>Title: <c:out value="${review.title}"/></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Review: <c:out value="${review.review}"/></td>
                </tr>
                <tr>
                    <td>Reviewer: <c:out value="${review.reviewer_id}"/></td>

                </tr>
            </tbody>
            <tfoot>
                <tr>
                    <td>
                        <a href="<%=request.getContextPath()%>/reviews/${review.id_reviews}" class="btn btn-secondary">View Review</a>
                    </td>
                </tr>
            </tfoot>
        </table>
        <br /><br />
    </c:forEach>
    <div id="clear"></div>
</div>
<div id="main_content_bottom"></div>

<jsp:include page="footer.jsp" />

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</body>

</html>
