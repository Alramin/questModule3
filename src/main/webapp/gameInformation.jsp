<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<footer class="fixed-bottom margin-top-large " >

    <div class="card" style="width: 18rem;">
        <div class="card-body fw-bolder">
            <p class="fs-6">
                Ваше имя = ${sessionScope.userName}
            </p>
            <p class="fs-6">
                Игр всего = ${sessionScope.userId}
            </p>

            <p class="fs-6">
                Количестро побед = ${sessionScope.winCounter}
            </p>
            <p class="fs-6">
                Количество поражений = ${sessionScope.loseCounter}
            </p>
        </div>
    </div>
    </div>

</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>