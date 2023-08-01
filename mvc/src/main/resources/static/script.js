const addBtn = document.querySelector(".add-btn");
const addContainer = document.querySelector(".add-form-container");
const addForm = document.querySelector(".add-form");
const editButtons = document.querySelectorAll(".edit-btn");
const forms = document.querySelectorAll(".edit-form");
editButtons.forEach((button) => {
    button.addEventListener("click", () => {
        const formRow = button.parentElement.nextElementSibling;
        formRow.classList.remove("hidden");
    });
});


forms.forEach((form) => {
    form.addEventListener("submit", (e) => {
        const formRow = form.parentElement;
        formRow.classList.add("hidden");
    });
});

addBtn.addEventListener("click", (e) => {
    addContainer.classList.remove("hidden");
})
addForm.addEventListener("submit", (e) => {
    addContainer.classList.add("hidden");
})