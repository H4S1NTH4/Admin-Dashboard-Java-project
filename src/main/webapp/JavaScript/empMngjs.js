

    document.addEventListener("DOMContentLoaded", function() {
        const closeModalButtons = document.querySelectorAll(".close-modal");
        closeModalButtons.forEach(button => {
            button.addEventListener("click", function() {
                const modalBackdrop = button.closest(".modal-backdrop");
                modalBackdrop.style.display = "none";
                window.location.href = "AllAdminServlet";
            });
        });
    });
