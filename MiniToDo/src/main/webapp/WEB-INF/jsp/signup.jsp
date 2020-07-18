<%@ include file="common/header.jsp"%>
<div class="container" style="margin-top: 100px;margin-right: 100px">
 <div class="row">
  <div class="col-md-6 col-md-offset-3 ">
   <div class="panel panel-primary">
    <div class="panel-heading">Sign in to continue</div>
    <div class="panel-body">
     <form:form method="post" modelAttribute="user" action="signup">
      <%-- <form:hidden path="id" /> --%>
       <fieldset class="form-group">
       <form:label path="firstName">First name</form:label>
       <form:input path="firstName"  class="form-control" />
       <form:errors path="firstName" cssClass="error" />
      </fieldset>
       <fieldset class="form-group">
       <form:label path="lastName">Last name</form:label>
       <form:input path="lastName"  class="form-control"/>
       <form:errors path="lastName" cssClass="error" />
      </fieldset>
       <fieldset class="form-group">
       <form:label path="email">Email</form:label>
       <form:input path="email"  class="form-control"/>
       <form:errors path="email" cssClass="error" />
      </fieldset>
      <fieldset class="form-group">
       <form:label path="password">Password</form:label>
       <form:input path="password" type="password" class="form-control" />
       <form:errors path="password" cssClass="error" />
      </fieldset>

      
      <div class="form-group">
      <button type="submit" class="btn btn-success">Sign Up</button>
      </div>
     </form:form>
    </div>
   </div>
  </div>
 </div>
</div>
<%@ include file="common/footer.jsp"%>