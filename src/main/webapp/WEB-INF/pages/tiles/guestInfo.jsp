<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="/WEB-INF/pages/tiles/localizationVars.jsp" %>

<c:out value="${info}" />
<div class="body-title">
	<a href="controller?command=return_to_base_page"><c:out value="${news}" /> </a> <c:out value="${latest_news}" />
</div>

<form action="command.do?method=delete" method="post">
	<c:forEach var="news" items="${sessionScope.latestNews}">
		<div class="single-news-wrapper">
			<div class="single-news-header-wrapper">
				<div class="news-title">
					<c:out value="${news.title}"/>
				</div>
				<div class="news-date">
					<c:out value="${news.newsDate}"/>
				</div>
				
				<div class="news-content">
					<c:out value="${news.briefNews}"/>
				</div>
			</div>
		</div>
		
	</c:forEach>
	
	<div class="no-news">
		<c:if test="${sessionScope.latestNews eq nule}">
			<c:out value="${no_news}" />
		</c:if>
	</div>
</form>
