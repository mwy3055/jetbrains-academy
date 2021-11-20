const taskList = document.getElementById("task-list"); // HTML element (unordered list)
const parsed = JSON.parse(localStorage.getItem("tasks"));
let tasks = parsed || [];
let taskCount = tasks.length;

console.log("Loaded: " + tasks.length);

for (const taskIndex in tasks) {
    let taskName = tasks[parseInt(taskIndex)].task;
    console.log("Task: " + taskName);
    addTask(taskName);
}

document.getElementById("add-task-button").addEventListener("click", function () {
    const inputTask = document.getElementById("input-task");
    const input = inputTask.value;
    addTask(input);
    tasks.push(createTask(input));
    storeTasks(tasks);
    inputTask.value = "";
});

function addTask(taskName) {
    if (taskName !== "") {
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
        span.innerHTML = taskName;
        task.appendChild(span);
        
        const deleteButton = document.createElement("button");
        deleteButton.classList.add("delete-btn");
        deleteButton.addEventListener("click", () => {
            onDeleteButtonClick(deleteButton);
        });
        const i = document.createElement("i");
        i.classList.add("fa", "fa-close")
        deleteButton.appendChild(i);
        task.appendChild(deleteButton);
        
        taskList.appendChild(task);
    }
}

function onDeleteButtonClick(deleteButton) {
    const li = deleteButton.parentNode;
    const span = li.getElementsByClassName("task")[0];
    const taskName = span.innerHTML;
    const taskIndex = findTaskIndex(taskName);
    console.log("remove " + taskName + ", index " + taskIndex);
    if (taskIndex > -1) {
        tasks.splice(taskIndex, 1);
    }
    
    li.remove();
    storeTasks(tasks);
}

function onCheckBoxChange(checkBox) {
    const label = checkBox.parentElement;
    const taskElement = label.parentElement.getElementsByClassName("task")[0];
    taskElement.classList.toggle("task-done");
    
    const taskIndex = findTaskIndex(taskElement.value);
    console.log("Index: " + taskIndex);
    tasks[taskIndex].checked = !tasks[taskIndex].checked;
    storeTasks(tasks);
}

function createTask(taskName) {
    return {
        id: taskCount++,
        task: taskName,
        checked: false
    };
}

function storeTasks(tasks) {
    const json = JSON.stringify(tasks);
    console.log("Store: " + json);
    localStorage.setItem("tasks", json);
}

function findTaskIndex(taskName) {
    return tasks.findIndex((item) => {
        console.log("finding... current: " + item.task);
        return item.task === taskName;
    });
}