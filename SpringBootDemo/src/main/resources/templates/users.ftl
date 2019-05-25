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
    function addUser(lastName, firstName, patronymic, orgs, post, email, login, password) {
        let json = {"userProfile":{
                "lastName": lastName, "firstName": firstName, "patronymic": patronymic
                , "post": {
                    "id": document.getElementById("post").options[document.getElementById("post").selectedIndex].value
                }
                , "email": email
            },
            "organization":{
             "id": document.getElementById("orgs").options[document.getElementById("orgs").selectedIndex].value
            }, "login": login, "password": password
        };

        $.ajax(
            {
                type: "POST",
                url: "users/add",
                data: JSON.stringify(json),
                contentType: "application/json; charset: utf-8",
                dataType: "json",
                success: function(response){
                    let resultPlace = document.getElementById("user_table");
                    let result = '<table>';
                    result += '<tr>'+
                        '<th>Фамилия</th>' +
                        '<th>Имя</th>' +
                        '<th>Отчество</th>' +
                        '<th>Организация</th>' +
                        '<th>Должность</th>' +
                        '<th>e-mail</th>' +
                        '<th>Логин</th>' +
                        '<th>Роль</th>' +
                        '</tr>';
                    for (let i = 0; i < response.length; i++) {
                        let current = response[i];

                        result += '<tr>';
                        result += '<td>' + current['userProfile']['lastName'] + '</td>'+

                        '<td>' + current['userProfile']['firstName'] + '</td>'+
                        '<td>' + current['userProfile']['patronymic']+ '</td>'+
                        '<td>' + current['organization']['name'] + '</td>'+
                        '<td>' + current['userProfile']['post']['name'] + '</td>'+
                        '<td>' + current['userProfile']['email'] + '</td>'+
                        '<td>' + current['login'] + '</td>'+
                        '<td>' + current['role'] + '</td>';

                        result += '</tr>';
                    }
                    result += '</table>';
                    resultPlace.innerHTML = result;
                },
                failure: function (errMsg) {
                            alert(errMsg);
                }
            }
    );
    }

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
                    resultString += '<option value='+current['id']+'>' + current['name'] + '</option>';
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
                    resultString += '<option value='+current['id']+'>' + current['name'] + '</option>';
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
<div>
    <#--<form method="post">-->
    <#--<input type="text" name="name" placeholder="Название">-->
    <#--<input type="text" name="price" placeholder="Стоимость">-->
    <#--<input type="submit" value="Добавить продукт">-->
    <#--</form>-->

    <input type="text" id="lastName" placeholder="Фамилия">
    <input type="text" id="firstName" placeholder="Имя">
    <input type="text" id="patronymic" placeholder="Отчество">
    <select id="orgs" name="Организация"></select>
    <select id="post" name="Должность"></select>
    <input type="text" id="email" placeholder="e-mail">
    <input type="text" id="login" placeholder="Логин">
    <input type="password" id="password" placeholder="Пароль">
    <button onclick="addUser(document.getElementById('lastName').value
                      , document.getElementById('firstName').value
                      , document.getElementById('patronymic').value
                      , document.getElementById('orgs').value
                      , document.getElementById('post').options[document.getElementById('post').selectedIndex].value
                      ,document.getElementById('email').value
                      , document.getElementById('login').value
                      , document.getElementById('password').value)">Добавить
        пользователя
    </button>
</div>
<div id="user_table">
    <table>
        <tr>
            <th>Фамилия</th>
            <th>Имя</th>
            <th>Отчество</th>
            <th>Организация</th>
            <th>Должность</th>
            <th>e-mail</th>
            <th>Логин</th>
            <th>Роль</th>
        </tr>
        <#list users as user>
            <tr>
                <td>${user.userProfile.lastName!""}</td>
                <td>${user.userProfile.firstName!""}</td>
                <td>${user.userProfile.patronymic!""}</td>
                <td>${user.organization.name!""}</td>
                <td>${user.userProfile.post.name!""}</td>
                <td>${user.userProfile.email!""}</td>
                <td>${user.login}</td>
                <td>${user.role}</td>
            </tr>
        </#list>
    </table>
</div>

</body>
</html>