(function(){
    let getallbtn = document.querySelector("#getallbtn");
    /*let getonebtn = document.querySelector("#getonebtn");*/
    let postbtn = document.querySelector("#postbtn");
    let putbtn = document.querySelector("#putbtn");
    let deletebtn = document.querySelector("#deletebtn");

    /*let getid = document.querySelector("#getoneid");*/
    let post1 = document.querySelector("#post1");
    let post2 = document.querySelector("#post2");
    let post3 = document.querySelector("#post3");
    let putid = document.querySelector("#putid");
    let put1 = document.querySelector("#put1");
    let put2 = document.querySelector("#put2");
    let put3 = document.querySelector("#put3");
    let deleteid = document.querySelector("#deleteid");

    let deletepara = document.querySelector("#deletepara")

    /* make use of the delete skeleton and also js file from the Fetch API task*/
    /* URL is local host stuff defined by java controller */

    let myGetAll = function() {
        fetch(`http://localhost:8080/getall`, {
            method: `get`})
            .then((data) =>{
                /*fill data into table*/
            })
            .catch(err => console.log(`something went wrong with error message: ${err}`)) 

    }
    getallbtn.addEventListener("click",() => myGetAll(), false);

/*
    let myGetOne = function() {
        fetch(`http://localhost:8080/getone/${getid}`, {
            method:`get`})
            .then((data) =>{
                
            })
            .catch(err => console.log(`something went wrong with error message: ${err}`)) 

    }
    getonebtn.addEventListener("click",() => myGetOne(), false);
*/
    let myPost = function() {
        fetch(`http://localhost:8080/post`, {
            method:`post`,
            headers: {"Content-type": "application/json; charset=UTF-8"}, 
            body: JSON.stringify({
                name: post1.value,
                description: post2.value,
                time: post3.value
            })
        })
        .then((data) => {
            /*fill data into table*/
        })

    }
    postbtn.addEventListener("click",() => myPost(), false);

    let myPut = function() {
        fetch(`http://localhost:8080/put`, {
            method: `put`,
            headers: {"Content-type": "application/json; charset=UTF-8"}, 
            body: JSON.stringify({
                id: putid.value,
                name: put1.value,
                description: put2.value,
                time: put3.value
            })
        })

    }
    putbtn.addEventListener("click",() => myPut(), false);

    let myDelete = function() {
        
        /*this is the correct sorta thing for the url but details might be wrong*/
        fetch(`http://localhost:8080/delete`, {
            method: `delete`,
            headers: {"Content-type": "application/json; charset=UTF-8"},  
            body:JSON.stringify(deleteid.value)  
        })
            .then((data) =>{
                 /*deletes automatically, return data to the table*/
                deletepara.append(document.createTextNode(`data with id: ${deleteid.value} deleted`));
            })
            .catch(err => console.log(`something went wrong with error message: ${err}`)) 

    }
    deletebtn.addEventListener("click",() => myDelete(), false);

})();