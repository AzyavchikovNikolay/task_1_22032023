<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.util.ResourceBundle" %>

<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="localization.local" var="loc" />
<fmt:message bundle="${loc}" key="local.header.title" var="news_management" />
<fmt:message bundle="${loc}" key="local.header.login_and_password_for_admin" var="login_for_admin" />
<fmt:message bundle="${loc}" key="local.header.login_and_password_for_user" var="login_for_user" />
<fmt:message bundle="${loc}" key="local.header.welcome" var="header_welcome" />
<fmt:message bundle="${loc}" key="local.header.lang_english" var="lang_eng" />
<fmt:message bundle="${loc}" key="local.header.lang_russian" var="lang_rus" />
<fmt:message bundle="${loc}" key="local.header.enter_login" var="enter_login" />
<fmt:message bundle="${loc}" key="local.header.enter_password" var="enter_password" />
<fmt:message bundle="${loc}" key="local.header.registration" var="registration" />
<fmt:message bundle="${loc}" key="local.header.sign_in" var="sign_in" />
<fmt:message bundle="${loc}" key="local.header.sign_out" var="sign_out" />
<fmt:message bundle="${loc}" key="local.header.status" var="status" />
<fmt:message bundle="${loc}" key="local.header.admin" var="admin" />
<fmt:message bundle="${loc}" key="local.header.redactor" var="redactor" />
<fmt:message bundle="${loc}" key="local.header.user" var="user" />

<fmt:message bundle="${loc}" key="local.header.title" var="news_management" />
<fmt:message bundle="${loc}" key="local.addNews.news" var="news" />
<fmt:message bundle="${loc}" key="local.addNews.adding_news" var="adding_news" />
<fmt:message bundle="${loc}" key="local.addNews.warning" var="add_news_warning" />
<fmt:message bundle="${loc}" key="local.addNews.news_title" var="news_title" />
<fmt:message bundle="${loc}" key="local.addNews.news_date" var="news_date" />
<fmt:message bundle="${loc}" key="local.addNews.news_brief" var="news_brief" />
<fmt:message bundle="${loc}" key="local.addNews.news_content" var="content" />
<fmt:message bundle="${loc}" key="local.addNews.add_news" var="add_news" />
<fmt:message bundle="${loc}" key="local.addNews.back_to_news_list" var="back_to_news_list" />
<fmt:message bundle="${loc}" key="local.addNews.news_status" var="news_status" />
<fmt:message bundle="${loc}" key="local.addNews.new_news" var="new_news" />
<fmt:message bundle="${loc}" key="local.addNews.published_news" var="published_news" />

<fmt:message bundle="${loc}" key="local.editNews.news" var="news" />
<fmt:message bundle="${loc}" key="local.editNews.adding_news" var="adding_news" />
<fmt:message bundle="${loc}" key="local.editNews.warning" var="edit_news_warning" />
<fmt:message bundle="${loc}" key="local.editNews.news_title" var="news_title" />
<fmt:message bundle="${loc}" key="local.editNews.news_date" var="news_date" />
<fmt:message bundle="${loc}" key="local.editNews.news_brief" var="news_brief" />
<fmt:message bundle="${loc}" key="local.editNews.news_content" var="content" />
<fmt:message bundle="${loc}" key="local.editNews.edit_news" var="edit_news" />
<fmt:message bundle="${loc}" key="local.editNews.back_to_news_list" var="back" />
<fmt:message bundle="${loc}" key="local.addNews.news_status" var="news_status" />
<fmt:message bundle="${loc}" key="local.addNews.new_news" var="new_news" />
<fmt:message bundle="${loc}" key="local.addNews.published_news" var="published_news" />
<fmt:message bundle="${loc}" key="local.editNews.current_news_status" var="current_news_status" />
<fmt:message bundle="${loc}" key="local.editNews.new_news_status" var="new_news_status" />
<fmt:message bundle="${loc}" key="local.editNews.new_news" var="new_news" />
<fmt:message bundle="${loc}" key="local.editNews.published_news" var="published_news" />

<fmt:message bundle="${loc}" key="local.error_page" var="error" />

<fmt:message bundle="${loc}" key="local.footer" var="footer" />

