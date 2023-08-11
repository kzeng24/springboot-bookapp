function viewInfo(row) {
  const bookId = row.getAttribute("book-id");
  document.location.href = "/spring-mvc-webapp-1/books/" + bookId;
}
