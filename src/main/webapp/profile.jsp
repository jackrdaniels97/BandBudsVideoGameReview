<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<jsp:include page="head.jsp" />
<title>Profiles</title>

<body class="container-fluid">
<jsp:include page="header.jsp" />
<div id="main_content_top"></div>
<div id="main_content">
    <h1>Profile Page</h1>

    <c:choose>
        <c:when test="${newUser == true}">
            <h3>New User Information</h3>
            <form method="post" action="/updateProfile">
                <div class="mb-3">
                    <label for="firstName" class="form-label">First Name</label>
                    <input type="text" class="form-control" id="firstName" name="firstName" value="${firstName}">
                </div>
                <div class="mb-3">
                    <label for="lastName" class="form-label">Last Name</label>
                    <input type="text" class="form-control" id="lastName" name="lastName" value="${lastName}">
                </div>
                <div class="mb-3">
                    <label for="email" class="form-label">Email</label>
                    <input type="text" class="form-control" id="email" name="email" value="${email}">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </c:when>
        <c:otherwise>
            <c:out value="${sessionScope.user.firstName} ${sessionScope.user.lastName}"/>
            <br>
            <h3>User Information</h3>
            <form method="post" action="/editProfile">
                <button type="submit" class="btn btn-success">Edit Profile</button>
            </form>
        </c:otherwise>
    </c:choose>

    <c:forEach var="review" items="${reviews}">
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
            <td>Reviewer: ${review.user.firstName} ${review.user.lastName}</td>
        </tr>
        </tbody>


        <tfoot>
        <tr>
            <td>
                <a href="<%=request.getContextPath()%>/editReview/${review.id_reviews}" class="btn btn-secondary">Edit Review</a>
            </td>
            <td>
                <a type="button"
                   class="btn btn-danger"
                   href="<%=request.getContextPath()%>/delete_review/${review.id_reviews}"
                   onclick="return confirm('Are you sure you want to delete this item? This CANNOT be undone.');">Delete</a>
            </td>
        </tr>
        </tfoot>
        </table>
        </c:forEach>

    </main>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</html>