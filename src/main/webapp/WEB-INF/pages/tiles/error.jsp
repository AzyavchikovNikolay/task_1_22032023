<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="/WEB-INF/pages/tiles/localizationVars.jsp" %>

	<c:out value="${error}" />
	<form action="controller" method="post">
		<input type="hidden" name="command" value="go_to_base_page"/>
		<div class="registration-field">
			<input type="submit" value="${back}"/>
		</div>
	</form>
