const form = document.getElementById("user-form");

form.addEventListener("submit", async (e) => {
    e.preventDefault();
    const formData = new FormData(form);
    const user = {};
    formData.forEach((value, key) => (user[key] = value));

    await fetch("http://localhost:8080/users", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(user),
    });

    form.reset();
    loadUsers();
});

async function loadUsers() {
    const res = await fetch("http://localhost:8080/users");
    const users = await res.json();

    const userList = document.getElementById("user-list");
    userList.innerHTML = users
        .map((user) => `<div>${user.name} - ${user.email}</div>`)
        .join("");
}

loadUsers();
