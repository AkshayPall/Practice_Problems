//Pagerank!

#include <stdio.h>

typedef struct {
	int src, dst;
} link;

void pagerank(link l[], int nlink, double r[], int npage, 
		double delta, int iters);

int main(void) {
	link l[] = {{0, 1}, {0,2}, {1,2}, {2,0}};
	double r[3];
	pagerank(l, sizeof(l)/sizeof(l[0]), r, sizeof(r)/sizeof(r[0]), 0.8, 20);
	for (int i = 0; i < sizeof(r)/sizeof(r[0]); i++) 
		printf("%f\n", r[i]);
	return 0;
}

void pagerank(link l[], int nlink, double r[], int npage, 
		double delta, int iters){
	//calculate # of outgoing links per page
	int out[npage];
	for (int j = 0; j < npage; j++)
		out[j]=0;
	for (int i = 0; i < nlink; i++)
		out[l[i].src]++;

	//initial guess
	for (int j = 0; j < npage; j++)
		r[j]= 1.0/npage;

	//iterate
	for (int k = 0; k<iters; k++){
		double t[npage]; //temp storage for new rank calcs
		//random jump probability
		for(int j = 0; j<npage; j++)
			t[j]=(1.0-delta)/npage;
		for (int i = 0; i < nlink; i++)
			t[l[i].dst] += delta*r[l[i].src]/out[l[i].src];
		//copy back to r
		for (int j = 0; j < npage; j++)
			r[j] = t[j];
	}
}
