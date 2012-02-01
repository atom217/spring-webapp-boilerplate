<%@ include file="/common/taglibs.jsp"%>
<head>
	<title>Admin page</title>
</head>
<body>
	<span>This is the admin section</span><br />
	<span><i>Look at the Javascript code to see requests with and without parameters</i></span>
	<script type="text/javascript">
		$.ajax({
			method: 'GET',
			url: '<c:url value="/users.html"/>',
			success: function(data) {
				$("body").append("<br /><br /><strong>AJAX Loaded Without Params: </strong><span>"+JSON.stringify(data)+"</span>");
			}
		});
		
		$.ajax({
			method: 'GET',
			url: '<c:url value="/user.html"/>',
			data: {userId: 123},
			success: function(data) {
				$("body").append("<br /><br /><strong>AJAX Loaded With Params: </strong><span>"+JSON.stringify(data)+"</span>");
			}
		});
	</script>
</body>