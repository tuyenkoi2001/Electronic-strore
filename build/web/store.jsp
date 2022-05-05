<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		 <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

		<title>Electro - HTML Ecommerce Template</title>

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
                <link type="text/css" rel="stylesheet" href="css/button.css"/>
                <link href="css/toast.css" rel="stylesheet" type="text/css"/>
                
		<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->

    </head>
	<body>
		<!-- HEADER -->
                <jsp:include page="header.jsp">
                    <jsp:param name="listC" value="${listC}" />
                </jsp:include>
		<!-- /HEADER -->

		<!-- NAVIGATION && BREADCRUM-->
                <jsp:include page="navigation.jsp"/>
                <jsp:include page="breadcrumb.jsp"/>
                <!-- /NAVIGATION && BREADCRUM-->

		

		<!-- SECTION -->
		<div class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">
					<!-- ASIDE -->
                                            <div id="aside" class="col-md-3">
                                                <form action="/filter" method="post">
                                                    <!-- aside Widget -->
                                                    <div class="aside">
                                                        <h3 class="aside-title">Categories</h3>
                                                            <div class="checkbox-filter">
                                                                <c:forEach items="${listC}" var="o" varStatus="count">
                                                                    <div class="input-checkbox">
                                                                        <input type="checkbox" id="category-${count.index+1}" value="${o.catID}" class="category-filter-checkbox" name="category-chk">
                                                                            <label for="category-${count.index+1}">
                                                                                    <span></span>
                                                                                    ${o.catName}
                                                                            </label>
                                                                    </div>
                                                                </c:forEach>
                                                            </div>
                                                    </div>
                                                    <!-- /aside Widget -->

                                                    <!-- aside Widget -->
                                                    <div class="aside">
                                                            <h3 class="aside-title">Price</h3>
                                                            <div class="price-filter">
                                                                    <div id="price-slider"></div>
                                                                    <div class="input-number price-min">
                                                                        <input id="price-min" type="number" name="price-min">
                                                                            <span class="qty-up">+</span>
                                                                            <span class="qty-down">-</span>
                                                                    </div>
                                                                    <span>-</span>
                                                                    <div class="input-number price-max">
                                                                        <input id="price-max" type="number" name="price-max">
                                                                            <span class="qty-up">+</span>
                                                                            <span class="qty-down">-</span>
                                                                    </div>
                                                            </div>
                                                    </div>
                                                    <!-- /aside Widget -->

                                                    <!-- aside Widget -->
                                                    <div class="aside">
                                                            <h3 class="aside-title">Brand</h3>
                                                            <div class="checkbox-filter">
                                                                <c:forEach items="${listB}" var="o" varStatus="count">
                                                                    <div class="input-checkbox">
                                                                        <input type="checkbox" id="brand-${count.index}" value="${o.bID}" class="brand-filter-checkbox" name="brand-chk">
                                                                            <label for="brand-${count.index}">
                                                                                    <span></span>
                                                                                    ${o.bName}
                                                                            </label>
                                                                    </div>
                                                                </c:forEach>
                                                            </div>
                                                    </div>
                                                    <!-- /aside Widget -->
                                                    <div class="aside">
                                                        <button class="apply-filter" type="submit">Apply</button>
                                                    </div>
                                                    <!-- aside Widget -->
                                                </form>
						<div class="aside">
							<h3 class="aside-title">Top selling</h3>
                                                        <c:forEach items="${topSelling}" var="o">
                                                            <div class="product-widget">
                                                                    <div class="product-img">
                                                                            <img src="/images/products/${o.img[0]}" alt="">
                                                                    </div>
                                                                    <div class="product-body">
                                                                            <p class="product-category"></p>
                                                                            <h3 class="product-name"><a href="product?productID=${o.id}">${o.name}</a></h3>
                                                                            <h4 class="product-price">${o.cost}$</h4>
                                                                    </div>
                                                            </div>

							</c:forEach>

							
						</div>
						<!-- /aside Widget -->
					</div>
                                        <!-- /ASIDE -->

					<!-- STORE -->
					<div id="store" class="col-md-9">
						<!-- store products -->
						<div id="content" class="row">
                                                    <c:forEach items="${listP}" var="o" varStatus="theCount">
							<!-- product -->
							<div class="col-md-4 col-xs-6">
								<div class="product">
									<div class="product-img">
										<img src="/images/products/${o.img[0]}" alt="">
										<div class="product-label">
											<span class="sale">-0%</span>
										</div>
									</div>
									<div class="product-body">
										<p class="product-category">${mapCatId[o.catId]}</p>
										<h3 class="product-name"><a href="product?productID=${o.id}">${o.name}</a></h3>
										<h4 class="product-price">${o.cost}$ <del class="product-old-price">${o.cost}$</del></h4>
										<div class="product-rating">
											<i class="fa fa-star"></i>
											<i class="fa fa-star"></i>
											<i class="fa fa-star"></i>
											<i class="fa fa-star"></i>
											<i class="fa fa-star"></i>
										</div>
										<div class="product-btns">
											<button class="add-to-wishlist"><i class="fa fa-heart-o"></i><span class="tooltipp">add to wishlist</span></button>
s										</div>
									</div>
									<div class="add-to-cart">
                                                                            <button class="add-to-cart-btn" id="${o.id}" onclick="(e)=>this.clickme(e)"> add to cart</button>
									</div>
								</div>
							</div>
							<!-- /product -->

                                                        <c:if test="${theCount.index % 3 == 1}">    
                                                            <div class="clearfix visible-sm visible-xs"></div>
                                                        </c:if>
                                                        <c:if test="${theCount.index % 3 == 2}">    
                                                            <div class="clearfix visible-lg visible-md"></div>
                                                        </c:if>
                                                    </c:forEach>
						</div>
						<!-- /store products -->

						<!-- store bottom filter -->
                                                <button class="load-more" onclick="loadmore()">Load More</button>
						<!-- /store bottom filter -->
					</div>
					<!-- /STORE -->
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
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
                
                <script>
                    function loadmore(){
                        var amount = document.getElementsByClassName("product").length;
                        $.ajax({
                          url: "/loadmore?catID="+${selectedCatID},
                          type: "get",
                          data:{
                              exists: amount
                          },
                          success: function(data) {
                            $('#content').append(data);
                          },
                          error: function(xhr) {

                          }
                        });
                    };
                </script>
	</body>
</html>
