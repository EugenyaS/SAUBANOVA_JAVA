<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script
            src="https://code.jquery.com/jquery-3.4.0.js"
            integrity="sha256-DYZMCC8HTC+QDr5QNaIcfR7VSPtcISykd+6eSmBW5qo="
            crossorigin="anonymous"></script>
    <title>Пользователи</title>
</head>
<script>
    function getPosts() {
        $.ajax({
            type: "GET",
            url: "/posts",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (response) {
                let resultPlace = document.getElementById('post');
                let resultString = '';
                for (let i = 0; i < response.length; i++) {
                    let current = response[i];
                    resultString += '<option value='+ current['id'] + '>' + current['name'] + '</option>' ;
                }
                resultPlace.innerHTML = resultString;
            },
            failure: function (errMsg) {
                alert(errMsg);
            }
        });

        $.ajax({
            type: "GET",
            url: "/orgs",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (response) {
                let resultPlace = document.getElementById('orgs');
                let resultString = '';
                for (let i = 0; i < response.length; i++) {
                    let current = response[i];
                    resultString += '<option value='+ current['id'] + '>' + current['name'] + '</option>' ;
                }
                resultPlace.innerHTML = resultString;
            },
            failure: function (errMsg) {
                alert(errMsg);
            }
        });

    }
</script>
<body onload="getPosts()">
<div >
    <#--<form method="post">-->
    <#--<input type="text" name="name" placeholder="Название">-->
    <#--<input type="text" name="price" placeholder="Стоимость">-->
    <#--<input type="submit" value="Добавить продукт">-->
    <#--</form>-->

    <input type="text" id="lastName" placeholder="Фамилия">
    <input type="text" id="firstName" placeholder="Имя">
    <select id="orgs" name="Организация"></select>
    <select id="post" name="Должность" ></select>
    <input type="text" id="email" placeholder="e-mail">
    <input type="text" id="login" placeholder="Логин">
    <input type="text" id="password" placeholder="Пароль">
    <button onclick="addUser(document.getElementById('name').value, document.getElementById('price').value)">Добавить
        продукт
    </button>
</div>
<div>
    <table>
        <tr>
            <th>Имя</th>
            <th>Фамилия</th>
            <th>Организация</th>
            <th>Должность</th>
            <th>e-mail</th>
            <th>Логин</th>
            <th>Роль</th>
        </tr>
        <#list users as user>
            <tr>
                <td>${user.userProfile.firstName}</td>
                <td>${user.userProfile.lastName}</td>
                <td>${user.organization.name}</td>
                <td>${user.userProfile.postId.name}</td>
                <td>${user.userProfile.email}</td>
                <td>${user.login}</td>
                <td>${user.role}</td>
            </tr>
        </#list>
    </table>
</div>

</body>
</html>