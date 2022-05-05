<%-- 
    Document   : edit-form
    Created on : Apr 19, 2022, 10:41:59 PM
    Author     : Hoàng Xuân Tuyền
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>Edit Form</h2>
    <form action="/product-manage" class="form-container">

          <div class="form-group">
              <input type="text" name="id" class="form-control" value="${product.id}" hidden >  
          </div>

          <div class="form-group">
              <label>Name:</label>  
              <input type="text" name="name" class="form-control" value="${product.name}" required="">  
          </div>  

          <div class="form-group">  
               <label>Cost</label>  
               <input type="text" name="cost" class="form-control" value="${product.cost}" required="">  
          </div>

          <div class="form-group">  
               <label>Available</label>  
               <input type="text" name="available" class="form-control" value="${product.available}" required="">  
          </div>


        <button type="submit" class="btn" name="action" value="Save">Save</button>
        <button type="button" class="btn cancel" onclick="closeEditForm()">Close</button>
    </form>
