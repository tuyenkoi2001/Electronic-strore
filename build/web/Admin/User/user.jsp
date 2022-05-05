
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link href="../../css/popup-form.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<jsp:include page="../Common/HeaderAndNav.jsp" />

<div class="section">

    <div class="container">
    <h2>User</h2>
    
    <table class="table table-striped">
    <thead>
      <tr>
        <th>ID</th>
        <th>User Name</th>
        <th>Password</th>
        <th>Email</th>
        <th>Active</th>
      </tr>
    </thead>
    <tbody>
        <c:forEach items="${listAccount}" var="o" >
              <tr>
                <td>${o.id}</td>
                <td>${o.username}</td>
                <td>${o.pass}</td>
                <td>${o.email}</td>
                <td>
                    <button class="btn btn-success" onclick="openEditForm(${o.id})" >Edit</button>
                    <c:if test="${o.getActive() == 1}">
                        <button class="btn btn-danger" onclick="Deactivate(${o.id})">Deactivate</button>
                    </c:if>
                    <c:if test="${o.getActive() == 0}">
                        <button class="btn btn-success" onclick="Activate(${o.id})">Activate</button>
                    </c:if>
                </td>
                <td>
                    <c:if test="${o.isIsAdmin()==1}">
                        <button class="btn btn-danger"  onclick="Reject(${o.id})">Reject</button>
                    </c:if>
                    <c:if test="${o.isIsAdmin()==0}">
                        <button class="btn btn-success"  onclick="Authority(${o.id})">Authority</button>
                    </c:if>
                </td>
              </tr>
        </c:forEach>
    </tbody>
    </table>
  
    <div class="form-popup" id="edit-form">
        
    </div>
    
    <script>
        function openEditForm(id) {
            document.getElementById("edit-form").style.display = "block";
            var action = "Edit";
            
            $.ajax({
                type: "post",
                url: "/user-manage",
                data: {id:id,action:action},
                success: function(data){
                    $('.form-popup').html(data);
                },
                error: function () {
                    alert(id);
                }
              });
        }

        function closeEditForm() {
          document.getElementById("edit-form").style.display = "none";
        }
        
        function Deactivate(id) {
            var id = id;
            var action = "Deactivate";
            $.ajax({
                type: "get",
                url: "/user-manage",
                data: {id:id,action:action},
                success: function(){
                    $('.section .container').load(' .section .container');
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert("lỗi rồi bro: "+id);
                }
              });
        }
        
        function Activate(id) {
            var id = id;
            var action = "Activate";
            $.ajax({
                type: "get",
                url: "/user-manage",
                data: {id:id,action:action},
                success: function(){
                    $('.section .container').load(' .section .container');
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert("lỗi rồi bro: "+id);
                }
              });
        }
        
        function Create(catName) {
            var catID = -1;
            var name = catName;
            var action = "Create";
            $.ajax({
                type: "post",
                url: "/category-manage",
                data: {catID:catID,action:action,name:name},
                success: function(){
                    $('.section .container').load(' .section .container');
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert("lỗi rồi bro: "+catID);
                }
              });
        }

        function Authority(id){
            var id = id;
            var action = "Authorize";
            $.ajax({
                type: "get",
                url: "/user-manage",
                data: {id:id,action:action},
                success: function(){
                    $('.section .container').load(' .section .container');
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert("lỗi rồi bro: "+id);
                }
              });
        }

        function Reject(id){
            var id = id;
            var action = "Reject";
            $.ajax({
                type: "get",
                url: "/user-manage",
                data: {id:id,action:action},
                success: function(){
                    $('.section .container').load(' .section .container');
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert("lỗi rồi bro: "+id);
                }
              });
        }

    </script>
</div>

</div>