
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link href="../../css/popup-form.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<jsp:include page="../Common/HeaderAndNav.jsp" />

<div class="section">

    <div class="container">
        <h2>Category</h2>

        <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#create-form" aria-expanded="false" aria-controls="collapseExample">
            Create
        </button>

        <div class="card card-body collapse" id="create-form">

              <label for="psw"><b>Name</b></label>
              <input type="text" class="form-control" placeholder="Category name" name="name" required>

              <button class="btn btn-success" onclick="Create($('#create-form input').val())">Submit</button>
        </div>

        <table class="table table-striped">
        <thead>
          <tr>
            <th>Category ID</th>
            <th>Category name</th>
            <th>Handle</th>
          </tr>
        </thead>
        <tbody>
            <c:forEach items="${listCategory}" var="o" >
                  <tr>
                    <td>${o.catID}</td>
                    <td>${o.catName}</td>
                    <td>
                        <button class="btn btn-success" onclick="openEditForm(${o.catID},'${o.catName}')" >Edit</button>
                        <c:if test="${o.getIsDeleted()==0}">
                            <button class="btn btn-danger" onclick="Delete(${o.catID})">Delete</button>
                        </c:if>
                        <c:if test="${o.getIsDeleted()==1}">
                            <button class="btn btn-warning" onclick="Retrieve(${o.catID})">Retrieve</button>
                        </c:if>
                    </td>
                  </tr>
            </c:forEach>
        </tbody>
        </table>

        <div class="form-popup" id="edit-form">
            <h2>Edit Form</h2>
            <form action="/category-manage" class="form-container">

              <label for="email"><b>ID</b></label>
              <input type="text" placeholder="" name="catID" required>

              <label for="psw"><b>Name</b></label>
              <input type="text" placeholder="" name="name" required>

              <button type="submit" class="btn" name="action" value="Edit">Save</button>
              <button type="button" class="btn cancel" onclick="closeEditForm()">Close</button>
            </form>
        </div>

        <script>
            function openEditForm(catID,catName) {
                document.getElementById("edit-form").style.display = "block";

                $('input[name="catID"]').val(catID);
                $('input[name="name"]').val(catName);
            }

            function closeEditForm() {
              document.getElementById("edit-form").style.display = "none";
            }

            function Delete(catID) {
                var catID = catID;
                var action = "Delete";
                $.ajax({
                    type: "get",
                    url: "/category-manage",
                    data: {catID:catID,action:action},
                    success: function(){
                        $('.section .container').load(' .section .container');
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                        alert("lỗi rồi bro: "+catID);
                    }
                  });
            }

            function Retrieve(catID) {
                var catID = catID;
                var action = "Retrieve";
                $.ajax({
                    type: "get",
                    url: "/category-manage",
                    data: {catID:catID,action:action},
                    success: function(){
                        $('.section .container').load(' .section .container');
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                        alert("lỗi rồi bro: "+catID);
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

        </script>
    </div>


</div>

<script src="../../js/main.js" type="text/javascript"></script>
        <script src="../../js/jquery.min.js"></script>
        <script src="../../js/bootstrap.min.js"></script>
        <script src="../../js/slick.min.js"></script>
        <script src="../../js/nouislider.min.js"></script>
        <script src="../../js/jquery.zoom.min.js"></script>
        <script src="../../js/main.js"></script>

