// http://www.cc.iitd.ernet.in/cgi-bin/proxy.mtech

#include <stdio.h>
#include<bool.h
//
// int main()
// {
//     int arr[] = {1,2,3,4,5};
//     arr[1] = 22;
//     // int * ptr = arr;
//     // Assume that base address of arr is 2000 and size of integer
//         // is 32 bit
//     // printf("%u\n", ptr);
//     // arr++;
//     printf("%u %u\n", sizeof(arr), sizeof(&arr));
//
//     return 0;
// }
////////////

//http://www.geeksforgeeks.org/printing-longest-common-subsequence/
//http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
int main()
{
    // void *x[9]; // size of
    // printf("%d\n", sizeof(&x));
    bool t = true;
    printf("pow(2,3) = %d\n", t );
    char str[5];
    int x = 10;
    int *ptr = &x;
    int j = 20;
    int y = x++ + ++x + x++;
    printf("y = %d \n",y);
    printf("%d %d %d %d\n", x++,x++,x++,++x);
    return 0;
}
///////////

// # include <stdio.h>
//
// void print(int arr[])
// {
//    int n = sizeof(arr)/sizeof(arr[0]);
//    int i;
//    for (i = 0; i < n; i++)
//       printf("%d ", arr[i]);
// }
//
// int main()
// {
//    int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
//    print(arr);
//    return 0;
// }
