#include <algorithm>
#include <omp.h>
#include <iostream>
using namespace std;
typedef unsigned long long data_t;



//swaps 2 elements 
void mySwap(data_t* left, data_t*right){

    data_t temp = *left;
    *left = *right;
    *right = temp;
    return;


}

void printArray(data_t* left, int size){

	for(int i = 0; i < size; i++){
	
		cout<< *(left+i) <<endl;
	
	}
	



}
int myPartition(data_t* left, data_t* right){
    int size = right - left;
    //cout << "input array" << endl;
    //printArray(left, size);
    int i = -1;

    data_t pivot = *(right-1);
    //cout << "size at partition is:" << size << endl;
    for(int j = 0; j < size - 1 ; j++){
        if(*(left + j) < pivot){
            i++;
            mySwap((left+i), (left+j));
        }
    }

    //cout << "pivot position is at" << i << endl;
    mySwap((left+i+1),(right - 1));
    //cout << "output array" << endl;    
    //printArray(left, size);
    if(i < 0){
    	return 0;
    
    }
    else{
    return i+1;
    }
}


void quicksort(data_t* left, data_t*right){
   

    //int size = right - left;
    if(left >= right){
    	return;
    }
    

    //cout << "size at base case is:" << size << endl;	
    //cout << "recursion counter:" << counter << endl;
    int pivot = myPartition(left, right);
    data_t* newRight = left+pivot;

    quicksort(left, newRight);

    quicksort ((newRight + 1), right);
    
}


void psort(int n, data_t* data) {
	



    quicksort(data, data+n);

 
    
}
