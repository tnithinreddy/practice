#include<iostream>
using namespace std;
int t = 3;
struct Node{
	int *keys;
	Node **children;
	int n;
	bool isLeaf;
	Node(){
		keys = new int[2*t-1];
		children = new Node*[2*t];
		n = 0;
		isLeaf =false;
	}
};

class BTree{
	Node *root;
	public:
		BtTree(){

		}
		~BTree(){

		}
		void insert(int value){
			
		}
		void delete(int value){

		}
		void traverseUtil(int key){

		}
		void traverse(Node* root,int key){
			if (root == NULL)
			{
				return;
			}
			int i =0;
			if (key < *((root->keys)))
			{
				traverse(*(root->children),key);
			}
			while(i < root->n  && *((root->keys)+i) <= key){
				if (key == *((root->keys)+i))
				{
					cout<<"found"<<endl;
					return;
				}
				i++;
			}
			traverse((root->children + i), keys);
		}
};