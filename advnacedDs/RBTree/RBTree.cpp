#include<iostream>
#include<unistd.h>
#include<queue>
using namespace std;
struct Node{
	int data;
	Node *left,*right,*parent;
	char color;
	Node(int d){
		data = d;
		color = 'r';
		right = left = parent = NULL;
	}	
};

class RBTree{
		Node *root;
	public:
		RBTree(){
			root = NULL;
		}

		void printRoot(){
			cout<<"root = "<< root<< endl;
		}
		
		void levelOrder(){
			queue<Node*> q;
			q.push(root);
			q.push(NULL);
			Node *ptr;
			while(!q.empty()){
				// sleep(1);
				ptr = q.front();
				q.pop();
				if (ptr == NULL)
				{
					cout<<endl;
					if (!q.empty())
					{
						q.push(NULL);
					}
					continue;
				}
				cout<< ptr->data << " ("<<ptr->color<<")";
				if (ptr->left !=NULL)
				{
				q.push(ptr->left);
					/* code */
				}
				if (ptr->right !=NULL)
				{
				q.push(ptr->right);
					/* code */
				}

			}
		}
		void insert(int value)
		{
			
			if (root == NULL){
				root = new Node(value);
				root->color = 'b';
				return;
			}
			Node *current = root;
			Node *parent = NULL;
			while(true){
				if (current->data == value)
				{
					return;
				}
				if (current->data > value)
				{	
					if (current->left == NULL)
					{
						parent = current;
						break;
					}
					current = current->left;
				}else{
					if (current->right == NULL)
					{
						parent = current;
						break;
					}
					current = current->right;
				}
			}
			Node *x = new Node(value);
			if (parent->data > value)
			{
				parent->left = x;
				x->parent = parent;
			}else{
				parent->right = x;
				x->parent = parent;
			}
			fixViolation(x);
			// root->parent = NULL;
			root->color = 'b';
			return;
		}

		void rotateRight(Node *&y){
			
			Node *x = y->left;
			if (y == root)
			{
				root = x;	
			}
			Node *grandParent = y->parent;
			if (grandParent != NULL)
			{
				if (grandParent->right == y)
				{
					grandParent->right = x;
				}else{
					grandParent->left = x;
				}
				x->parent = grandParent;
			}
			Node *beta = x->right;
			x->right = y;
			y->parent = x;

			y->left = beta;
			if (beta!=NULL)
			{
				beta->parent = y;
			}

			y = x;
		}

		void rotateLeft(Node *&y){
			Node *x = y->right;
			if (y == root)
			{
				root = x;
			}
			Node *grandParent = y->parent;
			if (grandParent != NULL)
			{
				if (grandParent->right == y)
				{
					grandParent->right = x;
				}else{
					grandParent->left = x;
				}
				x->parent = grandParent;
			}
			Node *beta = x->left;
			x->left = y;
			y->parent = x;
			y->right = beta;
			if (beta!=NULL)
			{
				beta->parent = y;
			}
			y = x;
		}

		char getUncleColor(Node *uncle){
			if (uncle == NULL)
			{
				return 'b';
			}
			if (uncle->color == 'b')
			{
				return 'b';
			}
			return 'r';
		}

		void fixViolation(Node *child){
			Node *parent,*grandParent,*uncle;
			char u,v;
			while(child!=NULL && child->color!='b' ){
				parent = child->parent;
				if (parent == NULL)
				{
					return;
				}
				if (parent->color == 'b')
				{
					return;
				}
				grandParent = parent->parent;
				if (grandParent == NULL)
				{	
					return;
				}
				if (grandParent->left == parent)
				{
					uncle = grandParent->right;
				}else{
					uncle = grandParent->left;
				}
				// if uncle is black
				if (getUncleColor(uncle) == 'b')
				{	
					// cout<<grandParent->data <<" "<<parent->data<<" "<< child->data<<endl;
					if (grandParent->right == parent)
					{
						// right left case
						if (parent->left == child)
						{	// rotate right(parent)
							rotateRight(parent);
						}
						rotateLeft(grandParent);
						child = grandParent;
						u = child->color;
						v = child->left->color;
						child->color = v;
						child->left->color = u;
						// swap color
					}else{
						// left
						if (parent->right == child)
						{	// left right case
							rotateLeft(parent);
						}
						// cout<<"left left\n";
						rotateRight(grandParent);
						child = grandParent;
						// swap colors
						u = child->color;
						v = child->right->color;
						child->color = v;
						child->right->color = u;
						// cout<<child->data<<" === data == color=== "<< child->color<<endl;
					}						
				}else{ // uncle is red
					grandParent->color = 'r';
					parent->color = 'b';
					uncle->color = 'b';
					child = grandParent;
				}

			}
		}	

		void delete(int key){

		}
};


int main(int argc, char const *argv[])
{
		cout<<"hello"<<endl;
	RBTree tree;
	// cout<<tree.root;
	// tree.printRoot();
	tree.insert(7);
 //    tree.levelOrder();

    tree.insert(6);
 //    tree.levelOrder();

    tree.insert(5);
  
    tree.insert(4);

    tree.insert(3);

    tree.insert(2);
    cout<<"levelOrder = "<<endl;
    // tree.levelOrder();
    tree.insert(1);
    tree.levelOrder();
	return 0;
}