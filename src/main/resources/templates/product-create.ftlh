<!DOCTYPE html>
<html>
<head>
    <title>Магазин "У Петровича"</title>
</head>
<body>
<h1>Магазин "У Петровича"</h1><hr>

<h3>Создать новый товар</h3>
<form action="/product/create" method="post">
    Вид товара: <Br>
    <input type="radio" name="title" value="Milk"> Milk<Br>
    <input type="radio" name="title" value="Meet"> Meet<Br>
    <input type="radio" name="title" value="Vegetables"> Vegetables<Br>
    <input type="radio" name="title" value="Fruit"> Fruit<Br>
    Название товара: <input type="text" name="name"/><br><br>
    Описание объявления: <input type="text" name="description"/><br><br>
    Цена: <input type="number" name="price"/><br><br>
    Магазин: <input type="text" name="magazine"/><br><br>
    <input type="submit" value="Добавить товар"/>
</form>
<form action="/" method="get">
    <input type="submit" value="Главная" />
</form>
</body>
</html>