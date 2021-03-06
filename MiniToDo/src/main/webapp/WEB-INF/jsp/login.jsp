<%@ include file="common/header.jsp"%>
<div class="container" style="margin-top: 100px;margin-right: 100px">
 <div class="row">
  <div class="col-md-6 col-md-offset-3 ">
   <div class="panel panel-primary">
    <div class="panel-heading">Sign in to continue</div>
    <div class="panel-body">
     <form:form method="post" modelAttribute="user">
      <%-- <form:hidden path="id" /> --%>
      <fieldset class="form-group">
       <form:label path="email">Email</form:label>
       <form:input path="email" type="text" class="form-control"/>
       <form:errors path="email" cssClass="text-danger" />
      </fieldset>

      <fieldset class="form-group">
       <form:label path="password">Password</form:label>
       <form:input path="password" type="text" class="form-control"
        required="required" />
       <form:errors path="password" cssClass="text-warning" />
      </fieldset>

      
      <div class="form-group">
      <button type="submit" class="btn btn-success">Sign In</button>
      <span>Don't have an account? <a href="/signup">Sign Up
        </a></span>
      </div>
     </form:form>
    </div>
   </div>
  </div>
 </div>
</div>
<%@ include file="common/footer.jsp"%>