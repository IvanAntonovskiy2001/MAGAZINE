<!DOCTYPE html>
<html>
<head>
    <title>MAGAZINE</title>
</head>
<body>
<h1>MAGAZINE
    <h4>Товары </h4>

    <#list baskets as product>
        <div>
            <p><b>${product.title}</b> ${product.price} руб. ${product.quantity}  </p>
            <form action="/cartPlus/${product.title}" method="Post">
                <input type="submit" value="Добавить товар" />
            </form>

            <form action="/cartMinus/${product.id}" method="get">
                <input type="submit" value="Удалить Товар" />
            </form>
        </div>

    <#else>
        <h3>Товаров нет</h3>
    </#list>
    <h2>Cумма Заказа : ${price}</h2>
    <h2>Количество товаров в  Заказе : ${quantity}</h2>

    <form action="/" method="get">
        <input type="submit" value="Главная" />
    </form>
    <hr>
    <form action="/basket/delete" method="post" enctype="multipart/form-data">
        <input type="submit" value="Удалить"/>
    </form>
</body>
</html>