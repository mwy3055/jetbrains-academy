const taskList = document.getElementById("task-list");

document.getElementById("add-task-button").addEventListener("click", function () {
    const inputTask = document.getElementById("input-task");
    const input = inputTask.value;
    if (input !== "") {
        const task = document.createElement("li");
        
        const label = document.createElement("label");
        label.className = "task-checkbox-label";
        const checkBox = document.createElement("input");
        checkBox.type = "checkbox";
        checkBox.addEventListener("change", () => {
            onCheckBoxChange(checkBox);
        });
        label.appendChild(checkBox);
        task.appendChild(label);
        
        const span = document.createElement("span");
        span.className = "task";
        span.innerHTML = input;
        task.appendChild(span);
        
        const deleteButton = document.createElement("button");
        deleteButton.classList.add("delete-btn");
        deleteButton.addEventListener("click", () => {
            onDeleteButtonClick(deleteButton);
        });
        const i = document.createElement("i");
        i.classList.add("fa", "fa-close");
        i.innerHTML = "Delete";
        deleteButton.appendChild(i);
        task.appendChild(deleteButton);
        
        taskList.appendChild(task);
    }
    inputTask.value = "";
});

const deleteButtons = taskList.getElementsByClassName("delete-btn");
for (const button in deleteButtons) {
    const deleteButton = deleteButtons[parseInt(button)];
    if (deleteButton !== undefined) {
        deleteButton.addEventListener("click", () => {
            onDeleteButtonClick(deleteButton);
        });
    }
}

let checkBoxLabels = document.getElementsByClassName("task-checkbox-label");
for (let i = 0; i < checkBoxLabels.length; i++) {
    const label = checkBoxLabels[i];
    const checkBox = label.getElementsByTagName("checkbox")[0];
    if (checkBox !== undefined) {
        checkBox.addEventListener("change", () => {
            onCheckBoxChange(checkBox);
        })
    }
}

function onDeleteButtonClick(deleteButton) {
    deleteButton.parentNode.remove();
}

function onCheckBoxChange(checkBox) {
    const label = checkBox.parentElement;
    const task = label.parentElement.getElementsByClassName("task")[0];
    task.classList.toggle("task-done");
}