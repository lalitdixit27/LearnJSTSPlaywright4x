//Mutiline
const getResult = (score) => {
    if(score > 70) return "Pass";
    return "fail";
}


console.log(getResult(78));
console.log(getResult(43));

const printNames = () => {
    console.log("Hi Lalit");
    console.log("Hi Sumit");
    console.log("Hi Amit");
    return "printed";
};

console.log(printNames());
