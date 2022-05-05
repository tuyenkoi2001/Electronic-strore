<%-- 
    Document   : detail
    Created on : Apr 20, 2022, 9:37:29 AM
    Author     : Hoàng Xuân Tuyền
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../Common/HeaderAndNav.jsp" />

<form action="/product-manage" method="post" enctype="multipart/form-data">
<div class="wrapper bg-white mt-sm-5">
    
    <h4 class="pb-4 border-bottom">Product</h4>

    <input type="text" value="0" name="id" hidden>

    
    <div class="d-flex align-items-start py-3 border-bottom"> <img src="https://images.pexels.com/photos/1037995/pexels-photo-1037995.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500" class="img" alt="">
        <div class="pl-sm-4 pl-2" id="img-section"> <b>Product image</b>
            <input name="photo" type="file" class="btn button border">
        </div>
    </div>
    
    <div class="py-1">
        <div class="row py-1">
            <div class="col-md-6"> 
                <label for="firstname">Name</label> 
                <input type="text" class="bg-light form-control" placeholder="Product Name" name="name" value="${product.name}"> 
            </div>
        </div>
            
        <div class="row py-1">
            <div class="col-md-12 pt-md-0 pt-6"> 
                <label for="lastname">Des</label> 
                <input type="text" class="bg-light form-control" placeholder="Description" name="des" value="${product.mota}"> 
            </div>
        </div>
            
        <div class="row py-1">
            <div class="col-md-12 pt-md-0 pt-6"> 
                <label for="lastname">Cost</label> 
                <input type="text" class="bg-light form-control" placeholder="Cost" name="cost" value="${product.cost}"> 
            </div>
        </div>
        
        <div class="row py-1">
            <div class="col-md-6"> 
                <label for="category">Category</label> 
                <select name="category" id="country" class="bg-light">
                    <c:forEach items="${listCategory}" var="o">
                        <option value="${o.catID}" >${o.catName}</option>
                    </c:forEach>
                </select> 
            </div>
        </div>
            
        <div class="row py-1">
            <div class="col-md-6 pt-md-0 pt-3" id="lang"> 
                <label for="brand">Brand</label>
                <div class="arrow"> 
                    <select name="brand" id="language" class="bg-light" >
                        <c:forEach items="${listBrand}" var="o">
                            <option value="${o.bID}" >${o.bName}</option>
                        </c:forEach>
                    </select> 
                </div>
            </div>
        </div>
        
        <div class="row py-1">
            <div class="col-md-12 pt-md-0 pt-6"> 
                <label for="lastname">Available</label> 
                <input type="number" min="0" class="bg-light form-control" placeholder="Available" name="avail" value="${product.available}"> 
            </div>
        </div>

            
        <div class="py-3 pb-4 border-bottom">
            <button type="submit" class="btn btn-primary mr-3" name="action" value="Create">Create</button> 
            <button class="btn border button">Cancel</button> </div>
        <div class="d-sm-flex align-items-center pt-3" id="deactivate">
            
        </div>
            
    </div>
</div>
</form>
        
        
        
<style>
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box
}

body {
    font-family: 'Poppins', sans-serif;
    background-color: aliceblue
}

.wrapper {
    padding: 30px 50px;
    border: 1px solid #ddd;
    border-radius: 15px;
    margin: 10px auto;
    max-width: 600px
}

h4 {
    letter-spacing: -1px;
    font-weight: 400
}

.img {
    width: 70px;
    height: 70px;
    border-radius: 6px;
    object-fit: cover
}

#img-section p,
#deactivate p {
    font-size: 12px;
    color: #777;
    margin-bottom: 10px;
    text-align: justify
}

#img-section b,
#img-section button,
#deactivate b {
    font-size: 14px
}

label {
    margin-bottom: 0;
    font-size: 14px;
    font-weight: 500;
    color: #777;
    padding-left: 3px
}

.form-control {
    border-radius: 10px
}

input[placeholder] {
    font-weight: 500
}

.form-control:focus {
    box-shadow: none;
    border: 1.5px solid #0779e4
}

select {
    display: block;
    width: 100%;
    border: 1px solid #ddd;
    border-radius: 10px;
    height: 40px;
    padding: 5px 10px
}

select:focus {
    outline: none
}

.button {
    background-color: #fff;
    color: #0779e4
}

.button:hover {
    background-color: #0779e4;
    color: #fff
}

.btn-primary {
    background-color: #0779e4
}

.danger {
    background-color: #fff;
    color: #e20404;
    border: 1px solid #ddd
}

.danger:hover {
    background-color: #e20404;
    color: #fff
}

@media(max-width:576px) {
    .wrapper {
        padding: 25px 20px
    }

    #deactivate {
        line-height: 18px
    }
}</style>