<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<jsp:include page="head.jsp" />
<title>Add Review</title>

<body class="container-fluid">

<jsp:include page="header.jsp" />

<div id="main_content_top"></div>
<div id="main_content">

    <main class="w-75 m-auto">
        <br />
        <h1 class="text-center align-self-center">
            Band Buds Video Game Reviews
        </h1>
        <br />
            <form method="POST" action="<%=request.getContextPath()%>/add_review">
                <div class="form-group">
                    <label for="title">Title of Game:</label>
                    <input type="text" class="form-control" id="title" placeholder="The Witcher 3">
                </div>
                <div class="form-group">
                    <label for="review">What did you think about this game?</label>
                    <input type="text" class="form-control" id="review" placeholder="It was great!">
                </div>
                <div class="form-group">
                    <label for="userName">User name:</label>
                    <input type="text" class="form-control" id="userName" placeholder="It was great!">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
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