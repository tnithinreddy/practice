#include <iostream>
#include <stack>
using namespace std;
struct Node{
	int index;
	int height;
};
int main(int argc, char const *argv[])
{
	stack<Node> s;
	std::vector heights;
	heights.push_back(6);
	heights.push_back(2);
	heights.push_back(5);
	heights.push_back(4);
	heights.push_back(5);
	heights.push_back(1);
	heights.push_back(6);

	std::vector<Node>::iterator it = heights.begin();
	Node n;
	n.height = *it;
	n.index = 0;
	int i = 1;
	s.push();
	int res = 0;
	++it;
	int prev,width;
	for (;it!=heights.end() ; ++it)
	{	
		while(!s.empty()&&s.top().height > *it){
			Node x = s.top();
			s.pop();
			if (s.empty())
			{
				width = i - x.index ;
			}
			else
			{
				width = i - s.top().index;
			}
			res = fmax	(res,width*x.height);
		}
		n.height = *height;
		n.index = i;
		s.push(n);
		i++;
	}
	while(!s.empty()){
		Node x = s.pop();
	}
	return 0;
}