<fmt:message bundle="${loc}" key="local.guest_info.guest_info" var="info" />
<fmt:message bundle="${loc}" key="local.guest_info.news" var="news" />
<fmt:message bundle="${loc}" key="local.guest_info.latest_news" var="latest_news" />
<fmt:message bundle="${loc}" key="local.guest_info.no_news" var="no_news" />

<fmt:message bundle="${loc}" key="local.menu.news" var="news" />
<fmt:message bundle="${loc}" key="local.menu.news_list" var="news_list" />
<fmt:message bundle="${loc}" key="local.menu.add_news" var="add_news" />

<fmt:message bundle="${loc}" key="local.news_list.news" var="news" />
<fmt:message bundle="${loc}" key="local.news_list.news_list" var="news_list" />
<fmt:message bundle="${loc}" key="local.news_list.delete_selected_news" var="delete_selected_news" />
<fmt:message bundle="${loc}" key="local.news_list.editlink" var="editlink" />
<fmt:message bundle="${loc}" key="local.news_list.viewlink" var="viewlink" />
<fmt:message bundle="${loc}" key="local.news_list.no_news" var="no_news" />
<fmt:message bundle="${loc}" key="local.news_list.registration_success" var="registration_success" />
<fmt:message bundle="${loc}" key="local.addNews.add_news_success" var="add_news_success" />
<fmt:message bundle="${loc}" key="local.news_list.delete_selected_news_warning" var="delete_selected_news_warning" />
<fmt:message bundle="${loc}" key="local.news_list.delete_selected_news_success" var="delete_selected_news_success" />
<fmt:message bundle="${loc}" key="local.news_list.delete_news_success" var="delete_news_success" />
<fmt:message bundle="${loc}" key="local.news_list.session_warning" var="session_warning" />
<fmt:message bundle="${loc}" key="local.news_list.news_status_new" var="news_status_new" />
<fmt:message bundle="${loc}" key="local.news_list.news_status_published" var="news_status_published" />
<fmt:message bundle="${loc}" key="local.news_list.news_status_remote" var="news_status_remote" />

<fmt:message bundle="${loc}" key="local.registration_form.registration_form" var="registration_form" />
<fmt:message bundle="${loc}" key="local.registration_form.warning_fill_fields" var="warning_fill_fields" />
<fmt:message bundle="${loc}" key="local.registration_form.warning_user_exists" var="warning_user_exists" />
<fmt:message bundle="${loc}" key="local.registration_form.enter_details" var="enter_details" />
<fmt:message bundle="${loc}" key="local.registration_form.login" var="login" />
<fmt:message bundle="${loc}" key="local.registration_form.password" var="password" />
<fmt:message bundle="${loc}" key="local.registration_form.role" var="role" />
<fmt:message bundle="${loc}" key="local.registration_form.surname" var="surname" />
<fmt:message bundle="${loc}" key="local.registration_form.name" var="name" />
<fmt:message bundle="${loc}" key="local.registration_form.phone" var="phone" />
<fmt:message bundle="${loc}" key="local.registration_form.email" var="email" />
<fmt:message bundle="${loc}" key="local.registration_form.birthday" var="birthday" />
<fmt:message bundle="${loc}" key="local.registration_form.confirm" var="confirm" />
<fmt:message bundle="${loc}" key="local.registration_form.go_to_main_page" var="go_to_main_page" />

<fmt:message bundle="${loc}" key="local.viewNews.news" var="news" />
<fmt:message bundle="${loc}" key="local.viewNews.view_news" var="view_news" />
<fmt:message bundle="${loc}" key="local.viewNews.news_title" var="news_title" />
<fmt:message bundle="${loc}" key="local.viewNews.news_date" var="news_date" />
<fmt:message bundle="${loc}" key="local.viewNews.news_brief" var="news_brief" />
<fmt:message bundle="${loc}" key="local.viewNews.news_content" var="news_content" />
<fmt:message bundle="${loc}" key="local.viewNews.edit" var="edit" />
<fmt:message bundle="${loc}" key="local.viewNews.delete" var="delete" />
<fmt:message bundle="${loc}" key="local.viewNews.edit_success" var="edit_success" />
<fmt:message bundle="${loc}" key="local.addNews.back_to_news_list" var="back_to_news_list" />

<fmt:message bundle="${loc}" key="local.base_page.header_title" var="header_title" />
<fmt:message bundle="${loc}" key="local.base_page.welcome" var="welcome" />