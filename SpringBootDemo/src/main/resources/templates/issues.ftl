<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Задачи</title>
</head>
<body>
<table>
    <tr>
        <th>Номер</th>
        <th>Заголовок</th>
        <th>Статус</th>
    </tr>
    <#list issues as issue>
        <tr>
            <td>${issue.id!""}</td>
            <td>${issue.subject!""}</td>
            <td>${issue.statusName!""}</td>
        </tr>
    </#list>
</table>
</body>
</html>