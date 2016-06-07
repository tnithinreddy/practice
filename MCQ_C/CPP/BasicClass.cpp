#include<iostream>
using namespace std;
// class User{
// private:
// 	int paid;
// protected:

// public:
// 	int i;
// };

void test(int *&i){
	*i = 999;
}
int main(int argc, char const *argv[])
{
	int i = 5;
	int *x = &i;
	test(x);
	cout<<"final value = "<<i;
	return 0;
}