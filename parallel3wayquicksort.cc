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
	std::swap(data[pivotLocation], data[n]);
	while(i< size){
		if( p == i){
			break;
		}
		else if(data[i] < data[n]){
			std::swap(data[i], data[k]);
			i++;
			k++;

			}
		else if(data[i] == data[n]){
			p--;
			std::swap(data[i], data[p]);
		}
		else{
			i++;
		}
	
	}

	int numberofpivots = n - p + 1;
	for(int o = 0; o < numberofpivots; o++){
		std::swap(data[p+o],data[k+o] );
	
	}
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

	myPartition(left, size,leftboundary, rightboundary);
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
