<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="/WEB-INF/pages/tiles/localizationVars.jsp" %>

<div class="body-title">
	<a href="controller?command=go_to_news_list"><c:out value="${news}" /></a> <c:out value="${adding_news}" />
</div>

	<c:if test="${sessionScope.add eq 'warning'}">
		<div class=registration-warning><c:out value="${add_news_warning}" /></div>
		<c:set var="add" scope="session" value=""/>
	</c:if>

<form action="controller" method="post">
			<input type="hidden" name="command" value="do_add_news"/>
			
			<div class="add-table-margin">
				<table class="news_text_format">
					
					<!--
					<tr>
						<td class="space_around_title_text"><c:out value="${news_id}" /></td>
						<td class="space_around_view_text">
							<div class="word-breaker">
								<input type="text" name="newsId" value=""/>
							</div>
						</td>
					</tr>
					-->
						
					<tr>
						<td class="space_around_title_text"><c:out value="${news_title}" /></td>
						<td class="space_around_view_text">
							<div class="word-breaker">
								<textarea rows="2" cols="50" name="titleEdit"></textarea>
							</div>
						</td>
					</tr>	
					
					<!--
					<tr>
						<td class="space_around_title_text"><c:out value="${news_date}" /></td>
						<td class="space_around_view_text">
							<div class="word-breaker">
								<input type="text" name="newsDateEdit" value=""/>
							</div>
						</td>
					</tr>	
					-->
					
					<tr>
						<td class="space_around_title_text"><c:out value="${news_brief}" /></td>
						<td class="space_around_view_text">
							<div class="word-breaker">
								<textarea rows="5" cols="50" name="briefEdit"></textarea>
							</div>
						</td>
					</tr>	
					<tr>
						<td class="space_around_title_text"><c:out value="${content}" /></td>
						<td class="space_around_view_text">
							<div class="word-breaker">
								<textarea rows="8" cols="50" name="contentEdit"></textarea>
							</div>
						</td>
					</tr>
						<tr>
						<td class="space_around_title_text"><c:out value="${news_status}" /></td>
						<td class="space_around_view_text">
							<div class="word-breaker">
								<select name="statusNewsEdit">
									<option value="new news"><c:out value="${new_news}" /></option>
									<option value="published news"><c:out value="${published_news}" /></option>
								</select>
							</div>
						</td>
					</tr>	
					
				</table>
			</div>
				
			<div class="registration-field">
				<input type="submit" value="${add_news}"/>
			</div>
		</form>

		<form action="controller" method="post">
			<input type="hidden" name="command" value="go_to_news_list"/>
			<div class="registration-field">
				<input type="submit" value="${back_to_news_list}"/>
			</div>
		</form>