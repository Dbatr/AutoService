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
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Выйти">
    </form>
    <a href="/profile">Посмотреть профиль</a>
<#else>
    <a href="/login" style="color: brown; font-size: 30px; text-decoration: none;">Войти</a>
</#if>
<hr>
<#if user?has_content>
    <h2>Заказы для определенного механика:</h2>
    <#list assignmentsForCurrentMechanic as assignment>
        <#if !assignment.product.completed>
            <div>
                <p>
                    Рабочий: ${assignment.mechanic.firstName} ${assignment.mechanic.lastName} выполняет в
                    ${assignment.workspace.workspaceName} задачу
                    ${assignment.product.description} от ${assignment.product.title}
                </p>
                <form action="/completeAssignment" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <input type="hidden" name="assignmentId" value="${assignment.id}">
                    <input type="submit" value="Заказ выполнен">
                </form>
            </div>
        </#if>
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