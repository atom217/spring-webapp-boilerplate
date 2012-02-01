<%@ include file="/common/taglibs.jsp"%>
<head>
	<title>Home page</title>
</head>
<body>
	<h1>Web Application Boilerplate</h1>
	<auth:authentication property="principal" var="user" />
	<auth:authentication property="authorities" var="roles" />
	<c:choose>
		<c:when test="${user != 'anonymousUser'}">
			<span>Hello <c:out value="${user.username}"></c:out> - <a href="<c:url value="/logout.jsp"/>">Logout</a></span><br />
		</c:when>
		<c:otherwise>
			<span>Hello anonymous user - <a href="<c:url value="/login.jsp"/>">Login</a></span><br />
		</c:otherwise>
	</c:choose>
	
	<auth:authorize ifAllGranted="ROLE_ANONYMOUS">
		<span>If you are reading this you have the role <c:out value="${roles}"></c:out></span><br />
	</auth:authorize>
	<auth:authorize ifAnyGranted="ROLE_ADMIN,ROLE_USER">
		<span>If you are reading this you have one of this roles: <c:out value="${roles}"></c:out></span><br />
	</auth:authorize>
	
	<auth:authorize ifAllGranted="ROLE_ADMIN">
		<span>If you are reading this you have the role <c:out value="${roles}"></c:out></span><br />
	</auth:authorize>
	
	<a href="<c:url value="/admin.html"/>">Admin area</a>
</body>