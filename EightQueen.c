#include <stdio.h>
#include <string.h>
#include <stdlib.h>

void InputBroadSize(int *n) {
    printf("Enter the size of the chessboard (n x n) and number of queens: n = ");
    scanf("%d", n);
}

void QueenPosition(int *x, int *y) {
    printf("Enter the position of the guaranteed queen:\n");
    printf("Row = ");
    scanf("%d", x);
    printf("Column = ");
    scanf("%d", y);
}

void Output(int n, char s[][256]) {
    int i, j;
    for (i = 0; i <= n; i++) {
        for (j = 0; j <= n; j++) {
            if (i == 0) printf("[%2d]", j);
            if (j == 0 && i != 0) printf("[%2d] ", i);
            if (s[i][j] != '*' && i != 0 && j != 0) printf("[ ] ");
            if (s[i][j] == '*') printf("[%c] ", s[i][j]);
        }
        printf("\n\n");
    }
    exit(0);
}

int Check(char s[][256], int x, int y, int n) {
    int dem = 0, i;
    for (i = 0; i <= n; i++) {
        if (s[i][y] != '*' && s[x][i] != '*' && s[i + x - y][i] != '*' && s[x + y - i][i] != '*') {
            // Do nothing, continue the loop.
        } else {
            dem++;
        }
    }
    return dem;
}

void PlaceQueens(int n, int x, int y, char s[][256], int dem) {
    dem++;
    s[x][y] = '*';
    if (dem == n) Output(n, s);
    int i, j;
    for (i = 1; i <= n; i++) {
        for (j = 1; j <= n; j++) {
            if (Check(s, i, j, n) == 0) PlaceQueens(n, i, j, s, dem);
        }
    }
    dem--;
    s[x][y] = 0;
}

int main() {
    char s[256][256];
    int n, x, y, dem = 0;
    InputBroadSize(&n);
    QueenPosition(&x, &y);
    PlaceQueens(n, x, y, s, dem);
    return 0;
}

