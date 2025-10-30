/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var map = function(arr, fn) {
    let res=[];
    for(let i=0;i<arr.length;i++){
        res.push(fn(arr[i],i));
    }
    return res;
};

// var map = function(arr, fn) {
//    return arr.map(fn);
// };

// var map = function(arr, fn) {
//     let ans = [];
//     arr.forEach((x,i) => {
//         ans.push(fn(x,i));
//     });
//     return ans;
//     }