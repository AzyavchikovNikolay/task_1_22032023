<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="/WEB-INF/pages/tiles/localizationVars.jsp" %>

<c:if test="${sessionScope.registration eq 'success'}">
			<div class=registration-success><c:out value="${registration_success}" /></div>
			<c:set var="registration" scope="session" value=""/>
</c:if>

<c:if test="${sessionScope.add_news eq 'success'}">
			<div class=registration-success><c:out value="${add_news_success}" /></div>
			<c:set var="add_news" scope="session" value=""/>
</c:if>

<c:if test="${sessionScope.delete_selected_news eq 'warning'}">
			<div class=registration-warning><c:out value="${delete_selected_news_warning}" /></div>
			<c:set var="delete_selected_news" scope="session" value=""/>
</c:if>

<c:if test="${sessionScope.delete_selected_news eq 'success'}">
			<div class=registration-success><c:out value="${delete_selected_news_success}" /></div>
			<c:set var="delete_selected_news" scope="session" value=""/>
</c:if>

<c:if test="${sessionScope.delete_news eq 'success'}">
			<div class=registration-success><c:out value="${delete_news_success}" /></div>
			<c:set var="delete_news" scope="session" value=""/>
</c:if>

<c:if test="${sessionScope.session_warning eq 'warning'}">
			<div class=registration-warning><c:out value="${session_warning}" /></div>
			<c:set var="session_warning" scope="session" value=""/>
</c:if>

<div class="body-title">
	<a href="controller?command=go_to_news_list"><c:out value="${news}" /></a> <c:out value="${news_list}" />
</div>

<form action="controller?command=do_delete_selected_news" method="post">
	<c:if test="${sessionScope.role eq 'admin'}">
		<div class="delete2">
			<input type="submit" value="${delete_selected_news}"/>
		</div>
	</c:if>
	<c:if test="${sessionScope.role eq 'redactor'}">
		<div class="delete2">
			<input type="submit" value="${delete_selected_news}"/>
		</div>
	</c:if>
	<c:forEach var="news" items="${sessionScope.news}">	
		<c:if test="${sessionScope.role eq 'admin'}">
		<div class="single-news-wrapper">
			<div class="single-news-header-wrapper">
					<c:if test="${news.newsStatus eq 'new'}">
						<div class="news-status-new">
							<c:out value="${news_status_new}" />
						</div>
					</c:if>
					<c:if test="${news.newsStatus eq 'published'}">
						<div class="news-status-published">
							<c:out value="${news_status_published}" />
						</div>
					</c:if>
					<c:if test="${news.newsStatus eq 'remote'}">
						<div class="news-status-remote">
							<c:out value="${news_status_remote}" />
						</div>
					</c:if>
					
				<div class="news-title">
					<c:out value="${news.title}" />
				</div>
				<div class="news-date">
					<c:out value="${news.newsDate}"/>
				</div>	
				
				<div class="news-content">
					<c:out value="${news.briefNews}" />
				</div>
				<div class="news-link-to-wrapper">
					<div class="link-position">
						<c:if test="${sessionScope.role eq 'admin'}">
							<a href="controller?command=go_to_edit_news&id=${news.idNews}"><c:out value="${editlink}" /> </a>
							<c:set var="for_submit_back" scope="session" value="news_list"/>
						</c:if>
							
						<a href="controller?command=go_to_view_news&id=${news.idNews}"><c:out value="${viewlink}" /> </a>
						
						<c:if test="${sessionScope.role eq 'admin'}">
							<input type="checkbox" name="idNews" value="${news.idNews }" />
						</c:if>
					</div>
				</div>
				
			</div>
		</div>
		</c:if>
		
		<c:if test="${sessionScope.role eq 'redactor'}">
		<div class="single-news-wrapper">
			<div class="single-news-header-wrapper">
					<c:if test="${news.newsStatus eq 'new'}">
						<div class="news-status-new">
							<c:out value="${news_status_new}" />
						</div>
					</c:if>
					<c:if test="${news.newsStatus eq 'published'}">
						<div class="news-status-published">
							<c:out value="${news_status_published}" />
						</div>
					</c:if>
					<c:if test="${news.newsStatus eq 'remote'}">
						<div class="news-status-remote">
							<c:out value="${news_status_remote}" />
						</div>
					</c:if>
					
				<div class="news-title">
					<c:out value="${news.title}" />
				</div>
				<div class="news-date">
					<c:out value="${news.newsDate}"/>
				</div>	
				
				<div class="news-content">
					<c:out value="${news.briefNews}" />
				</div>
				<div class="news-link-to-wrapper">
					<div class="link-position">
						<c:if test="${sessionScope.role eq 'redactor'}">
							<a href="controller?command=go_to_edit_news&id=${news.idNews}"><c:out value="${editlink}" /> </a>
							<c:set var="for_submit_back" scope="session" value="news_list"/>
						</c:if>
							
						<a href="controller?command=go_to_view_news&id=${news.idNews}"><c:out value="${viewlink}" /> </a>
						
						<c:if test="${sessionScope.role eq 'redactor'}">
							<input type="checkbox" name="idNews" value="${news.idNews }" />
						</c:if>
					</div>
				</div>
				
			</div>
		</div>
		</c:if>
		
		<c:if test="${sessionScope.role eq 'user'}">
		<c:if test="${news.newsStatus eq 'published'}">
		
		<div class="single-news-wrapper">
			<div class="single-news-header-wrapper">
					
				<div class="news-title">
					<c:out value="${news.title}" />
				</div>
				<div class="news-date">
					<c:out value="${news.newsDate}"/>
				</div>	
				
				<div class="news-content">
					<c:out value="${news.briefNews}" />
				</div>
				
				<div class="news-link-to-wrapper">
					<div class="link-position">
						<a href="controller?command=go_to_view_news&id=${news.idNews}"><c:out value="${viewlink}" /> </a>
					</div>
				</div>
				
			</div>
		</div>
		</c:if>
		</c:if>
		
	</c:forEach>
	
	<div class="no-news">
		<c:if test="${sessionScope.news eq null}">
		<c:out value="${no_news}" />
	</c:if>
	</div>
</form>