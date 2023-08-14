<%
	if (session.getAttribute("name") == null) {
		response.sendRedirect("login.jsp");
	}
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport"
        content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Resource</title>
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <script src="https://use.fontawesome.com/releases/v5.15.4/js/all.js"
    	crossorigin="anonymous"></script>
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
    	rel="stylesheet" type="text/css" />
    <link
    	href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic"
    	rel="stylesheet" type="text/css" />
</head>
<body id="page-top">
    <h1>Here's your resource</h1>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<script src="js/scripts.js"></script>
	<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>
</html>
