<%@ include file="/common/taglibs.jsp"%>
<head>
	<title>Login</title>
</head>
<body>
	<form method="post" id="loginForm" action="<c:url value="/j_security_check"/>">
		<fieldset>
			<legend>Login form</legend>
			<label for="j_username">Username</label>
			<input type="text" size="30" name="j_username" id="j_username"><br />
			<label for="j_password">Password</label>
			<input type="password" size="30" name="j_password" id="j_password"><br />
			<input type="submit" id="login" value="Login">
		</fieldset>
		<c:if test="${param.error != null}">
			<p style="color: red;"><strong>Login failed, try again.</strong></p>
			<p><c:out value="${param.error }"></c:out></p>
		</c:if>
    </form>
</body>