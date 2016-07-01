#include <iostream>

using namespace std;

int main(int argc, char const *argv[])
{
        int m = 5,n = 3;
        // int a[][4] = {
        //     { 1,  2,  3},
        //     { 5,  6,  7},
        //     { 9, 10, 11},
        //     {13, 14, 15}
        // };
         int a[][3] = {
            { 1,  2,  3},
            { 5,  6,  7},
            { 9, 10, 11},
            {13, 14, 15},
            {16, 17, 18}
        };
        // int a[][5] = {{1,2,3,4,5}};

            // int a[][4] = {   { 1,  2,  3,  4},
            //             { 5,  6,  7,  8},
            //             { 9, 10, 11, 12},
            //             {13, 14, 15, 16},
            //             {17, 18, 19, 20}
            //         };
        int top = 0, left = 0, right = n-1,bottom = m-1;
        int i = top;
        int j = left;
        // for (int a = 0; a< m*n ; a++ ) {
            
        // }
        while(top<= bottom && left<=right){
            for (j=left;j<=right ;j++ ) {
                cout<<a[top][j]<<" ";               
            }
            top++;
            for(i = top;i< bottom;i++){
                cout<<a[i][right]<<" ";
            }
            right--;
            if (top<=bottom)
            {
                /* code */
                for(j = right+1;j>=left;j--){
                     cout<<a[bottom][j]<<" ";
                }
                bottom--;
            }
            
            
            // bottom--;
            if (left<=right)
            {
                /* code */
                for (i = bottom;i>=top ;i-- ) {
                    cout<<a[i][left]<<" ";
                }
                left++;
            }
            
        }
    return 0;
}
// int main() {
//     const int m = 4, n = 3;
//     // int mat[m][n] = {   { 1,  2,  3,  4},
//     //                     { 5,  6,  7,  8},
//     //                     { 9, 10, 11, 12},
//     //                     {13, 14, 15, 16}
//     //                     // {17, 18, 19, 20},
//     // };
//       int mat[m][n] = {   { 1,  2,  3},
//                         { 5,  6,  7},
//                         { 9, 10, 11},
//                         {13, 14, 15}
//                         // {17, 18, 19, 20},
//     };
    
//     int left = 0, top = 0;
//     int right = n-1, bottom = m-1;
//     int i = top, j = left;

//     for(int a = 0; a < m * n; ++a) {
//         cout << mat[i][j] << " " << flush;

//         if (i == top && j < right) {
//             if(++j == right)
//                 top++;
//         }
//         else if (j == right && i < bottom) {
//             if(++i == bottom)
//                 right--;
//         }
//         else if (i == bottom && j > left) {
//             if(--j == left)
//                 bottom--;
//         }
//         else if (j == left && i > top) {
//             if(--i == top)
//                 left++;
//         }
//     }
    
//     return 0;
// }
