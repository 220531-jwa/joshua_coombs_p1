let baseUrl = "http://localhost:8090";
//Employee functionality
async function employeeLogin() {
    let uName = document.getElementById('uName').value;
    let pWord = document.getElementById('pWord').value;
    let employee = {
        username: uName,
        password: pWord
    }
    let eJson = JSON.stringify(employee);
    let desuetude = await fetch(
        `${baseUrl}/login`,
        {
            method: 'POST',
            header: {'Content-Type': 'application/json'},
            body: eJson
        }
    );
    let desuetudeJson = await desuetude.json().then((desuetudinal) => {
            sessionStorage.setItem("employee", JSON.stringify(desuetudinal));
            window.location.assign("employeePortal.html");
        }).catch((error) => {
                console.log(error);
                alert("Login Unsuccessful")
            });
}

async function logoutEmployee() {
    sessionStorage.removeItem("employee");
    window.location.assign("loginPage.html");
}

async function financeManagerLogin() {
    let uName = document.getElementById('uName').value;
    let pWord = document.getElementById('pWord').value;
    let financeManager = {
        username: uName,
        password: pWord
    }
    let fmJson = JSON.stringify(financeManager);
    let desuetude = await fetch(
        `${baseUrl}/login`,
        {
            method: 'POST',
            header: {'Content-Type': 'application/json'},
            body: fmJson
        }
    );
    let desuetudeJson = await desuetude.json().then((desuetudinal) => {
            sessionStorage.setItem("financeManager", JSON.stringify(desuetudinal));
            window.location.assign("financeManagerPortal.html");
        }).catch((error) => {
                console.log(error);
                alert("Login Unsuccessful")
            });
}

async function logoutFinanceManager() {
    sessionStorage.removeItem("financeManager");
    window.location.assign("loginPage.html");
}

async function submitRF() {
    //let rId = document.getElementById('rId').value;
    //let eId = document.getElementById('eId').value;
    let eventType = document.getElementById('eventType').value,
        gradeFormat = document.getElementById('gradeFormat').value,
        cost = document.getElementById('cost').value,
        datetime = document.getElementById('datetime').value,
        location = document.getElementById('location').value,
        desc = document.getElementById('description').value,
        just = document.getElementById('justification').value,
        status = "Pending",
        grade = " ";

    let employee = JSON.parse(sessionStorage.getItem("employee"));
    let rf = {
        eId: employee.eId,
        firstName: employee.fName,
        lastName: employee.lName,
        eventType: eventType,
        gradeFormat: gradeFormat,
        cost: cost,
        datetime: datetime,
        location: location,
        desc: desc,
        just: just,
        status: status,
        grade: grade,
        rAmount: rAmount
    }
    let rfJson = JSON.stringify(rf);

    let desuetude = await fetch(
        `${baseUrl}/login/employee/requests/newRequest`,
        {
            method: 'POST',
            header: {'Content-Type': 'application/json'},
            body: rfJson
        }
    );
    let desuetudeJson = await desuetude.json()  
        .then((desuetudinal) => {
            window.location.assign("reimbursementForm.html")
        }).catch((error) => {
            console.log(error);
            alert("Request unsuccessful");
        });
}

async function viewAllRequestsEmployee() {
    let desuetude = await fetch(
        `${baseUrl}/login/employee/requests`,
        {
            method: 'GET',
            header: {'Content-Type': 'application/json'}
        }
    );
    let desuetudeJson = await desuetude.json()  
        .then((desuetudinal) => {
            fillRFTableEmployee(desuetudinal, employee);
        }).catch((error) => {
            console.log(error);
            alert("Request unsuccessful");
        });
}

async function fillRFTableEmployee(desuetudinal, employee) {
    let eTable = document.getElementById("allRequests");

    for (d of desuetudinal) {
        let r = eTable.insertRow(-1);
        let col0 = r.insertCell(0);
        let col1 = r.insertCell(1);
        let col2 = r.insertCell(2);
        let col3 = r.insertCell(3);
        let col4 = r.insertCell(4);
        let col5 = r.insertCell(5);
        let col6 = r.insertCell(6);
        let col7 = r.insertCell(7);
        let col8 = r.insertCell(8);
        let col9 = r.insertCell(9);
        let col10 = r.insertCell(10);
        let col11 = r.insertCell(11);
        let col12 = r.insertCell(12);
        let col13 = r.insertCell(13);

        col0.innerHTML = employee.eId;
        col1.innerHTML = employee.rId;
        col2.innerHTML = employee.fName;
        col3.innerHTML = employee.lName;
        col4.innerHTML = d.datetime;
        col5.innerHTML = d.location;
        col6.innerHTML = d.desc;
        col7.innerHTML = d.cost;
        col8.innerHTML = d.gradeFormat;
        col9.innerHTML = d.eventType;
        col10.innerHTML = d.just;
        col11.innerHTML = d.rAmount;
        col12.innerHTML = d.status;
    }
}  

