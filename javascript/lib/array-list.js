"use strict";

var FixedArray = require("./fixed-array"),
    IndexError = require("./index-error");
 // create an object prototype
function ArrayList() {
    this._array = new FixedArray(10);
    this._size = 0;
}

ArrayList.prototype.size = function() {
    return this._size;
}

ArrayList.prototype.get = function(index) {
    this._checkBounds(index);
    return this._array.get(index);
}

// Define a method "add" which takes a single argument. This method should
// append the argument to the end of this ArrayList and increase the size by
// 1. The return value must be this.
ArrayList.prototype.add = function (arg){
    this._array.set(this._size, arg);
    this._size += 1;
    return this;
}

// Define a method "prepend" which takes a single argument. This method should
// prepend the argument to the beginning of this ArrayList and increase the size
// by 1. The return value must be this.

ArrayList.prototype.prepend = function (arg){
    // need to check if the this._size if large than the FixedArray, if not, just shift elements of the array one element to the right
    if (this._size == this._array.size()){
    }
    this._size += 1;
    var newArr = new FixedArray(this._size);
    newArr[0] = arg;
    for (var i = 1; i<this._size;i++){
        newArr[i] = this._array[i-1];
    }
    this._array = newArr;
    return this;
}

ArrayList.prototype.prepend = function (arg){
    if ( ! this._ifIncreaseSize(1)){
        this._shiftvalues();
        this._arry.set(0, arg);
        thsi._size += 1;
    }
}

// ArrayList.prototype._ifIncreaseSize = function( shift = 0){
//     //  determine if the size of the array list needs to increased as result of as a shift
//     if ( this._size + shift >= this._arry.size()){
//         var tempArr = new FixedArray(index+1);
//         for (var i = 0; i < this._size; i++){
//             tempArr.set(this._array.(i));
//         }
//         for (var i = 0; i < this._size; i++){
//             this._array.set(i + sift, tempArr.get(i));
//         }
//         return true;
//     }
//     return false;
// }





// Define a "delete" method which takes a single index argument. This method
// should delete the value at the provided index and return it. The size should
// be 1 less than it was before this method was called. The index must be within
// the bounds of the ArrayList, or an IndexError should be thrown.
ArrayList.prototype.delete = function (index){
    this._checkBounds(index);
    var output = this._array.get(index);
    this._size -= 1;
    this._shiftLeft(index);
    this._array.set(this._size , null);
    return output;
}
// Define a method "set" which takes 2 arguments. This method should set the
// value at the index defined in the first argument such that list.get(index)
// will return the second argument.

ArrayList.prototype.set = function (index, value){
    this._checkLowerBound(index);
    if (index < this._size) {
        var output = this._array[index];
        this._array[index] = value;
        return output;
    } else if ( index >= this._size ){
        var newArr = new FixedArray(index+1);
        for ( var i = 0; i< this._size; i++){
            newArr[i] = this._array[i];
        }
        newArr[index] = value;
        this._array = newArr;
        this._size = index+1;
        for (var i = 0; i < this._size; i++){
            if (this._array[i] === undefined) {
                this._array[i] = null;
                // console.log("The index is "+i);
            }
        }
        return null;
    }
}
//
// If the index is negative, an IndexError should be thrown.
//
// If the index is bigger than the current size of the _array, the _array should
// be replaced with a bigger FixedArray to fit the new index. All indexes
// between the former last element and the new index should be initialized with
// null. An additional buffer should be included in the new FixedArray (in case
// the array is grown more), though this is not required.
//
// The size after this method is called depends on the index provided. An
// existing index would not affect the size, but an index greater than the last
// index will add the difference to the size.
//
// This method should return the value that was previously in the given index,
// or null if that does not apply.

ArrayList.prototype._checkBounds = function(index) {
    this._checkLowerBound(index);
    this._checkUpperBound(index);
}


ArrayList.prototype._shiftRight = function(){
    //define function to shift the element of the array to the right by 1 position
    for (var i = this._size -1; i>= 0;i--){
        this._array.set(i+1, this._array.get(i));
    }
}
ArrayList.prototype._shiftLeft = function(index){
    //define function to shift the element of the array to the left by 1 position
    for (var i = index; i < this._size; i++){
            this._array.set(i, this._array.get(i + 1));
    }
}


ArrayList.prototype._checkLowerBound = function(index) {
    if (index < 0) {
        throw new IndexError("Invalid index: " + index);
    }
}

ArrayList.prototype._checkUpperBound = function(index) {
    if (index >= this.size()) {
        throw new IndexError("Invalid index: " + index);
    }
}

module.exports = ArrayList;
