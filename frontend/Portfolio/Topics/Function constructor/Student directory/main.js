function Student(name, surname, age) {
    this.name = name;
    this.surname = surname;
    this.age = age;
    
    // write your function here
    this.getStudent = () => {
        console.log("Student name: " + name + ", student surname: " + surname + ", student age: " + age);
    }
}

const student = new Student("Alex", "Brown", 28);