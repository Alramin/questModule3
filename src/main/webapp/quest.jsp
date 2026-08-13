<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Quest Game</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script src="<c:url value='https://code.jquery.com/jquery-3.6.0.min.js'/>"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body, html {
            height: 100%;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
        }
        .section {
            display: flex;
            justify-content: center;
            align-items: center;
            text-align: center;
        }
        .margin-top-large {
            margin-top: 100px; /* Adjust this value as needed */
        }
        .btn-lg {
            width: 400px; /* Adjust the width as needed */
        }


        .btn-lg:last-child {
            margin-bottom: 0; /* Remove bottom margin for the last button */
        }

        .blinking-text {
            animation: blink 1s infinite;
        }
    </style>
</head>
<body class="quest">
<jsp:include page="header.jsp"></jsp:include>

<section class="section margin-top-large">
    <div>
        <h1>${question.getText()}</h1>
        <br>
    </div>
</section>

<section class="section">
    <div class="container">
        <c:if test="${question != null}">
            <div>
                <c:forEach var="i" begin="0" end="${endIndex}">
                    <div class="mb-2">
                        <button class="btn btn-info btn-lg fw-bold text-dark text-uppercase w-100 my-2"
                                onclick="window.location='/gameServlet?answerId=${i}'">
                            <c:out value="${question.getAnswerList().get(i).getText()}"/>
                        </button>


                    </div>
                </c:forEach>
            </div>
        </c:if>
    </div>
</section>

<section class="section">
    <div class="container btn-lg">
        <c:if test="${question == null}">
            <c:if test="${wrongAnswer != null}">
                <h1>${wrongAnswer.getWrongAnswerEndText()}</h1>
            </c:if>
            <c:if test="${wrongAnswer == null}">
                <h1>Тебя вернули домой. Победа!</h1>
            </c:if>
            <button onclick="window.location='/restart'" class="btn btn-info btn-lg fw-bold text-dark text-uppercase w-100 my-2">Начать заново</button>
        </c:if>
    </div>
</section>
<jsp:include page="gameInformation.jsp"></jsp:include>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
