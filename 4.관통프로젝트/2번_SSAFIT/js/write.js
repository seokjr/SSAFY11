document.getElementById("writebutton").addEventListener("click", function () {
  var myModal = new bootstrap.Modal(document.getElementById("reviewModal"));
  myModal.show();
});

document.getElementById("table-detail").addEventListener("click", function () {
  var detailModal = new bootstrap.Modal(document.getElementById("detailModal"));
  detailModal.show();
});

document.getElementById("rewrite").addEventListener("click", function () {
  var detailModal = new bootstrap.Modal(
    document.getElementById("rewriteModal")
  );
  detailModal.show();
});
