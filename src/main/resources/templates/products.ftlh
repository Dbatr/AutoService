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
<#list products as product>
    <div>
        <p><b>${product.title}</b>  | <a href="/product/${product.id}">Подробнее...</a></p>
    </div>
<#else>
    <h3>Заказов нет</h3>
</#list>
<hr>
<h3>Создать новый заказ</h3>
<form action="/product/create" method="post">
    Имя клиента: <input type="text" name="title"/><br><br>
    Описание заказа: <input type="text" name="description"/><br><br>
    <input type="submit" value="Добавить товар"/>
</form>
</body>
</html>