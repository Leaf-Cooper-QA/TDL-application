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

    let getallpara = document.querySelector("#getallpara");
    let postpara=document.querySelector("#postpara");
    let putpara=document.querySelector("#putpara");
    let deletepara = document.querySelector("#deletepara");

    let getalltable = document.querySelector("#getalltable");
    let posttable = document.querySelector("#posttable");
    let puttable = document.querySelector("#puttable")

    /* make use of the delete skeleton and also js file from the Fetch API task*/
    /* URL is local host stuff defined by java controller */

    let myGetAll = function() {
        fetch(`http://localhost:8080/getall`, {
            method: `get`})
            .then(res => res.json())
            .then(data =>{

                getalltable.innerHTML=``;

                let tablehead = document.createElement("tr");

                let idhead = document.createElement("th");
                idhead.textContent=`Id`;
                tablehead.append(idhead);

                let namehead = document.createElement("th");
                namehead.textContent=`Name`;
                tablehead.append(namehead);

                let deschead = document.createElement("th");
                deschead.textContent=`Description`;
                tablehead.append(deschead);

                let timehead = document.createElement("th");
                timehead.textContent=`Time estimate`;
                tablehead.append(timehead);

                getalltable.append(tablehead);

                for (const element of data) {
                    let tablerow = document.createElement("tr");

                    let iddata = document.createElement("td");
                    iddata.textContent=element.id;
                    tablerow.append(iddata);
        
                    let namedata = document.createElement("td");
                    namedata.textContent=element.name;
                    tablerow.append(namedata);
        
                    let descdata = document.createElement("td");
                    descdata.textContent=element.description;
                    tablerow.append(descdata);
        
                    let timedata = document.createElement("td");
                    timedata.textContent=element.time;
                    tablerow.append(timedata);

                    getalltable.append(tablerow);

                }


                console.log(data)
                getallpara.innerHTML(`data retrieved`);
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
        .then(res => res.json())
        .then((data) => {
            posttable.innerHTML=``;
            /*fill data into table*/
            let tablehead = document.createElement("tr");

            let idhead = document.createElement("th");
            idhead.textContent=`Id`;
            tablehead.append(idhead);

            let namehead = document.createElement("th");
            namehead.textContent=`Name`;
            tablehead.append(namehead);

            let deschead = document.createElement("th");
            deschead.textContent=`Description`;
            tablehead.append(deschead);

            let timehead = document.createElement("th");
            timehead.textContent=`Time estimate`;
            tablehead.append(timehead);

            let tablerow = document.createElement("tr");

            let iddata = document.createElement("td");
            iddata.textContent=data.id;
            tablerow.append(iddata);

            let namedata = document.createElement("td");
            namedata.textContent=data.name;
            tablerow.append(namedata);

            let descdata = document.createElement("td");
            descdata.textContent=data.description;
            tablerow.append(descdata);

            let timedata = document.createElement("td");
            timedata.textContent=data.time;
            tablerow.append(timedata);

            posttable.append(tablehead);
            posttable.append(tablerow);

            console.log(data)
            postpara.innerHTML=`data sent`;
        })
        .catch(err => console.log(`something went wrong with error message: ${err}`)) 

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
        .then(res => res.json())
        .then((data) =>{
            /*fill data into table*/
            puttable.innerHTML=``;
            /*fill data into table*/
            let tablehead = document.createElement("tr");

            let idhead = document.createElement("th");
            idhead.textContent=`Id`;
            tablehead.append(idhead);

            let namehead = document.createElement("th");
            namehead.textContent=`Name`;
            tablehead.append(namehead);

            let deschead = document.createElement("th");
            deschead.textContent=`Description`;
            tablehead.append(deschead);

            let timehead = document.createElement("th");
            timehead.textContent=`Time estimate`;
            tablehead.append(timehead);

            let tablerow = document.createElement("tr");

            let iddata = document.createElement("td");
            iddata.textContent=data.id;
            tablerow.append(iddata);

            let namedata = document.createElement("td");
            namedata.textContent=data.name;
            tablerow.append(namedata);

            let descdata = document.createElement("td");
            descdata.textContent=data.description;
            tablerow.append(descdata);

            let timedata = document.createElement("td");
            timedata.textContent=data.time;
            tablerow.append(timedata);

            puttable.append(tablehead);
            puttable.append(tablerow);
            console.log(data);
            putpara.innerHTML=`data updated`;
        })
        .catch(err => console.log(`something went wrong with error message: ${err}`)) 

    }
    putbtn.addEventListener("click",() => myPut(), false);

    let myDelete = function() {
        
        fetch(`http://localhost:8080/delete`, {
            method: `delete`,
            headers: {"Content-type": "application/json; charset=UTF-8"},  
            body:JSON.stringify(deleteid.value)  
        })
        .then(res => res.json())
        .then((data) =>{
            /*deletes automatically, return data to the table*/
            console.log(data)
            deletepara.innerHTML = `data with id: ${data} deleted`;
            
            /*in other situations, might need data.value instead of just data*/
            /*other outputs need to be in tables, hopefully can just do e.g. innerHTML = postTable */
            
        })
        .catch(err => console.log(`something went wrong with error message: ${err}`)) 

    }
    deletebtn.addEventListener("click",() => myDelete(), false);

})();