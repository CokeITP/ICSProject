
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<nav
	class="admin-header navbar navbar-default col-lg-12 col-12 p-0 fixed-top d-flex flex-row"
	style="background-color: #134B8A;">
	<!-- logo -->
	<div class="text-left navbar-brand-wrapper">
		<a class="navbar-brand brand-logo" href="${uri}"><img
			src="${uri}/contents/images/logo.png" alt=""></a> <a
			class="navbar-brand brand-logo-mini" href="${uri}"><img  
			src="${uri}/contents/images/logo.png" alt=""></a>
	</div>

	<!-- top bar right -->
	<ul class="nav navbar-nav ml-auto">
		<li class="nav-item dropdown "><a class="nav-link top-nav"
			data-toggle="dropdown" href="#" role="button" aria-haspopup="false"
			aria-expanded="false"> <i class="fa fa-bell"></i>
		</a></li>

		<li class="nav-item dropdown mr-30"><a
			class="nav-link nav-pill user-avatar" data-toggle="dropdown" href="#"
			role="button" aria-haspopup="true" aria-expanded="false"> <img
				src="${uri}/contents/images/people.png" alt="avatar">
		</a></li>

	</ul>
</nav>
