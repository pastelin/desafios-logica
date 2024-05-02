function Employee(title) {
    this.title = title;
}

// 
Employee.prototype.setTitle = function (title) {
    this.title = title;
};

Employee.prototype.getTitle = function () {
    return this.title;
};

function Engineer(title, isManager) {
    Employee.call(this, title);
    this.isManager = isManager;
}

Engineer.prototype = Object.create(Employee.prototype);
Engineer.prototype.constructor = Engineer;

Engineer.prototype.setIsManager = function (isManager) {
    this.isManager = isManager;
};

Engineer.prototype.getIsManager = function () {
    return this.isManager;
};



let a = new Engineer('Developer', false);
a.setTitle('Developer4');
a.setIsManager(true);

console.log(a.getTitle()); // Developer4
console.log(a.getIsManager()); // true
