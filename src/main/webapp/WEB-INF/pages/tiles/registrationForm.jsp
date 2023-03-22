<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="/WEB-INF/pages/tiles/localizationVars.jsp" %>

<div class="registration">
	<div class=registration-title><c:out value="${registration_form}" /><br/>
	</div>
		<c:if test="${sessionScope.warningReg eq 'warning'}">
			<div class=registration-warning><c:out value="${warning_fill_fields}" /></div>
			<c:set var="warningReg" scope="session" value=""/>
		</c:if>
		<c:if test="${sessionScope.warningReg2 eq 'warning'}">
			<div class=registration-warning><c:out value="${warning_user_exists}" /></div>
			<c:set var="warningReg2" scope="session" value=""/>
		</c:if>
	<div class="registration-field" ><b><c:out value="${enter_details}" /></b></div>
	<div  align="left">
		
		<form action="controller" method="post">
			<input type="hidden" name="command" value="do_registration"/>
			<div class="registration-field"><c:out value="${login}" /> <input type="text" name="loginReg" value="${registrationData.login}"/>
				<c:if test="${(sessionScope.loginInvalid eq 'local.registration_form.login_invalid')}">
					<font color="red"> 
						<fmt:message bundle="${loc}" key="${sessionScope.loginInvalid}" var="login_invalid" />
						<c:out value="${login_invalid}" />
						<c:set var="loginInvalid" scope="session" value=""/>
					</font> 
				</c:if>
			<br/>
			</div> 
			<div class="registration-field"><c:out value="${password}" /> <input type="text" name="passwordReg" value="${registrationData.password}"/>
				<c:if test="${(sessionScope.passwordInvalid eq 'local.registration_form.password_invalid')}">
					<font color="red"> 
						<fmt:message bundle="${loc}" key="${sessionScope.passwordInvalid}" var="password_invalid" />
						<c:out value="${password_invalid}" />
						<c:set var="passwordInvalid" scope="session" value=""/>
					</font> 
				</c:if>
			<br/>
			</div>
			<div class="registration-field"><c:out value="${role}" />
				<select name="role">
					<!-- <option>admin</option> -->
					<option>user</option>
				</select>
			</div>
			<div class="registration-field"><c:out value="${surname}" />: <input type="text" name="surname" value="${registrationData.surname}"/>
				<c:if test="${(sessionScope.surnameInvalid eq 'local.registration_form.surname_invalid')}">
					<font color="red"> 
						<fmt:message bundle="${loc}" key="${sessionScope.surnameInvalid}" var="surname_invalid" />
						<c:out value="${surname_invalid}" />
						<c:set var="surnameInvalid" scope="session" value=""/>
					</font>
				 </c:if>
			<br/>
			</div>
			<div class="registration-field"><c:out value="${name}" /> <input type="text" name="name" value="${registrationData.name}"/>
				<c:if test="${(sessionScope.nameInvalid eq 'local.registration_form.name_invalid')}">
					<font color="red"> 
						<fmt:message bundle="${loc}" key="${sessionScope.nameInvalid}" var="name_invalid" />
						<c:out value="${name_invalid}" />
						<c:set var="nameInvalid" scope="session" value=""/>
					</font> 
				</c:if>
			<br/>
			</div>
			<div class="registration-field"><c:out value="${phone}" /><input type="text" name="phone" value="${registrationData.phone}"/>
				<c:if test="${(sessionScope.phoneInvalid eq 'local.registration_form.phone_invalid')}">
					<font color="red"> 
						<fmt:message bundle="${loc}" key="${sessionScope.phoneInvalid}" var="phone_invalid" />
						<c:out value="${phone_invalid}" />
						<c:set var="phoneInvalid" scope="session" value=""/>
					</font> 
				</c:if>
			<br/>
			</div>
			<div class="registration-field"><c:out value="${email}" /> <input type="text" name="email" value="${registrationData.email}"/>
				<c:if test="${(sessionScope.emailInvalid eq 'local.registration_form.email_invalid')}">
					<font color="red"> 
						<fmt:message bundle="${loc}" key="${sessionScope.emailInvalid}" var="email_invalid" />
						<c:out value="${email_invalid}" />
						<c:set var="emailInvalid" scope="session" value=""/>
					</font> 
				</c:if>
			<br/>
			</div>
			<div class="registration-field"><c:out value="${birthday}" /> <input type="text" name="birthday" value="${registrationData.birthday}"/>
				<c:if test="${(sessionScope.birthdayInvalid eq 'local.registration_form.birthday_invalid')}">
					<font color="red"> 
						<fmt:message bundle="${loc}" key="${sessionScope.birthdayInvalid}" var="birthday_invalid" />
						<c:out value="${birthday_invalid}" />
						<c:set var="birthdayInvalid" scope="session" value=""/>
					</font>
				</c:if>
			<br/>
			</div>
			<div class="registration-field">
				<input type="submit" value="${confirm}"/>
			</div>
		</form>

		<div class="registration-field">
			
				<form action="controller" method="post">
							<input type="hidden" name="command" value="return_to_base_page">
							<input type="submit" value="${go_to_main_page}"> 
				</form>			
		</div>
	</div>
</div>