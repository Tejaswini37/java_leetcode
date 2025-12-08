/**
 * @param {Function} fn
 * @return {Function}
 */
function memoize(fn) {
    const cache=new Map();
    let callCount=0;
    return function(...args) {
        const key=JSON.stringify(args);
        if(cache.has(key)) return cache.get(key);
        callCount++;
        const res=fn(...args);
        cache.set(key,res);
        return res;
    }
}
// JSON.stringify(args) is used to differentiate calls with distinct argument tuples.

// Examples:

// memoSum(2,2) → key "[2,2]"

/** 
 * let callCount = 0;
 * const memoizedFn = memoize(function (a, b) {
 *	 callCount += 1;
 *   return a + b;
 * })
 * memoizedFn(2, 3) // 5
 * memoizedFn(2, 3) // 5
 * console.log(callCount) // 1 
 */

 /**
 * @param {Function} fn
 */
// function memoize(fn) {
    
//    const cache = {};
  
//    return function(...args) {
//     const key = JSON.stringify(args);
    
//     if (key in cache) {
//       return cache[key];
//     }
    
//     const result = fn.apply(this, args);
//     cache[key] = result;
    
//     return result;
//   }
  
// }


// const memoizedSum = memoize(function(a, b) {
//   return a + b;
// });

// console.log(memoizedSum(2, 3)); // Output: Computing sum, 5
// console.log(memoizedSum(2, 3)); // Output: 5