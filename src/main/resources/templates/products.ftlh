<!DOCTYPE html>
<html>
<head>
    <title>Autoservice</title>
    <style>



    </style>
</head>
<body>
<h1>Autoservice</h1>
<#if user?has_content>
    <form action="/logout" method="post">
        <input type="submit" value="Выйти">
    </form>
    <a href="/profile">Посмотреть профиль</a>
<#else>
    <a href="/login" style="color: brown; font-size: 30px; text-decoration: none;">Войти</a>
</#if>
<hr>
<#if user?has_content>
    <h2>Заказы для определенного механика:</h2>
    <h1>Все заказы:</h1>
    <#list products as product>
        <div>
            <p><b>${product.title}</b>  | <a href="/product/${product.id}">Подробнее...</a></p>
        </div>
    <#else>
        <h3>Заказов нет</h3>
    </#list>
<#else>
    <p style="color: red">Чтобы увидеть все заказы, сначала зайдите в профиль</p>
</#if>
</body>
</html>