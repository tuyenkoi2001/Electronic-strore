
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h2>Edit Form</h2>
    <form action="/user-manage" class="form-container">

        <div class="form-group">
              <input type="text" name="id" class="form-control" value="${Account.id}" hidden>  
        </div>

          <div class="form-group">
              <label>Name:</label>  
              <input type="text" name="name" class="form-control" value="${Account.name}" required="">  
          </div>  

          <div class="form-group">  
               <label>Email:</label>  
               <input type="text" name="email" class="form-control" value="${Account.email}" required="">  
          </div>

          <div class="form-group">  
               <label>UserName:</label>  
               <input type="text" name="username" class="form-control" value="${Account.username}" required="">  
          </div>

          <div class="form-group">  
               <label>Password:</label>  
               <input type="text" name="password" class="form-control" value="${Account.pass}" required="">  
          </div>

          <div class="form-group">  
               <label>Address</label>  
               <input type="text" name="address" class="form-control" value="${Account.address}" required="">  
          </div>

          <div class="form-group">  
               <label>Phone</label>  
               <input type="text" name="phone" class="form-control" value="${Account.sdt}" required="">  
          </div>

      <button type="submit" class="btn" name="action" value="Save">Save</button>
      <button type="button" class="btn cancel" onclick="closeEditForm()">Close</button>
    </form>
