#include<queue>
#include<iostream>

using namespace std;

int parent(int i){
	return i/2-1;
}
int left(int i){
	return 2*i + 1;
}
int right(int i){
	return 2*i + 2;
}

struct Node
{
	int row;
	int value;
	int col;
};
int maxSize = 4;
int size = 0;
Node *nodes;
void heapify(Node *a,int i){
	int l = left(i);
	int r = right(i);
	if (l >= size)
	{
		return;
	}
	int min = i;
	if (r >= size)
	{
		if (a[l].value < a[i].value)
		{
			min = l;
		}
	}else{
		if (a[l].value < a[i].value)
		{
			min = l;
		}
		if(a[r].value < a[min].value)
			min = r;
	}
	if (min != i)
	{
		// swap 
		Node x = a[min];
		a[min].value = a[i].value;
		a[min].row = a[i].row;
		a[min].col = a[i].col;

		a[i] = x;
		heapify(a,min);
	}
}

int insert(int value,int row, int col){
	if (size >= maxSize)
	{
		cout<<"over flow\n";
		return -1;
	}
	int i = size;
	nodes[size].value = value;
	nodes[size].row = row;
	nodes[size].col = col;

	size++;
	int p = parent(i);
	while(p >= 0 && nodes[i].value < nodes[p].value){
		Node t = nodes[i];
		nodes[i] = nodes[p];
		nodes[p] = t;
		i = p;
		p = parent(p);
	}
}
Node extractMin(Node *nodes){
	if (size < 1)
	{	
		return nodes[0];
	}
	Node n = nodes[0];
	nodes[0] = nodes[size-1];
	size--;
	heapify(nodes,0);
	return n;
}



int main(){
	int a[4][4]={
		{10, 20, 30, 40},
		{15, 25, 35, 45},
		{27, 29, 37, 48},
		{32, 33, 39, 50}
	};
	
	int rows = 4;
	nodes = new Node[maxSize];
	for (int i = 0; i < rows; ++i)
	{
		nodes[i].value = a[i][0];
		nodes[i].row = i;
		nodes[i].col = 0;
	}
	size = rows;
	int h = (size -1)/2;
	while(h>=0){
		heapify(nodes,h);
		h--;		
	}
	for (int i = 0; i < size; ++i)
	{
		cout<<nodes[i].row << " value = "<< nodes[i].value<<endl; 
	}
	int i = 0;
	int j;
	while(i<rows*rows){
		Node n = extractMin(nodes);
		cout<<n.value<<" ";
		if (n.col<3)
		{	
			insert(a[n.row][n.col+1], n.row,n.col+1);	
		}
		cout<<endl;
		// sleep(1);
		i++;
	}
}