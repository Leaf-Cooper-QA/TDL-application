(function(){
    let getallbtn = document.querySelector("#getallbtn");
    let getonebtn = document.querySelector("#getonebtn");
    let postbtn = document.querySelector("#postbtn");
    let putbtn = document.querySelector("#putbtn");
    let deletebtn = document.querySelector("#deletebtn");

    let getid = document.querySelector("#getoneid");
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

    }
    getallbtn.addEventListener("click",() => myGetAll(), false);

    let myGetOne = function() {

    }
    getonebtn.addEventListener("click",() => myGetOne(), false);

    let myPost = function() {

    }
    postbtn.addEventListener("click",() => myPost(), false);

    let myPut = function() {

    }
    putbtn.addEventListener("click",() => myPut(), false);

    let myDelete = function() {
        
        fetch(`https://dummywebsite.com/data/${deleteid.value}`, {
            method: `delete`})
            .then((data) =>{
                 /*deletes automatically, return data to the table*/
                deletepara.append(document.createTextNode(`data with id: ${deleteid.value} deleted`));
            })
            .catch(err => console.log(`something went wrong with error message: ${err}`)) 

    }
    deletebtn.addEventListener("click",() => myDelete(), false);

})();