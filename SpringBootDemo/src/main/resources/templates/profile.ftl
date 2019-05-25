<!doctype html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Профиль</title>
</head>
<body>
Логин: ${user.login} </br>
Фамилия: ${user.userProfile.lastName!""} </br>
Имя: ${user.userProfile.firstName!""} </br>
Отчество: ${user.patronymic!""} </br>
Должность: ${user.userProfile.post.name!""} </br>
Организация: ${user.organization.name!""} </br>
</body>
</html>