<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- BREADCRUMB -->
		<div id="breadcrumb" class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">
					<div class="col-md-12">
						<ul class="breadcrumb-tree">
							<li><a href="HomeControl">Home</a></li>
							<li><a href="category">All Categories</a></li>
                                                        <c:if test="${selectedCatID > 0}">
                                                            <li><a href="category?catID=${selectedCatID}">${mapCatId[selectedCatID]}</a></li>
                                                        </c:if>
						</ul>
					</div>
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /BREADCRUMB -->