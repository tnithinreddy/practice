// http://www.cc.iitd.ernet.in/cgi-bin/proxy.mtech

#include <stdio.h>
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

#include <stdio.h>

int main()
{
    // void *x[9]; // size of
    // printf("%d\n", sizeof(&x));
    char str[5];
    scanf("%s\n", str);
    printf("%s\n", str);
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