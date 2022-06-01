<!DOCTYPE html>
<html>
<head>
    <title>Магазин "У Петровича"</title>
</head>
<body>
<h1>Магазин "У Петровича"</h1><hr>
<h4>Подробная информация о товаре</h4>
<b>Название товара: </b>${product.title}<br>
<b>Описание товара: </b>${product.description}<br>
<b>Цена: </b>${product.price}<br>
<hr>
<form action="/product/delete/${product.id}" method="post">
    <input type="submit" value="Удалить товар"/>

</form>
<form action="/" method="get">
    <input type="submit" value="Главная" />
</form>
</body>
</html>