$(function () {
    $("#nav-placeholder").load("nav.html");
});

window.onload = (event) => {
    document.getElementById("page-name").innerHTML = document.title;
};