async function fillRFTableManager(desuetudinal) {
    let mTable = document.getElementById("allRequestsManager");

    for (d of desuetudinal) {
        let r = mTable.insertRow(-1);
        let col0 = r.insertCell(0);
        let col1 = r.insertCell(1);
        let col2 = r.insertCell(2);
        let col3 = r.insertCell(3);
        let col4 = r.insertCell(4);
        let col5 = r.insertCell(5);
        let col6 = r.insertCell(6);
        let col7 = r.insertCell(7);
        let col8 = r.insertCell(8);
        let col9 = r.insertCell(9);
        let col10 = r.insertCell(10);
        let col11 = r.insertCell(11);
        let col12 = r.insertCell(12);
        let col13 = r.insertCell(13);

        col0.innerHTML = d.eId;
        col1.innerHTML = d.rId;
        col2.innerHTML = d.fName;
        col3.innerHTML = d.lName;
        col4.innerHTML = d.fName;
        col5.innerHTML = d.datetime;
        col6.innerHTML = d.location;
        col7.innerHTML = d.desc;
        col8.innerHTML = d.cost;
        col9.innerHTML = d.gradeFormat;
        col10.innerHTML = d.eventType;
        col11.innerHTML = d.just;
        col12.innerHTML = d.rAmount;
        col13.innerHTML = d.status;
    }
}

async function viewAllRequestsManager(financeManager) {
    let desuetude = await fetch(
        `${baseUrl}/login/manager/requests`,
        {
            method: 'GET',
            header: {'Content-Type': 'application/json'}
        }
    );
    let desuetudeJson = await desuetude.json()  
        .then((desuetudinal) => {
            fillRFTableManager(desuetudinal, financeManager);
        }).catch((error) => {
            console.log(error);
            alert("Request unsuccessful");
        });
}

function cancelRequest() {
    let select = document.getElementById('selectId');
    let cancel = document.getElementById('cancelRequest');

    let selectedId = select.options[select.selectedIndex].value;
    let cancelled = cancel.value;
    let c = {
        rId: selectedId,
        cancelR: cancelled
    }

    let cString = JSON.stringify(c);
    let desuetude = await fetch(
        `${baseUrl}/login/employee/requests/cancel`,
        {
            method: 'PATCH',
            header: {'Content-Type': 'application/json'},
            body: cString
        }.then(() => {
            window.location.reload();
        }).catch((error) => {
            console.log(error)
        })
    );
}

async function changeGrade() {
    let select = document.getElementById('selectId');
    let grade = document.getElementById('changeGrade');

    let selectedId = select.options[select.selectedIndex].value;
    let changedGrade = grade.value;
    let g = {
        rId: selectedId,
        gradeC: changedGrade
    }

    let gradeString = JSON.stringify(g);
    let desuetude = await fetch(
        `${baseUrl}/login/employee/requests`,
        {
            method: 'PATCH',
            header: {'Cointent-Type': 'application/json'},
            body: gradeString
        }.then(() => {
            window.location.reload();
        }).catch((error) => {
            console.log(error)
        })
    );
}

async function changeStatus() {
    let select = document.getElementById('selectId');
    let status = document.getElementById('changeStatus');

    let selectedId = select.options[select.selectedIndex].value;
    let changedStatus = status.value;
    let s = {
        rId: selectedId,
        statusC: changedStatus
    }

    let sString = JSON.stringify(s);
    let desuetude = await fetch(
        `${baseUrl}/login/manager/requests`,
        {
            method: 'PATCH',
            header: {'Cointent-Type': 'application/json'},
            body: sString
        }.then(() => {
            window.location.reload();
        }).catch((error) => {
            console.log(error)
        })
    );
}