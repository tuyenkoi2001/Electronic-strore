<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		 <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

		<title>Account</title>

 		<!-- Google font -->
		<link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">

		<!-- Bootstrap -->
		<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css"/>
                <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous" />
		<!-- Slick -->
		<link type="text/css" rel="stylesheet" href="css/slick.css"/>
		<link type="text/css" rel="stylesheet" href="css/slick-theme.css"/>

		<!-- nouislider -->
		<link type="text/css" rel="stylesheet" href="css/nouislider.min.css"/>

		<!-- Font Awesome Icon -->
		<link rel="stylesheet" href="css/font-awesome.min.css">

		<!-- Custom stlylesheet -->
		<link type="text/css" rel="stylesheet" href="css/style.css"/>
                <link href="css/account.css" rel="stylesheet" type="text/css"/>


    </head>
	<body>
		<!-- HEADER -->
                <jsp:include page="header.jsp">
                    <jsp:param name="listC" value="${listC}" />
                </jsp:include>
		<!-- /HEADER -->

		<!-- NAVIGATION && BREADCRUM-->
                <jsp:include page="navigation.jsp"/>
                <!-- /NAVIGATION && BREADCRUM-->

		

		<!-- SECTION -->
		
                    <form action="/user-manage" method="post">
        <div class="wrapper bg-white mt-sm-5">

        <h4 class="pb-4 border-bottom">Account</h4>
        <input type="text" name="id" value="${Account.id}" hidden>  

        <div class="d-flex align-items-start py-3 border-bottom"> <img src="https://images.pexels.com/photos/1037995/pexels-photo-1037995.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500" class="img" alt="">
        </div>

        <div class="py-1">
            <div class="row py-1">
                <div class="col-md-6"> 
                    <label for="firstname">Name</label> 
                    <input type="text" class="bg-light form-control" name="name" value="${Account.name}"> 
                </div>
            </div>

            <div class="row py-1">
                <div class="col-md-12 pt-md-0 pt-6"> 
                    <label for="email">Email</label> 
                    <input type="text" class="bg-light form-control" name="email" class="form-control" value="${Account.email}" required="">  
                </div>
            </div>

            <div class="row py-1">
                <div class="col-md-12 pt-md-0 pt-6"> 
                    <label for="username">Username</label>
                    <input type="text" class="bg-light form-control" name="username" class="form-control" value="${Account.username}" required="">  
                </div>
            </div>

            <div class="row py-1">
                <div class="col-md-12 pt-md-0 pt-6"> 
                    <label for="password">Password</label>
                    <input type="text" class="bg-light form-control" name="password" class="form-control" value="${Account.pass}" required="">  
                </div>
            </div>

            <div class="row py-1">
                <div class="col-md-12 pt-md-0 pt-6"> 
                    <label for="address">Address</label>
                    <input type="text" class="bg-light form-control" name="address" class="form-control" value="${Account.address}" required="">  
                </div>
            </div>

            <div class="row py-1">
                <div class="col-md-12 pt-md-0 pt-6"> 
                    <label for="phone">Phone</label>
                    <input type="text" class="bg-light form-control" name="phone" class="form-control" value="${Account.sdt}" required="">  
                </div>
            </div>

            <div class="py-3 pb-4 border-bottom">
                <button type="submit" class="btn btn-primary mr-3" name="action" value="Save">Save Changes</button> 
            </div>

        </div>
    </div>
    </form>
        
        
		<!-- /SECTION -->
                
                <!<!-- NEWSLETTER AND FOOTER -->
		<jsp:include page="footer.jsp"/>
                <!<!--/ NEWSLETTER AND FOOTER -->
                
                <!-- jQuery Plugins -->
		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="js/slick.min.js"></script>
		<script src="js/nouislider.min.js"></script>
		<script src="js/jquery.zoom.min.js"></script>
		<script src="js/main.js"></script>
                <script src="js/CustomJS.js" type="text/javascript"></script>
                <script src="js/toast.js" type="text/javascript"></script>

	</body>
</html>
