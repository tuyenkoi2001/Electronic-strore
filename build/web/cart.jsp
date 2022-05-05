<%-- 
    Document   : cart
    Created on : Feb 27, 2022, 8:04:26 PM
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

		<title>Electro - HTML Ecommerce Template</title>

 		<!-- Google font -->
 		<link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">

 		<!-- Bootstrap -->
 		<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css"/>

 		<!-- Slick -->
 		<link type="text/css" rel="stylesheet" href="css/slick.css"/>
 		<link type="text/css" rel="stylesheet" href="css/slick-theme.css"/>

 		<!-- nouislider -->
 		<link type="text/css" rel="stylesheet" href="css/nouislider.min.css"/>

 		<!-- Font Awesome Icon -->
 		<link rel="stylesheet" href="css/font-awesome.min.css">

 		<!-- Custom stlylesheet -->
 		<link type="text/css" rel="stylesheet" href="css/style.css"/>
                <link href="css/cart-style.css" rel="stylesheet" type="text/css"/>    
        </head>
        <body onload="sumPrice()">
		<!-- HEADER -->
                <jsp:include page="header.jsp"/>
		<!-- /HEADER -->

		<!-- NAVIGATION -->
                <jsp:include page="navigation.jsp"/>
		<!-- /NAVIGATION -->

		<!-- SECTION -->
		<div class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
                            <div class="container-fluid">
                                <div class="row">
                                    <aside class="col-lg-9">
                                        <div class="card">
                                            <div class="table-responsive">
                                                <table class="table table-borderless table-shopping-cart">
                                                    <thead class="text-muted">
                                                        <tr class="small text-uppercase">
                                                            <th scope="col">Product</th>
                                                            <th scope="col" width="120">Quantity</th>
                                                            <th scope="col" width="120">Price</th>
                                                            <th scope="col" class="text-right d-none d-md-block" width="200"></th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach items="${list}" var="o">
                                                            <tr id="productnumber${o.id}">
                                                                <td>
                                                                    <figure class="itemside align-items-center">
                                                                        <div class="aside"><img src="/images/products/${o.img[0]}" class="img-sm"></div>
                                                                        <figcaption class="info"> <a href="product?productID=${o.id}" class="title text-dark" data-abc="true">${o.name}</a>
                                                                        </figcaption>
                                                                    </figure>
                                                                </td>
                                                                <td> 
                                                                    <input type="number" min='0' value="${o.quantity}" class="qty">
                                                                </td>
                                                                <td>
                                                                    <div class="price-wrap"> <div class="price"> ${o.quantity*o.cost}</div> <small class="text-muted"> ${o.cost}</small>$ </div>
                                                                </td>
                                                                <td class="text-right d-none d-md-block"> 
                                                                    <a data-original-title="Save to Wishlist" title="" href="" class="btn btn-light" data-toggle="tooltip" data-abc="true"> <i class="fa fa-heart"></i></a> 
                                                                    <a class="btn btn-light" data-abc="true" id="${o.id}"> Remove</a> 
                                                                </td>
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </aside>
                                    <aside class="col-lg-3">
                                        <div class="card mb-3">
                                            <div class="card-body">
                                                <form>
                                                    <div class="form-group"> <label>Have coupon?</label>
                                                        <div class="input-group"> <input type="text" class="form-control coupon" name="" placeholder="Coupon code"> <span class="input-group-append"> <button class="btn btn-primary btn-apply coupon">Apply</button> </span> </div>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                        <div class="card">
                                            <div class="card-body">
                                                <dl class="dlist-align">
                                                    <dt>Total price: $</dt>
                                                    <dd class="text-right ml-3" id="total">0</dd>
                                                </dl>
                                                <dl class="dlist-align">
                                                    <dt>Discount: $ </dt>
                                                    <dd class="text-right text-danger ml-3">-0</dd>
                                                </dl>
                                                <dl class="dlist-align">
                                                    <dt>Total:</dt>
                                                    <dd class="text-right text-dark b ml-3" id="checkout">$ <strong>0</strong></dd>
                                                </dl>
                                                <hr> <a href="checkout" class="btn btn-out btn-primary btn-square btn-main" data-abc="true"> Make Purchase 
                                                </a> <a href="category" class="btn btn-out btn-success btn-square btn-main mt-2" data-abc="true">Continue Shopping</a>
                                            </div>
                                        </div>
                                    </aside>
                                </div>
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
                
	</body>
</html>
