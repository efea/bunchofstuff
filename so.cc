#include <algorithm>
#include <omp.h>
#include <iostream>
#include <time.h>
using namespace std;

typedef unsigned long long data_t;

void printArray(data_t* data, int size){

    for(int i = 0; i < size; i++){
        std::cout << data[i] <<std::endl;
    }
            std::cout <<"------------"<<std::endl;

}

void myPartition(data_t* data, int size, int& leftboundary,int& rightboundary) {

	srand(time(NULL));
	int i = 0;
	int k = 0;
	int n = size - 1;
	int p = n;
	int pivotLocation = rand() % size; 
	//std::cout << "pivotLocation:" << pivotLocation << endl;
	//std::cout << "pivot is:" << data[pivotLocation] << endl;
	//choose pivot.
	//swap with the last element
	//std::cout << "before swapping pivot:" << endl;
	//printArray(data, size);
	std::swap(data[pivotLocation], data[n]);
	//std::cout << "after swapping pivot:" << endl;
	//printArray(data, size);
	
	while(i< size){
		if( p == i){
			break;
		}
		else if(data[i] < data[n]){
			//std::cout << "pivot bigger, we gon swap i and k" << endl;
			std::swap(data[i], data[k]);
			i++;
			k++;
			//printArray(data, size);
			
			}
		else if(data[i] == data[n]){
			p--;
			//std::cout << "same as pivot, we gon put it next to pivot" << endl;			
			std::swap(data[i], data[p]);
			//printArray(data, size);
		}
		else{
			i++;
			//std::cout << "pivot smaller we gon keep it at left." << endl;	
			//printArray(data, size);
		}
	
	}
	
	//std::cout << "pivot was:" << data[n] << endl;
	//std::cout << "after swaps the array is:" << endl;
	//rintArray(data, size);
	//std::cout << "size is:" << size << endl;
	//std::cout << "i is:" << i << endl;
	//std::cout << "k is:" << k << endl;	
	//std::cout << "n is:" << n << endl;
	//std::cout << "p is:" << p << endl;
	int numberofpivots = n - p + 1;
	for(int o = 0; o < numberofpivots; o++){
		std::swap(data[p+o],data[k+o] );
	
	}
	//std::cout << "after putting pivots to correct place:" << endl;
	//printArray(data, size);
	leftboundary = k;
	rightboundary = numberofpivots;
}




void quicksort(data_t* left, data_t* right) {

	int size = right - left;
	int leftboundary, rightboundary;
	if(size <= 1){
		return;
	}
	
	else if(size < 10000){
		std::sort(left,right);
	
	}
	
	else{

	//std::cout << "size is:" << size << std::endl;
	//std::cout << "left element is:" << *(left) << std::endl;
	//std::cout << "right element is:" << *(right - 1) << std::endl;
	

	myPartition(left, size,leftboundary, rightboundary);
	//std::cout << " leftboundary is:" << leftboundary  << std::endl;
	//std::cout << "left array is: " << std::endl;
	//printArray(left, leftboundary);
	
	//std::cout << " rightboundary is:" << leftboundary  << std::endl;
	//std::cout << "right array is: " << std::endl;
	//printArray((left+leftboundary+rightboundary) ,(size - (leftboundary+rightboundary))  );
	

        #pragma omp task
	quicksort(left, (left + leftboundary));
        #pragma omp task
	quicksort((left+leftboundary+rightboundary), right);
	
	}
	

    


}

void psort(int n, data_t* data) {

	#pragma omp parallel num_threads(omp_get_max_threads())
	#pragma omp single
	{ 
		quicksort(data, data+n);
	}    
}
