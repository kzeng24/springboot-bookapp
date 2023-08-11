function viewInfo(row) {
  const bookId = row.getAttribute("book-id");
  document.location.href = "/books/" + bookId;
}
function changeLanguage(value) {
  const rootUrl = window.location.href.toString().split("?lang=");
  document.location.href = rootUrl[0] + '?lang=' + value;
}
