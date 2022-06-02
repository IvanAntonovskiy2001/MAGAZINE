<!DOCTYPE html>
<html>
<head>
    <title>Магазин "У Петровича"</title>
</head>
<body>
<a href="/login">Войти</a><hr>
<form action="/product/create" method="get">
<h1>Магазин "У Петровича"...<< Создать товар для потребительской корзины>> - <input type="submit" value="Добавить новый товар в каталог" />
</form>
<h1>Товары нашего магазина : </h1>
<#list products as product>
    <div>
        <form action="/product/${product.id}" method="get">

        <p><b>${product.name}</b> ${product.price} руб. | <input type="submit" value="Информация о товаре." /></p>
        </form>
    </div>
    <#else>
    <h3>Товаров нет</h3>
</#list>
<hr>
<h1>Выбирите товар : </h1>
<#list products as product>
    <div>
        <form action="/cart/${product.title}" method="get">
        <p><b>${product.name} - </b> ${product.price} руб. <input type="submit" value="Добавить в корзину" />  </p>
        </form>
    </div>
<#else>
    <h3>Товаров нет</h3>
</#list>
<hr>
<h2>Cумма Заказа : ${price} руб.</h2>
<h2>Количество товаров в  Заказе : ${quantity} штук</h2>

<form action="/basket/delete" method="post" enctype="multipart/form-data">
    <h2><input type="submit" value="Очистить корзину"/></h2>
</form>
<hr>
<form action="/basket" method="get">
    <H2>Зайти в корзину : <input type="submit" value="Корзина" /></H2>
</form>


<form action="/categories" method="get">
    <input type="submit" value="категории" />
</form>

</body>
</html>