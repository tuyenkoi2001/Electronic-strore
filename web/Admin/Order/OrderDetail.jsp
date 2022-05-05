<%-- 
    Document   : edit-form
    Created on : Apr 19, 2022, 10:41:59 PM
    Author     : Hoàng Xuân Tuyền
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>Order Id</h2>

<div class="order-summary">
    
    <div class="container" style="width:100%">
        <table class="table">
            <thead>
                <tr>
                    <th class="th-lg">Product</th>
                    <th class="th-lg">Quantity</th>
                    <th class="th-lg" style="width: 15%">Cost</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${list}" var="o">
                    <tr>
                        <td><a href="/product?productID=${o.id}">${o.name}</a></td>
                        <td>${o.quantity}</td>
                        <td>${o.cost*o.quantity} $</td>
                    </tr>
                </c:forEach>>
            </tbody>
        </table>
    </div>
    
    <div class="order-col" style="width: 30%">
            <div><strong>Shipping</strong></div>
            <div><strong>FREE</strong></div>
    </div>
    <div class="order-col" style="width: 30%">
            <div><strong>TOTAL</strong></div>
            <div><strong class="order-total">$${totalCost}</strong></div>
    </div>
    
    <button type="button" class="btn cancel" onclick="closeEditForm()">Close</button>
</div>