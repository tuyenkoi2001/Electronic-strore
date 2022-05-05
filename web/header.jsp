<%-- 
    Document   : header
    Created on : Jan 29, 2022, 2:58:07 PM
    Author     : Hoàng Xuân Tuyền
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- HEADER -->
    <header>
    <!-- TOP HEADER -->
    <div id="top-header">
            <div class="container">
                    <ul class="header-links pull-left">
                            <li><a href="#"><i class="fa fa-phone"></i> +021-95-51-84</a></li>
                            <li><a href="#"><i class="fa fa-envelope-o"></i> email@email.com</a></li>
                            <li><a href="cart.jsp"><i class="fa fa-map-marker"></i> 1734 Stonecoal Road</a></li>
                    </ul>
                    <ul class="header-links pull-right">
                            <li><a href="#"><i class="fa fa-dollar"></i> USD</a></li>
                            <c:if test="${sessionScope.acc != null}">
                                <li><a href="user"><i class="fa fa-user-o"></i> My Account</a></li>
                                <li><a href="logout"><i class="fa fa-door-open"></i> Logout</a></li>
                            </c:if>
                            <c:if test="${sessionScope.acc == null}">
                                <li><a href="login.jsp"><i class="fa fa-user-md"></i> Login</a></li>
                            </c:if>
                            <c:if test="${sessionScope.acc.isIsAdmin() == 1}">
                                <li><a href="/admin/account-setting"><i class="fa fa-key"></i> Admin</a></li>
                            </c:if>
                    </ul>
            </div>
    </div>
    <!-- /TOP HEADER -->

    <!-- MAIN HEADER -->
    <div id="header">
            <!-- container -->
            <div class="container">
                    <!-- row -->
                    <div class="row">
                            <!-- LOGO -->
                            <div class="col-md-3">
                                    <div class="header-logo">
                                            <a href="HomeControl" class="logo">
                                                    <img src="./img/logo.png" alt="">
                                            </a>
                                    </div>
                            </div>
                            <!-- /LOGO -->

                            <!-- SEARCH BAR -->
                            <div class="col-md-6">
                                    <div class="header-search">
                                        <form action="search" method="get">
                                                    <select name="catId" class="input-select">
                                                        <option value="0">All Categories</option>
                                                        <c:forEach items="${listC}" var="o">
                                                            <option value="${o.catID}">${o.catName}</option>
                                                        </c:forEach>
                                                    </select>
                                                    <input name="searchInput" class="input" placeholder="Search here">
                                                    <button class="search-btn" type="submit">Search</button>
                                            </form>
                                    </div>
                            </div>
                            <!-- /SEARCH BAR -->

                            <!-- ACCOUNT -->
                            <div class="col-md-3 clearfix">
                                    <div class="header-ctn">
                                            <!-- Wishlist -->
                                            <div>
                                                    <a href="#">
                                                            <i class="fa fa-heart-o"></i>
                                                            <span>Your Wishlist</span>
                                                            <div class="qty">0</div>
                                                    </a>
                                            </div>
                                            <!-- /Wishlist -->

                                            <!-- Cart -->
                                            <div class="dropdown">
                                                <a href="cart" class="dropdown-toggle" >
                                                            <i class="fa fa-shopping-cart"></i>
                                                            <span>Your Cart</span>
                                                            <div class="qty">0</div>
                                                    </a>

                                            </div>
                                            <!-- /Cart -->

                                            <!-- Menu Toogle -->
                                            <div class="menu-toggle">
                                                    <a href="#">
                                                            <i class="fa fa-bars"></i>
                                                            <span>Menu</span>
                                                    </a>
                                            </div>
                                            <!-- /Menu Toogle -->
                                    </div>
                            </div>
                            <!-- /ACCOUNT -->
                    </div>
                    <!-- row -->
            </div>
            <!-- container -->
    </div>
    <!-- /MAIN HEADER -->
    </header>

    <div id="toast"></div>
    
    <!-- /HEADER -->