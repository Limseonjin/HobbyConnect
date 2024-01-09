// 메인 사진 줌 js
function zoomIn(event) {
    event.target.style.transform = "scale(1.2)";
    event.target.style.zIndex = 1;
    event.target.style.transform = "all 0.5";
}
function zoomOut(event) {
   event.target.style.transform = "scale(1)";
   event.target.style.zIndex = 0;
   event.target.style.transform = "all 0.5";
}