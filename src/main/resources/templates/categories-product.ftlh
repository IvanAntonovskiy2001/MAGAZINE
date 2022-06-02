<!DOCTYPE html>
<html>
<head>
    <title>Магазин "У Петровича"</title>
</head>
<body>
<#list categories as product>
    <div>
        <form action="/cart/${product.title}" method="get">
            <p><b>${product.title} - <a href="/product/${product.id}" >${product.name}</a> </b> ${product.price} руб. <input type="submit" value="Добавить в корзину" />  </p>
        </form>
    </div>
<#else>
    <h3>В этой категории товаров нет </h3>
    <form action="/product/create" method="get">
        <input type="submit" value="Добавить новый товар в эту категорию" />
    </form>
</#list>
<hr>

<form action="/" method="get">
    <input type="submit" value="Главная" />
</form>
</body>
</html>