<%-- 
    Document   : index
    Created on : Jan 25, 2022, 5:43:12 PM
    Author     : Hoàng Xuân Tuyền
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		 <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

		<title>Electro</title>

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
                <link href="css/toast.css" rel="stylesheet" type="text/css"/>


    </head>
	<body>
		<!-- HEADER -->
                <jsp:include page="header.jsp">
                    <jsp:param name="listC" value="${listC}" />
                </jsp:include>
		<!-- /HEADER -->

		<!-- NAVIGATION -->
		<jsp:include page="navigation.jsp">
                    <jsp:param name="listC" value="${listC}" />
                </jsp:include>
		<!-- /NAVIGATION -->

		<!-- SECTION -->
		<div class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">
					<!-- shop -->
					<div class="col-md-4 col-xs-6">
						<div class="shop">
							<div class="shop-img">
								<img src="./img/shop01.png" alt="">
							</div>
							<div class="shop-body">
								<h3>Laptop<br>Collection</h3>
								<a href="category?catID=1" class="cta-btn">Shop now <i class="fa fa-arrow-circle-right"></i></a>
							</div>
						</div>
					</div>
					<!-- /shop -->

					<!-- shop -->
					<div class="col-md-4 col-xs-6">
						<div class="shop">
							<div class="shop-img">
								<img src="./img/shop03.png" alt="">
							</div>
							<div class="shop-body">
								<h3>Accessories<br>Collection</h3>
								<a href="category?catID=2" class="cta-btn">Shop now <i class="fa fa-arrow-circle-right"></i></a>
							</div>
						</div>
					</div>
					<!-- /shop -->

					<!-- shop -->
					<div class="col-md-4 col-xs-6">
						<div class="shop">
							<div class="shop-img">
								<img src="./img/shop02.png" alt="">
							</div>
							<div class="shop-body">
								<h3>Cameras<br>Collection</h3>
								<a href="category?catID=4" class="cta-btn">Shop now <i class="fa fa-arrow-circle-right"></i></a>
							</div>
						</div>
					</div>
					<!-- /shop -->
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /SECTION -->
                
		
                <!-- SECTION -->
		<div class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">

					<!-- section title -->
					<div class="col-md-12">
						<div class="section-title">
							<h3 class="title">New Products</h3>
							<div class="section-nav">
								<ul class="section-tab-nav tab-nav">
                                                                    <c:forEach items="${listC}" var="o">
									<li><a data-toggle="tab" href="#${o.catID}">${o.catName}</a></li>
                                                                    </c:forEach>
								</ul>
							</div>
						</div>
					</div>
					<!-- /section title -->

					<!-- Products tab & slick -->
					<div class="col-md-12">
						<div class="row">
							<div class="products-tabs">
                                                            <div id="tab1" class="tab-pane active">
									<div class="products-slick" data-nav="#slick-nav-1">
										<!-- product -->
                                                                                <c:forEach items="${newest}" var="p">
										<div class="product">
											<div class="product-img">
												<img src="/images/products/${p.img[0]}" alt="">
												<div class="product-label">
													<span class="sale">-0%</span>
													<span class="new">NEW</span>
												</div>
											</div>
											<div class="product-body">
												<p class="product-category">${mapCatId[p]}</p>
												<h3 class="product-name"><a href="product?productID=${p.id}"> ${p.name} </a></h3>
												<h4 class="product-price">$${p.cost} <del class="product-old-price">$${p.cost}</del></h4>
												<div class="product-rating">
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
												</div>
												<div class="product-btns">
													<button class="add-to-wishlist"><i class="fa fa-heart-o"></i><span class="tooltipp">add to wishlist</span></button>
													<button class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">quick view</span></button>
												</div>
											</div>
											<div class="add-to-cart">
                                                                                            <button class="add-to-cart-btn" id="${p.id}"><i class="fa fa-shopping-cart"></i> add to cart</button>
											</div>
										</div>
                                                                                </c:forEach>
                                                                        </div>
									<div id="slick-nav-1" class="products-slick-nav"></div>
								</div>
								<!-- tab -->
                                                                <c:forEach items="${catID}" var="o">
								<div id="${o}" class="tab-pane inactive">
									<div class="products-slick" data-nav="#slick-nav-1">
										<!-- product -->
                                                                                <c:forEach items="${listP[o]}" var="p">
										<div class="product">
											<div class="product-img">
												<img src="/images/products/${p.img[0]}" alt="">
												<div class="product-label">
													<span class="sale">-0%</span>
													<span class="new">NEW</span>
												</div>
											</div>
											<div class="product-body">
												<p class="product-category">${mapCatId[o]}</p>
												<h3 class="product-name"><a href="product?productID=${p.id}"> ${p.name} </a></h3>
												<h4 class="product-price">$${p.cost} <del class="product-old-price">$${p.cost}</del></h4>
												<div class="product-rating">
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
												</div>
												<div class="product-btns">
													<button class="add-to-wishlist"><i class="fa fa-heart-o"></i><span class="tooltipp">add to wishlist</span></button>
													<button class="add-to-compare"><i class="fa fa-exchange"></i><span class="tooltipp">add to compare</span></button>
													<button class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">quick view</span></button>
												</div>
											</div>
											<div class="add-to-cart">
                                                                                            <button class="add-to-cart-btn" id="${p.id}"><i class="fa fa-shopping-cart"></i> add to cart</button>
											</div>
										</div>
                                                                                </c:forEach>
                                                                        </div>
									<div id="slick-nav-1" class="products-slick-nav"></div>
								</div>
                                                                </c:forEach>
							</div>
						</div>
                                                
					</div>
                                        
					<!-- Products tab & slick -->
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /SECTION -->

		<!-- HOT DEAL SECTION -->
		<div id="hot-deal" class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">
					<div class="col-md-12">
						<div class="hot-deal">
							<ul class="hot-deal-countdown">
								<li>
									<div>
										<h3>02</h3>
										<span>Days</span>
									</div>
								</li>
								<li>
									<div>
										<h3>10</h3>
										<span>Hours</span>
									</div>
								</li>
								<li>
									<div>
										<h3>34</h3>
										<span>Mins</span>
									</div>
								</li>
								<li>
									<div>
										<h3>60</h3>
										<span>Secs</span>
									</div>
								</li>
							</ul>
							<h2 class="text-uppercase">hot deal this week</h2>
							<p>New Collection Up to 50% OFF</p>
							<a class="primary-btn cta-btn" href="category">Shop now</a>
						</div>
					</div>
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /HOT DEAL SECTION -->

		<!-- SECTION -->
		<div class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">

					<!-- section title -->
					<div class="col-md-12">
						<div class="section-title">
							<h3 class="title">Top selling</h3>
							<div class="section-nav">
								<ul class="section-tab-nav tab-nav" role="tablist">
                                                                    <c:forEach items="${listC}" var="o">
									<li><a data-toggle="tab" role="tab" href="#top${o.catID}">${o.catName}</a></li>
                                                                    </c:forEach>
								</ul>
							</div>
						</div>
					</div>
					<!-- /section title -->

					<!-- Products tab & slick -->
					<div class="col-md-12">
						<div class="row">
							<div class="products-tabs">
								<!-- tab -->
								<div id="tab" class="tab-pane fade show active">
									<div class="products-slick" data-nav="#slick-nav-2">
                                                                            <!-- product -->
                                                                            <c:forEach items="${topSelling}" var="o">
										<div class="product">
											<div class="product-img">
												<img src="/images/products/${o.img[0]}" alt="">
												<div class="product-label">
													<span class="sale">-0%</span>
													<span class="new">NEW</span>
												</div>
											</div>
											<div class="product-body">
												<p class="product-category"></p>
												<h3 class="product-name"><a href="product?productID=${o.id}">${o.name}</a></h3>
												<h4 class="product-price">$${o.cost} <del class="product-old-price">$${o.cost}</del></h4>
												<div class="product-rating">
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
												</div>
												<div class="product-btns">
													<button class="add-to-wishlist"><i class="fa fa-heart-o"></i><span class="tooltipp">add to wishlist</span></button>
													<button class="add-to-compare"><i class="fa fa-exchange"></i><span class="tooltipp">add to compare</span></button>
													<button class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">quick view</span></button>
												</div>
											</div>
											<div class="add-to-cart">
                                                                                            <button class="add-to-cart-btn" id="${o.id}"><i class="fa fa-shopping-cart"></i> add to cart</button>
											</div>
                                                                                </div>
                                                                            </c:forEach>
										
									</div>
									<div id="slick-nav-2" class="products-slick-nav"></div>
								</div>
								<!-- /tab -->
                                                                <c:forEach items="${catID}" var="o">
                                                                    <!-- tab -->
								<div id="top${o}" class="tab-pane fade show inactive" >
									<div class="products-slick" data-nav="#slick-nav-2">
                                                                            <!-- product -->
                                                                            <c:forEach items="${topSellingbyId[o]}" var="p">
										<div class="product">
											<div class="product-img">
												<img src="/images/products/${p.img[0]}" alt="">
												<div class="product-label">
													<span class="sale">-30%</span>
													<span class="new">NEW</span>
												</div>
											</div>
											<div class="product-body">
												<p class="product-category"></p>
												<h3 class="product-name"><a href="product?productID=${p.id}">${p.name}</a></h3>
												<h4 class="product-price">$${p.cost} <del class="product-old-price">$${p.cost}</del></h4>
												<div class="product-rating">
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
												</div>
												<div class="product-btns">
													<button class="add-to-wishlist"><i class="fa fa-heart-o"></i><span class="tooltipp">add to wishlist</span></button>
													<button class="add-to-compare"><i class="fa fa-exchange"></i><span class="tooltipp">add to compare</span></button>
													<button class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">quick view</span></button>
												</div>
											</div>
											<div class="add-to-cart">
                                                                                            <button class="add-to-cart-btn" id="${p.id}" ><i class="fa fa-shopping-cart"></i> add to cart</button>
											</div>
                                                                                </div>
                                                                            </c:forEach>
									</div>
									<div id="slick-nav-2" class="products-slick-nav"></div>
								</div>
								<!-- /tab -->
                                                                </c:forEach>
							</div>
						</div>
					</div>
					<!-- /Products tab & slick -->
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /SECTION -->

		<!-- SECTION -->
		
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
                <script src="js/toast.js" type="text/javascript"></script>
                
                <script>
                    $('.add-to-cart-btn').click(function(){
                        var productID = $(this).attr('id');
                        var qty = 1;
                        $.ajax({
                            type: "get",
                            url: "/addtocart",
                            data: {productID:productID,qty:qty},
                            success: function(){
                                showSuccessToast();
                            },
                            error: function (jqXHR, textStatus, errorThrown) {
                                showErrorToast();
                            }
                          });
                    });
                    
                </script>

	</body>
</html>

