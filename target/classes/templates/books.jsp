<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Books List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="starter-template">
        <h1>Book Listing</h1>
        <table class="table table-striped table-hover table-condensed table-bordered">
            <tr>
                <th>Category Name</th>
                <th>ISBN</th>
                <th>Title</th>
                <th>Publisher</th>
                <th>Price</th>

            </tr>
            <tr th:each="book : ${books}">
                <td th:text="${book.category_name}"></td>
                <td th:text="${book.isbn}"></td>
                <td th:text="${book.title}"></td>
                <td th:text="${book.publisher}"></td>
                <td th:text="${book.price}"></td>
            </tr>
        </table>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
</body>
</html>
