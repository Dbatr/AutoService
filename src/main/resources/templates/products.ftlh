<!DOCTYPE html>
<html>
<head>
    <title>Autoservice</title>
</head>
<body>
<h1>Autoservice</h1>

<#if user?has_content>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Выйти">
    </form>
<#else>
    <a href="/login" style="color: brown; font-size: 30px; text-decoration: none;">Войти</a>
</#if>
<hr>
<#if user?has_content>
    <form action="/" method="get">
        Поиск по имени: <input type="text" name="title"><br>
        <input type="submit" value="Поиск"/>
    </form>

    <h2>Заказы для определенного механика:</h2>
    <#list allAssignments as assignment>
        <div>
            <p>
                Рабочий: ${assignment.mechanic.firstName} ${assignment.mechanic.lastName} выполняет в
                ${assignment.workspace.workspaceName} задачу
                ${assignment.product.description} от ${assignment.product.title}
            </p>
        </div>
    </#list>
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