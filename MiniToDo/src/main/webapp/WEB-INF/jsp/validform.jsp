<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head><style>
    .error{
        color:red
    }
</style>

</head>
<body>
<form:form action="testValid"  modelAttribute="user">
    <form:input path="name"/><br><br>
    <form:input path="password" />
    <form:errors path="password" cssClass="error"/>
    <input type="submit">
</form:form>
</body></html>