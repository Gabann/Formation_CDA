// let current = 1;
// let target = 10000 * 400;
// let count = 0;
//
// while (current <= target){
// 	current *= 2;
// 	count++;
// }

let current = 4000000;
let target = 1;
let count = 0;

while (current >= target) {
	current /= 2;
	count++;
}

console.log(count);