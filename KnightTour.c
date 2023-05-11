#include <stdio.h>
#include <math.h>
#include <stdlib.h>

void InputBoardSize(int *n)
{
    printf("Enter the size of the board (n x n): n = ");
    scanf("%d", n);
}

void GetStartPosition(int *x, int *y)
{
    printf("Enter the starting position:\nx = ");
    scanf("%d", x);
    printf("y = ");
    scanf("%d", y);
}

void Output(int n, int s[][256])
{
    int i, j;
    printf("\n");
    for(i = 1; i <= n; i++)
    {
        for(j = 1; j <= n; j++)
            printf("[%2d] ", s[i][j]);
        printf("\n\n");
    }
    exit(0);
}

void Move(int n, int s[][256], int x, int y, int dem)
{
    int X[8] = {1, 1, 2, 2, -1, -1, -2, -2};
    int Y[8] = {-2, 2, -1, 1, -2, 2, 1, -1};
    int i, a, b;
    dem++;
    s[x][y] = dem;
    if(dem == n * n)
        Output(n, s);
    for(i = 0; i < 8; i++)
    {
        a = x + X[i];
        b = y + Y[i];
        if(a >= 1 && a <= n && b >= 1 && b <= n && s[a][b] == 0)
            Move(n, s, a, b, dem);
    }
    dem--;
    s[x][y] = 0;
}

int main()
{
    int s[256][256], n, dem = 0, x, y;
    InputBoardSize(&n);
    GetStartPosition(&x, &y);
    Move(n, s, x, y, dem);
    return 0;
}

