<%-- 
    Document   : navigation
    Created on : Jan 29, 2022, 3:06:39 PM
    Author     : Hoàng Xuân Tuyền
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- NAVIGATION -->
		<nav id="navigation">
			<!-- container -->
			<div class="container">
				<!-- responsive-nav -->
				<div id="responsive-nav">
					<!-- NAV -->
					<ul class="main-nav nav navbar-nav">
						<li class="active"><a href="HomeControl">Home</a></li>
						<li><a href="#">Hot Deals</a></li>
						<li><a href="category?catID=0">Categories</a></li>
                                                <c:forEach items="${listC}" var="o">
                                                    <li><a href="category?catID=${o.catID}">${o.catName}</a></li>
                                                </c:forEach>
					</ul>
					<!-- /NAV -->
				</div>
				<!-- /responsive-nav -->
			</div>
			<!-- /container -->
		</nav>
		<!-- /NAVIGATION -->
                
                
