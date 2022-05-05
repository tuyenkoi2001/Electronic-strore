

		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		 <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

		<title>Admin</title>

		<!-- Google font -->
		<link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">

		<!-- Bootstrap -->
		<link type="text/css" rel="stylesheet" href="../../css/bootstrap.min.css">
		<!-- Slick -->
		<link type="text/css" rel="stylesheet" href="../../css/slick.css">
		<link type="text/css" rel="stylesheet" href="../../css/slick-theme.css">

		<!-- nouislider -->
		<link type="text/css" rel="stylesheet" href="../../css/nouislider.min.css">

		<!-- Font Awesome Icon -->
		<link rel="stylesheet" href="../../css/font-awesome.min.css">

		<!-- Custom stlylesheet -->
		<link type="text/css" rel="stylesheet" href="../../css/style.css">


<div id="header">
            <!-- container -->
            <div class="container">
                    <!-- row -->
                    <div class="row">
                            <!-- LOGO -->
                            <div class="col-md-3">
                                    <div class="header-logo">
                                            <a href="/HomeControl" class="logo">
                                                <img src="../../img/logo.png" alt=""/>
                                            </a>
                                    </div>
                            </div>
                            <!-- /LOGO -->

                            <!-- SEARCH BAR -->
                            <div class="col-md-6">
                                    <div class="header-search">
                                        <form action="search" method="get">
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
        <nav id="navigation">
			<!-- container -->
			<div class="container">
				<!-- responsive-nav -->
				<div id="responsive-nav">
					<!-- NAV -->
					<ul class="main-nav nav navbar-nav">
						<li><a href="/HomeControl">Home</a></li>
                                                <li><a href="/admin/category">Category</a></li>
                                                <li><a href="/admin/brand">Brand</a></li>
                                                <li><a href="/admin/product">Product</a></li>
                                                <li><a href="/admin/user">User</a></li>
                                                <li><a href="/admin/order">Order</a></li>
                                                <li><a href="/admin/shipper">Shipper</a></li>
                                                <li><a href="/admin/account-setting">Setting Account</a></li>
					</ul>
					<!-- /NAV -->
				</div>
				<!-- /responsive-nav -->
			</div>
			<!-- /container -->
	</nav>