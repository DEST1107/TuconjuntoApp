const navButtons = document.querySelectorAll(".nav-btn");
const sections = document.querySelectorAll(".app-section");
const jumpButtons = document.querySelectorAll("[data-jump]");
const dayButtons = document.querySelectorAll(".day-btn");
const scheduleCards = document.querySelectorAll(".schedule-card");
const reservaForm = document.getElementById("reserva-form");
const toast = document.getElementById("toast");

function activateSection(sectionId) {
    navButtons.forEach((button) => {
        button.classList.toggle("active", button.dataset.section === sectionId);
    });

    sections.forEach((section) => {
        const isTarget = section.id === sectionId;
        section.classList.toggle("visible", isTarget);
        section.classList.toggle("hidden", !isTarget);
    });

    window.scrollTo({ top: 0, behavior: "smooth" });
}

function showToast(message) {
    toast.textContent = message;
    toast.hidden = false;

    clearTimeout(showToast.timeoutId);
    showToast.timeoutId = setTimeout(() => {
        toast.hidden = true;
    }, 2600);
}

navButtons.forEach((button) => {
    button.addEventListener("click", () => {
        const target = button.dataset.section;
        if (target) {
            activateSection(target);
        }
    });
});

jumpButtons.forEach((button) => {
    button.addEventListener("click", () => {
        const target = button.dataset.jump;
        activateSection(target);
    });
});

dayButtons.forEach((button) => {
    button.addEventListener("click", () => {
        const selectedDay = button.dataset.day;

        dayButtons.forEach((dayButton) => {
            dayButton.classList.toggle("active", dayButton.dataset.day === selectedDay);
        });

        scheduleCards.forEach((card) => {
            const isVisible = card.dataset.day === selectedDay;
            card.classList.toggle("hidden-card", !isVisible);
        });
    });
});

if (reservaForm) {
    reservaForm.addEventListener("submit", (event) => {
        event.preventDefault();
        showToast("Solicitud enviada. Administracion revisara tu reserva.");
        reservaForm.reset();
    });
}
