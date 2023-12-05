<!DOCTYPE html>
<html>
<head>
    <title>Autoservice</title>
</head>
<body>
<h1>Autoservice</h1><hr>
<h4>Заказы</h4>
<form action="/" method="get">
    Поиск по имени: <input type="text" name="title"><br>
    <input type="submit" value="Поиск"/>
</form>

<!-- Display all assignment details -->
<h4>Список выполненных работ (все детали):</h4>
<#list allAssignments as assignment>
    <div>
        <p>
            AssignmentID: ${assignment.id} |
            Рабочий: ${assignment.mechanic.firstName} ${assignment.mechanic.lastName} выполняет в
            ${assignment.workspace.workspaceName} задачу
            ${assignment.product.description} от ${assignment.product.title}
        </p>
    </div>
</#list>

<#list products as product>
    <div>
        <p><b>${product.title}</b>  | <a href="/product/${product.id}">Подробнее...</a></p>
    </div>
<#else>
    <h3>Заказов нет</h3>
</#list>
</body>
</html>