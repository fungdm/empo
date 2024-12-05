document.getElementById("add-btn").addEventListener("click", addEmployee);

function addEmployee() {
    const firstName = document.getElementById("first-name").value;
    const lastName = document.getElementById("last-name").value;
    const phone = document.getElementById("phone").value;
    const email = document.getElementById("email").value;
    const department = document.getElementById("department").value;
    const salary = document.getElementById("salary").value;

    const newEmployee = {
        firstName,
        lastName,
        phone,
        email,
        department,
        salary
    };

    fetch("http://localhost:8080/api/employees", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(newEmployee)
    })
    .then(response => response.json())
    .then(data => {
        alert("Employee added successfully!");
        loadEmployees();  // Reload employees list
    })
    .catch(error => console.error("Error adding employee:", error));
}

// Load all employees
function loadEmployees() {
    fetch("http://localhost:8080/api/employees")
        .then(response => response.json())
        .then(data => {
            const employeeTableBody = document.getElementById("employee-table-body");
            employeeTableBody.innerHTML = ""; // Clear current data

            data.forEach(employee => {
                const row = document.createElement("tr");
                row.innerHTML = `
                    <td>${employee.id}</td>
                    <td>${employee.firstName}</td>
                    <td>${employee.lastName}</td>
                    <td>${employee.phone}</td>
                    <td>${employee.email}</td>
                    <td>${employee.department}</td>
                    <td>${employee.salary}</td>
                    <td>
                        <button onclick="deleteEmployee('${employee.id}')">Delete</button>
                    </td>
                `;
                employeeTableBody.appendChild(row);
            });
        });
}

// Delete employee
function deleteEmployee(id) {
    fetch(`http://localhost:8080/api/employees/${id}`, {
        method: "DELETE"
    })
    .then(() => {
        alert("Employee deleted successfully!");
        loadEmployees();  // Reload employees list
    })
    .catch(error => console.error(  "Error deleting employee:", error));
}

// Initial load
loadEmployees();
