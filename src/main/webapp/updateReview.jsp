<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<jsp:include page="head.jsp" />
<title>Update Review</title>

<body class="container-fluid">

<jsp:include page="header.jsp" />

<div id="main_content_top"></div>
<div id="main_content">

    <main class="w-75 m-auto">
        <br />
        <h1 class="text-center align-self-center">
            Update Review
        </h1>
        <br />
        <form method="POST" action="<%=request.getContextPath()%>/update_review/${review.id_reviews}">
            <div class="form-group">
                <label for="title">Title of Game:</label>
                <input type="text" class="form-control" id="title" value="${review.title}">
            </div>
            <div class="form-group">
                <label for="review">Review</label>
                <input type="text" class="form-control" id="review" value="${review.review}">
            </div>
            <button type="submit" class="btn btn-primary">Save update</button>
            <a href="/reviews/${review.id_reviews}" class="btn btn-danger">Cancel update</a>
        </form>
        <br />
        <br />

        <img src="images/gamer.png" alt="One Does not Simply" class="center">

    </main>


    <div id="clear"></div>
</div>
<div id="main_content_bottom"></div>

<jsp:include page="footer.jsp" />

</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</html>