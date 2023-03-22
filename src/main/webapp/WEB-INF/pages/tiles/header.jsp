<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="/WEB-INF/pages/tiles/localizationVars.jsp" %>

<div class="wrapper">
	<div class="newstitle">
		<c:out value="${news_management}" /><br/>
		<div class="newstitle-admin">
			<c:out value="${login_for_admin}" /><br/>
			<c:out value="${login_for_user}" />
		</div>
	</div>
	
	<div class="welcome-title">	
		<c:if test="${not (sessionScope.welcome eq 'guest')}">
			<c:out value="${header_welcome}" />
			<c:out value="${sessionScope.welcome}" />!
			<c:out value="${status}"/>
				<c:if test="${(sessionScope.role eq 'admin')}">
					<c:out value="${admin}"/>
				</c:if>
				<c:if test="${(sessionScope.role eq 'redactor')}">
					<c:out value="${redactor}"/>
				</c:if>
				<c:if test="${(sessionScope.role eq 'user')}">
					<c:out value="${user}"/>
				</c:if>
			</c:if>
			<c:if test="${sessionScope.session eq 'guest'}">
		</c:if>
	</div>
	
	<div class="local-link">

		<div align="right">

			<a href="controller?command=do_change_local&local=en">
				<c:out value="${lang_eng}" /></a> &nbsp;&nbsp; 
			<a	href="controller?command=do_change_local&local=ru">
				<c:out value="${lang_rus}" /></a> <br /> <br />
		</div>
		
		<c:if test="${not (sessionScope.user eq 'active')}">
			<div align="right">
				<form action="controller" method="post">
					<input type="hidden" name="command" value="do_sign_in" />
					
					<c:out value="${enter_login}" />
						<c:if test="${not (requestScope.loginInvalid eq null)}">
							<font color="red"> 
								<fmt:message bundle="${loc}" key="${requestScope.loginInvalid}" var="login_invalid" />
							   <c:out value="${login_invalid}" />
							</font> 
						</c:if>
					<input type="text" name="login" value="" /><br /> 
					
					<c:out value="${enter_password}" />
						<c:if test="${not (requestScope.passwordInvalid eq null)}">
							<font color="red"> 
								<fmt:message bundle="${loc}" key="${requestScope.passwordInvalid}" var="password_invalid" />
							   <c:out value="${password_invalid}" />
							</font> 
						</c:if>
					<input type="password" name="password" value="" /><br />

					<c:if test="${not (requestScope.AuthenticationError eq null)}">
						<font color="red"> 
							<fmt:message bundle="${loc}" key="${requestScope.AuthenticationError}" var="auth_error" />
						   <c:out value="${auth_error}" />
						</font> 
					</c:if>
					
					<a href="controller?command=go_to_registration_page&registration=new">
					<c:out value="${registration}" /></a> <input type="submit" value="${sign_in}" /><br />
				</form>
					
			</div>

		</c:if>
		
		<c:if test="${sessionScope.user eq 'active'}">

			<div align="right">
			
				<form action="controller" method="post">
					<input type="hidden" name="command" value="do_sign_out" /> 
					<input type="submit" value="${sign_out}" /><br />
				</form>
			</div>
		</c:if>
	</div>
</div>