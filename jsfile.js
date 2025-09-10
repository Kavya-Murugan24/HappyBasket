document.addEventListener("DOMContentLoaded", function() {
    const hamburger = document.querySelector('.hamburger');
    const navRight = document.querySelector('.nav-right');

    if (hamburger && navRight) {
        hamburger.addEventListener('click', () => {
            navRight.classList.toggle('active');  // shows/hides nav on mobile
        });
    }
});
