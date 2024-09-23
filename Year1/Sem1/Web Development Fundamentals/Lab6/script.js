function myFunction() {
    var x = document.getElementById("main-menu");
    if (x.className === "topnav") {
        x.className += " responsive";
    } else {
        x.className = "topnav";
    }
}
