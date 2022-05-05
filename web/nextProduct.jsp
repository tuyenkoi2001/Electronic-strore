<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
                            
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
                        </div>
                </div>
                <div class="add-to-cart">
                    <button class="add-to-cart-btn" id="${o.id}" onclick="clickme(${o.id})">add to cart</button>
                </div>
        </div>
</div>
<!-- /product -->
</c:forEach>
