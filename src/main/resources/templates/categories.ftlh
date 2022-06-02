<!DOCTYPE html>
<html>
<head>
    <title>Магазин "У Петровича"</title>
</head>
<body>
<h1>Магазин "У Петровича"</h1><hr>

<#list categories as product>
    <div>
        <form action="/categories/${product.title}" method="get">
        <p><b>${product.title}</b> <input type="submit" value="Посмотреть категорию" /></p>
        </form>
    </div>
</#list>

<form action="/" method="get">
    <input type="submit" value="Главная" />
</form>
</body>
</html>