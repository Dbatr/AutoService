<!DOCTYPE html>
<html>
<head>
    <title>Вход</title>
</head>
<body>
<h1>Вход</h1>
<form action="/login" method="post">
    <label for="login">Логин:</label>
    <input type="text" id="login" name="login" required><br>
    <label for="password">Пароль:</label>
    <input type="password" id="password" name="password" required><br>
    <input type="submit" value="Войти">
</form>
<!-- Отобразите сообщение об ошибке входа, если попытка входа не удалась -->
    <#if loginError??>
    <p style="color: red;">Ошибка входа. Пожалуйста, проверьте ваши учетные данные и попробуйте снова.</p>
    </#if>
</body>
</html>