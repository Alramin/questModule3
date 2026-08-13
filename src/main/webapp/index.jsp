<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Quest Module3 Game</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">


    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>



<body>
<!-- 1. Название QUEST GAME сверху -->
<jsp:include page="header.jsp"></jsp:include>

<!-- Главный контейнер -->
<div class="container margin-top-large mt-5">
    <div class="row align-items-center justify-content-center">

        <!-- 2. Текстовый блок с новым цветом шрифта -->
        <div class="col-lg-7 col-md-12 mb-4">
            <!-- Заголовок теперь неоново-бирюзовый (cyan) -->
            <h1 class="fw-bolder text-info text-uppercase tracking-wide" style="text-shadow: 0 0 10px rgba(13, 202, 240, 0.4);">НАЧАЛО</h1>

            <!-- Главная фраза — ярко-белая -->
            <h3 class="fw-bolder fs-4 text-light mt-3">Будь у тебя мозги, хрен бы ты сюда попал, но обратной дороги нет, придется пробираться через калоотстойники.
            Вернуться домой с планеты Плюк мало кому удавалось, впрочем выбор твой не велик, одно не верное движение и геймовер.
            </h3>


            <!-- Разделительная полоса теперь тоже бирюзовая вместо синей -->
            <div class="bg-info p-1 mt-4 rounded-3" style="max-width: 200px; opacity: 0.7;"></div>
        </div>

        <!-- 3. Карточка с формой -->
        <div class="col-lg-4 col-md-8">
            <div class="card p-4 shadow bg-dark text-light border-secondary">
                <form action="gameServlet" method="post">

                    <!-- Поле ввода имени -->
                    <div class="mb-4">
                        <label class="form-label text-muted">Регистрация выжившего</label>
                        <input type="text" name="firstName" class="form-control form-control-lg bg-secondary text-white border-0" placeholder="Введите ваше имя" required>
                    </div>

                    <!-- Кнопка "Начать игру" (сменили на бирюзовый цвет btn-info) -->
                    <div class="d-grid">
                        <button class="btn btn-info btn-lg fw-bold text-uppercase text-dark" type="submit">Начать игру</button>
                    </div>

                </form>
            </div>
        </div>

    </div>
</div>

<script src="https://jsdelivr.net"></script>
</body>
</html>
