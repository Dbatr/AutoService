<!DOCTYPE html>
<html>
<head>
    <title>Autoservice</title>
</head>
<body>
<h1>Autoservice</h1><hr>
<h4>Подробная информация о заказе</h4>
<b>Имя клиента: </b>${product.title}<br>
<b>Описание проблемы: </b>${product.description}<br>
<hr>
<form action="/product/delete/${product.id}" method="post">
    <input type="submit" value="Данный заказ выполнен. Убрать из списка"/>
</form>
</body>
</html>