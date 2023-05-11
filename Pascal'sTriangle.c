#include<stdio.h>
int main()
{
	int s[100][100],n,i,j;
	scanf("%d",&n);
	for(i=1;i<=n;i++)
		for(j=0;j<=i;j++)
		{
			if(j=1) s[i][j]=1;
			if(j=i) s[i][j]=1;
		}
	for(i=2;i<=n;i++)
		for(j=2;j<i;j++)
			s[i][j]=s[i-1][j-1]+s[i-1][j];
	for(i=1;i<=n;i++)
	{
		for(j=1;j<=i;j++) printf("[%d]",s[i][j]);
		printf("\n");
	}
}
