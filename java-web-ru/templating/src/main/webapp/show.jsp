<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- BEGIN -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User</title>
    // Подключаем стили Bootstrap
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
          crossorigin="anonymous">
</head>
<body>
// В цикле выводим всех пользователей
// Внутри jsp-файла нам доступна переменная users, которую мы установили в сервлете
<div class="container">
    <a href="/users">Все пользователи</a>
    <table>
        <tr>
            <td>${user.get("id")}</td>
        </tr>
        <tr>
            <td>${user.get("firstName")}</td>
            <td>${user.get("lastName")}</td>
        </tr>
        <tr>
            <td>${user.get("email")}</td>
        </tr>
    </table>
    <a href='/users/delete?id=${user.get("id")}'>Удалить</a>
</div>
</body>
</html>
<!-- END -->
