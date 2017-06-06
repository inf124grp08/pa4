document.addEventListener("DOMContentLoaded", function(event) {
  //do work
  console.log('ready');

  var images = document.getElementsByClassName('product-image');

  Array.from(images).forEach(img => {
    let originalHeight;

    img.addEventListener('mouseenter', ()=>{
      originalHeight = window.getComputedStyle(img).height;
      img.style.height = `${parseInt(originalHeight)*1.2}px`;
    });

    img.addEventListener('mouseout', ()=>{
      img.style.height = originalHeight;
    });
  });
});
